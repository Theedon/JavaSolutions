package dennis;
import java.util.*;
import java.util.Arrays;
            /*Rock beats Scissors
                Scissors beats paper
                Paper beats Rock
            */



public class RockPaperScissors {
    static String[] Weapons= {"ROCK","PAPER","SCISSORS"};



    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        String input= sc.next();
        String userWeapon= correctInput(input);
        String[] newWeapons= Weapon(Weapons, userWeapon);
        String aiWeapon= getWeapon(newWeapons);
        getWinner(userWeapon, aiWeapon);

    }

    public static String[] Weapon(String[] Weapons, String correctInput){
        correctInput= correctInput.toUpperCase();
        ArrayList<String> tempArr= new ArrayList<>();
        tempArr.addAll(Arrays.asList(Weapons));
        tempArr.remove(correctInput);
        String[] newWeapons= tempArr.toArray(new String[0]);
        return newWeapons;

    }

    public final static String getWeapon(String[] Weapons){
        Random random= new Random();
        int randNumber= random.nextInt(Weapons.length);
        String aiWeapon= Weapons[randNumber];
        return aiWeapon;

    }

    public static String correctInput(String input){
        input= input.toUpperCase();
        String userWeapon="";
        switch (input){
            case "S":
                userWeapon= "Scissors";
                break;
            case "R":
                userWeapon= "Rock";
                break;
            case "P":
                userWeapon= "Paper";
                break;
            default:
                userWeapon= "error";
                break;
        }

        return userWeapon;
    }

    public static String getWinner(String userWeapon, String aiWeapon){
        String comp= "COMPUTER";

        userWeapon= userWeapon.toUpperCase();
        aiWeapon= aiWeapon.toUpperCase();
        String winner= "";
        String output;
        if (userWeapon.equals("SCISSORS")){
            if (aiWeapon.equals("ROCK"))winner= aiWeapon;
            if (aiWeapon.equals("PAPER"))winner= userWeapon;
        }

        if (userWeapon.equals("PAPER")){
            if (aiWeapon.equals("SCISSORS"))winner= aiWeapon;
            if (aiWeapon.equals("ROCK"))winner= userWeapon;
        }

        if (userWeapon.equals("ROCK")){
            if (aiWeapon.equals("PAPER"))winner= aiWeapon;
            if (aiWeapon.equals("SCISSORS"))winner= userWeapon;
        }
        if(userWeapon.equals("ERROR")){
            output= "ERROR!\nWRONG INPUT\nTRY AGAIN!";
        }
        else{
            output= "You vs "+comp+"\n"+userWeapon+" vs "+aiWeapon
                    +"\n"+winner+" wins";

        }

        System.out.println(output);
        if (!(userWeapon.equals("ERROR"))){
            if(userWeapon.equals(winner)){ System.out.println("You win!");}
            else System.out.println(comp+" wins!");
        }

        return winner;

    }
}
