package LeetcodeJune;
import java.util.Arrays;

 public class SearchInsertPosition {
	public static int SearchInsert(int[] arr, int num) {
		//Create an array of type integer;
		
		int num2 = -1;
		int len= arr.length;
		int[] arr2= new int[len+1];
		boolean num3= false;
		int num4=0;
		for(int i=0; i<len; i++) {
		if(arr[i]==num)
			num2= i;
		
		
		}
		if(num2==-1) {
			num3= true;
			for(int j=0; j<len; j++) {
				arr2[j]= arr[j];
				
			}
		arr2[len]= num;
		Arrays.sort(arr2);
		
		for(int j=0; j<arr2.length; j++  ) {
			if(arr2[j]==num) {
				num2=j;
			}
		}
		
		}
		/*
		 * The below code wasn't relevant for the challenge i was trying for, it was only to make it all spicy
		 *  
		if(num3==true) {
			String str= "Your number wasn't in the array provided so i added it to index "+num2+" of the list";
			System.out.println(str); 
		}
		*/
		
		return num2;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}