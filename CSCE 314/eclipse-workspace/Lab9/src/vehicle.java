
public class vehicle {
	private float maxSpeed;
	
	public vehicle(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void left() {}
	public void right() {}
	public void forward() {}
	public void reverse() {}
	
	public static void main(String[] args) {
		vehicle car = new vehicle(20);
	}
}


