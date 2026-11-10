package com.aprax.aidesignstudio.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/** Stores the API key encrypted with a key held by Android Keystore on API 23+. */
public class ApiKeyManager {
    private static final String PREF = "api_keys";
    private static final String KEY_NAME = "aidesignstudio_api_key";
    private final Context context;

    public ApiKeyManager(Context context) { this.context = context.getApplicationContext(); }
    private SharedPreferences prefs() { return context.getSharedPreferences(PREF, Context.MODE_PRIVATE); }

    public void saveApiKey(String apiKey) {
        if (apiKey == null) { deleteApiKey(); return; }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(Cipher.ENCRYPT_MODE, getOrCreateKey());
                byte[] encrypted = cipher.doFinal(apiKey.getBytes(StandardCharsets.UTF_8));
                String payload = Base64.encodeToString(cipher.getIV(), Base64.NO_WRAP) + ":" +
                    Base64.encodeToString(encrypted, Base64.NO_WRAP);
                prefs().edit().putString("gemini_api_key_enc", payload).remove("gemini_api_key").apply();
            } else {
                // Compatibility fallback for Android 5.x devices only.
                prefs().edit().putString("gemini_api_key", apiKey).apply();
            }
        } catch (Exception e) { android.util.Log.e("ApiKeyManager", "Could not encrypt API key", e); }
    }

    public String loadApiKey() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                String payload = prefs().getString("gemini_api_key_enc", null);
                if (payload == null) return null;
                String[] parts = payload.split(":", 2);
                if (parts.length != 2) return null;
                byte[] iv = Base64.decode(parts[0], Base64.NO_WRAP);
                byte[] encrypted = Base64.decode(parts[1], Base64.NO_WRAP);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(Cipher.DECRYPT_MODE, getOrCreateKey(), new GCMParameterSpec(128, iv));
                return new String(cipher.doFinal(encrypted), StandardCharsets.UTF_8);
            }
            return prefs().getString("gemini_api_key", null);
        } catch (Exception e) { android.util.Log.e("ApiKeyManager", "Could not decrypt API key", e); return null; }
    }

    public void deleteApiKey() {
        prefs().edit().remove("gemini_api_key_enc").remove("gemini_api_key").apply();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                KeyStore store = KeyStore.getInstance("AndroidKeyStore");
                store.load(null);
                if (store.containsAlias(KEY_NAME)) store.deleteEntry(KEY_NAME);
            }
        } catch (Exception e) { android.util.Log.e("ApiKeyManager", "Could not remove key", e); }
    }

    private SecretKey getOrCreateKey() throws Exception {
        KeyStore store = KeyStore.getInstance("AndroidKeyStore");
        store.load(null);
        if (store.containsAlias(KEY_NAME)) return (SecretKey) store.getKey(KEY_NAME, null);
        KeyGenerator generator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        generator.init(new android.security.keystore.KeyGenParameterSpec.Builder(KEY_NAME,
            android.security.keystore.KeyProperties.PURPOSE_ENCRYPT | android.security.keystore.KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes("GCM").setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(true).build());
        return generator.generateKey();
    }

    public boolean isValidApiKeyFormat(String apiKey) { return apiKey != null && apiKey.trim().length() > 20; }
}
