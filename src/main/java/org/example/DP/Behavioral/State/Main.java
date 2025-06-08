package org.example.DP.Behavioral.State;

import static org.example.DP.Behavioral.State.State.TVStartState;
import static org.example.DP.Behavioral.State.State.TVStopState;

/**
 * State is just interface implementation with finitely many states.
 */
public class Main {
    public static void main(String[] args) {
        TVContext context = new TVContext();
        context.setState(TVStartState);
        context.doAction();
        context.setState(TVStopState);
        context.doAction();
    }
}
