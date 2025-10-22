package ie.atu.sw;

import java.util.*;

public class StudentManager {
	private Collection<Student> students = new ArrayList<>();

	
	
	
	public int size() {			// Delegate methods
		return students.size(); // Delegate the Call
	}

	public boolean isEmpty() {		
		return students.isEmpty();
	}

	public boolean hasStudent(Student s) { // changed from Object o
		return students.contains(s);
	}

	public boolean add(Student e) {
		return students.add(e);
	}

	public boolean remove(Student s) {
		return students.remove(s);
	}

	public void deleteAll() {
		students.clear();
	}


	public String toString() {
		return students.toString();
	}
	
	
	
	
	
	
}
