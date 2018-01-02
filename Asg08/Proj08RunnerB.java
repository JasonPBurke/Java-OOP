import java.util.*;
import java.awt.Color;

class Proj08RunnerB{

	private int data;
	
	public Proj08RunnerB(){// constructor
		//System.out.println("Burke");
	
	}// end constructor
	
	public int getDataFromObj(Object myObject){
		
		int randNum = (((Proj08RunnerA)myObject).getData());
		graphic(randNum);
		return randNum;
		
	}
	
	public void graphic(int secondRand){
		
	Picture pix = new Picture(350,125);
	pix.setAllPixelsToAColor(Color.BLUE);
	pix.addMessage("Jason Burke",10,74);
	pix.addMessage(Integer.toString(secondRand),10,118);
	pix.show();
	
	}// end graphic
}// end class Proj08RunnerB