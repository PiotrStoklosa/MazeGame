public class Effect {

    String name;

    Effect(String name){
        this.name = name;
    }


    public static void generateAllEffects(Maze maze, String difficulty) {
        NewExit.RandNewExit(maze, difficulty);
    }

    public void execute(Maze maze){
        maze.getPlayerPosition().removeEffect();
    }

}
