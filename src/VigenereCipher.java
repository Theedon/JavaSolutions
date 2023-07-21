package PersonalFunctions;
import java.util.Scanner;

public class VigenereCipher{

	public static String encrypt(String inpSentence, String inpKey) {
		
		/*Apart from the general rules of the Vigenere cipher itself
		 * i replaced every space bar with #
		 * I replaced every . with %
		 * I replaced every , with a ~
		 * The function takes the string to be encrypted and the key to encrypt it with
		 * example VigenereCipher.encrypt("This, is a string.", "This is a key")
		 This gives the encrypted String "MOQKCEALWTGWRYQFZG"
		 
		 *Note: The string to be encrypted can only contain the 26 alphabets, comma, full stop and space
		 *Note: The key can only contain the 26 alphabets
		 */
		
		//inpSentence= inpSentence.replace(" ", "#");
		//inpSentence= inpSentence.replace(".", "%");
		//inpSentence= inpSentence.replace(",", "~");
		inpSentence= inpSentence.toUpperCase();
		inpKey= inpKey.toUpperCase();
		
		inpKey= inpKey.replace("A", "");
		inpKey= inpKey.replace("B", "");
		
		char[] arrSentence= inpSentence.toCharArray();
		char[] arrKey= inpKey.toCharArray();
		int lenSentence= arrSentence.length;
		arrKey= regulateKey(arrKey, lenSentence);
		char[] arrEncrypted= new char[lenSentence];
		char[] arrDecrypted= new char[lenSentence];
		arrEncrypted= encryptMessage(arrSentence, arrKey, lenSentence);
		
		
		//This to convert the character array to a string
		String finalString=arrEncrypted[0]+"";
		
		
		
		for(int i= 1; i<lenSentence; i++) {
			finalString= finalString+arrEncrypted[i];
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



	public static char[] encryptMessage(char[] arrSentence, char[] arrKey, int lenSentence) {
		char[] testArray= new char[lenSentence];
		for(int i=0; i<lenSentence; i++) {
//beginning of madness
			
			//i changed this because space was giving me a problem
			if(arrSentence[i]==' ') {
				testArray[i]= ' ';
				continue;
			}
			//i changed this because A was encrypting and decrypting to i
			//if(arrSentence[i]=='A') {
				//testArray[i]= 'A';
				//continue;
			//}
			//end of latest modified
			
			
			if(arrSentence[i]=='{') {
				testArray[i]= '{';
				continue;
			}
			if(arrSentence[i]=='|') {
				testArray[i]= '|';
				continue;
			}
			if(arrSentence[i]=='}') {
				testArray[i]= '}';
				continue;
			}
			if(arrSentence[i]=='~') {
				testArray[i]= '~';
				continue;
			}
			
			//the madness has been reduced with some considerable work
			//end of madness
			
			
			testArray[i]= (char) (((arrSentence[i]+arrKey[i])%66)+'!');
			
		}
		
		return testArray;
		
	}



}




































/* package PersonalFunctions;
import java.util.Scanner;

public class VigenereCipher{
	
	public static void main(String args[]) {
		char[] alphabets= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		
		
		
		
	
		String sentence= "zzzzzz";
		String key= "zz";
		key= key.toUpperCase();
		sentence= sentence.toUpperCase();
		char[] sentenceCh= sentence.toCharArray();
			char[] keyCh= key.toCharArray();
			int lenSentenceCh= sentenceCh.length;
			int lenKeyCh= keyCh.length;
			char[] newKeyCh= null;
			int[] finalIndexArray= null;
			int[] regulatedFinalIndexArray= null;
			char[] finalHash= null;
		
			newKeyCh= EqualLength(keyCh, lenSentenceCh);
			finalIndexArray= getIndexArray(sentenceCh, newKeyCh, alphabets);
			regulatedFinalIndexArray= regulateIndexArray(finalIndexArray, alphabets);
			finalHash= computeHashFromArray(regulatedFinalIndexArray, alphabets);
		
			
			
			
			
			
			
			
			
			
			
			System.out.println(finalHash);
		
		
		
	}
	public static char[] EqualLength(char[] keyCh, int lenSentenceCh) {
		//the first input is the charArray which is the key, the second is the length of lenSentenceCh
		int lenKey= keyCh.length;
		
		char[] newCh= new char[100] ;
		int d=0;
		for(int i= 0; i<lenSentenceCh; i++) {
			newCh[i]= keyCh[d];
			d++;
			if(d>lenKey-1) {
				d=0;
			}
			
		}
		return newCh;
	}
	
	public static int[] getIndexArray(char sentenceCh[], char newKeyCh[], char alphabets[]) {
		int lenKey= sentenceCh.length;
		int lenAlphabets= alphabets.length;
		int[] sentenceIndexArray= new int[100];
		int[] keyIndexArray= new int[100];
		int[] finalIndexArray= new int[100];
		
		//This to put into an array the index of the sentence and the key in relation to where they are in the alphabet array
		for(int i=0; i<lenKey; i++) {
			for(int j= 0; j<lenAlphabets; j++) {
				if(sentenceCh[i]==alphabets[j]) {
				sentenceIndexArray[i]= j;
				}
			
			
				if(newKeyCh[i]==alphabets[j]) {
				keyIndexArray[i]= j;
				}
			
			}
		}
		//This to add the indexes in both arrays
		for(int k=0; k<lenKey; k++) {
			finalIndexArray[k]= sentenceIndexArray[k]+keyIndexArray[k];
			finalIndexArray[k]+=1;
			System.out.println(finalIndexArray[k]);
		}
		
		
		
		return  finalIndexArray;
	}
	
	public static int[] regulateIndexArray(int[] finalIndexArray, char[] alphabets) {
		int lenAlphabets= alphabets.length;
		int regulatedFinalIndexArray[]= new int[100];
		int lenArray= regulatedFinalIndexArray.length;
		int corrector=0;
		for(int i=0; i<lenArray; i++) {
			if (finalIndexArray[i]>(lenAlphabets-1)){
				corrector= finalIndexArray[i]-(lenAlphabets);
				regulatedFinalIndexArray[i]= corrector;
			}
			else {
				regulatedFinalIndexArray[i]= finalIndexArray[i];
				
			}
		}
	
		return regulatedFinalIndexArray;
	
	
	This to make sure any of the value of the array isn't higher than the length of the alphabets array
	If it is then we subtract by the length of the array so we can convert easily
	For example if the length of the array is 26 and we have 27, we simply do 27-26 to get 1 which gives A	
	
	
	}

	
	
	public static char[] computeHashFromArray(int regulatedFinalIndexArray[], char[] alphabets) {
		char[] finalHash= new char[100];
		int a=0;
		for(int i=0; i<regulatedFinalIndexArray.length; i++) {
			a= regulatedFinalIndexArray[i];
			finalHash[i]= alphabets[a]; 
		}
		return finalHash;
	}
	
		
	
	
	
}
*/