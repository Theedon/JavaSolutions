import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int inp= s.nextInt();
		int inp2= s.nextInt();
		float a=((float) inp)/12;
		if(a>=inp2){
			System.out.println("Buy it!");
		}
		else{
			System.out.println("Try again");
		}
		
	}
}