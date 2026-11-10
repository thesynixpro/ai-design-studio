package com.aprax.aidesignstudio.utils;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    public static boolean createZip(File[] files, String zipFilePath) {
        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFilePath));
            for (File file : files) {
                addFileToZip(file, file.getName(), zipOut);
            }
            zipOut.finish();
            zipOut.close();
            return true;
        } catch (IOException e) {
            Log.e("ZipUtils", "Error creating ZIP", e);
            return false;
        }
    }

    private static void addFileToZip(File file, String fileName, ZipOutputStream zipOut) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) return;
            for (File child : files) {
                addFileToZip(child, fileName + "/" + child.getName(), zipOut);
            }
        } else {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
    }
}
