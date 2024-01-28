package ru.gb.hw;

import java.io.File;

public class FilePrefixAdder {

    public static void addPrefixToFiles(String prefix, String... filenames) {
        for (String filename : filenames) {
            File file = new File(filename);

            if (file.exists()) {
                String parentPath = file.getParent();
                String newName = prefix + file.getName();
                File newFile = new File(parentPath, newName);

                if (file.renameTo(newFile)) {
                    System.out.println("Префикс успешно добавлен к файлу: " + filename);
                } else {
                    System.out.println("Не удалось добавить префикс к файлу: " + filename);
                }
            } else {
                System.out.println("Файл не существует: " + filename);
            }
        }
    }
}
