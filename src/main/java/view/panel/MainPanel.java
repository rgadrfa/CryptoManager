package view.panel;

import view.interfaces.IParentPanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainPanel implements IParentPanel {
    private final JPanel mainPanel;
    private final JPanel centerPanel;

    private JLabel labelStatus;
    private JMenuBar menuBar;
    private JMenu menuMain,menuHelp;
    private JMenuItem
            menuMainItemExit,
            menuMainItemKeyStore,
            menuMainLoadSession,
            menuMainItemNewSession,
            menuHelpItemGIT,
            menuHelpItemIssues;

    private String LABEL_STATUS = "Строка состояния";

    private final String MENU_MAIN = "Главная";
    private final String MENU_HELP = "Помощь";

    private final String MENU_MAIN_ITEM_EXIT = "Выход";
    private final String MENU_MAIN_ITEM_NEW_SESSION = "Новая сессия";
    private final String MENU_MAIN_ITEM_LOAD_SESSION = "Загрузить сессию";
    private final String MENU_MAIN_ITEM_KEY_STORE = "Мастер ключей";

    private final String MENU_HELP_ITEM_GIT = "GIT";
    private final String MENU_HELP_ITEM_ISSUES = "Сообщить об ошибке";

    public MainPanel(){
        mainPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new BorderLayout());

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

        menuBar = createMenuBar();

        panel.add(menuBar);
        return panel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menuMain = new JMenu(MENU_MAIN);
        menuHelp = new JMenu(MENU_HELP);

        menuMainItemExit = new JMenuItem(MENU_MAIN_ITEM_EXIT);
        menuMainItemKeyStore = new JMenuItem(MENU_MAIN_ITEM_KEY_STORE);
        menuMainItemNewSession = new JMenuItem(MENU_MAIN_ITEM_NEW_SESSION);
        menuMainLoadSession = new JMenuItem(MENU_MAIN_ITEM_LOAD_SESSION);

        menuHelpItemGIT = new JMenuItem(MENU_HELP_ITEM_GIT);
        menuHelpItemIssues = new JMenuItem(MENU_HELP_ITEM_ISSUES);

        menuMain.add(menuMainItemKeyStore);
        menuMain.addSeparator();
        menuMain.add(menuMainItemNewSession);
        menuMain.add(menuMainLoadSession);
        menuMain.addSeparator();
        menuMain.add(menuMainItemExit);

        menuHelp.add(menuHelpItemGIT);
        menuHelp.add(menuHelpItemIssues);

        menuBar.add(menuMain);
        menuBar.add(menuHelp);

        return menuBar;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.LIGHT_GRAY);

        labelStatus = new JLabel(LABEL_STATUS);

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