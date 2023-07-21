package dennis;

import java.util.Scanner;

public class CollatzConjecture {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int input= sc.nextInt();
        while (input!=1){
            input= isEvenOrIsOdd(input);
        }

    }




    public static int isEvenOrIsOdd(int inp){
        if (inp>1){
            int output=0;
            if(inp%2==0){
                output=inp/2;
                System.out.println(inp+"/2 ="+output);
            }
            if (inp%2!=0){
                output= (inp*3)+1;
                System.out.println(inp+"*3+1 ="+output);
            }
            return output;
        }


        return inp;
    }

}
