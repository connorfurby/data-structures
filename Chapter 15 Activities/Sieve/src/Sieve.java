import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set <Integer> numbers = new HashSet<>(); 
         
        for(int x = 2; x <n+1; x++)
        {
            numbers.add(x); 
        }
        int size = numbers.size();

        Iterator <Integer> iterator = numbers.iterator(); 
        while(iterator.hasNext())
        {
            int num = iterator.next();
            for(int divNum = 2; divNum < n+1; divNum++)
            {
                 
                if (num%divNum==0 && num != divNum)
                {
                    iterator.remove();
                    break;
                }
                
            }
        }
        System.out.println(numbers);


        
      







    }
}