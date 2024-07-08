package com.miller.learn.concurrency;

public class ProducerConsumerExample {
    public static void testRun() {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
