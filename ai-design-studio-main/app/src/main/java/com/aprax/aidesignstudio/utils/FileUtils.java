package com.aprax.aidesignstudio.utils;
import java.io.FileInputStream;
import android.util.Log;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.Toast;
import com.aprax.aidesignstudio.generators.CodeValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {

    /**
     * Export project as ZIP file
     */
    public static boolean exportProjectAsZip(String projectDirPath, String zipFilePath, Context context) {
        try {
            File zipFile = new File(zipFilePath);
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            File projectDir = new File(projectDirPath);
            addDirectoryToZip(projectDir, projectDir.getName(), zipOut);

            zipOut.finish();
            zipOut.close();
            fos.close();

            Log.d("FileUtils", "Project exported as ZIP");
            return true;
        } catch (IOException e) {
            Log.e("FileUtils", "Error exporting ZIP", e);
            return false;
        }
    }

    private static void addDirectoryToZip(File directory, String directoryName, ZipOutputStream zipOut) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                addDirectoryToZip(file, directoryName + "/" + file.getName(), zipOut);
            } else {
                addFileToZip(file, directoryName + "/" + file.getName(), zipOut);
            }
        }
    }

    private static void addFileToZip(File file, String fileName, ZipOutputStream zipOut) throws IOException {
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
