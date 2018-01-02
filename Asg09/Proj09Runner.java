import java.util.*;


class Proj09Runner{
		
	public Proj09Runner(){
		
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