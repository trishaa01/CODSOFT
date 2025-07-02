import java.util.*;
public class Numbergame
{
    int num;
    public Numbergame(int n)   //Constructor to initialize data members
    {
     num=n;   //initializing num with parameter of the constructor
    }
    public int guess()
    {
        //Taking input for number from the user
        Scanner sc=new Scanner(System.in);
        System.out.print("Guess the number: ");
        int g=sc.nextInt();
        return g;   //returning user's guess
    }
    public void check()  //function to check and display whether the entered number is correct or not
    {
        int count=0;    //variable to count number of attempts
        
        while(count<=5) //Limiting the no. of attempts to 5
        {
            int x=guess();  //Storing the guessed number in a variable
            if (x==num) //Checking if guessed number is correct
            {
                System.out.println("Correct Number!");
                count++;
                return;
            }
            else if (x<num) //Checking if guessed number is less than actual number
            {
                System.out.println("Number entered is too low!\n");
                count++;
            }
            else if(x>num)  //Checking if the guessed number is greater than the actual number
            {
                System.out.println("Number entered is too high!\n");
                count++;
            }
        }
        System.out.println("YOU LOST!\nCorrect number was "+num+"\nTRY AGAIN LATER!");
    }
    
    public static void main(String args[])  //main() function for the program
    {
        int x=(int)(Math.random()*100)+1;   //generating a random number between 1 and 100
        Numbergame obj=new Numbergame(x);   //Creating object of the class Numbergame
        obj.check();        //Calling the check() function of Numbergame class
    }
}