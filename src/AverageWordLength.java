import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String input= sc.nextLine();
	input= input.toUpperCase();
	String[] inputL= input.split("");
	List<String> list= new ArrayList<>();
	List<String> list2= new ArrayList<>();
	for(String i:inputL){
		list.add(i);
	}
	
	
	
	
	for(String s:list){
		if(isAlphabet(s)==true){
			list2.add(s);
		}
	}
	
	
	String ansQ= "";
	for(String m:list2){
		ansQ= ansQ+m;
	}
	
	
	String[] ansR= ansQ.split(" ");
	
	int ansFinal= findAverage(ansR);
	System.out.println(ansFinal);
	
	}
	
	
	
	
	
	
	
	
	public static boolean isAlphabet(String inp){
		boolean check=false;
		String alphab= " abcdefghijklmnopqrstuvwxyz".toUpperCase();
		
		String[] arr= alphab.split("");
		inp= inp.toUpperCase();
		
		if(true){
			for(String i:arr){
				if(inp.equals(i)){
					check= true;
				
				}
		}
		}
		
		
		return check;
		
	}

	
	public static int findAverage(String[] str){
		int len= str.length;
		int totalNum=0;
		int average;
		for(int z=0; z<len; z++){
			totalNum+= (str[z]).length();
		}
		average=(int) Math.ceil(((float) totalNum/len));
		return average;
	}
	
	

}
