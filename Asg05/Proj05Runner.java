import java.awt.Color;


class Proj05Runner extends Proj05{
	
	public Proj05Runner(){//constructor
		System.out.println("Jason Burke");
	}// end constructor
	
	public void run(){
		
		Picture skater = new Picture("Proj05a.bmp");
		//skater.explore();
		skater = crop(skater,6,59,392,293);
		
		Picture hole = new Picture("Proj05b.bmp");
		//hole.explore();
		hole = crop(hole,6,59,392,293);
		
		Picture snowScene = new Picture("Proj05c.jpg");
		//snowScene.explore();
		snowScene = crop(snowScene,6,59,392,293);
		
		// Make all the pixels darker in the snow scene except
		// for those in the location of the hole.  Make them brighter.
		darkenBackground(hole,snowScene);
		
		// Apply a tint to the skater.
		greenTint(skater);
		
		// Draw the skater on the snowScene.
		greenScreenDraw(skater,snowScene,0,0);
		
		// Draw the green parabola on the snow scene.
		parabola(snowScene);
		
		// Display name on final output.
		snowScene.addMessage("I certify that this program is my own work",10,60);
		snowScene.addMessage("and is not the work of others. I agree not",10,78);
		snowScene.addMessage("to share my solution with others.",10,96);
		snowScene.addMessage("Jason Burke",10,114);
		
		snowScene.explore();
		System.out.println(snowScene);
	
		
	}// End run method
	

	private void darkenBackground(Picture pattern, Picture dest){
		
		Pixel[] patternPixels = pattern.getPixels();
		Pixel[] destPixels = dest.getPixels();
		Color color = null;
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for(int count = 0; count < patternPixels.length; count++){
			color = patternPixels[count].getColor();
			if(color.equals(Color.GREEN)){
				// Darken corresponding pixel in the destination picture
				color = destPixels[count].getColor();
				destPixels[count].setColor(color.darker());
			}// end if(color...)
			else{
				// Apply a red//green tint to the corresponding 
				// pixel in the destination.
				color = destPixels[count].getColor();
				green = color.getGreen();
				
				if(green*1.25 < 255){
					green = (int)(green * 1.25);
				}// end if(red*...)
				else{
					green = 255;
				}// end else
				green = 255;	
				red = 0; //(int)(color.getRed() * 0.8);
				blue =  0; //(int)(color.getBlue() * 0.8);
				destPixels[count].setColor(new Color(red,green,blue));
			}// end else 
				
		}// end for(int count...)
	}// end darkenBackground method
	
	// Assumes the source has a pure green background.
	// Applies a red tint to every pixel that is not pure green.
	private void greenTint(Picture pic){
		Pixel[] pixels = pic.getPixels();
		Color color = null;
		int red = 0;
		int green = 0;
		int blue = 0;
		for(int cnt = 0; cnt< pixels.length; cnt++){
			color = pixels[cnt].getColor();
			//Apply a red tint to all non-green pixels
			if(!(color.equals(Color.GREEN))){
				// Increase the value of the red component
				green = color.getGreen();
				if(green*1.25 < 255){
					green = (int)(green*1.25);
				}// end if red*...
				else{
					green = 255;
				}// end else
					
				// Decrease the value of blue and green 
				red = 0;//(int)(color.getRed()*0.8);
				blue = 0;//(int)(color.getBlue()*0.8);
				
				// Apply the new color to the pixel.
				pixels[cnt].setColor(new Color(red,green,blue));
			}// end if(!(color...
		}// end for loop
	}// end redTint method
	
	private void greenScreenDraw(Picture source, Picture dest,
								 int destX, int destY){
		
		int width = source.getWidth();
		int height = source.getHeight();
		Pixel pixel = null;
		Color color = null;
		
		for(int row = 0; row < height; row++){
			for(int col = 0; col < width; col++){
				color = source.getPixel(col,row).getColor();
				if(!(color.equals(Color.GREEN))){
					pixel = dest.getPixel(destX + col, destY + row);
					pixel.setColor(color);
				}// end if
			}// end inner for 
		}// end outer for
		
	}// end greenScreenDraw method 
	
	
	private Picture crop(Picture pic,int startCol,int startRow,int width,int height){
		
		Picture output = new Picture(width, height);		
		int colOut = 0;
		int rowOut = 0;
		int col = 0;
		int row = 0;
		Pixel pixel = null;
		Color color = null;
		
		for(col = startCol; col < startCol + width; col++){
			for(row = startRow; row < startRow + height; row++){
				color = pic.getPixel(col,row).getColor();
				pixel = output.getPixel(colOut,rowOut);
				pixel.setColor(color);
				rowOut++;
			}// end inner loop
			rowOut = 0;
			colOut++;
		}// end outer loop
		return output;
	}// end crop method.
	
	private void parabola(Picture pic){
		
		// variables to control the parabola offsets.
		double xOff = 0.21;
		double yOff = -0.38;
		double xScale = 0.40*pic.getWidth()/2;
		double yScale = 1.57*pic.getHeight()/2;
		
		Turtle turtle = new Turtle(0,0,pic);
		double yVal = 0;
		int row = 0;
		int col = 0;
		double xVal = -1;
		
		turtle.penUp();
		turtle.setPenColor(Color.GREEN);
		turtle.setPenWidth(8);
		
		for(int i = 0; i <= 100; i++, xVal += 0.02){
			// Get a y-value for the given x-value.
			yVal = parabolaFunction(xVal);
			
			col = (int)((xOff+xVal)*xScale);
			row = (int)((yOff+yVal)*yScale);
			//System.out.println(col + " " + row);
			
			turtle.moveTo(col + pic.getWidth()/2, row + pic.getHeight()/2);
			
			
			turtle.penDown();
		}// end for loop 
		
		
	}// end parabola method 
	
	double parabolaFunction(double xVal){
		double yVal = xVal*xVal;
		return yVal;
	}// end parabolaFunction

}// end class Prob04Runner
















