package pack;

public class Person
{
    String Name;
    int Bill, Password;
    Boolean isBlocked = false;

    public Person(String name, int bill, int password) {
        Name = name;
        Bill = bill;
        Password = password;
    }
    public void SetName(String name) {
        Name = name;
    }

    public String GetName() {
        return Name;
    }
    public void SetBill(int bill) {
        Bill = bill;
    }
    public int GetBill() {
        return Bill;
    }

    public void SetPassword(int password) {
        Password = password;
    }
    public int GetPassword() {
        return Password;
    }
    public void SetIsBlocked(Boolean is_Blocked) {
        isBlocked = is_Blocked;
    }
    public Boolean GetIsBlocked() {
        return isBlocked;
    }
}

