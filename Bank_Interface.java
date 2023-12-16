import java.util.Scanner;

interface BankInterface // Interface Definition
{
    public abstract double getBalance(); // abstract class declarations
    public abstract double getInterestRate();
}

class BankA implements BankInterface // BankA class implements the interface
{
    double balance;

    BankA(double balance)
    {
        this.balance=balance;
    }

    @Override
    public double getBalance() //Method Definitions
    {
        return balance;
    }

    @Override
    public double getInterestRate()
    {
        return 0.7;
    }
}

class BankB implements BankInterface //BankB class implements the interface
{
    double balance;

    BankB(double balance)
    {
        this.balance=balance;
    }

    @Override
    public double getBalance()
    {
        return balance;
    }

    @Override
    public double getInterestRate()
    {
        return 0.74;
    }
}

class BankC implements BankInterface //BankC class implements the interface
{
    double balance;

    BankC(double balance)
    {
        this.balance=balance;
    }

    @Override
    public double getBalance()
    {
        return balance;
    }

    @Override
    public double getInterestRate()
    {
        return 0.79;
    }
}

public class Bank_Interface
{
     public static void main(String args[]) // Main Method definition
    {
        Scanner sc = new Scanner(System.in);
        double deposit_A = 10000;
        BankA b1 = new BankA(deposit_A);
        double deposit_B = 150000;
        BankB b2 = new BankB(deposit_B);
        double deposit_C = 200000;
        BankC b3 = new BankC(deposit_C);
        System.out.println("Display on Balance and Rate of Interest");
        System.out.println("----------------------------------------");
        System.out.println("Bank A details:");
        System.out.println("Balance: " + b1.getBalance());
        System.out.println("Interest Rate: " + b1.getInterestRate() * 100 + "%");
        System.out.println("----------------------------------------");
        System.out.println("Bank B details:");
        System.out.println("Balance: " + b2.getBalance());
        System.out.println("Interest Rate: " + b2.getInterestRate() * 100 + "%");
        System.out.println("----------------------------------------");
        System.out.println("Bank C details:");
        System.out.println("Balance: " + b3.getBalance());
        System.out.println("Interest Rate: " + b3.getInterestRate() * 100 + "%");
        sc.close();
    }
}