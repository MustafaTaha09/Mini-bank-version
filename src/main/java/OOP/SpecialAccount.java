package OOP;

public class SpecialAccount extends Account {


    public void withdraw(double amount) {
        if (getBalance() - amount < -1000) {
            System.out.println("Can't withdraw that much amount from a special Account!");
            return;
        }
        setBalance(getBalance() - amount);
    }

    public SpecialAccount(double balance, String accountNumber) {
        super(balance, accountNumber);
    }

    public SpecialAccount() {
        super();
    }

    @Override
    public String toString() {
        return "Special Account details: \n" + "Balance = " + getBalance()
                + "\nAccount Number is " + getAccountNumber();
    }


}
