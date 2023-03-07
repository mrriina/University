package pack;

public interface ATMState
{
    void Expectation_(ATM atm);
    void Authentication_(ATM atm);
    void PerformingOperation_(ATM atm);
    void Blocking_(ATM atm);
}

