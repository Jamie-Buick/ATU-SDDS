package ie.atu.sw;

import java.util.*;

public class Runner {

	public static void main(String[] args) throws Exception {
		Animal a = new RaceHorse("Sheep", 34);
	
		
		a.move();
		a.eat();
		
		a = new RaceHorse("Arkle", 12);
		//a = new Kangaroo("Skippy", 4);
		
		RaceHorse arkle = (RaceHorse) a;    // Down-casts are dangerous!!!!!!!!
		arkle.gallop();
		
	
		List<JumpingAnimal> jumpers = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			
			int random = (int) (Math.random() * 200);
			if( random > 50 ) {
				jumpers.add(new RaceHorse("Arkle- " + i, 12));
			}else {
				jumpers.add(new Kangaroo("Skippy- " + i, 12));
		
			}
		}
		visit(jumpers);
		
	}
	
	
	
	public static void visit(Collection<JumpingAnimal> col) throws Exception {
		
		for(JumpingAnimal j : col) {
			//j.jump(); // Behaviour depends on the type of jumping animal => POLYMORHISM!
			//j.eat(); // This behaviour is polymorphic and depends on the type of animal
			j.sleep();
		}
		
	}
	
	
}
