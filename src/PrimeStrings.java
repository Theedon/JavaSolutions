package dennis;
import java.util.*;

public class PrimeStrings {

    public static void main(String[] args){
        String input= "99999";

        ArrayList<Object> returner= isPrimeString(input);
        sortEqualStrings(returner);

    }

    public static ArrayList<Object> isPrimeString(String input){
        ArrayList<Object> returner= new ArrayList<>();
       ArrayList<String> list= new ArrayList<String>();
        ArrayList<String> list2= new ArrayList<String>();
        ArrayList<String> list3= new ArrayList<String>();

        String[] inpArray= input.split("");
        list.addAll(Arrays.asList(inpArray));

        System.out.println("iiiiiiii"+Collections.frequency(list, "9"));

        for(String i:list){
            int occurrences1= Collections.frequency(list2, i);
            int occurrences2= Collections.frequency(list3, i);

            if (list2.contains(i)) list3.add(i);
            if (!(list2.contains(i))) list2.add(i);
        }



        System.out.println(list2);
        System.out.println(list3);
        returner.add(list2);
        returner.add(list2);
        return returner;
    }

    public static boolean sortEqualStrings(ArrayList<Object> returner){
        ArrayList<String> list2= (ArrayList<String>) returner.get(0);
        ArrayList<String> list3= (ArrayList<String>) returner.get(1);


        int diff;
        ArrayList<String> fakeList2= (ArrayList<String>) returner.get(0);
        System.out.println(fakeList2);
        for(String i:fakeList2){
            System.out.println(i);
            int occurrences1= Collections.frequency(list2, i);
            int occurrences2= Collections.frequency(list3, i);

            System.out.println("occurrences: "+occurrences1+" "+occurrences2);
            if (occurrences1!=occurrences2){
                diff= occurrences2-occurrences1;
                for (int j=0; j<diff; j++){
                    list2.add(i);
                    list3.remove(i);

                }
            }
        }
        fakeList2= (ArrayList<String>) returner.get(1);
        for(String i:fakeList2){
            System.out.println(i);
            int occurrences1= Collections.frequency(list2, i);
            int occurrences2= Collections.frequency(list3, i);

            System.out.println("occurrences: "+occurrences1+" "+occurrences2);
            if (occurrences1!=occurrences2){
                diff= occurrences2-occurrences1;
                for (int j=0; j<diff; j++){
                    list2.add(i);
                    list3.remove(i);

                }
            }
        }

        System.out.print("\nyaya: ");
        System.out.println(list2);
        System.out.println(list3);

        return false;
    }



}
