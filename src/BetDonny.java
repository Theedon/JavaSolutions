package dennis;
import java.util.Scanner;
import java.util.ArrayList;

public class BetDonny {


    //None of the odds on each team must be lesser than 2.0
    //if it is then you won't make a real profit
    //made by Theedon +2348102942321 getdonnyapps@gmail.com

    /*public static void main(String[] args){
        System.out.println(betDonny(15000, "chelsea", 1.3, "barca", 3.5 ));
    }*/

    public static String betDonny(double totalStake, String team1, double odd1, String team2, double odd2){
        double val1;

        val1= odd1+odd2;
        double val2= Math.round((odd1/val1)*totalStake);
        double val3= Math.round((odd2/val1)*totalStake);
        double totalReturn= Math.round(val2*odd2);
        double gain= Math.round(totalReturn-totalStake);

        if(odd1>2.0&&odd2>2.0){
            String string= "Stake on "+team1+" :"+(int) val3+"\n"+"Stake on "+team2+" :"+(int) val2+"\n\n"+
                    "Your return: "+(int) totalReturn+"\n"+ "Your gain from this bet will be "+(int) gain;
            return string;
        }
        else return null;
    }


}

