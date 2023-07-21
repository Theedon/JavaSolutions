import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		String a= "abcdefghijklmnopqrstuvwxyz";
		String[] b= a.split("");
		String[] c= new String[b.length];
		for(int i=0,j=b.length-1; i<b.length; i++,j--){
			c[i]= b[j];
			System.out.println(c[i]);
		}
		ArrayList<String> listA= new ArrayList<>();
		ArrayList<String> listB= new ArrayList<>();
		for(String i:b){
			listA.add(i);
		}
		for(String i:c){
			listB.add(i);
		}
	
		
		
	}
		public static String encrypt(String str){
			String a;
			String b;
			String[] z= str.split("");
			for(String i: z){
				if(listA.contains(i)){
			b= listB.get(5);
				}
			}
			
			return null;
		}
}