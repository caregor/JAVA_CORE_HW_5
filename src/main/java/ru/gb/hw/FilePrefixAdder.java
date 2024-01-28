package ru.gb.hw;

import java.io.File;

public class FilePrefixAdder {
    /**
     * Добавляет указанный префикс к именам файлов. Если файл существует, он переименовывается
     * с добавлением префикса, и выводится соответствующее сообщение. Если файл не существует,
     * выводится сообщение об ошибке.
     *
     * @param prefix     Префикс, который будет добавлен к именам файлов.
     * @param filenames  Имена файлов, к которым необходимо добавить префикс.
     */
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
