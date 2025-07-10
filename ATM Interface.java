import java.util.*;
public class UserAccount
{
    private double balance;
    
    public UserAccount(double initial_balance)
    {
        this.balance=initial_balance;
    }
    
    public double getbalance()
    {
        return balance;
    }
    
    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance+=amount;
            System.out.println("Rs. "+amount+" has been successfully deposited in the account.");
        }
        else
        {
            System.out.println("Enter a valid amount to deposit.");
        }
    }
    
    public void withdraw(double amount)
    {
        if (amount>0 && amount<=balance)
        {
            balance-=amount;
            System.out.println("Rs. "+amount+" has been successfully withdrawn from the account.");
        }
        else if(amount>balance)
        {
            System.out.println("Insufficient balance!");
        }
        else
        {
            System.out.println("Invalid amount!");
        }
    }
}

class ATM extends UserAccount
{
    Scanner sc=new Scanner(System.in);
    public ATM(double initial_balance)
    {
        super(initial_balance);
    }

    public void interface()
    {
        do
        {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.print("\n Enter your choice: ");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1: System.out.println("\nYour current balance is Rs. "+getbalance());
                    break;
            case 2: System.out.print("\nEnter amount to be withdrawn: ");
                    double withdraw_amt=sc.nextDouble();
                    withdraw(withdraw_amt);
                    break;
            case 3: System.out.print("\nEnter amount to be deposited: ");
                    double deposit_amt=sc.nextDouble();
                    deposit(deposit_amt);
                    break;
            case 4: System.out.println("\nThank you for using this ATM!");
                    break;
            default: System.out.println("\nInvalid choice. Please try again.");
        }
        }
        while (choice!=4);
    }
}
public class ATMInterface
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(Sytem.in);
        System.out.print("Enter initial account balance: ");
        double bal=nextDouble();
        ATM ob=new ATM(bal);
        ob.Interface();
    }
}
