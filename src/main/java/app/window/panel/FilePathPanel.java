package app.window.panel;

import app.window.interfaces.IFirstMenu;
import app.window.interfaces.ISecondMenu;

import javax.swing.*;
import java.awt.*;

public class FilePathPanel implements ISecondMenu {
    private final JPanel MAIN_PANEL;
    private final IFirstMenu FIRST_MENU;
    private JTextField fileTextField;
    private JButton processButton;

    public FilePathPanel(IFirstMenu firstMenu){
        FIRST_MENU = firstMenu;
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createNorthPanel(), BorderLayout.NORTH);
        MAIN_PANEL.add(createSouthPanel(), BorderLayout.SOUTH);
    }

    public JPanel createNorthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        return panel;
    }

    public JPanel createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        return panel;
    }

    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }
}