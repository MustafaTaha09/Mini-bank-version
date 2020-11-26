package OOP;

import java.util.Scanner;

public class Main {
    public static void mainMenu (Bank b){
        while(true){
            System.out.println("1) Add a client and an account\n" +
                    "2) Display all Clients and their Accounts\n" +
                    "3) Deposit\n" +
                    "4) Withdraw\n" +
                    "5) Display a specific Client\n" +
                    "6) Enter -1 to exit");
            String choice;
            Scanner in = new Scanner(System.in);
            choice = in.next();
            while(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !choice.equalsIgnoreCase("3") && !choice.equalsIgnoreCase("4") && !choice.equalsIgnoreCase("5") && !choice.equalsIgnoreCase("-1")){
                System.out.println("Invalid Option! Enter a valid choice: ");
                choice = in.next();
            }
            if(choice.equalsIgnoreCase("1")){
                b.add();
                System.out.println("Client and Account were added Successfully!");
                mainMenu(b);
            }
            else if(choice.equalsIgnoreCase("2")){
                b.display();
                mainMenu(b);
            }
            else if(choice.equalsIgnoreCase("3")){
                deposit(b);
                mainMenu(b);
            }
            else if(choice.equalsIgnoreCase("4")){
                withdraw(b);
                mainMenu(b);
            }
            else if(choice.equalsIgnoreCase("5"))
            {
                show(b);
                mainMenu(b);
            }
            else if(choice.equalsIgnoreCase("-1")){
                System.out.println("Thank you for using our program!");
                System.exit(0);
            }

        }
    }
    public static void show(Bank b){
        Scanner in = new Scanner(System.in);
        String ID, type;
        if(b.getClientArrayList().size() == 0){
            System.out.println("There are no Clients yet.");
            return;
        }
        System.out.println("Enter the client's type (Commercial/Normal): ");
        type = in.next();
        while(!type.equalsIgnoreCase("Normal") && !type.equalsIgnoreCase("commercial")){
            System.out.println("Please enter a valid option: ");
            type = in.next();
        }
        System.out.println("Enter the client's National ID if it's normal or Commercial's ID if it's commercial: ");
        ID = in.next();

        for(int i=0; i<b.getSize(); i++){
                if(b.getClientArrayList().get(i).checkID(ID)){
                    if(type.equalsIgnoreCase("Commercial") && b.getClientArrayList().get(i).getNationalID().equalsIgnoreCase("00000")){
                        System.out.println(b.getClientArrayList().get(i).toString());
                        return;
                    }
                    else if(type.equalsIgnoreCase("Normal") && !b.getClientArrayList().get(i).getNationalID().equalsIgnoreCase("00000")){
                        System.out.println(b.getClientArrayList().get(i).toString());
                        return;
                    }

                }
                else if(i == b.getSize() -1 && !(b.getClientArrayList().get(i).checkID(ID)))
                {
                    System.out.println("The " + type + " ID u entered doesn't exist! ");
                    return;
                }
            }
        }

    public static void withdraw(Bank b){
        String ID, type;
        double amount;
        if(b.getClientArrayList().size() == 0){
            System.out.println("There are no Clients yet.");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the amount You want to withdraw: ");
        amount = in.nextDouble();
        System.out.println("Enter the client's type (Commercial/Normal): ");
        type = in.next();
        while(!type.equalsIgnoreCase("Normal") && !type.equalsIgnoreCase("commercial")){
            System.out.println("Please enter a valid option: ");
            type = in.next();
        }
        System.out.println("Enter the client's National ID if it's normal or Commercial's ID if it was commercial: ");
        ID = in.next();
        for(int i=0; i<b.getSize(); i++){
            if(b.getClientArrayList().get(i).checkID(ID)){
                if(type.equalsIgnoreCase("Commercial") && b.getClientArrayList().get(i).getNationalID().equalsIgnoreCase("00000")){
                    b.getClientArrayList().get(i).getAccount().withdraw(amount);
                    return;
                }
                else if(type.equalsIgnoreCase("Normal") && !b.getClientArrayList().get(i).getNationalID().equalsIgnoreCase("00000")) {
                    b.getClientArrayList().get(i).getAccount().withdraw(amount);
                    return;
                }
            }
            else if(i == b.getSize() -1 && !(b.getClientArrayList().get(i).checkID(ID)))
            {
                System.out.println("The " + type + " ID u entered doesn't exist! ");
                return;
            }
        }

    }

    public static void deposit(Bank b){
        Scanner in = new Scanner(System.in);
        String ID, type;
        if(b.getClientArrayList().size() == 0){
            System.out.println("There are no Clients yet.");
            return;
        }
        double amount;
        System.out.println("Enter the amount You want to deposit: ");
        amount = in.nextDouble();
        System.out.println("Enter the client's type (Commercial/Normal): ");
        type = in.next();
        while(!type.equalsIgnoreCase("Normal") && !type.equalsIgnoreCase("commercial")){
            System.out.println("Please enter a valid option: ");
            type = in.next();
        }
        System.out.println("Enter the client's National ID if it's normal or Commercial's ID if it was commercial: ");
        ID = in.next();
        for(int i=0; i<b.getSize(); i++){
            if(b.getClientArrayList().get(i).checkID(ID)){
                if(type.equalsIgnoreCase("Commercial") && b.getClientArrayList().get(i).getNationalID().equalsIgnoreCase("00000")){
                    b.getClientArrayList().get(i).getAccount().deposit(amount);
                    return;
                }
                else if(type.equalsIgnoreCase("Normal") && !b.getClientArrayList().get(i).getNationalID().equalsIgnoreCase("00000")) {
                    b.getClientArrayList().get(i).getAccount().deposit(amount);
                    return;
                }
            }
            else if(i == b.getSize() -1 && !(b.getClientArrayList().get(i).checkID(ID)))
            {
                System.out.println("The " + type + " ID u entered doesn't exist! ");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Bank b = new Bank();
        mainMenu(b);

    }
}
