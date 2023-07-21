public class Matrix {

    static int[][] add(int a[][], int b[][]) {
        int res[][] = new int[a.length][a[0].length];
        for(int k = 0; k < a.length; k++)
            for(int j = 0; j < a[0].length; j++)
                res[k][j] = a[k][j] + b[k][j];
                
        return res;
    }
    static void print(int a[][]) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " "); 
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int a[][] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}};
        
        int b[][] = {
        {12, 11, 10, 9},
        {8, 7, 6, 5},
        {4, 3, 2, 1}};
    
        print(add(a, b));
        
    }
}