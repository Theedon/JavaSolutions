package SololearnComplete;

import java.util.Arrays;
import java.util.Scanner;

public class YoutubeLinkFinder {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter date in US format:  ");
        String inp= sc.nextLine();

        System.out.println(getNewLink(inp));
        //String inp= "https://www.youtube.com/watch?v=kbxkq_w51PM";
        //String inp2= "https://youtu.be/KMBBjzp5hdc";



    }

    public static int getLinkFormat(String inp){
        int format= 0;
        if(inp.contains("watch")){
            format= 1;
        }
        else {
            format= 2;
        }
        return format;
    }

    public static String getNewLink(String inp){
        String newLink="";
        if(getLinkFormat(inp)==1){
            String[] tempArray= inp.split("");
            boolean start= false;
            for(String i: tempArray){


                if(start!= true){

                }
                else {
                    newLink+= i;
                    continue;
                }

                if(i.equals("=")){

                    start= true;
                }

            }
        }

        else if(getLinkFormat(inp)==2){
            String[] tempArray= inp.split("/");
            newLink= tempArray[3];
        }
        else {
            newLink= "";
        }

        return newLink;
    }
}
