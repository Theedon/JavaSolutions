import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int input= sc.nextInt();
		float tPrice=(float) ((40)+(5.0*input));
		float tax= ((float)(10.0/100.0))*tPrice;
		float total= tax+tPrice;
		int fin= Math.round(total);
		
		
		System.out.println((int) fin);
	}
}