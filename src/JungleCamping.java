import java.util.Scanner;
import java.util.ArrayList;
//import java.util.LinkedList
import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		
		
	
		ArrayList<String> list= new ArrayList<>();
		
		HashMap<String, String> linList= new HashMap<>();
		
		linList.put("Rawr", "Tiger");
		linList.put("Chirp", "Bird");
		linList.put("Ssss", "Snake");
		linList.put("Grr", "Lion");
		
		Scanner sc= new Scanner(System.in);
		String inp= sc.nextLine();
		
		String[] str= inp.split(" ");
		for(String x: str){
			list.add(x);
		}
		
		
		int aLen= list.size();
		
		ArrayList list2= new ArrayList();
		String ans= new String();
		String iter= new String();
		
		for(String z: list){
			
			iter= linList.get(z);
			ans= ans+iter+" ";
			
		}
		System.out.println(ans);
		
	}
}