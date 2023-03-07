package pack;

public class ATM
{
    private ATMState State;

    public ATMState getState() {
        return State;
    }

    public void setState(ATMState state) {
        State = state;
    }

    public ATM(ATMState state) {
        State = state;
    }

    public void Expectation() {
        State.Expectation_(this);
    }

    public void Authentication() {
        State.Authentication_(this);
    }

    public void PerformingOperation() {
        State.PerformingOperation_(this);
    }

    public void Blocking() {
        State.Blocking_(this);
    }
}

