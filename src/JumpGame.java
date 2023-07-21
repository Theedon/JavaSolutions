package LeetCode;

import java.util.Arrays;

public class JumpGame {


    public static void main(String[] args){
        int[] nums1= {2,3,1,1,4};
        int[] nums2= {3,2,1,0,4};
        String solNums1= Arrays.toString(nums1)+" = "+canJump(nums1);
        String solNums2= Arrays.toString(nums2)+" = "+canJump(nums2);
        System.out.println(solNums1+"\n"+solNums2);
    }

    public static boolean canJump(int[] nums){
        int current=0;
        int target=nums.length-1;
        boolean canJump= false;

        for(int i=1; i<nums.length; i++){


            if(current==0){
                current++;
                //System.out.println("initial jump from 0 to 1");
                continue;
            }

            try{
                String out= "jump from "+ current+" ";
                if(nums[current]==0){
                    break;
                }
                current+= nums[current];
                out+= "to "+current;
                //System.out.println(out);
                if(current==target){
                    canJump=true;
                    break;

                }
            }
            catch (Exception e){
                //System.out.println("while the most recent jump is not possible");
                break;
            }




        }


        return canJump;
    }
}
