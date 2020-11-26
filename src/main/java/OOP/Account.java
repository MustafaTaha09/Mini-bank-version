package OOP;


public class Account {
    private double balance;
    private String accountNumber;

    public Account() {
        balance = 0;
        accountNumber = "";
    }

    public Account(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String toString() {
        return "Normal Account details: \n" + "Balance = " + balance
                + "\nAccount Number is " + accountNumber;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Can't withdraw that much amount from a normal account!");
            return;
        }
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
