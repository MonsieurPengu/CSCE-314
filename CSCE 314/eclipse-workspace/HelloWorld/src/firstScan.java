// Ian Wang
// Tests inputs
import java.util.Scanner; // must import for Scanner usage

public class firstScan {
	
	static Scanner sc = new Scanner(System.in); // start Scanner
	
	public static void main(String[] args) {
		int age = -1; // set a DEFAULT value
		
		System.out.println("How old are you?");
		age = sc.nextInt(); // grab value from keyboard (user)
		
		int dogAge = age * 7;
		
		System.out.println("You are " + dogAge + " years old in DOG YEARS");
	}
}
