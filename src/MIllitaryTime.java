import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String time= sc.nextLine();
		String[] list= time.split(":");
		String hour= list[0];
		String min= list[1].substring(0,2);
		String range= list[1].substring(3,5);
		boolean check= false;
		
		String nHour, nMin, nRange;
		nHour="";
		
		if(range.equals("PM")){
			int a= Integer.parseInt(hour);
			a= (a+12)%24;
			nHour= Integer.toString(a);
			if(a==0)nHour="12";
			
		}
		
		if(range.equals("AM")){
			nHour= hour;
			if(nHour.equals("12"))nHour="00";
		}
		nMin= min;
		
		System.out.println(nHour+":"+nMin);
		
	}
}