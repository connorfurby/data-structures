import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<>();

        // Add some print jobs
        jobs.add("Joe: Expense Report 2023");
        jobs.add("Cathy: Top Secret Document #5");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Cathy: Really Top Secret Document #2");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Can I get Fired for This?");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Boss: Cathy's Termination Letter");

        // Print the rest of the jobs in the queue 
        while (jobs.size() > 0) {
            System.out.println("Printing: " + jobs.remove());
        }
    }
}
