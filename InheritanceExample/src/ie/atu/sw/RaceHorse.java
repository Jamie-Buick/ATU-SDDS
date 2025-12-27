package ie.atu.sw;

public class RaceHorse extends JumpingAnimal{
	private int speed;
	
	public RaceHorse(int maxHeight, int speed, String name) {
		super(maxHeight, name); //Constructors are chained
		this.speed = speed;
	}

	public void gallop() throws Exception {
		System.out.println(this.getName() + " is galloping at " + speed + " km/hour");
		move();
	}
}