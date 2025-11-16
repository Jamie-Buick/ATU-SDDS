package ie.atu.sw;

public class Runner {

	public static void main(String[] args) throws Exception {
		Animal a = new Animal("Sheep");
	
		
		a.move();
		a.eat();
		
		a = new RaceHorse("Arkle", 12);
		//a = new Kangaroo("Skippy", 4);
		
		RaceHorse arkle = (RaceHorse) a;    // Down-casts are dangerous!!!!!!!!
		arkle.gallop();
		
		JumpingAnimal jumper = null;
		int random = (int) (Math.random() * 200);
		if( random > 50 ) {
			jumper = new RaceHorse("Arkle", 12);
		}else {
			jumper = new Kangaroo("Skippy", 12);
		}
		visit(jumper);
		
	}
	
	
	
	public static void visit(JumpingAnimal j) throws Exception {
		j.jump(); // Behaviour depends on the type of jumping animal => POLYMORHISM!
	}
	
	
	
}
