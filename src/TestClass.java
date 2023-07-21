//I used this class just to try and solve a problem i had with not being able to encrypt my characters
//For the VigenereCipher.encrypt() function in this package
package PersonalFunctions;

public class TestClass {

	public static void main(String[] args) {
		char ch= (char) (('z'+'m')%66)+'!';
		int num= (int) ']';
		char m= (char) 32;
		System.out.println(ch);
		
		char dh= (char) ((int) (((ch-'m')+66)%66)+'!');
		System.out.println(dh);
	}

	
	/*The problem was with modulo 26
	 * all this deals with their corresponding ASCII codes(integers)
	 * i found that 'A'=65 and 'Z'= 90
	 * i used a test case which was '['=91
	 * This was the main code in it char ch= (char) (('['+'A')%26)+'A'; 
	 * If we do this offhand, it will give 91+65= 156
	 * 156%26 gives us 0 and that in turn gives us A
	 * So i realized i had to find the correct number for the modulo
	 * This means i needed a number that if i added to the final 'A' would give me 91
	 * Therefore 91-65(the ASCII code for 'A' is 65) = 26
	 * Therefore i needed 156moduloX= 26 where X is the modulo number i was finding 
	 * After minutes of tinkering I finally got 156modulo130 to be 26
	 * That means our X(The number to replace 26 with in that equation is now 130
	 * This should apply to characters that have their ASCII between 65 and 127(A to ) 
	 * 
	 * There are some symbols that are before 65 that all this doesn't work for
	 * But i believe this problem can be solved b adding a character with lesser ASCII number 
	 * Instead of adding A as in the final +'A' in the main code ch= (char) (('['+'A')%26)+'A'
	 * This will mean we will have to rework the modulo code as the values will now be different 
	 * Compared to when we knew we were just adding 65('A')
	 * 
	 * Today is another of trying to solve this problem and i have found that possible reasonable characters
	 * that i should be aiming for are with ASCII code 33(!) to 126(-)
	 * 
	 * I finally have solved the problem
	 * Since i started from 33(!), i changed the final value to be added from 'A' to be the char of 33 which is !
	 * And so i finally got the modulo i could use to be 66
	 * But that means the characters i could allow as inputs can only be from 33 to 98 because of the 66 threshhold
	 * This means i have to hardcode the rest(99-126) with if statements
	 * I will take this as a win for now and probably try to solve for these in the future
	 */
	
	
	
	
}
