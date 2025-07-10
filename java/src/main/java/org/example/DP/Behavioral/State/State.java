package org.example.DP.Behavioral.State;

@FunctionalInterface
public interface State {
    void doAction();

    State TVStartState = () -> System.out.println("TV is turned ON");
    State TVStopState = () -> System.out.println("TV is turned OFF");
}
