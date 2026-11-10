# AI Design Studio (GitHub Actions build)

This is the Java + XML Android project prepared for building on GitHub Actions.
It does not use Kotlin.

## Build an APK on GitHub

1. Create a new GitHub repository.
2. Upload the **contents** of this folder to the repository (the `.github/workflows/android.yml` file must be included).
3. Open the repository's **Actions** tab.
4. Select **Build AI Design Studio APK**.
5. If it has not run automatically, choose **Run workflow**.
6. Wait for the workflow to finish successfully.
7. Open the completed workflow run and download the artifact named
   **AI-Design-Studio-debug-apk**.

The APK inside the artifact is `app-debug.apk`.

## Build configuration

- Android Gradle Plugin: 8.6.1
- Gradle: 8.7 (installed by the workflow)
- JDK: 17
- Compile SDK: 34
- Minimum Android version: API 21
- Language: Java
- UI resources: XML

The project uses stable AndroidX and Material dependencies. The workflow builds a
debug APK; it does not publish a Play Store release.
