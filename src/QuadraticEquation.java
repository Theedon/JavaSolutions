package newPackage;

import java.util.Scanner;

public class QuadraticEquation {

    private int a, b, c;

    QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getDiscriminant() {
        int discriminant = b * b - (4 * a * c);
        return discriminant;
    }

    public double getRoot1() {
        double root1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
        return root1;
    }

    public double getRoot2() {
        double root2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
        return root2;
    }


}


    class TestClass{

        public static void main(String[] args){

            Scanner sc= new Scanner(System.in);
            System.out.println("input value of a: ");
            int a= sc.nextInt();
            System.out.println("input value of b: ");
            int b= sc.nextInt();
            System.out.println("input value of c: ");
            int c= sc.nextInt();

            QuadraticEquation testObj= new QuadraticEquation(a,b,c);

            if(testObj.getDiscriminant()>0){
                System.out.println(testObj.getRoot1());
                System.out.println(testObj.getRoot2());
            }

            else if(testObj.getDiscriminant()==0){
                System.out.println(testObj.getRoot1());
            }

            else{
                System.out.println("The equation has no roots");
            }

        }

        }




