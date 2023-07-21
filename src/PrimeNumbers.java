package PersonalFunctions;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class PrimeNumbers {
	
	public static boolean getTotalPrime(int input) {
	try {
		Scanner scanner= new Scanner(System.in);
		
		//check if all the prime numbers in the input are the same
		ArrayList<Integer> list= new ArrayList<>();
		ArrayList list2= new ArrayList();
		String inp= Integer.toString(input);
		String[] s= inp.split("");
		
		for(String i:s) {
			
			list.add(Integer.parseInt(i));
			//adding the values of the String to the list that will contain them as Integers
		}
		
		for(Integer j:list) {
			if(isPrime(j)) {
				list2.add(j);
			}
			else continue;
		}
		
		boolean checker= PrimeNumbers.isSame(list2);
		
		
		return checker;
	} catch (IndexOutOfBoundsException e) {
		// TODO Auto-generated catch block
		
		
		System.out.println("There is not a prime number in your input");
		return false;
	}
	catch(Exception e) {
		System.out.println("an error occurred");
		return false;
	}
	
	
	
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
	
	public static boolean isSame(ArrayList listA) {
		Integer a= (Integer) listA.get(0);
		int check= 0;
		for(Object i:listA) {
			if(a!=i) { check++; break;}
			else continue;
			
			
		}
		
		if(check>0)return false;
		else return true;
	}
}
