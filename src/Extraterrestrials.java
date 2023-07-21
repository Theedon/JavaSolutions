import java.util.Scanner;
import java.util.Arrays;
public class Extraterrestrials
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
       String input= sc.nextLine();
        String[] inpArr= input.split("");
        String[] inpArr2= new String[inpArr.length];
        for(int i=inpArr.length-1, j=0; i>=0; i--,j++){
            inpArr2[i]= inpArr[j];
            
            
        }
        String out="";
        for(String i:inpArr2){
        	out+=i;
        }
        out=out.trim();
        System.out.println(out);
      
    }
}