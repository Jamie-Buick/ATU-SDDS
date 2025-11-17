package ie.atu.sw;

import java.util.*;

public abstract class Animal {

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


	public abstract void sleep(); // An abstract / deferred method
	
	// Protected visability can be seen by subtypes and co-packaged types
	protected String getName() {
		return name;
	}
	
	public void eat() {
		System.out.println(this.getClass().getName() + " -> is eating");
		lifeForce++;
	}
	
	public void move() throws Exception {
		if (lifeForce <= 0) throw new Exception("Cannot move because " + name + "is dead");
		if (lifeForce <= 100) sleep();
		lifeForce--;
	}
	
	
	
	
	
	
	
}
