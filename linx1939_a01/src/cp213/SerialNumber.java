package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

	// your code here
    if(str == null) {
    	return false;
    }
    
    for(int i = 0; i < str.length(); i++) {
    	char temp = str.charAt(i);
    	
    	if(!Character.isDigit(temp)) {
    		return false;
    	}
    }
    
	return true;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

	// your code here
	if (sn.startsWith("SN/") &&
	        Character.isDigit(sn.charAt(3)) &&
	        Character.isDigit(sn.charAt(4)) &&
	        Character.isDigit(sn.charAt(5)) &&
	        Character.isDigit(sn.charAt(6)) &&
	        sn.charAt(7) == '-' &&
	        Character.isDigit(sn.charAt(8)) &&
	        Character.isDigit(sn.charAt(9))) {
	        return true;
	    }
    
    return false;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	// your code here
    while(fileIn.hasNextLine()) {
    	String serialNum = fileIn.nextLine().trim();
    	
    	if(validSn(serialNum)) {
    		goodSns.println(serialNum);
    	}else {
    		badSns.println(serialNum);
    	}
    }
    
    	

	return;
    }

}
