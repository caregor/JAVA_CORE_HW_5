package ru.gb.hw;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String path = "./test";
       Backup.createBackup(path);
    }
}