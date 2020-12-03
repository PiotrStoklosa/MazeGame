import java.awt.*;

import static java.lang.Thread.sleep;

public class MazeDrawMethod extends MazeDraw{

    public MazeDrawMethod(Maze maze) {
        super(maze);
    }


    @Override
    public void paint(Graphics g) {

        for (int i=0; i<maze.getX(); i++){
            for (int j=0; j<maze.getY(); j++){
                    g.drawLine(30*i,30*j,30+30*i,30*j);
                    g.drawLine(30*i,30*j+30,30+30*i,30*j+30);
                    g.drawLine(30*i,30*j,30*i,30+30*j);
                    g.drawLine(30*i+30,30*j,30*i+30,30+30*j);
            }

        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.paint(g);
    }
}
