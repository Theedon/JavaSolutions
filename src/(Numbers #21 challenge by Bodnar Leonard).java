/*Read a positive whole number, very if all is it's figures digits are even or odd.
Example:

2468 => TRUE
1245 => FALSE
1357 => TRUE

(Numbers #21 challenge by Bodnar Leonard)

*/
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		String aa= Integer.toString(a);
		String[] b= aa.split("");
		int[] z= new int[b.length];
		int dd= 0;
		for(int i= 0; i<b.length; i++){
			dd= Integer.parseInt(b[i]);
			z[i]= dd;
		}
		int ff, gg=0;
		for(int j=0; j<z.length; j++){
			ff= z[j];
			if(ff%2!=0){
				gg++;
			}
		}
		
		if(gg==0){
			System.out.println("False");
		}
		else{
			System.out.println("True: "+ gg+ " time(s)");
		}
	}
}