package com.modernjava.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderJava8 {
    static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("/home/aa100150/repos/farinaz/modern-java/src/main/java/com/modernjava/lambdas/hi.txt"))) {
            return p.process(br);
        }
    }

    static void readFile() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLines = processFile((BufferedReader br) -> br.readLine() + "\n" + br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLines);
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
