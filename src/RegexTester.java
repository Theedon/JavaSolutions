package dennis;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTester {

    public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    String regex= (".*((\\w)\\s+)(?!\\2).*");
    String string= "fufyxxxxxPPPPyyy";
    Pattern pattern= Pattern.compile(regex);
    Matcher matcher= pattern.matcher(string);
    //System.out.println(matcher.find()?"found it":"Not found");

    String y= string.replaceAll("x*(P*)y+", "$`");
        System.out.println(y+" "+ string);
    }

}
