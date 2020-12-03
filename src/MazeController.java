import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazeController {

    public MazeController(MazeView view, MazeModel model, String difficulty) throws InterruptedException {

        model.Generate(view.getMazeDraw(), difficulty);
        Thread.sleep(1000);

        view.draw(model.getMaze());


        view.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void newPosition(String direction){

                int oldX = model.maze.getPlayerPosition().getX();
                int oldY = model.maze.getPlayerPosition().getY();
                int newX;
                int newY;

                boolean move;

                switch (direction) {
                    case "up" -> {
                        newX = oldX;
                        newY = oldY - 1;
                        move = !model.maze.getMazeBlock(oldX, oldY).isWallNorth();
                    }
                    case "down" -> {
                        newX = oldX;
                        newY = oldY + 1;
                        move = !model.maze.getMazeBlock(oldX, oldY).isWallSouth();
                    }
                    case "right" -> {
                        newX = oldX + 1;
                        newY = oldY;
                        move = !model.maze.getMazeBlock(oldX, oldY).isWallEast();
                    }
                    default -> {
                        newX = oldX - 1;
                        newY = oldY;
                        move = !model.maze.getMazeBlock(oldX, oldY).isWallWest();
                    }
                }

                if (move) {
                    model.maze.getMazeBlock(oldX, oldY).setPlayerPosition(false);
                    model.maze.getMazeBlock(newX, newY).setPlayerPosition(true);
                    view.draw(model.maze.getMazeBlock(oldX, oldY),model.maze.getMazeBlock(newX, newY));
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_UP)
                    if (endOdTheGame("up"))
                        view.endOfTheGame("win");
                    else
                        newPosition("up");


                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    if (endOdTheGame("down"))
                        view.endOfTheGame("win");
                    else
                        newPosition("down");

                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    if (endOdTheGame("right"))
                        view.endOfTheGame("win");

                    else
                        newPosition("right");

                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    if (endOdTheGame("left"))
                        view.endOfTheGame("win");
                    else
                        newPosition("left");

                if (model.maze.getPlayerPosition().isEffect()){

                    model.getMaze().getPlayerPosition().getEffect().execute(model.getMaze());
                    view.getMazeDraw().repaint();

                }
            }

            private boolean endOdTheGame(String direction) {
                if (model.maze.getPlayerPosition().getY() == 0 && direction.equals("up") && !model.maze.getPlayerPosition().isWallNorth())
                    return true;
                if (model.maze.getPlayerPosition().getY() == model.maze.getY()-1 && direction.equals("down") && !model.maze.getPlayerPosition().isWallSouth())
                    return true;
                if (model.maze.getPlayerPosition().getX() == model.maze.getX()-1 && direction.equals("right") && !model.maze.getPlayerPosition().isWallEast())
                    return true;

                return model.maze.getPlayerPosition().getX() == 0 && direction.equals("left") && !model.maze.getPlayerPosition().isWallWest();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }
}
