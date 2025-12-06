package ie.atu.sw;

public class Bean extends Legume {

	private String name;

	public Bean(String name) {
		super(name);
	}

	@Override
	public void grow() {
		System.out.println(this.getClass().getName() + "....Bean Growing....");
	}

}
