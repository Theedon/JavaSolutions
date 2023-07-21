package PersonalFunctions;
import java.util.ArrayList;
import java.util.Scanner;


public class LabNumber {
	
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int input= sc.nextInt();
		ArrayList<Integer> divisor= Divisors(input);
		System.out.println("Divisors are "+ divisor+ "\n");
		ArrayList<Integer>primeDivisor= primeDivisors(divisor);
		System.out.println("Prime Divisors are "+ primeDivisor+"\n");
		boolean isLab= isLabNumber(divisor, primeDivisor);
		
		if(isLab==true) {
			System.out.println(input+" is a Lab number");
		}
		else System.out.println(input+" is not a Lab number");
		
	}
	
	
	
	
	public static ArrayList<Integer> Divisors(int input){
		ArrayList<Integer> divisor= new ArrayList<Integer>();
		for(int i=2; i<input; i++) {
			if(input%i==0) divisor.add(i);
		}
		return divisor;
	}
	
	public static ArrayList<Integer> primeDivisors(ArrayList<Integer> list){
		ArrayList<Integer> primeDivisor= new ArrayList<Integer>();
		for(Integer i:list) {
			if(isPrime(i)) {
				primeDivisor.add(i);
			}
		}
		return primeDivisor;
		
	}
	
	public static boolean isPrime(int inp) {
		ArrayList l1= new ArrayList();
		int check= 0;
		for(int i=1; i<inp; i++) {
			if(inp%i==0) {
				check++;
			}else continue;
		}
		
		if(check<2)return true;
		else return false;
	}
	
	public static boolean isLabNumber(ArrayList<Integer> divisor,
			ArrayList<Integer> primeDivisor) {
			boolean isLab= false;
			
			for(Integer primeDivisorNumber:primeDivisor) {
				int squareOfprimeDivisorNumber= (int) Math.pow(primeDivisorNumber,2);
				if(divisor.contains(squareOfprimeDivisorNumber)) {
					isLab=true;
					break;
				}
				else isLab=false;
			}
		
		
				return isLab;
		
	}
}
