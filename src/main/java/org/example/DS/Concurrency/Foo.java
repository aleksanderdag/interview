package org.example.DS.Concurrency;

import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;

public class Foo {
    PrintStream out = System.out;
//    private CountDownLatch latch1 = new CountDownLatch(0);
    private CountDownLatch latch2 = new CountDownLatch(1);
    private CountDownLatch latch3 = new CountDownLatch(1);

    public Foo() {}

    public void print(String str) { out.print(str); }
    public void first() throws InterruptedException { first(() -> print("first")); }
    public void second() throws InterruptedException { second(() -> print("second")); }
    public void third() throws InterruptedException { third(() -> print("third")); }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch2.await();
        latch2 = new CountDownLatch(1);

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        latch3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch3.await();
        latch3 = new CountDownLatch(1);

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
