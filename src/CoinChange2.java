import java.util.Scanner;

public class CoinChange2 {
	public static void main(String[] args) {
		//Scanner s= new Scanner(System.in);
	//	int inpA= s.nextInt();
		int inpA= 6;
		int[] arrA= {4,2};
		for(int i=0; i<arrA.length;i++){
			if(inpA%arrA[i]==0){
				int tempA1= inpA/arrA[i];
				int var= arrA[i];
				for(int ia= 0; ia<tempA1; ia++ ){
					if(ia==tempA1-1){
						System.out.print(var+"\n");
					}
					else{
					System.out.print(var+"+");
				}
				
				
			}
			
			
			
			
		}
		
		if(inpA%arrA[i]!=0){
			int tmp1= inpA%arrA[i];
			int tmp2= (int) inpA%arrA[i];
			int tmp= arrA[i];
			for(int c:arrA){
				if (c==tmp2){
				int ca= tmp2;
				for(int cb=0; ca<tmp2;ca++){
					if(ca==tmp2-1){
						System.out.println(tmp2+"/n");}
						else{
							System.out.println(tmp2+"+");
						}
						}
					}
				}
			}
			
			
			
			
		}
		
		
		
		
		
	}
}
