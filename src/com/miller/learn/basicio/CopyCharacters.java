package com.miller.learn.basicio;

import java.io.*;

public class CopyCharacters {
    public void readAndWriteCharacters() throws IOException {
        try (FileReader inputStream = new FileReader("xanadu.txt");
             FileWriter outputStream = new FileWriter("outagain.txt")) {
            int c;
            while( (c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void lineCharactersReadAndWrite() throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
             PrintWriter outputStream = new PrintWriter("outagain.txt")) {
            String l;
            while((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
