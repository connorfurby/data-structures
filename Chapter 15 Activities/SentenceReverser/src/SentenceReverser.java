import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
    	Stack<String> words = new Stack<>();
        String newsentence = "";
        int space1index = -1;
        String currWord;
        for (int i = 0; i < sentence.length(); i++)
        {
            if (sentence.charAt(i) == ' ' || sentence.charAt(i) == '.')
            {
                if (sentence.charAt(i) == '.')
                {
                    currWord = sentence.substring(space1index + 1, i);
                    currWord = currWord + " ";
                }
                else 
                    currWord = sentence.substring(space1index + 1, i + 1);
                if (sentence.charAt(i) == ' ')
                    space1index = i;
                else if (!(i + 1 >= sentence.length()))
                    space1index = i + 1;
                words.push(currWord);
            }
            
            if (sentence.charAt(i) == '.')
            {
                boolean first = true;
                while(words.size() > 0)
                {
                    currWord = words.pop();
                    if (first)
                        currWord = currWord.substring(0, 1).toUpperCase() + currWord.substring(1);
                    if (words.size() == 0)
                        currWord = currWord.toLowerCase();
                    first = false;
                    newsentence = newsentence + currWord;
                }
                space1index += 2;
                newsentence = newsentence + ".";
            }
        }
        return newsentence;

    }
}
