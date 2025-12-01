package ie.atu.sw;

public interface Jumpator {

	public static final double MIN_HEIGHT = 7; // underline on UML means static!

	public static double getHeightAsMetres(double feet) {
		return feet * 0.3;
	}

	/*
	public void jump() {
		System.out.println(this.getClass().getName() + "....Jumping..... ");
	}

	public void jump (double height, Unit unit) {
		
	}
*/
}
