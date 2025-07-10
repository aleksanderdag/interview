package org.example.DP.Concurrency.ActiveObject;

public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        myObject.doSomething();
        System.out.println(myObject.getVal());
        myObject.doSomethingElse();
        System.out.println(myObject.getVal());
    }
}
