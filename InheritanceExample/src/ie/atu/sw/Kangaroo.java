package ie.atu.sw;

public class Kangaroo extends JumpingAnimal{
	private Pouch pouch = new Pouch();
	
	public Kangaroo(int maxHeight, String name) {
		super(maxHeight, name); //Constructors are chained
	}
	
	@Override
	public void jump() throws Exception {
		System.out.println(this.getName() + " is jumping like a Kangaroo");
		this.move();
		this.eat();
	}

	private class Pouch{
		//This is called an inner class.
	}
}