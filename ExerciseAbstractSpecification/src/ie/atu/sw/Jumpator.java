package ie.atu.sw;

public interface Jumpator {

	public static final double MIN_HEIGHT = 7; // underline on UML means static!

	public static double getHeightAsMetres(double feet) {	// static for helper operators
		return feet * 0.3;
	}

	
	public abstract void jump();
	
	
	public default void jump (double height, Unit unit) { // Default can be used to retrofit new behaviour
		System.out.println();
	}

}
