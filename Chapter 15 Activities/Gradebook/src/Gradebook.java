import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

         Map <String, String> grades = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } 

            else if (input.equals("A"))
            {
                String name;
                String grade;
                System.out.println("Enter a name: ");
                in.nextLine();
                name = in.nextLine();
                System.out.println("Enter their grade: ");
                grade = in.nextLine();
                grades.put(name, grade);

            } 

            else if (input.equals("R"))
            {
                String name;
                System.out.println("Who would you like to remove?: ");
                in.nextLine();
                name = in.nextLine();
                if (grades.containsKey(name))
                    grades.remove(name); 
                else
                    System.out.println("That person is not in the system. ");
            }

            else if (input.equals("M"))
            {
                String name;
                String grade;
                System.out.println("Whos grade would you like to modify?: ");
                in.nextLine();
                name = in.nextLine();
                System.out.println("Enter their new grade: ");
                grade = in.nextLine();
                if (grades.containsKey(name))
                    grades.put(name, grade);
                else
                    System.out.println("That person is not in the system yet, try adding them.");

            } 

            else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = grades.keySet();
                for (String key : keys) 
                {
                System.out.println(key + ": " + grades.get(key));
                }
            }
            else
            {
                done = true;
            }
        }
    }
}
