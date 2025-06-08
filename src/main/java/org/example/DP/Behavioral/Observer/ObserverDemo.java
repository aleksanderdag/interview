package org.example.DP.Behavioral.Observer;

/*
 * Observer Pattern or pub/sub moves the work from deps to parent.
 * It transforms polling to pushing.
 * Reduces all subs to a single trigger in pub (no other way to enter).
 *
 * Passing data in the update is the preferred way, but if data is too large to copy,
 * sub can hold pub ref if change value is accessed via getter after update is called
 */
public class ObserverDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addObserver(event -> System.out.println("Received response: " + event));
        eventSource.scanSystemIn();
    }
}
