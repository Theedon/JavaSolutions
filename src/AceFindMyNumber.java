/*Here's an interesting challenge for those interested: find my number! 

I will leave the clues here, and your job is to write a program to figure out the number! Seems simple enough right?Cool! Let's have some fun!

Between 1 and 1000, there is only 1 number that meets the following criteria:

1. The number has two or more digits.
2. The number is prime.
3. The number does NOT contain a 1 or 7 in it.
4. The sum of all of the digits is less than or equal to 10.
5. The first two digits add up to be odd.
*6. The second to last digit is even and greater than 1. 
7. The last digit is equal to how many digits are in the number.

So what's my number? Programs are better than proofs here! {^_^}

*Clarification: (So if the number is 2 or 3 digits, you want the digit in the 10s spot)
*/

public class Main {
    public static void main(String[] args) {
        int check= 0;
    

        for(int i=0; i<=1000; i++){
            if((Integer.toString(i)).length()>=2){
                //This checks for the first condition
                if(isPrime(i)){
                    if(isNotHave17(i)){
                        if(sumLess10(i)){
                            if(addToOdd(i)){
                                if(evenGreater1(i)){
                                    if(lastEqualsLen(i)){
                                        System.out.println(i);
                                    }
                                }
                            }
                        }
                        
                    }
                        }
                
                
            }
            
            
            
        }
        
    }
    
    
    /*The below are methods theck check for the conditions before being called in the main class above
    */
    
    public static boolean isPrime(int a){
        //checks if the number is prime 
        int check=0;
        for(int i=0; i<a-1; i++){
            if(i==0)continue;
            if(a%i==0)check++;
        }
        if(check>2)return false;
        else return true;
    }
    
    public static boolean isNotHave17(int b){
    //checks if The number does NOT contain a 1 or 7 in it.
        String a= Integer.toString(b);
        int check= 0;
        int len= a.length();
        for(int i=0; i<len; i++){
            if(a.charAt(i)=='1' || a.charAt(i) == '7'){
                check++;
            }
        }
        if(check==0) return true;
        else return false;
    }
    
    public static boolean sumLess10(int c){   
    //checks if The sum of all of the digits is less than or equal to 10.
        String a= Integer.toString(c);
        String[] b= a.split("");
        int sum=0;
        for(int i=0; i<b.length; i++){
            sum+= Integer.parseInt(b[i]);
        }
        if(sum<=10){
            return true;
        }
        else return false;
    }
    
    public static boolean addToOdd(int d){
    //checks if The first two digits add up to be odd.
        String a= Integer.toString(d);
        String[] aa= a.split("");
        int sum=0;
        for(int i=0; i<aa.length; i++){
            if(i>1)break;
            sum+= Integer.parseInt(aa[i]);
        }

        if(sum%2==0)return false;
        else return true;
    }
    
    public static boolean evenGreater1(int e){
        //checks if The second to last digit is ///even and greater than 1.
        String a= Integer.toString(e);
        String[] b= a.split("");
        int check= Integer.parseInt(b[b.length-2]);
        if(check>1&&check%2==0)return true;
        else return false;
    }
    
    public static boolean lastEqualsLen(int f){
        //checks if The last digit is equal to how many digits are in the number.
        String a= String.valueOf(f);
        String[] b= a.split("");
        int lenOfNum= b.length;
        int lastDigit= Integer.parseInt(b[lenOfNum-1]);
        if(lenOfNum==lastDigit)return true;
        else return false;
    }
    
    
    
}