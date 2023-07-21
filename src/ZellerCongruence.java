package dennis;
import java.util.ArrayList;

public class ZellerCongruence {

    public static void main(String[] args){
        System.out.println(dayOfWeek(2000, "february", 10));
    }


    /*public static String dayOfWeek(int year, int month, int dayOfMonth){
        String[] daysOfWeek= new String[]{"Saturday", "Sunday",
                "Monday", "Tueday", "Wednesday", "Thursday", "Friday",};
        int h;
        int m=month;
        int j=year/100; //century
        int k= year%7; //year of century,
        int q=dayOfMonth;
        h= (((q+(26*(m+1)/10)) + k + (k/4) + (j/4) + 5*j) % 7);

        String dayOfWeek= daysOfWeek[h];
        return dayOfWeek;

    }*/

    public static String dayOfWeek(int year, String month, int dayOfMonth){
        /*METHOD OVERLOAD FOR IF USER USES A STRING AS THE MONTH INSTEAD OF USING THE APPROPRIATE INTEGER
        ONLY DIFFERENCE IN THEIR SIGNATURES IS THE MONTH WHICH DATATYPE IS STRING HERE
        IT WAS INTEGER IN THE PREVIOUS METHOD DECLARATION
        */

        month.toLowerCase(); //convert user input to small letter to avoid conflicts

        String[] months = new String[]{"january", "february", "march", "april", "may", "june", "july",
        "august", "september", "october", "november", "december"};

        String[] daysOfWeek= new String[]{"Saturday", "Sunday",
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",};
        int h;

        int m= 0; //month
        for(int i=0; i<months.length; i++){
            if (months[i]== month){
                if(month.equals("january")||month.equals("february")){
                    m=i+13;
                    year-=1;
                    break;
                }
                else {
                    m= i+1;
                    break;
                }
                }

            else {
                //do nothing
            }
        }//this is to get the Integer of the month the user input


        int j=year/100; //century
        int k= year%7; //year of century,
        System.out.println(j);
        int q=dayOfMonth;
        h= (((q+(26*(m+1)/10)) + k + (k/4) + (j/4) + (5*j)) % 7);

        String dayOfWeek= daysOfWeek[h];
        return dayOfWeek;
    }
}
