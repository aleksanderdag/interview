package org.example.DP.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventSource {
    List<Observer> observers = new ArrayList<>();

    public void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        String enterText = "Enter Text: ";
        System.out.print(enterText);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
            System.out.print(enterText);
        }
    }
}
