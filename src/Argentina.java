import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		float pesos=  sc.nextInt();
		float usd= sc.nextInt();
		float pesoToCents= pesos*2;
		float pesoToDollars= pesoToCents/100;
		
		if(pesoToDollars>usd){System.out.println("Dollars");}
		else {System.out.println("Pesos");}
	}
}