
public class Main {
	public static void main(String[] args) {
		// abstract classes cannot be instatiated, but they can have a subclass
		// abstract methods are declared without an implementation
		
		// Cannot declare a vehicle directly, but can make a Car
		// This adds a layer of security much like private
		Car car = new Car();
		car.go();
	}
}
