import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{

    //Stack representing the cars in the driveway.
    private Stack<Integer> driveway;
    //Stack representing the cars in the street.
    private Stack<Integer> street;
    public Driveway()
    {
      driveway = new Stack<Integer>();
      street = new Stack<Integer>();
    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
       driveway.push(licensePlate);
       System.out.println("Added car with license plate " + licensePlate + " to the driveway.");
    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
      if (driveway.contains(licensePlate)) {
        System.out.println("Removed car with license plate " + licensePlate + " from the driveway.");
        Stack<Integer> temp = new Stack<Integer>();
        while (!driveway.isEmpty() && driveway.peek() != licensePlate) 
        {
          temp.push(driveway.pop());
        }
        if (!driveway.isEmpty()) 
        {
            driveway.pop();
        }
        while (!temp.isEmpty()) 
        {
            street.push(temp.pop());
        }
      } 

      else if (street.contains(licensePlate)) {
        System.out.println("Removed car with license plate " + licensePlate + " from the street.");
        Stack<Integer> temp = new Stack<Integer>();
        while (!street.isEmpty() && street.peek() != licensePlate) 
        {
            temp.push(street.pop());
        }
        if (!street.isEmpty()) 
        {
            street.pop();
        }
        while (!temp.isEmpty()) 
        {
            street.push(temp.pop());
        }
      } 

      else {
        System.out.println("Car with license plate " + licensePlate + " not found.");
    }
}

    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");

        for (int i = 0; i < driveway.size(); i++) {
          int license = driveway.pop();
          System.out.println(license);
      }

        System.out.println("In Street, starting at first in (one license plate per line):");
        
        for (int i = 0; i < street.size(); i++) {
          int license = street.pop();
          System.out.println(license);
        }
      }

}
