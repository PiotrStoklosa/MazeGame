import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FinalMessage extends Frame{
    Label announcement;
    Button exit;
    public FinalMessage(String info){
        setResizable(false);
        setSize(200,200);
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

        exit = new Button("Exit");
        exit.setBounds(75,150,50,25);
        add(exit);

        exit.addActionListener(e -> dispose());

        announcement = new Label();
        announcement.setBounds(75,50,50,25);
        add(announcement);
        if (info.equals("win"))
            win();
        else
            lose();
    }

    private void lose() {
        announcement.setText("You lost :(");
    }

    private void win() {
        announcement.setText("You won! :D");

    }

}
