import java.util.Scanner;
 class Password{
	public static String calcPassword(String input) {
	
		String symbol= "!@#$%&*";
		char[] sym= symbol.toCharArray();
		
		String number= "0123456789";
		char[] num= number.toCharArray();
		
		char[] inp= input.toCharArray();
		
		int inpLen= inp.length;
		int check= 0;
		int check3=0;
		if(inpLen>=7){
			check=1;
		}
		
		
		
		for(char i: inp){
			for(char a: num){
				if(check>2){
					break;
				}
				if(a==i){
					check+=1;
				}
				
				}
				
				
			for(char b:sym){
				int check2= 2;
				if(check3==check2){
					break;}
				if(b==i){
					check3+=1;
					
				}
				
			} 
					
		}
		
		check+=check3;
		if(check>=5){
			return "Strong";
		}
		else{return "Weak";}

		
	}
	
}
	public class Main{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		String userInput= sc.nextLine();
		String ans= Password.calcPassword(userInput);
		System.out.println(ans);
	}
}