package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

	// your code here
    if(string == null) {
    	return false;
    }
    
    char temp[] = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
    
    int head = 0;
    int tail = temp.length-1;
    
    while(head < tail) {
    	if(temp[head] != temp[tail]) {
    		return false;
    	}
    	
    	head++;
    	tail--;
    }
    

	return true;
	
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

	// your code here
    if(name == null) {
    	return false;
    }
    
    char temp = name.charAt(0);
    if(!Character.isLetter(temp) && temp != '_') {
    	return false;
    }
    
    if(name.equals("_")) {
    	return false;
    }
    
	return true;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

	// your code here
    if(word == null) {
    	return "";
    	
    }
    
    char temp = word.charAt(0);
    boolean firstChar = Character.isUpperCase(temp);
    
    String lower_Case = word.toLowerCase();
    
    
    // first scenario
    if(VOWELS.indexOf(temp) != -1) {
    	return word + "way";
    }
    
    // other wise 
    int index = -1;
    for(int i = 0; i < lower_Case.length(); i++) {
    	char key = lower_Case.charAt(i);
    	if(VOWELS.indexOf(key) != -1) {
    		index = i;
    		break;
    	}
    }
    
    if(index != -1) {
    	String part_One = lower_Case.substring(0, index);
    	String rest_Part = lower_Case.substring(index);
    	
    	String pigLatin = rest_Part + part_One + "ay";
    	
    	
    	// update the first letter;
    	if(firstChar) {
    		pigLatin = Character.toUpperCase(pigLatin.charAt(0)) + pigLatin.substring(1);
    	}
    	
    	return pigLatin;
    }
    
    
    return word;
    		
    }

}
