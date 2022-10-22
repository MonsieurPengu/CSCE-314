// Class File
public class Employee {
	
	// member variables
	private String name;
	private String department;
	private String title;
	private int salary;
	
	// mutators
	public void setName(String newName) { name = newName; } // set name
	public void setDepartment(String newDP) {department = newDP;} // sets department
	public void setTitle(String newTitle) {title = newTitle;} // sets title
	public void setSalary( int newSalary) { salary = newSalary; }
	
	public void setSalaryRaise(double percentage) {
		salary += salary * percentage;
	}
	
	// accessors
	public String getName( ) { return name; } // retrieves name
	public String getDepartment( ) { return department; } // retrieves department
	public String getTitle( ) { return title; } // retrieves title
	public int getSalary( ) { return salary; } // retrieves salary
	
	public void printPayCheck(double hours, double taxPercentage) {
		System.out.println("------- You should receive in your check -------");
		double pay = hours * salary * (1.00-(taxPercentage/100));
		System.out.println("$" + pay + "after taxes.");
	}
	
	// toString method
	public String toString( ) {
		return name + "\n" + department + "\n" + title + "\n" + salary;
	}
	
	// what if no public/private in front??
	// USE PUBLIC FOR NOW
}
