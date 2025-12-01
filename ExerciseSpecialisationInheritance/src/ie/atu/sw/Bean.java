package ie.atu.sw;

public class Bean extends Legume {

	private String name;

	public Bean(String name) {
		super(name);
		this.name = name;
	}

	// Bean is completely overriding the Legume super class. It doesn't call super.grow. 
	@Override
	public void grow() {
		System.out.println(this.getClass().getName() + "....Bean Growing....");

	}

}
