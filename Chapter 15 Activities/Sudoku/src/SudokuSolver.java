import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3; // number of squares in a row
    private final int N = M * M; // number of squares in a sudoku
    private int[][] grid; // 2d array of integers 
    private ArrayList<Set<Integer>> rows; // stores the rows
    private ArrayList<Set<Integer>> cols; // stores the columns
    private ArrayList<Set<Integer>> squares; // stores all of the squares
    private Set<Integer> nums; // populates the potential numbers

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {  // blank = 0
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows) 
        this.rows = new ArrayList<Set<Integer>>();
        for (int i = 0; i < N; i++)
        {
            Set <Integer> currRow = new HashSet<>(); 
            for (int k = 0; k < N; k++)
            {
                currRow.add(grid[i][k]);
            }
            this.rows.add(currRow);
        }

        // create the list of sets for each col (this.cols)
        this.cols = new ArrayList<Set<Integer>>();
        for (int i = 0; i < 9; i++)
        {
            Set <Integer> currCol = new HashSet<>(); 
            for (int k = 0; k < 9; k++)
            {
                currCol.add(grid[k][i]);
            }
            this.cols.add(currCol);
        }

        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        this.squares = new ArrayList<Set<Integer>>();
        for (int sqnum = 0; sqnum < N; sqnum++)
        {
            Set <Integer> currSquare = new HashSet<>();
            for (int col = 0; col < M; col++)
            {
                for (int row = 0; row < M; row++)
                {
                    if (sqnum < N/M)
                        currSquare.add(grid[row][((sqnum % 3)* 3) + col]);
                    else if (sqnum < N/M*2)
                        currSquare.add(grid[3 + row][((sqnum % 3)*3) + col]);
                    else
                        currSquare.add(grid[6 + row][((sqnum % 3)*3) + col]);
                }
            }
            this.squares.add(currSquare);
        }

        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<>();
        for (int i = 0; i < 9; i++)
        {
            this.nums.add(i);
        }

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        /*
        for (int i = 0; i < rows.get(nextRow).size(); i++)
        {
            if (cols.get(nextCol).contains(i))
                possibleNums.remove(i);
        }
        */
        possibleNums.removeAll(cols.get(nextCol));
        possibleNums.removeAll(rows.get(nextRow));
        int nextSquare = -1;

        if (nextCol < N/M)
        {
            if (nextRow < N/M)
                nextSquare = 0;
            else if (nextRow < N/M*2)
                nextSquare = 1;
            else
                nextSquare = 2;
        }
        else if (nextCol < N/M*2)
        {
            if (nextRow < N/M)
                nextSquare = 3;
            else if (nextRow < N/M*2)
                nextSquare = 4;
            else
                nextSquare = 5;
        }
        else
        {
            if (nextRow < N/M)
                nextSquare = 6;
            else if (nextRow < N/M*2)
                nextSquare = 7;
            else
                nextSquare = 8;
        }
        System.out.println("Curr Row: " + nextRow + "   Curr Col: " + nextCol + "   Curr Square: " + nextSquare);
        possibleNums.removeAll(rows.get(nextSquare));

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            grid[nextRow][nextCol] = possibleNum;
            rows.get(nextRow).add(possibleNum);
            cols.get(nextCol).add(possibleNum);
            squares.get(nextSquare).add(possibleNum);

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                grid[nextRow][nextCol] = 0;
                rows.get(nextRow).remove(possibleNum);
                cols.get(nextCol).remove(possibleNum);
                squares.get(nextSquare).remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}