
public class Driver {
	
	public static void main(String[] args) {
		
		int intEx1 = 20;
		int intEx2 = 20;
		Integer wrapper1 = new Integer(10);
		Integer wrapper2 = new Integer(10);
		
		System.out.println(multiply (intEx1, intEx2));
		System.out.println(multiply (wrapper1, wrapper2));
	}
	
	public static int multiply (int a, int b) { return a * b; }
}
