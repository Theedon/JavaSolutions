package dennis;

import java.util.ArrayList;
import java.util.Arrays;

public class strStr {

    public static void main(String[] args){
        System.out.println("".contains(""));
        ArrayList<String> arrayList= new ArrayList<>();
        for(int i=0; i<90; i++){
            String ii= Integer.toString(i);
            arrayList.add(ii);
        }
        String[] str= (String[]) arrayList.toArray(new String[0]);
        System.out.println(Arrays.toString(str));




    }


}
