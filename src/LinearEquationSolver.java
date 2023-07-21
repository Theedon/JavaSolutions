package dennis;
import java.util.*;
public class LinearEquationSolver {

    public static void main(String[] args){
        String inp= "1 = 2x - 3";
        ArrayList<String> list= new ArrayList<>();
        list.addAll(Arrays.asList(inp.split("=")));
        System.out.println(list);
        String answer= list.get(containsEqual(list));
        System.out.println(answer);

        String[] newStr1= answer.split(" ");
        ArrayList<String> newStr= new ArrayList<>();
        Collections.addAll(newStr, newStr1);
        int b=-1;
        for(int i=0; i<newStr.size(); i++){
            if(newStr.get(i).contains("x")){
                b=i;

            }

        }

        System.out.println(b);





    }

    public static int containsEqual(ArrayList<String> list){
        int ind = 0;
        if (list.get(0).contains("x")){
            ind= 0;
        }
        if (list.get(1).contains("x")){
            ind= 1;
        }

        return ind;
    }




}
