package OOP;

public class CommercialClient extends Client {
    private String commercialID;

    public void setCommercialID(String commercialID) {
        this.commercialID = commercialID;
    }

    public String getCommercialID() {
        return commercialID;
    }

    CommercialClient(String commercialID) {
        super();
        this.commercialID = commercialID;
    }

   @Override
   public boolean checkID(String s){
        if(commercialID.equalsIgnoreCase(s))
            return true;
        else
            return false;
    }

    CommercialClient(String name, String nationalID, String address, String phone, String commercialID, Account acc) {
        super(name,"00000", address, phone, acc);
        this.commercialID = commercialID;
    }
    @Override
    public String toString() {
        return "Commercial Client's Info:\n" + "Name: " + getName()
                + "\nCommercial ID: " + commercialID +
                "\nAddress: " + getAddress() + "\nNational ID: " + getNationalID() + "\nPhone: " + getPhone() + "\nAccount Info:" + "\nBalance = " + getAccount().getBalance()
                + "\nAccount Number is " + getAccount().getAccountNumber();
    }
}
