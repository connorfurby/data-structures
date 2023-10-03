import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create a priority queue of to-do items
        // A WorkOrder has a message ID that is used to determine priority
        // A priority queue can only store Comparable objects
        Queue<WorkOrder>  toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(2, "Walk Dog"));
        toDo.add(new WorkOrder(9, "Play Videogames"));
        toDo.add(new WorkOrder(1, "Study for the Chapter 15 Exam"));

        // Objects added to a priority queue are stored in priority order
        System.out.println(toDo);

        while(toDo.size() > 0) {
            System.out.println(toDo.remove());
        }
    }
}
