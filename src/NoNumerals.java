import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String input= sc.nextLine();
	
	//	input= input.replaceLast("10", " ten");
		input=input.replace("10", "ten");
	
		String[] inp= input.split("");
		String[] newL= new String[inp.length];
		//to merge 1 and 0
		ArrayList<String> list= new ArrayList<>();
		ArrayList<String> list2= new ArrayList<>();
		for(String m:inp){
			list.add(m);
		}
		
		/*for(int check=0; check<list.size();check++){
			if(check<list.size()){
			if(list.get(check)=="1"&&list.get(check+1)=="0"){
				list2.add("10");
				continue;
			}
			}
			
			
			if(check>0){
				if(list.get(check)=="0"&&list.get(check-1)=="1"){
					continue;
				}
			}
			list2.add(list.get(check));
		}
		System.out.println(list);
		System.out.println(list2);
		*/
		
		for(int i=0; i<inp.length; i++){
			
			if(convertToWord(inp[i])!=null){
				newL[i]=convertToWord(inp[i]);
			}
			else{
				newL[i]= inp[i];
			}
		}
		 String s="";
		 for(int i=0; i<newL.length; i++ ){
		 	
		 	s= s+newL[i];
		 }
		 	
		 
	
		
		 
	System.out.println(s);
	
		
	}
	public static String convertToWord(String s){
		HashMap<String, String> hashmap= new HashMap<>();
		hashmap.put("0", "zero");
	hashmap.put("1", "one");
	hashmap.put("2", "two");
	hashmap.put("3", "three");
	hashmap.put("4", "four");
	hashmap.put("5", "five");
	hashmap.put("6", "six");
	hashmap.put("7", "seven");
	hashmap.put("8", "eight");
	hashmap.put("9", "nine");
	hashmap.put("10", "ten");
		String converted= hashmap.get(s);
		return converted;
	}
	
	
	
}