public class MazeModel {
    Maze maze;

    public MazeModel(int x, int y) {

        maze = new MazeMethod(x,y);
    }

    public void Generate(MazeDraw mazeDraw, String difficulty) throws InterruptedException {
        maze.mazeGenerate(false, mazeDraw, difficulty);
    }

    public Maze getMaze() {
        return maze;
    }



}
