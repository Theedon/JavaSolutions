import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Goldbach's conjecture is a rule in math that states the following: every even number greater than 2 can be expressed as the sum of two prime numbers. 

Write a program that finds every possible pair of prime numbers, whose sum equals the given number or a set of numbers within a range.

For example:
Input: 16
Output:
3 + 13
5 + 11

Input: 32
Output: 
3 + 29
13 + 19

Input: 4, 8
Output: 
4: 2 + 2  
6: 3 + 3  
8: 3 + 5
*/

public class GoldbachConjecture {

    public static void main(String args[]){

        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        String[] inpArray= input.split(",");
        for(int i=0; i<inpArray.length; i++){
            inpArray[i]= inpArray[i].trim();
        }


        if(inpArray.length==1){
            int inp= Integer.parseInt(inpArray[0]);

            ArrayList<Integer> primeList= getPrimeList(inp);
            ArrayList<String> goldbachDerivationStrings= goldbachConjecture(inp, primeList);
            for(String i:goldbachDerivationStrings){
                System.out.print(i);
            }

        }

        if(inpArray.length>1){
            for(int nextIndex=0; nextIndex<inpArray.length; nextIndex++){
                int inp= Integer.parseInt(inpArray[nextIndex]);

                ArrayList<Integer> primeList= getPrimeList(inp);
                ArrayList<String> goldbachDerivationStrings= goldbachConjecture(inp, primeList);
                for(String i:goldbachDerivationStrings){
                    System.out.print(i);
                }
                System.out.println("\n");
            }
        }






    }

    public static boolean isPrime(int inp) {
        ArrayList l1= new ArrayList();
        int check= 0;
        for(int i=1; i<inp; i++) {
            if(inp%i==0) {
                check++;
            }else continue;
        }

        if(check<2)return true;
        else return false;
    }

    public static ArrayList<Integer> getPrimeList(int inp){
        ArrayList<Integer> primeList= new ArrayList<>();
        for(int i=2; i<inp; i++){
            if(isPrime(i)) primeList.add(i);

        }
        return primeList;
    }

    public static ArrayList<String> goldbachConjecture(int inp, ArrayList<Integer> primeList){
        boolean isGoldbach= false;
        ArrayList<String> goldbachDerivationStrings= new ArrayList<>();
        for(Integer i: primeList){
            for(Integer k:primeList){
                if(k==i) continue;

                if(i+k==inp){
                    isGoldbach= true;
                    String goldbachDerivation= i+" + "+k+"\n";
                    goldbachDerivationStrings.add(goldbachDerivation);
                }

            }
        }

        //the below code is to make sure there are no repetitions
        int sizeOfList= goldbachDerivationStrings.size();
        ArrayList<String> newGoldbachDerivationStrings= new ArrayList<>();
        for(int i=0; i<sizeOfList/2; i++){
            newGoldbachDerivationStrings.add(goldbachDerivationStrings.get(i));
        }
        System.out.println("is "+ inp+" a Goldbach Conjecture: "+isGoldbach);

        return newGoldbachDerivationStrings;
    }

}
