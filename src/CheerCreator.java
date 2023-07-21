import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int inp= (new Scanner(System.in)).nextInt();
	if(inp<1){
		System.out.println("shh");
	}
	if(inp>0&&inp<11){
		for(int i=inp; i>0; i--){
			System.out.print("Ra!");
		}
	}
	if(inp>10)System.out.println("High Five");
	}
}