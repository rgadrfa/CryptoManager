package app.window.panel;

import app.window.interfaces.IFirstMenu;
import app.window.interfaces.ISecondMenu;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class MainPanel implements ISecondMenu, IFirstMenu {
    private final JPanel MAIN_PANEL;
    private JPanel centerPanel;
    @Getter
    private JLabel labelStatus;
    @Getter
    private JMenuBar menuBar;
    @Getter
    private JMenu menuMain,menuHelp;
    @Getter
    private JMenuItem menuMainItemExit,menuHelpItemGIT,menuHelpItemIssues;
    @Getter
    private SessionSelectPanel sessionSelectPanel;

    public MainPanel(){
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createNorthPanel(), BorderLayout.NORTH);

        sessionSelectPanel = new SessionSelectPanel(this);
        centerPanel = sessionSelectPanel.getPanel();
        MAIN_PANEL.add(centerPanel, BorderLayout.CENTER);

        MAIN_PANEL.add(createSouthPanel(), BorderLayout.SOUTH);
    }

    public JPanel createNorthPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuBar = new JMenuBar();
        panel.setBackground(Color.LIGHT_GRAY);

        menuMain = new JMenu("Главная");
        menuMainItemExit = new JMenuItem("Выход");

        menuHelp = new JMenu("Помощь");
        menuHelpItemGIT = new JMenuItem("GitHub");
        menuHelpItemIssues = new JMenuItem("Сообщить об ошибке");

        menuMain.add(menuMainItemExit);
        menuHelp.add(menuHelpItemGIT);
        menuHelp.add(menuHelpItemIssues);

        menuBar.add(menuMain);
        menuBar.add(menuHelp);

        panel.add(menuBar);
        return panel;
    }

    public JPanel createCenterPanel(){
        return sessionSelectPanel.getPanel();
    }

    public JPanel createSouthPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        labelStatus = new JLabel("Строка состояния");
        panel.add(labelStatus);
        return panel;
    }

    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }

    @Override
    public void setPanel(JPanel newPanel) {
        MAIN_PANEL.remove(centerPanel); // удаляем старую центральную панель
        centerPanel = newPanel; // сохраняем новую панель
        MAIN_PANEL.add(centerPanel, BorderLayout.CENTER); // добавляем новую панель
        MAIN_PANEL.revalidate(); // перераспределяем компоненты
        MAIN_PANEL.repaint(); // перерисовываем
    }
}