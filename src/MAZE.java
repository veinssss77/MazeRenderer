import java.io.IOException;

//main class that ties MAZEreading, Mazeconverter, MAZEprinter
public class MAZE {
    private static char[][] maze;
    //static varibale to hold maze structure
    

    
    public static void main(String[] args) {
        try {
	    //reading the maze from file
            maze = MAZEreader.readMazeFromFile("maze_output.txt");
            
	    //convert the maze walls to use box-drawing character
	    MAZEconverter.convertWallsToBoxDrawing(maze);
        
	    //print the updated maze to the console
	    MAZEprinter.printMaze(maze);
        } catch (IOException e) {

            //handles error related to file reading or writing
            System.out.println("Error reading or writing files: " + e.getMessage());
        }
    }
}

