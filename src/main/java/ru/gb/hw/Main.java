package ru.gb.hw;

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

        //Task 3
        FilePrefixAdder.addPrefixToFiles("new_", "./test/1.txt", "./test/2.txt", "file3.txt");

    }
}