package LeetCode;

import java.util.Arrays;

public class RotateImage {


    public static void main(String[] args){
        int[][] matrix= {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        int[][] matrix2= {{1,2,3}, {4,5,6}, {7,8,9}, {11,12,13}};
        rotate(matrix);

    }

    public static int[][] rotate(int[][] matrix){

        //first to get the transpose
        int temp;
        for(int i=0; i<matrix[0].length; i++){
            for(int j=i; j<matrix[0].length; j++){
                temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }


        //second to reverse each single array in the 2d array

        for(int i=0; i<matrix.length; i++){
            matrix[i]= reverseArray(matrix[i]);
        }

        for(int i=0; i<matrix.length; i++){
            System.out.print(Arrays.toString(matrix[i])+", ");
        }


        return matrix;
    }

    public static int[] reverseArray(int[] arr){
        int temp;
        int len= arr.length;
        for(int i=0, j=len-1; i<arr.length && i<=j; i++,j--){
            temp= arr[i];
            arr[i]= arr[j];
            arr[j]= temp;

        }

        return arr;
    }
}
