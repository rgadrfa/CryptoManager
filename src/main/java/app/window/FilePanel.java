package window;

import main.Main;
import window.interfaces.ISecondMenu;

import javax.swing.*;
import java.awt.*;

public class FilePanel implements ISecondMenu {
    private final JPanel MAIN_PANEL;

    public FilePanel() {
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createCenterPanel(),BorderLayout.CENTER);
    }


    public static JPanel createCenterPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Выберите опцию", "Опция 1", "Опция 2", "Опция 3"});
        comboBox.setPreferredSize(new Dimension(200, 25));
        panel.add(comboBox);
        return panel;
    }


    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }
}
