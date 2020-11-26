package OOP;

public class Client {
    private String name;
    private String nationalID;
    private String address;
    private String phone;
    private Account account;

    public Client(String name, String nationalID, String address, String phone, Account acc) {
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        this.account = acc;


    }

    public Client() {
        this.name = "";
        this.nationalID = "00000000000";
        this.address = "";
        this.phone = "";

        this.account = new Account();
    }

    public String getAddress() { return address; }

    public String getName() { return name; }

    public String getNationalID() { return nationalID; }

    public String getPhone() { return phone; }

    public Account getAccount() { return account; }

    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setAddress(String address) { this.address = address; }

    public void setAccount(Account account) { this.account = account; }

    public void setNationalID(String nationalID) { this.nationalID = nationalID; }

    public boolean checkID(String s){
        if(nationalID.equalsIgnoreCase(s))
            return  true;
        else
            return false;
    }
    public String toString() {
        return "Normal Client's Info:\n" + "Name: " + name
                + "\nNational ID: " + nationalID +
                "\nAddress: " + address + "\nPhone: " + phone + "\nAccount Info:" + "\nBalance = " + account.getBalance()
                + "\nAccount Number is " + account.getAccountNumber();
    }

}
