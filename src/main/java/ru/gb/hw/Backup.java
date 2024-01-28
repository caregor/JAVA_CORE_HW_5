package ru.gb.hw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


public class Backup {
    /**
     * Создает бэкап содержимого указанного исходного каталога. Создает каталог "backup" внутри
     * исходного каталога, если он не существует, и копирует все файлы и подкаталоги из исходного
     * каталога в этот "backup" каталог.
     *
     * @param sourcePath Путь к исходному каталогу, для которого будет создан бэкап.
     */
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
    /**
     * Рекурсивно копирует файлы и каталоги из исходного места в пункт назначения.
     * Если исходный элемент - каталог, рекурсивно копирует его содержимое
     * (исключая каталог "backup") в пункт назначения. Если исходный элемент - файл,
     * копирует файл в пункт назначения.
     *
     * @param source      Исходный файл или каталог для копирования.
     * @param destination Каталог, в который будут скопированы файлы или каталоги.
     * @throws IOException Если происходит ошибка ввода-вывода в процессе копирования.
     */
    private static void copyFiles(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!source.getName().equals("backup")) {
                for (File file : Objects.requireNonNull(source.listFiles())) {
                    copyFiles(file, destination);
                }
            }
        } else {
            File destinationFile = new File(destination, source.getName());
            Files.copy(source.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
