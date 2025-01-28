package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author HunterLin
 * @version 2024-10-03
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forname, LocalDate birthDate ) {

	// assign attributes here
//    getAttributeName
//    setAttributeName
    	this.birthDate = birthDate;
    	this.forename = forname;
    	this.surname = surname;
    	this.id = id;
	return;
    }
    
    
    /**
     * @return the student's birthdate
     */
    public LocalDate getBirthDate() {
    	return this.birthDate;
    }
    
    /**
     * @param birthDate
     */
    public void setBirthDate(LocalDate  birthDate) {
    	this.birthDate = birthDate;
    }
    
    /**
     * @return the student's forename
     */
    public String getForename() {
    	return this.forename;
    }
    
    /**
     * @param forename
     */
    public void setForename(String forename) {
    	this.forename = forename;
    }
    
    /**
     * @return Student's surname
     */
    public String getSurname() {
    	return this.surname;
    }
    
    /**
     * @param surname
     */
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    /**
     * @return students id
     */
    public int getId() {
    	return this.id;
    }
    
    /**
     * @param id
     */
    public void setId(int id) {
    	this.id = id;
    }
    

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString( ) {
	String string = "";

	// your code here
	
	string = String.format("Name:      %s, %s%nID:        %d%nBirthdate: %s", this.surname, this.forename, this.id, this.birthDate);
	
	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = 0;

	// your code here
	result = this.surname.compareTo(target.surname);
	
	if (result == 0) {
        result = this.forename.compareTo(target.forename);
        if (result == 0) {
            result = Integer.compare(this.id, target.id);
        }
	}
	

	return result;
    }


    // getters and setters defined here


}
