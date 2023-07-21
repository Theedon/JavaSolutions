import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String textRaw= s.nextLine();
		
		String[] text= textRaw.split(" ");
		int len= text.length;
		String c= "";
		char d= 'f';
		
		for(int i=0; i<len; i++){
		c= text[i];
		d= c.charAt(0);
			text[i]= text[i]+d+"ay";
			text[i]= text[i].substring(1);
			
		}
		String ans=text[0];
		for(int j=1; j<len; j++ ){
			ans= ans+" "+text[j];
		}
		System.out.println(ans);
	}
}