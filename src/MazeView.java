import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MazeView extends Frame {

    MazeDraw mazeDraw;
    MazeView(int x, int y) throws InterruptedException {

        setResizable(false);
        setSize(x*30+100,y*30+100);
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);

        addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e) { }
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
            @Override
            public void windowClosed(WindowEvent e) { }
            @Override
            public void windowIconified(WindowEvent e) { }
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) { }
        });
        mazeDraw = new MazeDraw(x,y);
        add(mazeDraw);
    }

    public void draw(Maze maze) {
        /*mazeDraw = new MazeDraw(10,10);
        add(mazeDraw);*/
        mazeDraw.actualise(maze);
    }

    public MazeDraw getMazeDraw() {
        return mazeDraw;
    }

    public void draw (MazeBlock oldOne, MazeBlock newOne){
        mazeDraw.replacePosition(oldOne,newOne);
    }

    public void endOfTheGame(String result){
        dispose();
        FinalMessage end = new FinalMessage(result);

    }
}
