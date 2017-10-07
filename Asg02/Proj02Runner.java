import java.awt.Color;

class Proj02Runner{
	private Picture pic = new Picture("Proj02.jpg");
	private Turtle turtle01 = new Turtle(pic);
	private Color green = new Color(0,255,0);
	double xScale = 1.0*pic.getWidth()/2;
	double yScale = 1.0*pic.getHeight()/2;
	private Pixel pixel = null;
	
	public Proj02Runner(){
		System.out.println("Jason Burke");
	}
	
	
	public Picture getPicture(){
		return pic;
	}	
	public Turtle getTurtle01(){return turtle01;}
	
	private void drawLine(double xScale, double yScale, 
						  double slope, double yIntercept){
		double yVal = 0;
		int row = 0;
		int col = 0;
		double xVal = -1.0;
		int last_col = -1;
		
		
		for (int cnt = 0 ; cnt<=2000; cnt++, xVal += 0.001){
			// Get a y value for a given x value
			yVal = function(xVal,slope,yIntercept);
			
			// Scale the x and y values to match the ploting surface
			col = (int)(xVal*xScale);
			row = (int)(yVal*yScale);
			
			
			if (col != last_col && col + pic.getWidth()/2 < pic.getWidth()){
				for(int row_change = row + 1; row_change + pic.getHeight()/2
													< pic.getHeight(); row_change ++){
				

				
					pixel = pic.getPixel(col + pic.getWidth()/2, 
										 row_change + pic.getHeight()/2);
					
				
					pixel.setRed(255 - pixel.getRed());
					pixel.setGreen(255 - pixel.getGreen());
					pixel.setBlue(127);
				}//end for loop
			
			}// end inner loop
			last_col = col;
	
		
		}// end outer loop
			
	}
	// This evaluates and returns the y-value for each x-value
	public double function(double xVar, double slope, double yIntercept){
		double yVar = (yIntercept) + (slope*xVar);
		return yVar;
	}
	
	
	public void run(){
		
		//pic.explore();// Print an explore window before changes are made
		
		// Instansiate an instance of the turtle01 object
		//turtle01 = new Turtle(pic);
		
		pic.addMessage("I certify that this program is my own work",10,20);
		pic.addMessage("and is not the work of others.  I agree not",10,38);
		pic.addMessage("to share my solution with others.",10,56);
		pic.addMessage("Jason Burke",10,74);

		
		double slope = -0.34;
		double yIntercept = .1667;
		
		drawLine(xScale,yScale,slope,yIntercept);
		// Manuver the turtle
		turtle01.hide();
		turtle01.setPenWidth(5);
		turtle01.setPenColor(Color.GREEN);
		double yStart = function(-1.0, slope, yIntercept);
		
		turtle01.setPenDown(false);
		
		int col = (int)(-1.0*xScale);
		int row = (int)(yStart*yScale);
		turtle01.moveTo(col + pic.getWidth()/2, row + pic.getHeight()/2);
		
		turtle01.penDown();
		
		double yEnd = function(1.0, slope, yIntercept);
		col = (int)(1.0*xScale);
		row = (int)(yEnd*yScale);
		turtle01.moveTo(col + pic.getWidth()/2, row + pic.getHeight()/2);
		
		pic.explore();
		
		//turtle01.show();
		
		//Pixel[] pixelArray = pic.getPixels();
		
		//for (Pixel pixel: pixelArray){
		//	while (pixel )
		//}
	}
	
}