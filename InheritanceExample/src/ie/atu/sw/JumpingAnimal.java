package ie.atu.sw;

public class JumpingAnimal extends Animal{
	private int maxHeight;
	
	public JumpingAnimal(int maxHeight, String name) {
		super(name); //Constructors are chained
		this.maxHeight = maxHeight;
	}
	
	public void jump() throws Exception {
		//Method getName() is inherited by THIS object
		System.out.println(this.getName() + " is jumping to " + maxHeight);
		
		move(); //Can also call an inherited method like this!
		
		//We can refer to non-private superclass features using super 
		System.out.println(super.getName() + " is finished jumping");
	}
}
