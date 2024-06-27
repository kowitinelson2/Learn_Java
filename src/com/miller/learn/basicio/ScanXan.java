package com.miller.learn.basicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScanXan {

    public void breakInputIntoTokens() throws IOException {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")))){
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }

    public void translatingIndividualTokens() throws IOException {
        double sum = 0;
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")))) {
            s.useLocale(Locale.US);
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    System.out.println(s.next());
                }
            }
        }
        System.out.println(sum);
    }
}
