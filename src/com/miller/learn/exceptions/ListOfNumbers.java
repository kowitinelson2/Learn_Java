package com.miller.learn.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

}
