package dennis;

import java.util.Arrays;

public class MaxDiff {
    /*public static void main(String[] args){
        int[] a= {3,1,4,1,5,9,2};
        int[] b= {9,4,6,8,2,2};

        MaxDiff maxDiff= new MaxDiff();
        System.out.println(maxDiff.slow(a));
        System.out.println(maxDiff.fast(a));




    }*/

    public int slow(int[] a){

        int max= a[1]-a[0];
        for(int j=2; j<a.length; j++){
            for(int i=0; i<j; i++){
                if(a[j]-a[i]>max){
                    max=a[j]-a[i];
                }
            }
        }
        return max;
    }

    public int fast(int[] a){
        int max= a[1]-a[0];
        int min= a[0];
        for(int k=1; k<a.length; k++){
            if((a[k]-min)>max){
                max= a[k]-min;
            }
            if(a[k]<min){
                min=a[k];
            }
        }
        return max;
    }
}
