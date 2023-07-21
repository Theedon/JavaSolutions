package LeetCode;
import java.util.Arrays;

public class RemoveDuplicatesInArray {

    public static void main(String[] args){
        long startTime= System.currentTimeMillis();

        //edit array here if you want to
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        
        String out= "Input: nums = " + Arrays.toString(nums) + "\n";

        int len= removeDuplicates(nums);
        int[] newNums= new int[len];

        for(int i=0; i<len; i++){
            newNums[i]= nums[i];
        }

        out+= "Output: " + len+", " + "nums = " + Arrays.toString(newNums);

        System.out.println(out);

        long endTime= System.currentTimeMillis();
        long time= endTime-startTime;
        System.out.println("Program took "+ time+" nanoseconds");
    }

    public static int removeDuplicates(int[] nums){
        Arrays.sort(nums);
        int check=0;
        int insert=1;
        for(int i=0; i<nums.length; i++){
            if(i==0){
                check= nums[0];
                continue;
            }
            if(nums[i]==check){
                continue;
            }
            if (nums[i]!=check){
                nums[insert]= nums[i];
                check= nums[i];
                insert++;

            }
        }
        int len= insert;
        System.out.println(Arrays.toString(nums));
        return len;
    }
}
