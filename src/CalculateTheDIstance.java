import java.util.Scanner;

public class CalculateTheDIstance {

    public static void main(String[] args){
        int[] listOfDistances= getUserInput();
        float distance= returnDistance(listOfDistances);
        System.out.println(distance);
    }


    public static int[] getUserInput(){
        Scanner sc= new Scanner(System.in);
        int x1= sc.nextInt();
        int x2= sc.nextInt();
        int y1= sc.nextInt();
        int y2= sc.nextInt();

        int[] listOfdistances= {x1,x2,y1,y2};
        return listOfdistances;
    }

    public static float returnDistance(int[] listOfdistances){
       float distance= (float) Math.sqrt((Math.pow((listOfdistances[1]-listOfdistances[0]),2))+
               (Math.pow((listOfdistances[3]-listOfdistances[2]),2)));
       return distance;
    }


}
