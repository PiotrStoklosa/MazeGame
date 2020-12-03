import java.util.ArrayList;
import java.util.Random;

public class Maze {

    private final int x;
    private final int y;
    private ArrayList< ArrayList < MazeBlock > > maze;
    protected MazeDraw mazeDraw;


    private boolean existBlock(Coordinates coordinates){
        return coordinates.getX() >= 0 && coordinates.getX() < x && coordinates.getY() >= 0 && coordinates.getY() < y;
    }

    public Maze(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void dfs(MazeBlock block) throws InterruptedException {

        block.Visited();
        Random generator =new Random();

        while (existAvaiableBlock(block)){

            int choice = (int)(generator.nextDouble()*4);
            switch (choice) {
                case 0:

                    if (avaiableBlock(block.getX(),block.getY()-1)) {
                        block.disattachWallNorth();
                        getMazeBlock(block.getX(), block.getY() - 1).disattachWallSouth();
                        dfs(getMazeBlock(block.getX(), block.getY() - 1));
                    }
                    break;
                case 1:
                    if (avaiableBlock(block.getX(),block.getY()+1)) {
                        block.disattachWallSouth();
                        getMazeBlock(block.getX(), block.getY() + 1).disattachWallNorth();
                        dfs(getMazeBlock(block.getX(), block.getY() + 1));
                    }
                    break;
                case 2:
                    if (avaiableBlock(block.getX()+1,block.getY())) {
                        block.disattachWallEast();
                        getMazeBlock(block.getX() + 1, block.getY()).disattachWallWest();
                        dfs(getMazeBlock(block.getX() + 1, block.getY()));
                    }
                    break;
                case 3:
                    if (avaiableBlock(block.getX()-1,block.getY())) {
                        block.disattachWallWest();
                        getMazeBlock(block.getX() - 1, block.getY()).disattachWallEast();
                        dfs(getMazeBlock(block.getX() - 1, block.getY()));
                    }
                    break;
            }
        }


    }

    boolean existAvaiableBlock(MazeBlock block) {
        if (avaiableBlock(block.getX(),block.getY()-1))
            return true;

        if (avaiableBlock(block.getX(),block.getY()+1))
            return true;

        if (avaiableBlock(block.getX()+1,block.getY()))
            return true;

        return avaiableBlock(block.getX() - 1, block.getY());
    }

    boolean avaiableBlock(int x, int y) {

        if (existBlock(new Coordinates(x,y)))
            return !getMazeBlock(x, y).isVisited();

        return false;
    }

    public void entryGenerator(){
        Random generator =new Random();

        int entry = (int)(generator.nextDouble()*4);
        int entryIndex1 = (int)(generator.nextDouble()*x);
        int entryIndex2 = (int)(generator.nextDouble()*y);

        switch (entry) {
            case 0 -> getMazeBlock(entryIndex1, 0).disattachWallNorth();
            case 1 -> getMazeBlock(x - 1, entryIndex2).disattachWallEast();
            case 2 -> getMazeBlock(entryIndex1, y - 1).disattachWallSouth();
            case 3 -> getMazeBlock(0, entryIndex2).disattachWallWest();
        }
    }

    public void mazeGenerate(boolean empty, MazeDraw mazeDraw, String difficulty) throws InterruptedException {

        this.mazeDraw=mazeDraw;
        maze = new ArrayList<>();
        for (int i = 0; i < x; i++) {

            maze.add(new ArrayList<>());
            for (int j = 0; j < y; j++)
                maze.get(i).add(new MazeBlock(i, j));
        }
        if (!empty) {

            dfs(getMazeBlock(0, 0));

            entryGenerator();

            Random generator = new Random();

            int startingPositionX = (int) (generator.nextDouble() * x);
            int startingPositionY = (int) (generator.nextDouble() * y);

            getMazeBlock(startingPositionX, startingPositionY).setPlayerPosition(true);

            Effect.generateAllEffects(this, difficulty);
        }
    }

    public MazeBlock getMazeBlock(int x, int y) {
        return maze.get(x).get(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MazeBlock getPlayerPosition() {
        for (int i=0; i<x;i++)
            for (int j=0; j<y; j++)
                if (getMazeBlock(i,j).isPlayerPosition())
                    return getMazeBlock(i,j);
        return null;
    }
    
}
