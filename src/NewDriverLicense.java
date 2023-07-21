import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String name= sc.nextLine();
		String num= sc.nextLine();
		int numOfAgents= Integer.parseInt(num);
		String otherNames= sc.nextLine();
		String[] listOtherNames= otherNames.split(" ");
		
		ArrayList<String> list= new ArrayList<>();
		list.add(name);
		for(String namesFromList:listOtherNames){
			list.add(namesFromList);
		}
		
		Collections.sort(list);
	
		int checkPosition=0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i)==name){
				checkPosition= i+1;
				break;
			}
		}
		
		
	    float batch=(float) checkPosition/numOfAgents;
		int ceilBatch=(int) (Math.ceil(batch));
		int time= ceilBatch*20;
		System.out.println(time);
		
		

	}
}