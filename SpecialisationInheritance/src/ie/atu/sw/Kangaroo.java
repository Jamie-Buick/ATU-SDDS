package ie.atu.sw;

public class Kangaroo extends JumpingAnimal{

	private Pouch pouch = new Pouch();
	
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



	private class Pouch {
		// An inner class promotes encapsulation but not re-use.
	}
	
}
