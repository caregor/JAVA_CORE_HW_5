package ru.gb.hw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class Backup {

    public static void createBackup(String sourcePath) {
        File sourceDir = new File(sourcePath);
        File backupDir = new File(sourceDir, "backup");

        if (!backupDir.exists() && !backupDir.mkdirs()) {
            System.err.println("Не удалось создать директорию для бэкапов.");
            return;
        }

        try {
            copyFiles(sourceDir, backupDir);
            System.out.println("Бэкап успешно создан: " + backupDir.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка при создании бэкапа.");
        }
    }

    private static void copyFiles(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!source.getName().equals("backup")) {
                for (File file : source.listFiles()) {
                    copyFiles(file, destination);
                }
            }
        } else {
            File destinationFile = new File(destination, source.getName());
            Files.copy(source.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
