import java.util.Random;

public class NewExit extends Effect{


    NewExit(){
        super("NewExit");
    }

    @Override
    public void execute(Maze maze) {
        super.execute(maze);
        newExit(maze);
    }

    static void RandNewExit(Maze maze, String difficulty){

        int x = maze.getX();
        int y = maze.getY();

        int traps;
        Random generator =new Random();

        traps = switch (difficulty) {
            case "beginner" -> 0;
            case "easy" -> 3;
            case "normal" -> 5;
            default -> 10;
        };

        for (int i=0; i<traps; i++) {
            int trapX = (int) (generator.nextDouble() * x);
            int trapY = (int) (generator.nextDouble() * y);

            maze.getMazeBlock(trapX, trapY).setEffect(new NewExit());
        }
    }

    public static void newExit(Maze maze) {
        for (int i=0;i<maze.getX(); i++) {
            if (!maze.getMazeBlock(i, 0).isWallNorth())
                maze.getMazeBlock(i, 0).buildWallNorth();
            if (!maze.getMazeBlock(i, maze.getY()-1).isWallSouth())
                maze.getMazeBlock(i, maze.getY()-1).buildWallSouth();
        }

        for (int i=0;i<maze.getY(); i++) {
            if (!maze.getMazeBlock(0, i).isWallWest())
                maze.getMazeBlock(0, i).buildWallWest();
            if (!maze.getMazeBlock(maze.getX()-1, i).isWallEast())
                maze.getMazeBlock(maze.getX()-1, i).buildWallEast();
        }
        maze.entryGenerator();
    }

}
