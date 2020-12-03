public class MazeMethod extends Maze{
    public MazeMethod(int x, int y) {
        super(x, y);
    }

    @Override
    protected void dfs(MazeBlock block) throws InterruptedException {
        mazeDraw.printActualBlock(block, 3);
        Thread.sleep(30);
        mazeDraw.printActualBlock(block, 1);
        super.dfs(block);
        mazeDraw.printActualBlock(block, 3);
        Thread.sleep(30);
        mazeDraw.printActualBlock(block, 2);
    }
}
