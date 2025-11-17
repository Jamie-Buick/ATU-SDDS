package ie.atu.sw;

public class RaceHorse extends JumpingAnimal{

	private int speed;

	public RaceHorse(String name, int maxHeight) {
		super(name, maxHeight);
	}
	
	
	public RaceHorse(int maxHeight, int lifeForce, String name) {
		super(maxHeight, lifeForce, name);
	}


	public RaceHorse(String name, int maxHeight, int speed) {
		super(name, maxHeight);
		this.speed = speed;
	}


	public void gallop() throws Exception {
		System.out.println(super.getName() + " is galloping at " + speed + "km/hr.");
		move();
	}


	@Override
	public void eat() {
		System.out.println(this.getClass().getName() + " -> is eating");
		// The horse stops to eat
		int temp = speed;
		speed = 0; // stop
		super.eat(); // eat
		speed = temp;
	}
	
	@Override
	public void sleep() {
		System.out.println(this.getClass().getName() + " -> is sleeping standing up...Zzzzzz");
	}
	
	
	
	
}
