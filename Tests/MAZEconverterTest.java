import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MAZEconverterTest {

    // ======= BLACK BOX TESTS =======

    /**
     * Black Box Test:
     * Verifies that an empty maze remains unchanged.
     */
    @Test
    public void blackBoxTestEmptyMaze() {
        char[][] maze = {{' ', ' '}, {' ', ' '}};
        MAZEconverter.convertWallsToBoxDrawing(maze);
        assertEquals(' ', maze[0][0], "Expected an empty cell to remain unchanged.");
    }

    /**
     * Black Box Test:
     * Verifies that a maze with walls is converted correctly.
     */
    @Test
    public void blackBoxTestWallConversion() {
        char[][] maze = {{'#', '#'}, {'#', '#'}};
        MAZEconverter.convertWallsToBoxDrawing(maze);
        assertEquals('┼', maze[0][0], "Expected a '+' character for a fully surrounded wall.");
    }

    /**
     * Black Box Test:
     * Verifies that mixed walls and paths are handled correctly.
     */
    @Test
    public void blackBoxTestMixedWalls() {
        char[][] maze = {{'#', ' '}, {'#', '#'}};
        MAZEconverter.convertWallsToBoxDrawing(maze);
        assertEquals('└', maze[1][0], "Expected a corner character for mixed connections.");
    }

    // ======= WHITE BOX TESTS =======

    /**
     * White Box Test:
     * Tests the loop logic for converting walls to box drawing characters.
     */
    @Test
    public void whiteBoxTestConversionLoop() {
        char[][] maze = {{'#', '#'}, {'#', '#'}};
        MAZEconverter.convertWallsToBoxDrawing(maze);
        assertEquals('┼', maze[0][0], "Expected correct character based on neighbors.");
    }

    /**
     * White Box Test:
     * Tests the condition logic for each type of wall connection.
     */
    @Test
    public void whiteBoxTestWallCondition() {
        char[][] maze = {{'#', ' '}, {'#', ' '}};
        MAZEconverter.convertWallsToBoxDrawing(maze);
        assertEquals('│', maze[0][0], "Expected vertical wall connection.");
    }

}
