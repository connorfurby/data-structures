import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /* The map interface is generic
         * The first type is the type of the key.
         * The second type is the type of the value */
        Map <String, Color> favColors = new HashMap<>();

        favColors.put("Hyder", Color.RED);
        favColors.put("Athena", Color.MAGENTA);
        favColors.put("Bavya", Color.BLUE);

        // Two different keys can have the same value
        favColors.put("Mitchell", Color.RED);

        // The same key CANNOT have two different values
        favColors.put("Athena", Color.ORANGE);

        System.out.println(favColors.get("Athena"));

        // Create a set of the keys in a map
        Set<String> keys = favColors.keySet();
        for (String key : keys) {
            System.out.println(key + "(" + key.hashCode() + "): " + favColors.get(key));
        }
    }
}
