import java.util.*;


class Proj09Runner{
	

	
	public Proj09Runner(){
		
		System.out.println("I certify that this is my own work");
		System.out.println("and not the work of others.  I agree not");
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
		
		Collections.sort((ArrayList)ref);
		Collections.reverse((ArrayList)ref);
		
		return ref;
		
	}
}