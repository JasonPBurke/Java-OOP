import java.awt.Color;

class Proj03Runner{
	// instantiate the Picture and pixel objects.
	private Picture pic = new Picture("Proj03a.bmp");
	private Pixel pixel = null;
	
	public Proj03Runner(){
		System.out.println("Jason Burke");
	}
	public Picture getPicture(){
		return pic;
	}
	public void run(){

		
		//Prepare the variables
		double xScale = 1.0 * pic.getWidth() / 2.0;
		double xStepSize = 1.0 / xScale;
		double yScale = 1.0 * pic.getHeight() / 2.0;
		int offsetVal = -31;
		int endOffset = offsetVal + 20;// this guarantees a dif of 20
		int shift = 1;
		
		////Draw the cubic function in BLUE to get a center point for black line////
		for(double xVal= -1.0; xVal<=1.0; xVal += xStepSize){
		  //Get a y-value for a given x-value.
		  double yVal = function(-xVal);
		  
		  //Apply the offsets and scale the results
		  int col = (int)Math.round((xVal*xScale) + (pic.getWidth() / 2.0));
		  int row = (int)Math.round((yVal*yScale) + (pic.getHeight() / 2.0));

		  // change the color values for blue and green in a stepwise linear fashion.
		  for(int row_change = row - 1; row_change >= 0; --row_change){
			pixel = pic.getPixel(col, row_change);
			//Get blue and green values for current pixel.
			int green = pixel.getGreen();
			int blue = pixel.getBlue();

			//Use the column number to compute the scale factor.
			double greenScale = (double)(col) / pic.getWidth();
			double blueScale = (double)(pic.getWidth() - col) / pic.getWidth();

			//Apply the scale factor.
			pixel.setGreen((int)(green * greenScale));
			pixel.setBlue((int)(blue * blueScale));
		  }////end for(int row_change////
		  
		  
		  
		  
		  // this loop should color the 20 pixels black for each column
		  for (int offset = offsetVal; offset <= endOffset; ++offset ){
			
			// This if loop should shift the 20 black pixels 
			// down one pixel for each 1/21st of the height
			// in effort to allign the black line.
			if (row >= pic.getHeight()/ 21 *(shift)){
				++offsetVal;
				++endOffset;
				++shift;				
				//offset = offsetVal;
			}
			if ( row + offset >= pic.getHeight() || row + offset < 0) { 
				continue;  // Skip any pixels that would be out of bounds
			}
			pixel = pic.getPixel(col, row + offset);
		    pixel.setColor(Color.BLACK);
		  }// end for (int offset
		}//end for(double xVal
		
		
		// Add message directly to pic.
		pic.addMessage("Jason Burke",10,74);
		
		pic.explore();
					  
	}//end run()
	
	//This method evaluates and returns the y-value for each x-value
	// for a cubic function with no offset centered at the origin.
	// y = x*x*x
	double function(double xVal){
		double yVal = xVal*xVal*xVal;
		return yVal;
	}//end function
	
}// end class Cubic01Runner