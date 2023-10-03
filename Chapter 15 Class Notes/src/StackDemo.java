import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();

        // Push commands onto the top of the stack
        commands.push("Insert: 'Hello'");
        commands.push("Insert: ','");
        commands.push("Insert: ' '");
        commands.push("Insert: 'World'");
        commands.push("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: '!'");

        // Print the stack; the top of the stack is on the far right
        System.out.println(commands);

        // Simulate the user pressing the undo button 4 times
        for (int i = 0; i < 4; i++) {
            String command = commands.pop();
            System.out.println("Undo: "  + command);
        }
    }
}
