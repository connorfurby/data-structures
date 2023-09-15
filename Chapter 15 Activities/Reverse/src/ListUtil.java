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
       ListIterator<String> iteratorforward = strings.listIterator();
       ListIterator<String> iteratorbackward = strings.listIterator();
       while (iteratorbackward.hasNext()) {
        iteratorbackward.next();
       }
        while(iteratorbackward.hasPrevious()){
            iteratorforward.add(iteratorbackward.previous());
        }
    }
}