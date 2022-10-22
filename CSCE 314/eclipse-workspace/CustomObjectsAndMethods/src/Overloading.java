
public class Overloading {
	
	public void getMethod(int score) { // Method #1
		System.out.println( "Method #1" );
		System.out.println( score );
	}
	
	public void getMethod (char grade) { // Method #2
		System.out.println( "Method #2 ");
		System.out.println( grade );
	}
	
	public void getMethod (double average) { // Method #3
		System.out.println( "Method #3 ");
		System.out.println( average );
	}
	
	public static void main(String [] args ) {
		Overloading ex = new Overloading();
		
		ex.getMethod(98); // What method # will be called??
		ex.getMethod(12.3); // What method # will be called??
		ex.getMethod('F'); // What method # will be called??
	}
}
