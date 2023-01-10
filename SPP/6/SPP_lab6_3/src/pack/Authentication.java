package pack;
import java.util.Scanner;

public class Authentication implements ATMState {
        Person person;

        public Authentication(Person per) {
            person = per;
        }
        public void Expectation_(ATM atm) {
            if (person.GetIsBlocked() == true) {
                Blocking_(atm);
                return;
            }
            System.out.println("Ожидание ввода данных...");
        }
        public void Authentication_(ATM atm) {
            Scanner scanner = new Scanner(System.in);
            if (person.GetIsBlocked() == true) {
                Blocking_(atm);
                return;
            }
            int pin, numTry = 0;

            do {
                System.out.println("Введите пароль:");
                pin = scanner.nextInt();
                if (person.GetPassword() == pin) {
                    System.out.println("Пароль введён верно!");
                    return;
                } else {
                    System.out.println("Пароль введён неверно!");
                    numTry++;
                    if (numTry == 3) {
                        Blocking_(atm);
                        return;
                    }
                }
            }
            while (person.GetPassword() != pin);
        }
        public void PerformingOperation_(ATM atm) {
            if (person.GetIsBlocked() == true) {
                Blocking_(atm);
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите сууму для снятия: ");
            int sum = scanner.nextInt();

            if (sum > person.GetBill()) {
                System.out.println("Недостаточно денег на счёте!");
            }
            if (sum <= person.GetBill()) {
                person.SetBill(person.GetBill() - sum);
                System.out.println("Выдача денег...");
                System.out.println("Остаток на счёте: " + person.GetBill());
            }
        }
        public void Blocking_(ATM atm) {
            person.SetIsBlocked(true);
            System.out.println("Ваша карта заблокирована!");
        }
 }

