import com.miller.learn.basicio.CountLetters;
import com.miller.learn.concurrency.TestThread;


import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the patience in ms: ");
        String patience = input.nextLine();
        TestThread.test(patience);
    }
}