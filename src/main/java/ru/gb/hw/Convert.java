package ru.gb.hw;

import java.io.FileOutputStream;
import java.io.IOException;

public class Convert {
    public static void convertData(int [] fieldValues) {
        int packedData = 0;
        for (int i = 0; i < 9; i++) {
            packedData |= fieldValues[i] << (i * 2);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream("output.bin")) {
            for (int i = 2; i >= 0; i--) {
                byte b = (byte) ((packedData >> (i * 8)));
                fileOutputStream.write(b);
            }
            System.out.println("Данные записаны в файл 'output.bin'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}