import java.util.*;
public class Numbergame
{
    int num, count,score=0;
    public Numbergame(int n)   //Constructor to initialize data members
    {
     num=n;   //initializing random number
    }
    public int guess()
    {
        //Taking input for number from the user
        Scanner sc=new Scanner(System.in);
        System.out.print("Guess the number: ");
        return sc.nextInt();    //returning user's guess
    }
    public boolean check()  //function to check and display whether the entered number is correct or not
    {
        count=0;    //variable to count number of attempts
        while(count<5) //Limiting the no. of attempts to 5
        {
            int x=guess();  //Storing the guessed number in a variable
            if (x==num) //Checking if guessed number is correct
            {
                System.out.println("Correct Number!");
                return true;
            }
            else if (x<num) //Checking if guessed number is less than actual number
            {
                System.out.println("Number entered is too low!\n");
            }
            else if(x>num)  //Checking if the guessed number is greater than the actual number
            {
                System.out.println("Number entered is too high!\n");
            }
            count++;
        }
        System.out.println("YOU LOST!\nCorrect number was "+num+"\nTRY AGAIN LATER!");
        return false;
    }
    public int getscore()
    {
        if (count==1)
            score=25;
        else
            score=5*(5-count+1);
        return score;
    }
    public static void main(String args[])  //main() function for the program
    {
        Scanner sc=new Scanner(System.in);
        int total_rounds=0,rounds_won=0,total_score=0;
        boolean play_again=true;
        while(play_again)
        {
            int x=(int)(Math.random()*100)+1;   //generating a random number between 1 and 100
            Numbergame obj=new Numbergame(x);   //Creating object of the class Numbergame
            System.out.println("ROUND "+(total_rounds+1)+"\nGuess a number between 1 and 100.\n");
            total_rounds++;
            if(obj.check())
            {
                int round_score=obj.getscore();
                total_score+=round_score;
                rounds_won++;
                System.out.println("Congratulations! You won "+round_score+" points.");
            }
            System.out.println("Do you want to play another round?(yes/no):");
            String ch=(sc.next().toLowerCase()).trim();
            play_again=ch.equals("yes");
        }
        System.out.println("\nGAME OVER!");
        System.out.println("Total Rounds Played: "+total_rounds);
        System.out.println("Rounds Won: "+rounds_won);
        System.out.println("Final Score: "+total_score+" points");
    }
}