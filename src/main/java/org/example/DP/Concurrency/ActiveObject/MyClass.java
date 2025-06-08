package org.example.DP.Concurrency.ActiveObject;

import java.util.concurrent.ForkJoinPool;

public class MyClass {
    private double val;
    private final ForkJoinPool fj = new ForkJoinPool(1,
            ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);

    public void doSomething() {
        fj.execute(() -> val = 1);
    }

    public void doSomethingElse() {
        fj.execute(() -> val = 2);
    }

    public double getVal() {
        return val;
    }
}
