package pack;

public class Main {
    public static void main(String[] args) {
        Person Bob = new Person("Bob", 1000, 1234);
        ATM atm = new ATM(new Authentication(Bob));
        atm.Expectation();
        atm.Authentication();
        atm.PerformingOperation();

    }
}