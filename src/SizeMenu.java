import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeMenu extends Menu implements ActionListener {


    SizeMenu(){
        super();
        firstOption.addActionListener(this);
        secondOption.addActionListener(this);
        thirdOption.addActionListener(this);

        firstOption.setLabel("small");
        secondOption.setLabel("medium");
        thirdOption.setLabel("large");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        DifficultyMenu menu;

        if (source == firstOption)
            menu = new DifficultyMenu("small");

        else if (source == secondOption)
            menu = new DifficultyMenu("medium");

        else
            menu = new DifficultyMenu("large");

        menu.setVisible(true);
        dispose();
    }


}
