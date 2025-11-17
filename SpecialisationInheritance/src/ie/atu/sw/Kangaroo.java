package ie.atu.sw;

public class Kangaroo extends JumpingAnimal{

	private Pouch pouch = new Pouch();
	private int size = 7; // Kangaroos start life with a size of 7 units.
	
	public Kangaroo(int maxHeight, int lifeForce, String name) {
		super(maxHeight, lifeForce, name);
	}

	public Kangaroo(String name, int maxHeight) {
		super(name, maxHeight);
	}

	
	
	
	@Override
	public void jump() throws Exception {
		System.out.println(this.getName() + " is jumping as a kangaroo");
		super.move();
		this.eat();
	}

	
	@Override
	public void eat() {
		System.out.println(this.getClass().getName() + " -> is eating");
		super.eat();
		size++;
	}


	
	private class Pouch {
		// An inner class promotes encapsulation but not re-use.
	}


	@Override
	public void sleep() {
		System.out.println(this.getClass().getName() + " -> is sleeping lying down...Zzzzzz");
	}
	
}
