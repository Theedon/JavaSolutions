package newPackage;

import java.util.Scanner;

public class LinearEquation {

    private int a,b,c,d,e,f;

    public LinearEquation(int a, int b, int c, int d, int e, int f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }

    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getC(){
        return c;
    }
    public int getD(){
        return d;
    }
    public int getE(){
        return e;
    }
    public int getF(){
        return f;
    }

    public boolean isSolvable(){
        if((a*d)-(b*c)!=0){
            return true;
        }
        else
            return false;
    }

    public double getX(){
        double x= ((e*d)-(b*f))/((a*d)-(b*c));
        return x;
    }

    public double getY(){
        double y= ((a*f)-(e*c))/((a*d)-(b*c));
        return y;

    }

}

    class TestClass2{
        public static void main(String[] args){
            Scanner sc= new Scanner(System.in);
            System.out.println("input the value of a");
            int a= sc.nextInt();
            System.out.println("input the value of b");
            int b= sc.nextInt();
            System.out.println("input the value of c");
            int c= sc.nextInt();
            System.out.println("input the value of d");
            int d= sc.nextInt();
            System.out.println("input the value of e");
            int e= sc.nextInt();
            System.out.println("input the value of f");
            int f= sc.nextInt();

            LinearEquation obj2= new LinearEquation(a,b,c,d,e,f);

            if(obj2.isSolvable()){
                System.out.println(obj2.getX());
                System.out.println(obj2.getY());
            }
            else {
                System.out.println("The equation has no solution");
            }


        }
    }
