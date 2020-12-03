public class MazeBlock {

    private boolean wallNorth, wallEast, wallSouth, wallWest;
    private boolean visited;
    private final int x;
    private final int y;
    private boolean playerPosition;
    private Effect effect;
    private boolean isEffect;

    public MazeBlock(int x, int y) {
        this.x=x;
        this.y=y;
        wallNorth = true;
        wallEast = true;
        wallSouth = true;
        wallWest = true;
        visited = false;
        playerPosition=false;
        isEffect = false;
    }

    public void disattachWallNorth() {
        wallNorth = false;
    }

    public void disattachWallEast() {
        wallEast = false;
    }

    public void disattachWallSouth() {
        wallSouth = false;
    }

    public void disattachWallWest() {
        wallWest = false;
    }

    public void Visited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWallNorth() {
        return wallNorth;
    }

    public boolean isWallEast() {
        return wallEast;
    }

    public boolean isWallSouth() {
        return wallSouth;
    }

    public boolean isWallWest() {
        return wallWest;
    }


    public void setPlayerPosition(boolean playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean isPlayerPosition() {
        return playerPosition;
    }

    @Override
    public String toString() {
        int sum=0;
        if (!wallNorth)
            sum++;
        if (!wallEast)
            sum+=2;
        if (!wallSouth)
            sum+=4;
        if (!wallWest)
            sum+=8;
        if (sum>9)
            return sum + " ";
        return sum + "  ";

    }

    public void buildWallNorth() {
        this.wallNorth = true;
    }

    public void buildWallEast() {
        this.wallEast = true;
    }

    public void buildWallSouth() {
        this.wallSouth = true;
    }

    public void buildWallWest() {
        this.wallWest = true;
    }

    public boolean isEffect() {
        return isEffect;
    }

    public void setEffect(Effect effect) {
        isEffect = true;
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public void removeEffect() {
        isEffect = false;
    }
}
