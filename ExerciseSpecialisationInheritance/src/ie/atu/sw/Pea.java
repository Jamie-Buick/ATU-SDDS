package ie.atu.sw;

public class Pea extends Legume{

	private int mushiness;
	
	// Constructor is required as super class Legume requires it also.
	public Pea(String name) {
		super(name); // super in my legume
	}

	public void mush() {
		mushiness++;
		System.out.println(this.getClass().getName() + "....Mushing......>" + mushiness);
	}

	// Overriding the Legume grow method. Overriding to refine as we are calling the Legumes grow method and then our overridden stuff.
	// If we were to completely override, I would just remove the legumes grow method and add new stuff.
	@Override
	public void grow() { 
		super.grow();
		System.out.println(this.getClass().getName() + "....Growing....");
	}
	

	
}
