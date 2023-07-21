package dennis;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class EditTextRegex {

    public static void main(String[] args){
        //File rubbish= new File("C:\\Users\\Theedon\\Desktop\\junit\\rubbish.txt");
        //System.out.println(rubbish.exists()?"yes":"no");

        String string = "";
        try{
            File rubbish= new File("C:\\Users\\Theedon\\Desktop\\junit\\rubbish.txt");
            Scanner sc= new Scanner(rubbish);
            while (sc.hasNextLine()){
                string+= " "+ sc.nextLine();

            }


        }
        catch (Exception e){
            System.out.println("didn't work");
        }


        replace3(string);



    }

    public static String replace3(String string){
    string= string.trim();
    string= string.replaceAll("\\s[0-9]\\s", " three ");
        System.out.println(string);

        return string;
    }


}
