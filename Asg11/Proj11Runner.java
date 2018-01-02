import java.util.*;
import java.io.Serializable;

class Proj11Runner{
	

	
	public Proj11Runner(){
		
		System.out.println("Jason Burke");
		System.out.println(); 
	}
	
	public Collection getCollection(String[] list){
		
		Collection ref = new TreeSet();
		int j = 0;
		
		for(String i : list){
			ref.add(list[j]);
			j++;
		}
		//Comparator aComparator = Collections.reverseOrder();		
		//Collections.sort(ref);
		//Collections.reverse((List)ref);
		
		return ref;
		
	}// end Proj11Runner()
}// end class Proj11Runner 


