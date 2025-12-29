# MazeRenderer

MazeRenderer is a terminal-based Java application that reads an ASCII maze from a file, converts wall characters into box-drawing characters, and prints a clean, readable maze to the console. The project focuses on modular design, clarity, and testability.

---

## Project Structure

MazeRenderer/
├── src/
│ ├── Maze.java – Main entry point orchestrating reading, conversion, and printing
│ ├── MazeReader.java – Reads the maze from a file into a 2D array
│ ├── MazeConverter.java – Converts walls to box-drawing characters based on neighbors
│ └── MazePrinter.java – Prints the converted maze to the terminal
│
├── tests/
│ ├── MazeReaderTest.java – Tests reading maze files into 2D arrays
│ └── MazeConverterTest.java – Tests wall-to-box conversion logic
│
├── docs/ # Supporting documentation
├── README.md
└── .gitignore # Excludes compiled files (.class), libraries, etc.

yaml
Copy code

---

## How It Works

1. `MazeReader` loads the maze from a text file.
2. `MazeConverter` analyzes neighboring cells and replaces wall characters with box-drawing characters.
3. `MazePrinter` outputs the formatted maze to the terminal.
4. `Maze` coordinates the full flow.

---

## Running the Program

Compile:
```bash
javac src/*.java
Run:

bash
Copy code
java Maze
Testing
JUnit test files are included under the tests/ directory to validate:

Maze file reading logic

Wall conversion correctness

Only test source files are included; external JUnit libraries are not bundled.

