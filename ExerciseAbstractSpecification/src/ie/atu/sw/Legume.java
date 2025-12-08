package ie.atu.sw;

public abstract class Legume {

	private String name;
	

	public Legume(String name) {
		this.name = name;
	}
	
	
	
	public String getName() {
		this.grow();		// this will work as it will be implemented in descendants at some point.
		return name;
	}



	public abstract void grow();
		
	
	
	

	/*
	public void grow() {
		System.out.println(this.getClass().getName() + "........growing.......");
	}
	*/

}
