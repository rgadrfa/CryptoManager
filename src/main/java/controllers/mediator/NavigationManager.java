package controllers.mediator;

import view.interfaces.IParentPanel;

import javax.swing.*;

public class NavigationManager {
    private static NavigationManager instance;
    private IParentPanel mainContainer;

    private NavigationManager() {}

    public static NavigationManager getInstance() {
        if (instance == null) {
            instance = new NavigationManager();
        }
        return instance;
    }

    public void setParentPanel(IParentPanel mainPanel){
        mainContainer = mainPanel;
    }

    public void showPanel(JPanel panel){
        mainContainer.setPanel(panel);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(mainContainer.getPanel(), message, "Информация", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(mainContainer.getPanel(), message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
