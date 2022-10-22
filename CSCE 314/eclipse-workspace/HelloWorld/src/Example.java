import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// variables
		char user;
		
		System.out.println("Will I do my work in Mr. Lupoli's Class??");
		
		// have user press "Y" or "N"
		user = sc.nextChar(); // reads what user typed
		
		if (user == 'Y') { // will pass
			System.out.println("Then I will pass JAVA, and take JAVA AB next year!");
		}
		
		if (user == 'N') { // will fail
			System.out.println("Then I will not pass Mr.Lupli's class.");
			System.out.println("And my parents will be upset!");
			// TWO LINES OR MORE
		}
	}
}
