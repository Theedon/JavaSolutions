package LeetCode;

public class MaximumGain {

    public static void main(String[] args){
        int[] prices= {7,1,5,3,6,4};

        int best= bestTimeToSell(prices);

        System.out.println("\n\n"+best);
    }




    public static int bestTimeToSell(int[] prices){
        int sellIndex=0;
        int buyIndex=0;
        int gain=0;
        //int[] result= getLowest(prices);

        for(int i=0; i<prices.length; i++){
            for(int j=0; j<prices.length; j++){
                if(i==j)continue;
                if(i<j)continue;

                if((prices[i]-prices[j])>gain){
                    sellIndex= i;
                    buyIndex= j;
                    gain= prices[i]-prices[j];
                }
            }
        }
        String out= null;
        if (sellIndex==0 && buyIndex==0)out= "no best day" +
                " for transaction";
        else {
            out= "buy at "+prices[buyIndex]+" on day "+
                    (buyIndex+1)+" sell at "+prices[sellIndex]+" on day "+
                    (sellIndex+1)+" to make "+ gain+" gain(s).";
        }

        System.out.println(out);

        return gain;
    }

   /* public static int[] getLowest(int[] arr){

        int lowestIndex= 0;
        int highestIndex= 0;
        int lowest= arr[0];
        int highest= arr[0];

        for (int i=0; i<arr.length; i++){
            if(arr[i]<lowest){
                lowestIndex= i;
                lowest= arr[i];
            }
            if (arr[i]>highest){
                highestIndex= i;
                highest= arr[i];
            }

        }
        int[] result= {lowest, lowestIndex, highest, highestIndex};
        return result;



    }*/




}
