public class Main {
	public static void main(String[] args) {
		int a= 11202088;
		String b= Integer.toString(a);
		String[] c= b.split("");
		
		//check array
		String[] d= new String[c.length];
		System.out.println(c.length);
		//use Array
		String[] e= new String[c.length];
		
		
		for(int i=0; i<c.length; i++){
			Boolean bool=true;
			for(String j:d){
				if (c[i]==j){
				bool= true;
				}
			}
			if(bool){
				continue;
			}
			if (bool== false){
				e[i]= c[i];
				d[i]= c[i];
			}
		}
		
		System.out.println(d[4]);
	}
}