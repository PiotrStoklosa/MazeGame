import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MazeDraw extends Canvas {

    protected Maze maze;
    private BufferedImage img;
    public MazeDraw(Maze maze){
        this.maze=maze;
        setBounds(50,50,maze.getX()*30+30,maze.getY()*30+30);
        try {
            img = ImageIO.read(new File("pictures/Character.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public MazeDraw(int x, int y) throws InterruptedException {
        this.maze=new Maze(x,y);
        maze.mazeGenerate(true,null,null);
        setBounds(50,50,maze.getX()*30+30,maze.getY()*30+30);
        try {
            img = ImageIO.read(new File("pictures/Character.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualise(Maze maze) {
        this.maze=maze;
        repaint();
    }


    public void paint (Graphics g)
    {
        super.paint(g);
        for (int i=0; i<maze.getX(); i++){
            for (int j=0; j<maze.getY(); j++){
                if (maze.getMazeBlock(i,j).isWallNorth())
                    g.drawLine(30*i,30*j,30+30*i,30*j);
                if (maze.getMazeBlock(i,j).isWallSouth())
                    g.drawLine(30*i,30*j+30,30+30*i,30*j+30);
                if (maze.getMazeBlock(i,j).isWallWest())
                    g.drawLine(30*i,30*j,30*i,30+30*j);
                if (maze.getMazeBlock(i,j).isWallEast())
                    g.drawLine(30*i+30,30*j,30*i+30,30+30*j);

                if (maze.getMazeBlock(i,j).isEffect()) {
                    g.setColor(Color.red);
                    g.fillRect(30 * i + 9, 30 * j + 10, 11, 9);
                    g.setColor(Color.black);
                }
                else{
                    g.setColor(Color.white);
                    g.fillRect(30 * i + 9, 30 * j + 10, 11, 9);
                    g.setColor(Color.black);
                }
                if (maze.getMazeBlock(i,j).isPlayerPosition()) {
                    g.setColor(Color.BLACK);
                    g.drawImage(img, 30*i+5,30 * j + 5,null);
                }

            }
        }
    }

    public void printActualBlock(MazeBlock mazeBlock, int state){
        Graphics g = getGraphics();
        switch (state){
            case 0 -> g.setColor(Color.WHITE);
            case 1 -> g.setColor(Color.GREEN);
            case 2 -> g.setColor(new Color(128,0,128));
            case 3 -> g.setColor(Color.red);
        }
        g.fillRect(mazeBlock.getX()*30+5,mazeBlock.getY()*30+5,20,20);
    }

    public void replacePosition(MazeBlock oldOne, MazeBlock newOne){
        Graphics g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(oldOne.getX()*30+5,oldOne.getY()*30+5,20,20);
        g.drawImage(img, 30*newOne.getX()+10,30 * newOne.getY() + 10,null);
    }

    /*public void drawBoard(){

        Graphics g = getGraphics();

        for (float transparency=0.01f; transparency<1f; transparency+=0.01f){

            g = getGraphics();
            super.repaint();
            
            for (int i=0; i<maze.getX(); i++){
                for (int j=0; j<maze.getY(); j++){
                    if (maze.getMazeBlock(i,j).isWallNorth())
                        g.drawLine(30*i,30*j,30+30*i,30*j);
                    if (maze.getMazeBlock(i,j).isWallSouth())
                        g.drawLine(30*i,30*j+30,30+30*i,30*j+30);
                    if (maze.getMazeBlock(i,j).isWallWest())
                        g.drawLine(30*i,30*j,30*i,30+30*j);
                    if (maze.getMazeBlock(i,j).isWallEast())
                        g.drawLine(30*i+30,30*j,30*i+30,30+30*j);
                }
            }

        }
    }*/

}
