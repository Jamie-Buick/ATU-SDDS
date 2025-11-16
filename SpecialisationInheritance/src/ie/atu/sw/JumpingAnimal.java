package ie.atu.sw;

public class JumpingAnimal extends Animal{

	
	private int maxHeight;
	
	
	public JumpingAnimal(String name, int maxHeight) {
		super(name);
		this.maxHeight = maxHeight;
	}



	public JumpingAnimal(int maxHeight, int lifeForce, String name) {
		super(lifeForce, name);
		this.maxHeight = maxHeight;
	}
	
	
	public void jump() throws Exception {
		System.out.println(this.getName() + " is jumping to a height of " + this.maxHeight);
		super.move();
		System.out.println(super.getName() + " is finished jumping.");
	}
	
	

}
