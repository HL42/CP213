package cp213;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Arrays Lab task methods.
 *
 * @author
 * @version 2022-01-25
 */
public class ArraysTest {

    /**
     * Tests arrays.
     *
     * @param args unused default parameter
     */
    public static void main(final String[] args) {
	System.out.println("Task 1");
	System.out.println(ArraysTest.task1());
	System.out.println("Task 2");
	System.out.println(ArraysTest.task2());
	System.out.println("Task 3");
	System.out.println(ArraysTest.task3());
	System.out.println("Task 4");
	System.out.println(ArraysTest.task4());
	System.out.println("Task 5");
	System.out.println(Arrays.toString(ArraysTest.task5()));
    }

    /**
     * Print the contents of the arrays first and second using a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task1() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	// your code here
	for(int i = 0; i < first.length; i++) {
		if(first[i] == second[i]) {
			return true;
		}
	}
	System.out.println();
	
	return false;

	// return true; - or - return false;
    }

    /**
     * Double the contents of the array first with a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task2() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	// your code here
	for(int i = 0; i < first.length; i++) {
		first[i] *= 2;
		if(first[i] == second[i]) {
			return true;
		}
	}
	
	
	return false;
	// return true; - or - return false;
    }

    /**
     * Double the contents of the array first with an enhanced for loop.
     *
     * @return true if the values in first are permanently changed, false otherwise
     */
    public static boolean task3() {
	final int[] first = { 1, 3, 5, 7, 9 };

	// your code here
	for(int values: first) {
		values = values * 2;
		for(int i = 0; i < first.length; i++) {
			if(first[i] == values) {
				return true;
			}
		}
	}
	
	return false;
	// return true; - or - return false;
    }

    /**
     * Attempt to assign the array first to a row of the 2D array third.
     *
     * @return true if this is allowed, false otherwise
     */
    public static boolean task4() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[][] third = new int[2][first.length];

		// your code here
		for(int i = 0; i < first.length; i++) {
			third[0][i] = first[i];
			if(third[0][i] == first[i]) {
				return true;
			}
		}
		
			
		return false;
		// return true; - or - return false;
    }

    /**
     * Assign the values 0 through 9 to an Integer ArrayList.
     *
     * @return the contents of the ArrayList as an Integer[] array.
     */
    public static Integer[] task5() {
	final ArrayList<Integer> values = new ArrayList<>();

	// your code here
	for(int i = 0 ; i < 10 ; i++) {
	      values.add(i);
	      
	      
	  }
	
	Integer[] valuesArray = values.toArray(new Integer[0]);
	
	return valuesArray;
	

    }
}
