import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<int[]> st = new Stack<>();
    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int farbe = 1;
        int[] p = new int[2];
        p[0] = row; p[1] = column;
        st.push(p);

        while (st.size() > 0) {
            int[] loc = st.pop();
            if (pixels[loc[0]][loc[1]] == 0) {
                pixels[loc[0]][loc[1]] = farbe;
                farbe++;
                if (loc[1] > 0) {
                    int[] t = new int[2];
                    t[0] = loc[0];
                    t[1] = loc[1] - 1;
                    st.push(t);
                } 
                if (loc[0] < 9) {
                    int[] t = new int[2];
                    t[0] = loc[0] + 1;
                    t[1] = loc[1];
                    st.push(t);
                } 
                if (loc[1] < 9) {
                    int[] temp = new int[2];
                    t[0] = loc[0];
                    t[1] = loc[1] + 1;
                    st.push(t);
                } 
                if (loc[0] > 0)
                {
                    int[] temp = new int[2];
                    t[0] = loc[0] - 1;
                    t[1] = loc[1];
                    st.push(t);
                } 
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
