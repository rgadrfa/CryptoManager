package app.window.panel;

import window.interfaces.IFirstMenu;
import window.interfaces.ISecondMenu;

import javax.swing.*;
import java.awt.*;

public class MainPanel implements ISecondMenu, IFirstMenu {
    private final JPanel MAIN_PANEL;
    public MainPanel(){
        MAIN_PANEL = new JPanel(new BorderLayout());
        MAIN_PANEL.add(createNorthPanel(),BorderLayout.NORTH);
        MAIN_PANEL.add(createCenterPanel(),BorderLayout.CENTER);
        MAIN_PANEL.add(createSouthPanel(),BorderLayout.SOUTH);
    }

    public static JPanel createNorthPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JMenuBar menuBar = new JMenuBar();
        panel.setBackground(Color.LIGHT_GRAY);

        JMenu menuMain = new JMenu("Главная");
        JMenuItem menuMainItemExit = new JMenuItem("Выход");

        JMenu menuHelp = new JMenu("Помощь");
        JMenuItem menuHelpItemGIT = new JMenuItem("GitHub");
        JMenuItem menuHelpItemIssues = new JMenuItem("Сообщить об ошибке");

        menuMain.add(menuMainItemExit);

        menuHelp.add(menuHelpItemGIT);
        menuHelp.add(menuHelpItemIssues);

        menuBar.add(menuMain);
        menuBar.add(menuHelp);

        panel.add(menuBar);
        return panel;
    }


    public static JPanel createCenterPanel(){
        return new FilePanel().getPanel();
    }


    public static JPanel createSouthPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel labelStatus = new JLabel("Строка состояния");
        panel.add(labelStatus);

        return panel;
    }

    @Override
    public JPanel getPanel() {
        return MAIN_PANEL;
    }


    @Override
    public void setPanel(JPanel elements) {

    }
}
