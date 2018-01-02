import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Prob01{//Driver class
  public static void main(String[] args){
    //Instantiate an object and call its method named run.
    Prob01Runner obj = new Prob01Runner();
    obj.run();
	Picture mars = obj.getMars();
    mars.explore();

    //Get information from the object and display it on
    // the command-line screen.
    System.out.println(obj.getForceshield());
    System.out.println(obj.getLightsaber());
  }//end main
}//end class Prob01

