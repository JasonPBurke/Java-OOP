import java.awt.Color;
import java.awt.*;
import javax.swing.*;

class Proj04Runner{
	
	

	public Proj04Runner(){		
		System.out.println("Jason Burke");
	}// end constructor
	
	public Picture run(){
		
		Picture pix = new Picture("Proj04.jpg");
		Turtle turtle = new Turtle(0,0,pix);
		
		// Add message directly to pic.
		pix.addMessage("I certify that this",2,18);
		pix.addMessage("program is my own",2,36);
		pix.addMessage("work and is not the",2,54);
		pix.addMessage("work of others.",2,72);
		pix.addMessage("Jason Burke",2,90);

		
		//Prepare the variables
		double xOff = -1.0; // offest relative to 1.0
		double yOff = -1.5;
		double xScale = 1.0*pix.getWidth()/2;
		double yScale = 1.0*pix.getHeight()/3;
		double yVal = 0;
		int row = 0;
		int col = 0;
		double xVal = -1.0;
		turtle.setPenColor(Color.BLACK);
		turtle.setPenWidth(1);
		turtle.penUp();
		
		//Draw the partial parabola.
		for(int cnt=0; cnt<=200; cnt++, xVal+=0.005){
			// get a y-value for the given x-value.
			yVal = parFunction(xVal);
			
			// apply the x and y offsets and scale the results.
			col = (int)((xOff-xVal)*xScale);//starts at 0
			row = (int)((yOff+yVal)*yScale);//starts at -40
		
			// move to the first point and translate the origin to the center in the process.
			turtle.moveTo(col + pix.getWidth()/2,
						  row + pix.getHeight()/2);
			
			turtle.penDown();
			
			//call the mirrorUpperQuads method to mirror
			//the pixels above the parabola
			pix = mirrorUpperQuads(pix,col,row);
						
		}// end for loop
				
		// Draw the 2pixel vertical line in RED
		turtle.setPenColor(Color.RED);
		turtle.setPenWidth(2);
		turtle.penUp();
		turtle.moveTo(pix.getWidth()/2,0);
		turtle.penDown();
		turtle.moveTo(pix.getWidth()/2, pix.getHeight()/2);
		turtle.penUp();	
		//color the black pixels on the red line.
		Pixel blackPixel = pix.getPixel(159,90);
		blackPixel.setColor(Color.BLACK);
		blackPixel = pix.getPixel(160,90);
		blackPixel.setColor(Color.BLACK);
		//int width = pix.getWidth()/2;
		
		//Copy the top half of picture to the bottom
		// half of the picture and invert the colors.
		pix = topToBottom(pix);
		
		pix.explore();
		return pix;
		
	} //end run method
	
	private Picture mirrorUpperQuads(Picture pix, int col, int row){
		//here you will take each colum from the for loop in the run method
		//and copy the row and all rows above it over to the right side
		//using getColor/setColor.
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		//int rowShift = row;
		int width = pix.getWidth();
		int midpoint = pix.getWidth()/2;
		int height = pix.getHeight();
	
		

		for(int rowShift = row + 120; rowShift >= 0; rowShift--){
				
			leftPixel = pix.getPixel(midpoint-(-col), rowShift);
			rightPixel = pix.getPixel(midpoint-1+(-col),rowShift);
			rightPixel.setColor(leftPixel.getColor());		
		}// end for (int rowShift

		return pix;	  	  
	}//end private mirror...
	
	private Picture topToBottom(Picture pix){
		//here you will copy the entire upper half of the picture
		//to the bottom half and then invert all the colors for the bottom half
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		
		int midpoint = pix.getHeight()/2;
		int height = pix.getHeight();
		int halfHeight = pix.getHeight()/2;
				
		for(int col = 0; col < pix.getWidth(); col++){
			for(int row = 0; row < midpoint; row++){
				topPixel = pix.getPixel(col,row);
				bottomPixel = pix.getPixel(col, halfHeight + row);
				bottomPixel.setColor(topPixel.getColor());
				bottomPixel.setGreen(255 - topPixel.getGreen());
				bottomPixel.setBlue(255 - topPixel.getBlue());
				bottomPixel.setRed(255 - topPixel.getRed());
			}// end for int row =
		}// end for int col =
		
		return pix;
	}
	
	double parFunction(double xVal){
		double yVal = xVal*xVal;
		return yVal;
	}// end function	
}// end Prob01Runner class












