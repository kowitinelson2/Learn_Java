package com.miller.learn.basicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public void readAndWriteBytes() throws IOException {
        try(FileInputStream in = new FileInputStream("C:\\Users\\nkowiti\\IdeaProjects\\EssentialJavaClasses\\src\\com\\miller\\learn\\basicio\\xanadu.txt");
            FileOutputStream out = new FileOutputStream("C:\\Users\\nkowiti\\IdeaProjects\\EssentialJavaClasses\\src\\com\\miller\\learn\\basicio\\outagain.txt")) {
            int c;
            while ( (c = in.read()) != -1 ) {
                out.write(c);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
