class newT implements Runnable{
	int i=0;
	public void run(){
		while(i<5){
			System.out.println("ran again");
			i++;
		}
	}
	
}


public class Main {
	public static void main(String[] args) {
		Thread obj= new Thread(new newT());
		
		try{
			obj.sleep(1000);
		}
		catch(Exception e){
			System.out.println("sorry");
		}
		obj.start();
	}
}
	