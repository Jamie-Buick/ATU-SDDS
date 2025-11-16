package ie.atu.sw;

import java.util.*;

public class Animal {

	private int lifeForce;
	private String name;
	
	
	
	
	
	public Animal(String name) {
		super();
		this.name = name;
		this.lifeForce = new Random().nextInt() >>> 1;
	}


	public Animal(int lifeForce, String name) {
		super(); // My supertype is java.lang.Object
		this.lifeForce = lifeForce;
		this.name = name;
	}


	// Protected visability can be seen by subtypes and co-packaged types
	protected String getName() {
		return name;
	}
	
	public void eat() {
		lifeForce++;
	}
	
	public void move() throws Exception {
		if (lifeForce <= 0) throw new Exception("Cannot move because " + name + "is dead");
		lifeForce--;
	}
	
	
	
	
	
	
	
}
