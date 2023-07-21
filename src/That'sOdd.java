import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int len= sc.nextInt();
		int[] listA= new int[len];
		for(int i=0; i<len; i++){
			listA[i]= sc.nextInt();
		}
		List<Integer> listB = new ArrayList<Integer>();
		for(int i: listA){
			if(i%2==0){
				listB.add(i);
			}
			else{}
		}
		int add=0;
		int add2= 0;
		int[] newList= new int[listB.size()];
		for(int i=0; i<newList.length; i++){
			newList[i]= listB.get(i);
			add+= listB.get(i);
			add2+= newList[i];
		}
		
		System.out.println(add2);
	}
}