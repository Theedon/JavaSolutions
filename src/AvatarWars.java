package PersonalFunctions;
import java.util.Random;
public class AvatarWars {
	String avatar;
	int life;
	int attack;
	int speed;
	
	public AvatarWars(String avatar, int life, int attack, int speed) {
		this.avatar= avatar;
		this.life= life;
		this.attack= attack;
		this.speed= speed;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	
	public int getLife() {
		return this.life;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getSpeed() {
		return this.speed;
	}
	public int takeLife(int hit) {
		return this.life-hit;
	}
}

 class Myclass{
	public static void  main(String[] args) {
		
		System.out.println(55);
		AvatarWars[] group= {
				new AvatarWars("Superman", 92, 90, 80),
				new AvatarWars("Batman", 70, 95, 60),
				new AvatarWars("Flash", 50, 79, 99)
		};
		int upperBound= (group.length)-1;
		Random random= new Random(upperBound);
		
		while((group[0].getLife())>0 && group[1].getLife()>0 && group[2].getLife()>0 ) {
			//rand1 is for the avatar that attacks
			int rand1= random.nextInt(upperBound);
			System.out.println(55);
			//rand2 is for the avatar that takes the hit
			int rand2= random.nextInt(upperBound);
			//randAttack is for the attack that will be given
			// i might need randAttack to have a lower bound in the future which means i might use Math.Random()
			int randAttack= random.nextInt(group[2].getLife());
			
			if(rand1==rand2) {
				System.out.println(group[rand1].getAvatar()+"tried an attack but missed!");
			}
			if(rand1!=rand2) {
				group[rand2].takeLife(randAttack);
				System.out.println(group[rand2].getLife());
			}
			
		}
	}
	
	
}