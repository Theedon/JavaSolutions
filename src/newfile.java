class A{
	public int aa, ab, ac;
	private String bb,bc,bd;
	A(){
		System.out.println("no condition");
	}
	A(int b){
		System.out.println(b*4);
	}
	public void scream(String str){
		String den;
		den= str;
		System.out.println(den);
	
	}
	
}

   class B extends A{
   	public int steal(int gg){
   		aa= gg;
   		System.out.println(aa);
   	return aa;
   	}
   }


public class Main {
	public static void main(String[] args) {
		B daay= new B();
		daay.steal(6);
		
	}
}