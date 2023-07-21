package LeetCode;

public class LongestValidParentheses {
    public static void main(String[] args){
        String input= "()(()))()(()()()(()";
        System.out.println(Solution.longestValidParentheses(input));
    }

}

class Solution{

    public static int longestValidParentheses(String inp){
        char[] a= inp.toCharArray();
        char current='1';
        int count= 0;
        for(int i=0; i<a.length; i++){
           if(current=='(' && a[i]==')'){
               count++;
           }

           current= a[i];
        }



        return count*2;
    }
}
