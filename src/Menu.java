import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Menu extends JFrame {

    Container menu;

    Button firstOption;
    Button secondOption;
    Button thirdOption;

    Menu(){

        setResizable(false);
        setSize(400,400);
        setLocationRelativeTo(null);

        setLayout(null);

        menu = new Container();
        menu.setBounds(100,0,200,300);

        firstOption = new Button();
        secondOption = new Button();
        thirdOption = new Button();

        menu.add(firstOption);
        menu.add(secondOption);
        menu.add(thirdOption);

        firstOption.setBounds(50,110,100,50);
        secondOption.setBounds(50,170,100,50);
        thirdOption.setBounds(50,230,100,50);

        add(menu);

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

    }


}
