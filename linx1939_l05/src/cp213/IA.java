package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class IA extends Student {

    // your code here
	private String course;
	
	public IA(final String lastName, final String firstName, final String id ,final String course) {
		super(lastName, firstName, id);
		this.course = course;
	}
	
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String toString() {
		return(super.toString() + "\nCourse: " + course);
	}

}
