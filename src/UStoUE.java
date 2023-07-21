package SololearnComplete;

import java.util.Scanner;

public class UStoUE {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter date in US format:  ");
        String inp= sc.nextLine();

        System.out.println(convertToEu(inp));
    }

    public static int getDateFormat(String inp){
        int format= 0;
        int lengthOfString= inp.length();
        if(lengthOfString<=10){
            format= 1;
        }
        else {
            format= 2;
        }
        return format;
    }

    public static String convertToEu(String inp){
        String result= "";
        if(getDateFormat(inp)==1){
            String[] tempArr= inp.split("/");
            result= tempArr[1]+"/"+tempArr[0]+"/"+tempArr[2];
        }

        else if (getDateFormat(inp)==2){
            String[] tempArr= inp.split(" ");
            int monthNumber= convertMonthToNumber(tempArr[0]);
            result= tempArr[1]+"\b/"+monthNumber+"/"+tempArr[2];

        }

        else {
            result= null;
        }
        return result;
    }

    public static int convertMonthToNumber(String month){
        int monthNumber= 0;
        switch (month.toLowerCase()){
            case "january":
                monthNumber= 1;
                break;
            case "february":
                monthNumber= 2;
                break;
            case "march":
                monthNumber= 3;
                break;
            case "april":
                monthNumber= 4;
                break;
            case "may":
                monthNumber= 5;
                break;
            case "june":
                monthNumber= 6;
                break;
            case "july":
                monthNumber= 7;
                break;
            case "august":
                monthNumber= 8;
                break;
            case "september":
                monthNumber= 9;
                break;
            case "october":
                monthNumber= 10;
                break;
            case "november":
                monthNumber= 11;
                break;
            case "december":
                monthNumber= 12;
                break;


        }
        return monthNumber;
    }


}
