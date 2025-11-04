package app.window.panel;

import app.window.interfaces.IFirstMenu;
import app.window.interfaces.ISecondMenu;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SessionSelectPanel implements ISecondMenu {
    private final JPanel MAIN_PANEL;
    @Getter
    private final IFirstMenu FIRST_PANEL;
    @Getter
    private JButton buttonNewSession, buttonOldSession;

    public SessionSelectPanel(IFirstMenu firstPanel) {
        FIRST_PANEL = firstPanel;
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createNorthPanel(), BorderLayout.NORTH);
        MAIN_PANEL.add(createCenterPanel(), BorderLayout.CENTER);
    }

    public JPanel createNorthPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonNewSession = new JButton("Создать новую сессию");
        buttonNewSession.setPreferredSize(new Dimension(250, 40));
        panel.add(buttonNewSession);
        return panel;
    }

    public JPanel createCenterPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonOldSession = new JButton("Открыть существующую сессию");
        buttonOldSession.setPreferredSize(new Dimension(250, 40));
        panel.add(buttonOldSession);
        return panel;
    }

    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }
}