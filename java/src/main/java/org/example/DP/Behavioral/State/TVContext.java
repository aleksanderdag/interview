package org.example.DP.Behavioral.State;

public class TVContext implements State {
    private State tvState;

    public void setState(State state) {
        tvState = state;
    }

    public State getState() {
        return tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }
}
