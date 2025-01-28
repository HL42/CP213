package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author your name here
 * @version 2022-01-17
 */
public class Main {

    public static void main(String[] args) {
	final String line = "-".repeat(40);
	int id = 123456;
	String surname = "Brown";
	String forename = "David";
	LocalDate birthDate =  LocalDate.parse("1962-10-25");
	Student student = new Student(id, surname, forename, birthDate);
	
	System.out.println("New Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test Getters");

	// call getters here
    System.out.println("Forename: " + student.getForename());
	System.out.println("Surname: " + student.getSurname());
	System.out.println("ID: " + student.getId());
    System.out.println("Birth Date: " + student.getBirthDate());

	System.out.println(line);
	System.out.println("Test Setters");

	// call setters here
	student.setId(169061939);
    student.setSurname("Hunter");
    student.setForename("Lin");
    student.setBirthDate(LocalDate.parse("2005-06-21"));

	System.out.println("Updated Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test compareTo");

	// create new Students - call comparisons here
	Student student1 = new Student(111111, "Brown", "David", LocalDate.of(1962, 10, 25));
	Student student2 = new Student(999999, "Brown", "David", LocalDate.of(2000, 1, 1));
	System.out.println(student1.compareTo(student2));
    }

}
