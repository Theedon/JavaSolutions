package dennis;

import java.util.ArrayList;
import java.util.Scanner;

public class GapfulNumber {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int inp= sc.nextInt();
        ArrayList list= isGapfulNumber(inp);
        String output= gapfulMessage(inp, list);
        System.out.println(output);


    }

    public static ArrayList isGapfulNumber(int inp){
        ArrayList list= new ArrayList<>();
        boolean isGapful= false;
        String inpToString= Integer.toString(inp);
        String[] inpStringArray= inpToString.split("");
        int firstAndLast= Integer.parseInt(inpStringArray[0]+inpStringArray[inpStringArray.length-1]);
        if(inp%firstAndLast==0)isGapful= true;
        else isGapful= false;
        list.add(firstAndLast);
        list.add(isGapful);
        return list;

    }

    public static String gapfulMessage(int inp, ArrayList list){
        String output= null;
        boolean isGapful= (boolean) list.get(1);
        int firstAndLast= (int) list.get(0);
        if(isGapful){
            output= isGapful+" ("+inp+" is gapful because it is divisible by "+ firstAndLast+")";
        }
        else output= isGapful+" ("+inp+" is not gapful because it is not divisible by "+ firstAndLast+")";

        return output;
    }

    public static boolean forTestCase(int inp){
        ArrayList list= isGapfulNumber(inp);
        return (boolean) list.get(1);
    }
}
