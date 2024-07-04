package com.miller.learn.basicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class CountLetters {

    private Path file;
    private char toLookFor;

    public CountLetters(char toLookFor, Path file) {
        this.toLookFor = toLookFor;
        this.file = file;
    }

    public int count() throws IOException {
        int count = 0;
        try(FileReader in = new FileReader(String.valueOf(this.file));
            BufferedReader reader = new BufferedReader(in)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (toLookFor == line.charAt(i)){
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }


}
