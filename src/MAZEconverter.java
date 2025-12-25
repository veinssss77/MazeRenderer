public class MAZEconverter{   //class to convert walls to box drawing characters

    //constants to represent maze elements paths and walls
    private static final char path = ' ';//for open path in maze
    private static final char wall = '#';//wall in the maze

    //converts all walls give in maze array into box-drawing characters

    //the parameters are a maze 2D array representing the maze where '#' is a wall and ' ' is a path
    public static void convertWallsToBoxDrawing(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == wall) {
                    maze[i][j] = determineBoxDrawingChar(maze, i, j);
                }
            }
        }
    }

    //parameter is  maze 2D array representing the maze
    //parameter  i is a Row index of the current cell
    //parameter j is a Column index of the current cell
    // returns a box-drawing character representing the wall configuration
     


    private static char determineBoxDrawingChar(char[][] maze, int i, int j) {
	//checking for walls on all directions
        boolean up = i > 0 && maze[i - 1][j] != path;//wall above
        boolean down = i < maze.length - 1 && maze[i + 1][j] != path;//wall below
        boolean left = j > 0 && maze[i][j - 1] != path;//wall to the left
        boolean right = j < maze[i].length - 1 && maze[i][j + 1] != path;//wall to the right

        if (up && down && left && right) return '┼';//connected on all sides
        if (up && down && left) return '┤';//connected on top,bottom,and left
        if (up && down && right) return '├';//connected on top,bottom and right
        if (up && left && right) return '┴';//connected on top. left and right
        if (down && left && right) return '┬';//connected on bottom,left,right
        if (up && down) return '│';//connected vrtically
        if (left && right) return '─';//connected horizontally
        if (up && right) return '└';//connected on top and right
        if (up && left) return '┘';//connected on top and left
        if (down && right) return '┌';//connected on bottom and right
        if (down && left) return '┐';//connected on bottom and left

        return '│';
    }
}
