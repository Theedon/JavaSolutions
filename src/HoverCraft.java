package SololearnComplete;
import java.util.Scanner;

public class HoverCraft {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int inp= sc.nextInt();
        int debit= (2000000*10)+ 1000000;
        long credit= inp*3000000;

        if(credit>debit){
            System.out.println("Profit");
        }

        else if(credit==debit){
            System.out.println("Broke Even");
        }

        else {
            System.out.println("Loss");
        }
    }




}
