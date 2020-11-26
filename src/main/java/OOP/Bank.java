package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Account> accountArrayList;
    private ArrayList<Client> clientArrayList;

    public Bank() {
        this.name = "";
        this.address = "";
        this.phone = "";
        this.accountArrayList = new ArrayList<Account>();
        this.clientArrayList = new ArrayList<Client>();
    }

    public Bank(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.accountArrayList = new ArrayList<Account>();
        this.clientArrayList = new ArrayList<Client>();
    }
    public int getSize(){ return clientArrayList.size();}

    public ArrayList<Client> getClientArrayList() { return clientArrayList; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public void add() {
        Scanner in = new Scanner(System.in);
        String name, nationalID, address, phone, commercialID,accountNumber, Accounttype;
        double balance;

        System.out.println("Enter the client's Name: ");
        name = in.next();
        System.out.println("Enter the Client's address: ");
        in.skip("\n");
        address = in.nextLine();
        System.out.println("Enter the Client's phone: ");
        phone = in.next();

        System.out.println("Enter the type of client whether Commercial or Normal: ");
        String Clienttype = in.next();

        while (!Clienttype.equalsIgnoreCase("Commercial") && !Clienttype.equalsIgnoreCase("Normal")) {
            System.out.println("Invalid option! write either Commercial or Normal");
            Clienttype = in.next();
        }

        System.out.println("Enter the type of the Account whether Special or Normal");
        Accounttype = in.next();
        while (!Accounttype.equalsIgnoreCase("Normal") && !Accounttype.equalsIgnoreCase("Special")) {
            System.out.println("Invalid option write either Special or Normal");
            Accounttype = in.next();
        }
        System.out.println("Enter the Account's balance: ");
        balance = in.nextDouble();
        System.out.println("Enter the Account's account number: ");
        accountNumber = in.next();

        if (Clienttype.equalsIgnoreCase("Commercial")) {
            System.out.println("Enter the client's commercial ID: ");
            commercialID = in.next();
            if (Accounttype.equalsIgnoreCase("Normal")) {

                clientArrayList.add(new CommercialClient(name, "00000", address, phone, commercialID,new Account(balance, accountNumber)));
                accountArrayList.add(clientArrayList.get(clientArrayList.size()-1).getAccount());
            } else if (Accounttype.equalsIgnoreCase("Special")) {

                clientArrayList.add(new CommercialClient(name, "00000", address, phone, commercialID ,new SpecialAccount(balance, accountNumber)));
                accountArrayList.add(clientArrayList.get(clientArrayList.size()-1).getAccount());
            }

        } else if (Clienttype.equalsIgnoreCase("Normal")) {

            System.out.println("Enter the Normal Client nationalID: ");
            nationalID = in.next();

            if (Accounttype.equalsIgnoreCase("Normal")) {

                clientArrayList.add(new Client(name, nationalID, address, phone, new Account(balance, accountNumber)));
                accountArrayList.add(clientArrayList.get(clientArrayList.size()-1).getAccount());

            } else if (Accounttype.equalsIgnoreCase("Special")) {

                clientArrayList.add(new Client(name, nationalID, address, phone, new SpecialAccount(balance, accountNumber)));
                accountArrayList.add(clientArrayList.get(clientArrayList.size()-1).getAccount());

            }

        }


    }

    public void display() {
        if(clientArrayList.size() == 0)
        {
            System.out.println("There are no clients neither accounts to display yet!");
            return;
        }
        for(int i=0; i<clientArrayList.size(); ++i)
        {
            System.out.println(clientArrayList.get(i).toString());
        }
    }


}
