
class lion{
	protected String animal= "lion";
	protected int limbs= 4;
	private String head= "one";
	public void kill(String prey){
		System.out.println(animal + " chases and kills " + prey);
	}
}
	class jaguar extends lion{
		jaguar(){
			
animal= "jaguar";

		}
				
								}

class Myclass{
	public static void main(String args[ ]){
	jaguar musher= new jaguar();
	musher.kill("antelope");
	}
}