package app.window.panel;

import app.window.interfaces.IPanel;

import javax.swing.*;
import java.awt.*;

public class FilePathPanel implements IPanel {
    private final JPanel mainPanel;
    private JTextField fileTextField;
    private JButton processButton;

    public FilePathPanel(){
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
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
        return mainPanel;
    }
}