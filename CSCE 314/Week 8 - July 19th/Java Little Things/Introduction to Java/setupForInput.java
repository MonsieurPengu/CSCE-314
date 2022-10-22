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
		
		
	/*
		What is a token??
		
		Lupoli - 1 token
		98 - 1 token
		Prof. Lupoli! - 2 token
		123.012 - 1 token
		Lupoli needs a vacation - 4 tokens
		!!! - 3 tokens
	*/


	/*
		Rest of Scanner Methods
	*/
		// float | nextFloat() - Scans the next token of the input as a float
		float amount;
		amount = sc.nextFloat();
		
		// int | nextInt() - Scans the next token of the input as an int.
		int score;
		score = sc.nextInt();
		
		// String | nextLine() - Advances this scanner past the current line and returns the input that was skipped.
		// THIS IGNORES SPACES WITHIN A USER INPUT!!!!
		String entireName;
		entireName = sc.nextLine();
		
	}
}