import java.io.File;
import java.io.IOException;
import java.util.Scanner;


//the class reads a maze structure from a file and converts it into box-drawing characters
public class MAZEreader {
     
    //reads the maze from a file and returns it as a 2D array
                                         
    //filename The name of the file that contains the maze structure.
    // A 2D char array representing the maze.
    //IOException If there's any issue with reading the file.
    public static char[][] readMazeFromFile(String filename) throws IOException {
       
        // Create a File object with the provided filename
        File file = new File(filename);

	// Check if the file exists; if not, notify the user and exit the program
        if (!file.exists()) {
            System.out.println("Maze file not found. Please provide a maze file.");
            System.exit(1);
        }
        // Variables to calculate the dimensions of the maze (rows and columns)
        int rows = 0;
        int cols = 0;
           
	 // First loop: Figure out the size of the maze
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                cols = line.length();
                rows++;
            }
        }

        char[][] maze = new char[rows][cols]; //creates a 2Darray to hold maze structure
        
	//second loop:read the file again to fill the maze array
        try (Scanner scanner = new Scanner(file)) {
            int row = 0; //counter for the current row
            while (scanner.hasNextLine()) {
            // Convert the line into a character array and store it in the current row
                maze[row] = scanner.nextLine().toCharArray();
                row++; //move to the next row
            }
        }



        //return the final 2D array representing the maze
        return maze;
    }


}  

