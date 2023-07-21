import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str1= sc.nextLine();
		char[] arr1= str1.toCharArray();
		Integer loc=new Integer(0);
		char var= '=';
		int len= arr1.length;
		for(int i=0; i<len; i++){
			if(arr1[i]==var){
			loc= i;
			break;
			}
			
			
		}
		int loc1= loc +1;
		char[] arr2= new char[100];
		int locArr2=0;
		for(int j=loc1; j<len; j++){
			arr2[locArr2]= arr1[j];
			locArr2++;
		}
		
		
		
		
		System.out.print(arr2);
		//we could also use println, it jsnt relevant in this case
		
	}
}