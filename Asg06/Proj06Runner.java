import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;


public class Proj06Runner extends Proj06{
	
	public Proj06Runner(){ // constructor 
		System.out.println("Jason Burke");
	} // end constructor
	
	public void run(double rotate){ // first image
		//Add name and display the first picture.
		pic.addMessage("I certify thatthis program is my own work",10,20);
		pic.addMessage("and is not the work of others.  I agree not",10,38);
		pic.addMessage("to share my solution with others.",10,56);
		pic.addMessage("Jason P Burke",10,74);
				
		pic = rotatePicture(pic,rotate);
		// Here will go the code to flip image attempting to ues the affine transform.
		//AffineTransform flip = new AffineTransform(0.0,0.0,0.0,-1.0,0.0,0.0);
		pic = cropAndFlip(pic, 0, 0, pic.getWidth()-1, pic.getHeight()-1);
		
	}// end run (double)
	
	public void run(int rotate){ // Second image
		//Add name and display the first picture.
		pic.addMessage("I certify thatthis program is my own work",10,20);
		pic.addMessage("and is not the work of others.  I agree not",10,38);
		pic.addMessage("to share my solution with others.",10,56);
		pic.addMessage("Jason Burke",10,74);

		pic = rotatePicture(pic,rotate);//rotate recieves a passed in value for the rotation.
				
	}// end run	(int)
	
	private Picture rotatePicture(Picture pic, double angle){
		
		// Prepare the rotation transform
		AffineTransform rotateTransform = new AffineTransform();
		rotateTransform.rotate(Math.toRadians(angle), pic.getWidth()/2, pic.getHeight()/2);
		
		// Compute the dimensions of the new picture object
		Rectangle2D rectangle2d = pic.getTransformEnclosingRect(rotateTransform);
	
		int resultWidth = (int)(rectangle2d.getWidth());
		int resultHeight = (int)(rectangle2d.getHeight());
		
		// Prepare the translation transform
		AffineTransform translateTransform = new AffineTransform();
		translateTransform.translate((resultWidth - pic.getWidth())/2,
									 (resultHeight - pic.getHeight())/2);
		
		// Concatenate the rotateTransform and translateTransform objects.		
		translateTransform.concatenate(rotateTransform);
		
		Picture result = new Picture(resultWidth, resultHeight);
		
		// Perform the concatenated transform.
		Graphics2D g2 = (Graphics2D)result.getGraphics();// the (graphics2d) is the result being cast to type graphics2d.
		
		g2.drawImage(pic.getImage(), translateTransform, null);
		
		return result;
		
	}// end rotatePicture method	
	
	private Picture cropAndFlip(Picture pic, int x1, int y1, int x2, int y2){
		
		//int lv_width = x2-x1+1;
		//int lv_height = y2-y1+1;
		
	Picture output = new Picture(x2-x1+1, y2-y1+1);
	
	int width = output.getWidth();// see if this = x2-x1+1
	
	Pixel pixel = null;
	Color color = null;
	
	for (int col = x1; col < (x2+1); col++){
		for (int row = y1; row < (y2+1); row++){
			color = pic.getPixel(col, row).getColor();
			pixel = output.getPixel(width-col+x1-1, row-y1);
			pixel.setColor(color);
			
		}// end inner loop
	}// end outer loop 
	
	return output;
	}// end cropAndFlip
	
}// end class Proj06Runner




















