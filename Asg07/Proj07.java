//34567890123456789012345678901234567890123456789012345678

/*File Proj07 Copyright 2013, R.G.Baldwin
*********************************************************/
import java.util.*;

abstract class Proj07{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Random generator = new Random(new Date().getTime());
    int firstRandomNumber = (byte)generator.nextInt();
    Proj07 objRef = new Proj07Runner(firstRandomNumber);
    System.out.println(objRef);
    
    int secondRandomNumber = (byte)generator.nextInt();
    System.out.println(
                      objRef.getData(secondRandomNumber));
    
    System.out.println(firstRandomNumber);
    System.out.println(secondRandomNumber);
  }//end main

  abstract int getData(int param);

}//end class Proj07
//End program specifications