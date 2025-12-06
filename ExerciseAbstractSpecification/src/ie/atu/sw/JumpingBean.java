package ie.atu.sw;

public class JumpingBean extends Bean implements Jumpator {
	
	public JumpingBean(String name) {
		super(name);
	}

	public void jump() {
		System.out.println(this.getClass().getName() + "....Jumping....");

	}
}
