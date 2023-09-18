import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
       ListIterator<String> iterator = strings.listIterator();
       LinkedList<String> temporary = new LinkedList<>();
       while (iterator.hasNext()) {
        iterator.next();
       }
        while(iterator.hasPrevious()){
            temporary.add(iterator.previous());
        }
        int count = 0;
        for (String s : temporary) {
            strings.set(count, s);
            count++;
        }
    }
}