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
        int space1index = 0;
        String currWord;
        for (int i = 0; i < sentence.length(); i++)
        {
            if (sentence.charAt(i) == ' ' || sentence.charAt(i) == '.')
            {
                if (sentence.charAt(i) == '.')
                    currWord = sentence.substring(space1index, i);
                else
                    currWord = sentence.substring(space1index, i + 1);
                space1index = i;
                words.push(currWord);
            }
            if (sentence.charAt(i) == '.')
            {
                boolean first = true;
                while(words.size() > 0)
                {
                    currWord = words.pop();
                    if (first)
                        currWord.toUpperCase();
                    if (words.size() == 1)
                        currWord.toLowerCase();
                    first = false;
                    newsentence = newsentence + currWord;
                }
            }
        }
        return newsentence;

    }
}
