/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Preston");
        students.addFirst("Emma");
        students.addFirst("William");
        students.addFirst("Addison");

        System.out.println(students);

        ListIterator iterator = students.listIterator();
        iterator.next();
        iterator.add("Hyder");
        System.out.println(iterator.next());
        iterator.remove();
    }


    }