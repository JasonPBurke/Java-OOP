import java.util.*;
import java.io.Serializable;

class Proj12Runner{
		
	public Proj12Runner(){

		System.out.println("Jason Burke");
		System.out.println(); 
	}
	
	public Collection getCollection(String[] list){
		
		Collection<String> ref = new TreeSet<>(new TheComparator());
		int j = 0;
		
		for(String i : list){
			ref.add(list[j]);
			j++;
		}
		
		return ref;
		
	}// end Proj12Runner()
}// end class Proj12Runner 

class TheComparator implements Comparator<Object>, Serializable{
	
	public int compare(Object o1, Object o2){
		if(!(o1 instanceof String))
			throw new ClassCastException();
		if(!(o2 instanceof String))
			throw new ClassCastException();
		
	// Do a regular comparason.	
	//int result = ((String)o1).compareTo(((String)o2));
	
	

	//Do an upper-case comparison
    int result =
            ((String)o1).toUpperCase().
                compareTo(((String)o2).toUpperCase());
	
    //return result;
	return result*(-1);// this will reverse the set order
	}// end compare
	
	public boolean equals(Object o){
		if(!(o instanceof TheComparator))
			return false;
		else return true;
	}// end overriden equals()
}// end class TheComparator


















