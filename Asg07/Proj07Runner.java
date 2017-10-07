import java.awt.Color;

class Proj07Runner extends Proj07{
	
	private int randomNum;
		
	public Proj07Runner(int number) {// constructor that will accept the  
									 // int that will be passed in.
		
		randomNum = number;// here we assign the passed in int value to randomNum
	}// end constructor
	
	public int getData(int secondRandom) {//
		
		graphic(secondRandom);// this will pass the second random number to the 
							  // graphic method for its output.
		return randomNum;		
	}// end getData method
		
	// we must now override the toString method as the
	// controlling class call directly a refrence holding the Proj07Runner object.
	public String toString() {
		return "Proj07\nJason\nBurke";			
	}// end toString method
	
	public void graphic(int secondRand){
		Picture pix = new Picture(350,125);
		pix.setAllPixelsToAColor(Color.BLUE);
		pix.addMessage("I certify that this program is my own work",10,20);
		pix.addMessage("and is not the work of others.  I agree not",10,38);
		pix.addMessage("to share my solution with others.",10,56);
		pix.addMessage("Jason Burke",10,74);
		pix.addMessage("ITSE 2321 asdfg",10,92);
		pix.addMessage(Integer.toString(secondRand),10,118);
		pix.show();
	}// end graphic
}// end class Proj07Runner 