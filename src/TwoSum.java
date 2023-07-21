package newPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        ArrayList<Integer> arr= new ArrayList<>();

        System.out.println("input your target");
        int target= scanner.nextInt();
        System.out.println();

        System.out.println("how many elements are in your array");
        int len= scanner.nextInt();
        System.out.println();
        for (int i=0; i<len; i++){
            int j=i+1;
            System.out.println("input element "+ j);
            arr.add(scanner.nextInt());
        }
        System.out.println();


        int[] array= new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            array[i]= arr.get(i);
        }




        int[] resultArray= getIndices(array, target);
        System.out.println("input: "+ arr);
        System.out.println();
        if(resultArray[0]==resultArray[1]){

            System.out.println("output: [null, null]" );
            System.out.println("target"+"("+target+")"+ " can't be gotten");
        }
        else{

            System.out.println("output: "+Arrays.toString(resultArray));

        }

    }

    public static int[] getIndices(int[] nums, int target){
        int[] resultArray = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i==j)continue;
                if(nums[i]+nums[j]==target){
                    if (nums[i]!=nums[j]){
                        resultArray[0]= i;
                        resultArray[1]= j;
                    /*
                    the below code is to terminate loop
                    once the answers had been found
                    no need to continue since there can
                    only be one pair of answers
                    */
                        i=nums.length+1;
                        j=nums.length+1;

                    }

                }
            }
        }



        return resultArray;
    }


}
