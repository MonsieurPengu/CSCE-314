import java.util.Scanner;

public class setupForInput {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("hello all");
		
		// tell user what they need to input
		System.out.println("Please enter an integer value");
		
		// grab input and store in a variable
		int integerValue = sc.nextInt();
		
		// confirm input by displaying variable
		System.out.println("you entered " + integerValue);
		
	}
}
