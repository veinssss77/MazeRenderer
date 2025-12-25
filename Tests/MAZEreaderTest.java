
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;


public class MAZEreaderTest {

    // ======= BLACK BOX TESTS =======

    /**
     * Black Box Test:
     * Verifies that an IOException is thrown when the file does not exist.
     */
    @Test
    public void blackBoxTestFileDoesNotExist() {
        Exception exception = assertThrows(IOException.class, () -> {
            MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/nonexistent.txt");
        });
        assertTrue(exception.getMessage().contains("Maze file not found"), 
                   "Expected an error indicating the file was not found.");
    }

    /**
     * Black Box Test:
     * Verifies that an empty file is handled gracefully and returns an empty maze array.
     */
    @Test
    public void blackBoxTestEmptyFile() {
        assertDoesNotThrow(() -> {
            char[][] maze = MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/empty.txt");
            assertEquals(0, maze.length, "Expected an empty array for an empty file.");
        });
    }

    /**
     * Black Box Test:
     * Verifies that a valid maze file is read correctly into a 2D char array.
     */
    @Test
    public void blackBoxTestValidMazeFile() {
        assertDoesNotThrow(() -> {
            char[][] maze = MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/ValidMaze.txt");
            assertNotNull(maze, "Maze should not be null for a valid file.");
            assertEquals(4, maze.length, "Expected maze rows to match the input file.");
            assertEquals(5, maze[0].length, "Expected maze columns to match the input file.");
        });
    }

    /**
     * Black Box Test:
     * Verifies that an invalid maze file (e.g., containing invalid data) is handled appropriately.
     */
    @Test
    public void blackBoxTestInvalidMazeFile() {
        Exception exception = assertThrows(IOException.class, () -> {
            MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/invalid.txt");
        });
        assertTrue(exception.getMessage().contains("Invalid maze data"), 
                   "Expected an error indicating invalid maze data.");
    }

    // ======= WHITE BOX TESTS =======

    /**
     * White Box Test:
     * Tests the scenario where the file exists but contains no data (empty file).
     * Verifies the loop handling for counting rows and columns.
     */
    @Test
    public void whiteBoxTestEmptyFileLoop() {
        assertDoesNotThrow(() -> {
            char[][] maze = MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/empty.txt");
            assertEquals(0, maze.length, "Expected no rows in the maze for an empty file.");
        });
    }

    /**
     * White Box Test:
     * Tests the loop logic for parsing a valid maze file.
     */
    @Test
    public void whiteBoxTestValidMazeLoop() {
        assertDoesNotThrow(() -> {
            char[][] maze = MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/ValidMaze.txt");
            assertEquals(' ', maze[0][0], "Expected a space for the starting path.");
            assertEquals('#', maze[0][1], "Expected a wall character.");
        });
    }

    /**
     * White Box Test:
     * Tests the condition where a file is invalid and contains unexpected symbols.
     */
    @Test
    public void whiteBoxTestInvalidDataCondition() {
        Exception exception = assertThrows(IOException.class, () -> {
            MAZEreader.readMazeFromFile("home/ishtiaq/Mohammed_Ishtiaq_22856133_ISErepo/invalid.txt");
        });
        assertTrue(exception.getMessage().contains("Invalid maze data"),
                   "Expected an error when invalid symbols are present.");
    }
}  
