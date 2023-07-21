package dennis;

public class factorial {

    public static void main(String[] args){
        getFactorial(7);



    }



    /*public static void factorial(int n){
        long sum=1;
        if(n>=1) {
            for (int i = n; i > 0; i--) {
                sum *= i;
            }
            System.out.println(sum);
        }
        else
            System.out.println("sorry");
    }*/

    public static void getFactorial(int n, long sum){
        if(n>1){
            sum*= (n);
            getFactorial(n-1, sum);

        }
        if (n==1){
            System.out.println(sum);
        }
        if(n<1) {
            System.out.println("0 or negative number");
        }
    }

    public static void getFactorial(int n){
        getFactorial(n, 1);
    }
}



