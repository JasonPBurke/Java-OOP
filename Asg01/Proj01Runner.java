import java.awt.Color;

// you will need to change all Prob01 to Proj01
//before you submit
class Proj01Runner{
	
	private Picture mars = new Picture("Proj01.jpg");
	private Color saberColor = new Color(0,255,255);
	private Color crossColor = new Color(255,200,0);//add red/yellow if not matching.
	//Instantiate the World and Turtle objects.
	//private World mars = new World(picture.getWidth(), picture.getHeight());
	private Turtle Forceshield;// = new Turtle(mars);
	private Turtle Lightsaber;// = new Turtle(mars);
	
	public Proj01Runner(){//constructor method.
		System.out.println("Jason Burke.");
	}//end constructor
	
	
	//Accessor Methods
	public Turtle getForceshield(){return Forceshield;}
	public Turtle getLightsaber(){return Lightsaber;}
	public Picture getMars(){return mars;}
	
	public void run(){
		//Replace the default all-white picture
		//with another picture.
		//mars.setPicture(picture);
		Forceshield = new Turtle(mars);
		Lightsaber = new Turtle(mars);
		int radius = 103;
		
		mars.addMessage("Jason Burke",10,74);
		
		//Manipulate the turtle named Lightsaber.
		Lightsaber.hide();
		Lightsaber.setName("Lightsaber");
		Lightsaber.setPenWidth(3);
		Lightsaber.setPenColor(saberColor);
		Lightsaber.setPenDown(false);
		Lightsaber.moveTo(190,166);
		Lightsaber.setPenDown(true);
		Lightsaber.moveTo(157,107);
		
		//Manipulate the turtle named Forceshield.
		Forceshield.penUp();
		Forceshield.hide();
		Forceshield.setName("Forceshield");
		Forceshield.setPenColor(Color.YELLOW);
		Forceshield.setPenWidth(3);

		Forceshield.turn(180.0);
		Forceshield.forward(radius);

		Forceshield.moveTo(197,44);
		Forceshield.penDown();
		
		double dX = 0.0;
		double dY = radius;
		
		while(dY > (double) (- radius)){
		  dY-=1;
		  if (dY < 0.0) {
                Forceshield.setPenColor(Color.RED);
                Forceshield.setPenWidth(4);
            }
		  dX = Math.sqrt((double) (radius*radius) - dY*dY);//starts about 14-15
		  Forceshield.moveTo((int) ((double)(mars.getWidth()/2) - dX),// we want the first move to be 197, 44 (X, Y)
							 (int) ((double)(mars.getHeight()/2) - dY));//Width = 393; Height = 294
		}//end while loop
		
		//Draw the axes in custom color
		Forceshield.setPenWidth(2);
		Forceshield.setPenColor(crossColor);
		Forceshield.turn(-90);
		Forceshield.penUp();
		Forceshield.moveTo(mars.getWidth()/2,0);
		Forceshield.penDown();
		Forceshield.moveTo(mars.getWidth()/2,mars.getHeight());
		Forceshield.penUp();
		Forceshield.moveTo(mars.getWidth(),mars.getHeight()/2);
		Forceshield.penDown();
		Forceshield.moveTo(0,mars.getHeight()/2);
		Forceshield.penUp();
		Forceshield.moveTo(197,147);
		
		
	}//end run method
}//end class Proj01Runner