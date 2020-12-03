import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyMenu extends Menu implements ActionListener {

    MazeView view;
    MazeController controller;
    MazeModel model;
    String size;
    Button nullOption;

    DifficultyMenu(String size){
        super();
        this.size = size;

        nullOption = new Button("beginner");


        nullOption.setBounds(50,50,100,50);
        menu.add(nullOption);

        nullOption.addActionListener(this);
        firstOption.addActionListener(this);
        secondOption.addActionListener(this);
        thirdOption.addActionListener(this);

        firstOption.setLabel("easy");
        secondOption.setLabel("normal");
        thirdOption.setLabel("hard");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        String difficulty;

        int coordinates;

        if (size.equals("small"))
            coordinates = 10;
        else if (size.equals("medium"))
            coordinates = 20;
        else
            coordinates = 30;


        if (source == nullOption)
            difficulty = "beginner";

        else if (source == firstOption)
            difficulty = "easy";

        else if (source == secondOption)
            difficulty = "normal";

        else
            difficulty = "hard";

        try {
            view = new MazeView(coordinates, coordinates);
            model = new MazeModel(coordinates, coordinates);
            controller = new MazeController(view, model, difficulty);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        dispose();

        }


}
