import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int siblings = input.nextInt();
        int popsicles = input.nextInt();
        
        int a= popsicles%siblings;
        if(a==0)System.out.println("give away");
        else System.out.println("eat them yourself");
        //your code goes here
       
    }
}