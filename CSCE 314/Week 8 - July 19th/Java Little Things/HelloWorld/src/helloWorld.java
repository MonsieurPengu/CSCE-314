// Ian Wang 
// First Program - Learning the Setup

// Imports
import java.util.Scanner;

// class header
public class helloWorld {
	
	// Set up Scanner
	static Scanner sc = new Scanner (System.in);
	
	// main()
	public static void main (String[] args) {
		
		// code goes here
		System.out.println("hello world");
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
	// Print example
		System.out.println("Hello Class, ");
		System.out.println("I am Wang-san"); // what is the difference between
		System.out.println("We will learn JAVA!!"); // println and print
		
	
	// Scanner class
		// String | next() - Finds and returns the next complete token from this scanner.
		
		// to read in a SINGLE char
		char letter;
		letter = sc.next().charAt(0);
		
		String name;
		name = sc.next();
		sc.reset(); // use after next since it mgiht look for more
		
		// double | nextDouble() - Scans the next token of the input as a double.
		double price;
		price = sc.nextDouble();
	}
}

// Import: Some commands and features require other "packages or libraries"
// Class: Every program needs a class name, think of it as a program name. The name must be one word. (Or combined with a _)
// Main: where most of your code will be placed. Starts from top to bottom.

/* Escape Sequences in Java
 	\t - tab 
 	\r - carriage return, go to beg. of next line
 	\\ - backslash
 	\" - double quote
 	\' - single quote
 	\n - new line
 	\b - back space
 	\f - form feed
*/