import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int input= sc.nextInt();
		ArrayList<Integer> list= new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(1);
		
		for(int i=3; i<=input; i+=1){
			int ans=(i-list.get(i-1))+(i-list.get(i-2));
			list.add(ans);
		}
		
		System.out.println(list.get(input));

	}
}