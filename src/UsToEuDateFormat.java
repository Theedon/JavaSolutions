
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String date= sc.nextLine();
		
		String[] arr, arr1;
		arr= date.split("/");
		arr1= new String[arr.length];
		String month="";
		
		if(date.length()<11){
		arr1[0]= arr[1];
		arr1[1]= arr[0];
		arr1[2]= arr[2];
		}
		
		if(date.length()>11){
			arr1[1]= (arr[0]).toLowerCase();
			switch(arr1[1]){
				case "january":
				month="1";
				break;
				case "february":
				month="2";
				break;
				case "march":
				month="3";
				break;
				case "april":
				month="4";
				break;
				case "may":
				month= "5";
				break;
				case "june":
				month= "6";
				break;
				case "july":
				month= "7";
				break;
				case "august":
				month= "8";
				break;
				case "september":
				month= "9";
				break;
				case "october":
				month= "10";
				break;
				case "november":
				month="11";
				break;
				case "december":
				month="12";
				break;
			}
				arr1[0]= arr[1];
				arr1[1]= month;
				arr1[2]= arr[2];
			
			}
			String symb="/";
			String euDate= arr1[0]+symb+arr1[1]+symb+arr1[2];
			System.out.println(euDate);
			
	}
}