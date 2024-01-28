package ru.gb.hw;

import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFileProcessing {
    public static int[] getBinaryData(String filePath) {

        int fieldSize = 9;
        int[] fieldValues = new int[fieldSize];

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[3];
            int bytesRead = fileInputStream.read(buffer);

            if (bytesRead == 3) {
                int packedData = ((buffer[0] & 0xFF) << 16) | ((buffer[1] & 0xFF) << 8) | (buffer[2] & 0xFF);
                for (int i = 0; i < fieldSize; i++) {
                    int mask = 0b11 << (i * 2);
                    int value = (packedData & mask) >> (i * 2);
                    fieldValues[i] = value;
                }
            } else {
                System.out.println("Ошибка чтения файла. Не удалось прочитать 3 байта.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fieldValues;
    }
}
