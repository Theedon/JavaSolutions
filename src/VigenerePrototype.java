public class Main {
	public static void main(String[] args) {
		char[] a= {'D','E','Z'};
		char[] b= {'A','B','C'};
		char[] c= new char[a.length];
		char[] d= new char[a.length];
		for(int i=0; i<b.length; i++){
			c[i]= (char) (((a[i]+b[i])%26)+'A');
		}
		System.out.println(c);
		
		for(int i=0; i<c.length; i++){
			d[i]= (char) (((c[i]-b[i]+26)%26)+'A');
		}
		System.out.println(d);
	}
}