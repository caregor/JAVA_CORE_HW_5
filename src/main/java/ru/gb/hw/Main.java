package ru.gb.hw;

import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Task 1
        String path = "./test";
        Backup.createBackup(path);

        //Task 2
        int[] fieldValues = {1, 0, 2, 3, 1, 2, 0, 3, 2};
        String filePath = "./output.bin";
        //Упаковка данных
        Convert.convertData(fieldValues);
        //Извлечение данных из файла(для проверки)
        int[] dataFromBinFile = BinaryFileProcessing.getBinaryData(filePath);

        System.out.println("Исходные значения из упакованных данных:");
        Arrays.stream(dataFromBinFile).forEach(System.out::print);

    }
}