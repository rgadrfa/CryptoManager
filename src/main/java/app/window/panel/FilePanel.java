package app.window.panel;

import app.window.interfaces.IFirstMenu;
import app.window.interfaces.ISecondMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FilePanel implements ISecondMenu {
    private final JPanel MAIN_PANEL;
    private final IFirstMenu FIRST_PANEL;

    public FilePanel(IFirstMenu firstPanel) {
        FIRST_PANEL = firstPanel;
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createNorthPanel(), BorderLayout.NORTH);
        MAIN_PANEL.add(createCenterPanel(), BorderLayout.CENTER);
    }

    public JPanel createNorthPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton buttonInformation = new JButton("Открыть существующую сессию");
        buttonInformation.setPreferredSize(new Dimension(250, 40));
        panel.add(buttonInformation);
        return panel;
    }

    public JPanel createCenterPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton buttonInformation1 = new JButton("Создать новую сессию");
        buttonInformation1.setPreferredSize(new Dimension(250, 40));

        buttonInformation1.addActionListener(this::action);
        panel.add(buttonInformation1);
        return panel;
    }

    public void action(ActionEvent e){
        FIRST_PANEL.setPanel(new SessionPanel(FIRST_PANEL).getPanel());
    }

    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }
}