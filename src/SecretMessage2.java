import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String input= sc.nextLine().toLowerCase();
		String[] inpArr= input.split("");
		String out= reverseStr(inpArr);
		System.out.println(out);
		
	}
		public static String reverseStr(String[] inpArr){
			String alph= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			alph=alph.toLowerCase();
			String[] alphArr= alph.split("");
			String[] alphRe= new String[alphArr.length];
			for(int y=0,z=alphArr.length-1; z>=0; y++,z--){
				alphRe[y]= alphArr[z];
				 } 
		
			
			
			String out="";
			for(String i : inpArr){
				if(i.equals(" ")){
					out+=i;
				}
				else{
				
					for(int j=0; j<alphArr.length; j++){
						
						if(alphArr[j].equals(i)){
							
							out+=alphRe[j];
							
						}
						
						
					}
					
				}
			}
			
			return out;
			
		
	}
}