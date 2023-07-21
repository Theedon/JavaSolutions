package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args){
        int[][] matrix= {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOder(matrix));
    }



    public static List<Integer> spiralOder(int[][] matrix){
        List<Integer> spiralOrder= new ArrayList<>();
        int row= matrix.length;
        int column= matrix[0].length;
        int elements= row*column;
        int up=0, left= 0, right= column-1, down= row-1;
        int x=0, y=0;

        while (elements>0){
            while (y<=right){
                spiralOrder.add(matrix[x][y++]);
                elements--;
            }
            up++; x++; y--;

            while (elements>0 && x<=down){
                spiralOrder.add(matrix[x++][y]);
                elements--;
            }
            right--; x--; y--;

            while (elements>0 && y>=left){
                spiralOrder.add(matrix[x][y--]);
                elements--;
            }
            down--; x--; y++;

            while (elements>0 && x>=up){
                spiralOrder.add(matrix[x--][y]);
                elements--;
            }
            left++; y++; x++;



        }
        return spiralOrder;
    }
}
