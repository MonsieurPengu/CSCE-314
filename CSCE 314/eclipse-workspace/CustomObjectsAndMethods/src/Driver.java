// Driver File 
import java.util.Scanner;

public class Driver {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Employee EM001 = new Employee();
		EM001.setName ("Mr. Lupoli");
		EM001.setDepartment ("Computer Science");
		EM001.setTitle ("Assistant Professor");
		EM001.setSalary (-1); 

		//create your own instance!!!
		Employee Ian = new Employee();
		Ian.setName("Ian Wang");
		
		System.out.println(EM001);
		System.out.println(EM001.getName());
		
		EM001.setSalaryRaise(0.02);
		// let's see if the raise stuck!!
		System.out.println(EM001);
		
		
		// testing toString
		Employee adjunct = new Employee();
		adjunct.setName ("Ian Wang");
		adjunct.setSalary(21);
		
		System.out.println(adjunct);
	}
}
