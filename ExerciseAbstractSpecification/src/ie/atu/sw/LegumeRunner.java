package ie.atu.sw;

import java.util.*;

public class LegumeRunner {

	public void growAll(Collection<Legume> col) {
		for (var j : col) {
			j.grow();
		}
	}
	
	
	
	public <T extends Legume> int countInstances(Collection<T> col) {
		
		for (var j : col) {
			j.grow();
		}
		
		return 0;
		
	}
	
	
}
