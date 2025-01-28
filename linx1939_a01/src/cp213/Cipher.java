package cp213;

/**
 * @author Hunter Lin
 * @version 2024-09-01
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    
    public static String shift(final String s, final int n) {
	// your code here
    char[] result = s.toUpperCase().toCharArray();
    String finalResult;
    int shiftValue = n % ALPHA_LENGTH;
    
    for(int i = 0; i < result.length; i++ ) {
    	char temp = result[i];
    	
    	int index = ALPHA.indexOf(temp);
    	if(index != -1) {
    		int newIndex = (index + shiftValue) % ALPHA_LENGTH;
    		result[i] = ALPHA.charAt(newIndex);
    	}
    }
    
    
    
    finalResult = new String(result);
    
    
	return finalResult;
    }
    

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {

	// your code here
    char result[] = s.toUpperCase().toCharArray();
    char cipherArr[] = ciphertext.toUpperCase().toCharArray();
    String finaResult;
    
    
    if(ALPHA_LENGTH == ciphertext.length()) {
    	for(int i = 0; i < result.length; i++) {
    		char temp = result[i];
    		int index = ALPHA.indexOf(temp);
    		
    		if(index != -1) {
    			result[i] = cipherArr[index];
    		}
    	}
    }
    
    finaResult = new String(result);

	return finaResult;
    }

}
    
