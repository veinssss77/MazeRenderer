//THis class is responsible for printing the maze to console
public class MAZEprinter {

    //prints the maze to the console in a readable format
    
    // maze is a 2D array representing maze structure
    public static void printMaze(char[][] maze) {
	    //loop through each row of the maze
        for (char[] row : maze) {
            //loop through each character in the current row
            for (char c : row) {
		   //print the character without a new line
                System.out.print(c);
            }
	    //after printing all characters in the row, move to next line
            System.out.println();
        }
    }
}

