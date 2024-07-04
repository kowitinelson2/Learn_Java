package com.miller.learn.concurrency;

import static com.miller.learn.concurrency.SimpleThreads.threadMessage;

public class TestThread {
    public static void test(String args) throws InterruptedException {
        // Delay, in ms before we interrupt message loop thread (default 1 hr)
        long patience = 1000 * 60 * 60;

        // if args is present, give patience in seconds
        if (!args.isEmpty()) {
            try{
                patience = Long.parseLong(args) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting Message Loop Thread...");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish...");
        // loop until messageloop thread exits
        while(t.isAlive()) {
            threadMessage("Still Waiting...");
            // wait a maximum of 1 second for messageLoop thread to finish
            t.join(1000);

            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                threadMessage("Tired of waiting :( ");
                t.interrupt();
                // should not be long now
                // wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally! :) ");

    }
}
