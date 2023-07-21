import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String input= sc.nextLine();
		String a= "abcdefghijklmnopqrstuvwxyz";
		String[] aa= a.split("");
		ArrayList<String> lCase= new ArrayList<>();
		ArrayList<String> nCase= new ArrayList<>();
		
		for(String z:aa){
			lCase.add(z);
			lCase.add(z.toUpperCase());
		}
		String nums= " 0123456789";
		String[] numsList= nums.split("");
		for(String y:numsList){
			lCase.add(y);
		}
	
		
		String[] listInput= input.split("");
		for(String d:listInput){
			if(lCase.contains(d)){
				nCase.add(d);
			}
			if(d==" "){
				nCase.add(d);
			}
			else{
			}
			
	}
	String s= new String();
	for(String j:nCase){
		s= s+j;
	}
	System.out.println(s);
}
}