import java.util.*;
public class Student
{
    int n;
    String name;
    double[] marks;
    public Student(int a,String nm)
    {
        name=nm;
        n=a;
        marks=new double[n];
    }
    public void input()
    {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter marks in subject "+(i+1)+": ");
            marks[i]=sc.nextDouble();
        }
    }
    public double findtotal()
    {
        double total=0;
         for(int i=0;i<n;i++)
        {
            total+=marks[i];
        }
        return total;
    }
    public double average()
    {
        return Math.round((findtotal()/n)*100.0)/100.0;
    }
    public String grades()
    {
        double a=average();
        if (a>=90)
            return "A++";
        else if (a>=85)
            return "A+";
        else if (a>=80)
            return "A";
        else if (a>=75)
            return "B+";
        else if (a>=70)
            return "B";
        else if (a>=60)
            return "C";
        else if (a>=50)
            return "D";
        else if (a>35)
            return "E";
        else
            return "F";
    }
    public void display()
    {
        double avg=average();
        System.out.println("Name: "+name+"\nTotal Marks: "+findtotal()+"\nAverage Percentage: "+avg+"\nGrades: "+grades());
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of Student: ");
        String st_name=sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int num=sc.nextInt();
        Student obj=new Student(num,st_name);
        obj.input();
        obj.display();
    }
}