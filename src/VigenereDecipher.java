package PersonalFunctions;

public class VigenereDecipher {

	public static String decrypt(String inpSentence, String inpKey) {
		
		inpSentence= inpSentence.toUpperCase();
		
		inpKey= inpKey.toUpperCase();
		inpKey= inpKey.replace("A", "");
		inpKey= inpKey.replace("B", "");
		
		
		char[] encryptedSentence= inpSentence.toCharArray();
		char[] arrKey= inpKey.toCharArray();
		int lenSentence= encryptedSentence.length;
		arrKey= regulateKey(arrKey, lenSentence);
		char[] arrDecrypted= new char[lenSentence];
		
		arrDecrypted= decryptSentence(encryptedSentence, arrKey, lenSentence);
		
		
		
		//This to convert the character array to a string
				String finalString=arrDecrypted[0]+"";
				
				
				
				for(int i= 1; i<lenSentence; i++) {
					finalString= finalString+arrDecrypted[i];
				}
		
		return finalString;
		
		
		

	}
	public static char[] regulateKey(char[] arrKey, int lenSentence){
		char[] testArray= new char[lenSentence];
		int lenKey= arrKey.length;
		for(int i=0, d=0; i<lenSentence; i++,d++) {
			if(d==lenKey) {
				d= 0;
			}
			testArray[i]= arrKey[d];
			
			
		}
		return testArray;
	}
	
	
	public static char[] decryptSentence(char[] encryptedSentence, char[] arrKey, int lenSentence) {
		char[] testArray= new char[lenSentence];
		for(int i=0; i<lenSentence; i++) {
			//beginning of madness
			
			//i changed this because space was giving me a problem
			if(encryptedSentence[i]==' ') {
				testArray[i]= ' ';
				continue;
			}
			//i changed this because A was encrypting and decrypting to i
			//if(encryptedSentence[i]=='A') {
				//testArray[i]= 'A';
				//continue;
			//}
			//end of latest modified
			
			
				if(encryptedSentence[i]=='{') {
				testArray[i]= '{';
				continue;
			}
			if(encryptedSentence[i]=='|') {
				testArray[i]= '|';
				continue;
			}
			if(encryptedSentence[i]=='}') {
				testArray[i]= '}';
				continue;
			}
			if(encryptedSentence[i]=='~') {
				testArray[i]= '~';
				continue;
			}
			
			
			
			
			//the madness has been reduced with some considerable work
			//end of madness
			testArray[i]= (char) ((((encryptedSentence[i]-arrKey[i])+66)%66)+'!');
			
		}
		
		return testArray;
		
	}

}
