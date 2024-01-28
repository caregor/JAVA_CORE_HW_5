package ru.gb.hw;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ShowFilesInCurrentDir {
    public void printFiles() {
        File file = new File(".");
        for (File f : Objects.requireNonNull(file.listFiles())) {
            System.out.println(f.getName());
        }
    }

    public void printAllFilesRecursively() {
        File file = new File(".");
        int level = 0;
        for (File f : Objects.requireNonNull(file.listFiles())) {
            diveDeep(f, level);
        }
    }

    private void diveDeep(File currentFile, int level) {
        if (currentFile.isFile()) {
            System.out.println("  ".repeat(level) + currentFile.getName());
        } else {
            System.out.println("  ".repeat(level) + currentFile.getName().toLowerCase() + ":");
            for (File file : Objects.requireNonNull(currentFile.listFiles())) {
                diveDeep(file, ++level);
            }
        }
    }

    private void diveDeepFromTimofey(File currentFile, int level) {
        if (currentFile.isFile()) {
            System.out.println("    ".repeat(level) + currentFile.getName());
        } else {
            System.out.println("    ".repeat(level) + currentFile.getName().toLowerCase() + ":");
            ++level;
            for (File file : Objects.requireNonNull(currentFile.listFiles())) {
                diveDeepFromTimofey(file, level);
            }
        }
    }

}
