import java.util.*;
import java.io.Serializable;

class Proj10Runner{
	

	
	public Proj10Runner(){
		
		System.out.println("I certify that this program is my own work");
		System.out.println("and is not the work of others.  I agree not");
		System.out.println("to share my solution with others.");
		System.out.println("Jason Burke");
		System.out.println(); 
	}
	public Collection getCollection(String[] list){
		
		Collection ref = new ArrayList();
		int j = 0;
		
		for(String i : list){
			ref.add(list[j]);
			j++;
		}
		//Comparator aComparator = Collections.reverseOrder();		
		Collections.sort((List)ref, new TheComparator());
		Collections.reverse((List)ref);
		
		return ref;
		
	}// end Proj10Runner()
}// end class Proj10Runner 

class TheComparator implements Comparator, Serializable{
	
	public int compare(Object o1, Object o2){
		if(!(o1 instanceof String))
			throw new ClassCastException();
		if(!(o2 instanceof String))
			throw new ClassCastException();
		
	//Do an upper-case comparison
    int result =
            ((String)o1).toUpperCase().
                compareTo(((String)o2).
                        toUpperCase());
    return result;
	}// end compare
	
	public boolean equals(Object o){
		if(!(o instanceof TheComparator))
			return false;
		else return true;
	}// end overriden equals()
}// end class TheComparator
