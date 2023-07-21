package dennis;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;

public class SelectionSort {

    public static void main(String[] args){

   /* int[] arr= new int[10];
    for(int i=0; i<arr.length; i++){
        arr[i]=(int) Math.round(Math.random()*100);

    }
        System.out.println(Arrays.toString(arr)+"\n");


        int min= arr[0];
        for(int i=0; i<arr.length; i++){
            int old=0;
            for(int j=i; j<arr.length; j++){
                if(arr[j]<min){
                    min= arr[j];
                    old=j;
                }
            }
            System.out.println(min);

            int temp= arr[i];
            arr[i]= min;



        }

        System.out.println(Arrays.toString(arr));

*/

        LinkedList<Integer> list= new LinkedList<>();
        list.add(8);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(1);
        list.add(3);
        list.add(0);
        System.out.println(list);

        for(int i= 0; i<list.size()-3; i++){
            int min= i;
            for(int j=i; j<list.size(); j++){
                if(list.get(min)>list.get(j)){
                    min= list.get(i);
                }

            if(min!=i)Collections.swap(list, i, list.indexOf(min));
            }
        }
        System.out.println(list);
    }
}
