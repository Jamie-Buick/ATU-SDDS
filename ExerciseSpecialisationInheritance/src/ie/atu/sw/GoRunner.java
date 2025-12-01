package ie.atu.sw;

public class GoRunner {

	public static void main(String[] args) {
		
		/*
		Legume legume = new JumpingBean("Jamie");		// Yes, as JumpingBean is a 'descendant' of legume 
		Bean bean = (Bean) legume; 						// Yes, you are down casting a legume to a bean. Not recommended but I think it works. Can lead to class cast exception.
		bean.grow();           							// Grow method is the method that jumpingBean inherited from bean. 	
		*/
		
		/*
		Legume legume = new JumpingBean("Jamie");		// Yes, as JumpingBean is a 'descendant' of legume 
		legume = new Pea("Jamie");						// Yes a pea 'IS A' legume.
		legume.grow();									// It is calling the grow method from pea. It override and refined the legume method thats why there is two sysouts. 
		legume.mush();									// legumes do not know anythig about mushing!
		
		// I think legume.grow worked but legume.much didnt work due to the grow method being overidden. Whereas legume doesn't know about mushing.
		 */
		
		/*
		Legume legume = new JumpingBean("Jamie");		// Yes, as JumpingBean is a 'descendant' of legume 
		Pea pea = (Pea) legume;							// No, a jumpingBean is not a pea. 
		pea.mush();
		*/	
	
	}
}
