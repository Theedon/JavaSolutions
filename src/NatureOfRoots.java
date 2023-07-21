package dennis;

public class NatureOfRoots {

    public static void main(String[] args){
    double x=1,y=2,z=3,determinant;
    double root1, root2;

    determinant= Math.sqrt((Math.pow(y,2))-4*x*z);

    if(determinant>0){
        root1= -y+((determinant)/2*x);
        root2= -y-((determinant)/2*x);
        System.out.println("Roots are "+root1+" and "+root2);
    }
    else if(determinant==0){
        root1= -y+((determinant)/2*x);
        System.out.println("Root of the equation is "+root1);
    }
    else{
        System.out.println("The equation has no real roots");
    }

    }

}
