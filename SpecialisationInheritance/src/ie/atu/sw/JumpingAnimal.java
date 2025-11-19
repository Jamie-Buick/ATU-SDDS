package ie.atu.sw;

import java.io.*;

public abstract class JumpingAnimal extends Animal implements Jumpator, Comparable<JumpingAnimal>, Serializable{
	private static final long serialVersionUID = 1L;
	private int maxHeight;
	
	public JumpingAnimal(String name, int maxHeight) {
		super(name);
		this.maxHeight = maxHeight;
	}



	public JumpingAnimal(int maxHeight, int lifeForce, String name) {
		super(lifeForce, name);
		this.maxHeight = maxHeight;
	}
	
	
	public int getMaxHeight() {
		return this.maxHeight;
	}
	
	@Override
	public int compareTo(JumpingAnimal other) {
		return (this.maxHeight > other.getMaxHeight()) ? 1 : -1; // ternary IF statement
	}



	public void jump() throws Exception {
		System.out.println(this.getName() + " is jumping to a height of " + this.maxHeight);
		super.move();
		System.out.println(super.getName() + " is finished jumping.");
	}
	
	

}
