package ie.atu.sw;

public class Runner {
	public static void main(String[] args) throws Exception {
		Animal animal = new Animal("Fido");
		animal = new JumpingAnimal(3, "Jumper");
		JumpingAnimal jumper = (JumpingAnimal) animal; //A downcast
		jumper.eat();
		jumper.jump(); //All JumpingAnimal methods are now available
		
		animal = new RaceHorse(3, 35, "Arkle");
		RaceHorse horse = (RaceHorse) animal; //A downcast
		horse.gallop(); //All RaceHorse methods are available
		
		Kangaroo skippy = (Kangaroo) animal; //A downcast is dangerous!
		skippy.jump();
	}
}
