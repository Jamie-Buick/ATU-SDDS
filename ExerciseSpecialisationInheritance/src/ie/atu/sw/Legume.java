package ie.atu.sw;

public class Legume {

	private String name;

	// Need to create a constructor to initialise name. Any sub classes need a string constructor.
	public Legume(String name) {
		this.name = name;
	}

	// Not in UML but add getters/setters.
	public String getName() {
		return name;
	}
	
	public void grow() {
		System.out.println(this.getClass().getName() + "....Growing....");
	}




}
