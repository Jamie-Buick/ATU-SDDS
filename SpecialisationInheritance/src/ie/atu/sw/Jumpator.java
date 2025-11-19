package ie.atu.sw;

public interface Jumpator {

	public static final double MIN_HEIGHT = 1.00d;
	public enum Unit {Metric, Imperial}; // A Set of predefined constants
	
	
	public abstract void jump() throws Exception;
	
	// A static method is used to add helper behaviour to an interface
	public static double getHeightAsMetres(double feet) {
		final double weight = 0.3048d;
		return feet * weight;
	}
	
	// A default method is used to retrofit and interface with new functional behaviour
	public default void jump(double height, Unit unit) throws Exception {
		if (unit == Unit.Imperial) {
			height = Jumpator.getHeightAsMetres(height);
			
		}
		
		jump(); // call jump even though it has not been implemented yet.
	}
	
}
