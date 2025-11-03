package app.window.panel;

import app.window.interfaces.IFirstMenu;
import app.window.interfaces.ISecondMenu;

import javax.swing.*;
import java.awt.*;

public class SessionPanel implements ISecondMenu {
    private final JPanel MAIN_PANEL;
    private final IFirstMenu FIRST_MENU;

    public SessionPanel(IFirstMenu firstMenu){
        FIRST_MENU = firstMenu;
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createNorthPanel(), BorderLayout.NORTH);
    }

    public JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        panel.add(new JButton("Сосал?"));
        return panel;
    }

    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }
}