package ie.atu.sw;

public class Pea extends Legume {

	private int mushiness;

	public Pea(String name) {
		super(name);
	}

	public void mush() {
		System.out.println(this.getClass().getName() + ".......mushing.........");
	}

	@Override
	public void grow() {
		System.out.println(this.getClass().getName() + "....Growing....");

	}

}
