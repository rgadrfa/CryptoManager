package view.panel;

import view.interfaces.IParentPanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainPanel implements IParentPanel {
    private final JPanel mainPanel;
    private final JPanel centerPanel;

    private final JLabel labelStatus;
    private final JMenuBar menuBar;
    private JMenu menuMain,menuHelp;
    private JMenuItem menuMainItemExit,menuHelpItemGIT,menuHelpItemIssues;

    public MainPanel(){
        mainPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new BorderLayout());

        this.menuBar = createMenuBar();
        this.labelStatus = new JLabel("Строка состояния");;

        setup();
    }

    private void setup() {
        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(menuBar);
        return panel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuMain = new JMenu("Главная");
        menuMainItemExit = new JMenuItem("Выход");
        menuMain.add(menuMainItemExit);

        JMenu menuHelp = new JMenu("Помощь");
        menuHelpItemGIT = new JMenuItem("GitHub");
        menuHelpItemIssues = new JMenuItem("Сообщить об ошибке");
        menuHelp.add(menuHelpItemGIT);
        menuHelp.add(menuHelpItemIssues);

        menuBar.add(menuMain);
        menuBar.add(menuHelp);

        return menuBar;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(labelStatus);
        return panel;
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }

    @Override
    public void setPanel(JPanel newPanel) {
        centerPanel.removeAll();
        centerPanel.add(newPanel);
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}