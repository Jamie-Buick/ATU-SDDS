package ie.atu.sw;

import java.util.Random;
public class Animal {
	private int lifeForce;
	private String name;
	
	public Animal(String name) {
		this.name = name;
		this.lifeForce = new Random().nextInt() >>> 1; //The lottery of life
	}

	protected String getName() {
		return name;
	}

	public void eat() {
		lifeForce++;
	}

	public void move() throws Exception{
		if (lifeForce <= 0) throw new Exception("Cannot move. Animal " + name + " is dead.");
		lifeForce--;
	}
}
