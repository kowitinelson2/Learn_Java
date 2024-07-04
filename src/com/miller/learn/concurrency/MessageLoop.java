package com.miller.learn.concurrency;

import static com.miller.learn.concurrency.SimpleThreads.threadMessage;

public class MessageLoop implements Runnable {
    @Override
    public void run() {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        try{
            for (String s : importantInfo) {
                //Pause for 4 seconds
                Thread.sleep(4000);
                threadMessage(s);
            }
        } catch (InterruptedException e) {
            threadMessage("I wasn't done!");
        }
    }

}
