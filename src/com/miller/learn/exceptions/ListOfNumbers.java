package com.miller.learn.exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;
    //constructor
    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() throws IOException {
        /*The try-with-resources statement automatically releases system resources when no longer needed
         A resource is an object that must be closed after the program is finished with it.*/

        try(FileWriter f = new FileWriter("Output.txt");
            PrintWriter out = new PrintWriter(f)) {
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i));
            }
        }
    }

    public void readList(String fileName) throws IOException {
        try(FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    list.add(number);
                    System.out.println(number);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Non integer data encountered" + line);
                }
            }
        }

    }

}
