package dennis;

import java.util.Arrays;
import java.util.Scanner;

public class SummationsCalculator {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String inp= sc.nextLine();
        String[] inpArray= inp.split(" ");
        char symbol=  inpArray[2].charAt(0);
        String obj= inpArray[2].substring(1);
        int lowerBound= Integer.parseInt(inpArray[0]);
        int upperBound= Integer.parseInt(inpArray[1]);
        String output="";
        int answer=0;


            for (int i=lowerBound; i!=upperBound+1; i++){
                if(symbol=='*'){
                    output+= i+"*"+obj+" + ";
                    answer+= (i*Integer.parseInt(obj));
                }

                if (symbol=='+'){
                    output+= i+"+"+obj+" + ";
                    answer+= (i+Integer.parseInt(obj));
                }

                if (symbol=='-'){
                    output+= i+"-"+obj+" + ";
                    answer+= (i-Integer.parseInt(obj));
                }

                if (symbol=='%'){
                    output+= i+"%"+obj+" + ";
                    answer+= (i%Integer.parseInt(obj));
                }

                if (symbol=='/'){
                    output+= i+"/"+obj+" + ";
                    answer+= (i/Integer.parseInt(obj));
                }
            }

            output= trimPlus(output);
            String finalOutput= answer+"("+output+")";
            System.out.println(finalOutput);





    }

    public static String trimPlus(String inp){
        inp= inp.trim();
        if(inp.endsWith("+")){
            inp= inp.substring(0, inp.length()-1);
            inp= inp.trim();
        }
        return inp;
    }

}
