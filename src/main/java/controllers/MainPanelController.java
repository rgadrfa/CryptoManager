package controllers;

import controllers.mediator.NavigationManager;
import view.panel.MainPanel;

import java.awt.*;
import java.net.URI;

public class MainPanelController {
    private final MainPanel view;
    private final NavigationManager navigation;
    public MainPanelController(MainPanel view){
        this.view = view;
        this.navigation = NavigationManager.getInstance();
        initController();
    }

    private void initController() {
        view.getMenuHelpItemGIT().addActionListener(e -> openGitHubLink());
        view.getMenuMainItemExit().addActionListener(
                e -> view.getLabelStatus().setText("Динах")
        );
    }

    private void openGitHubLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/rgadrfa/CryptoManager"));
        } catch (Exception ex) {
            navigation.showErrorMessage("Не удалось открыть ссылку: " + ex.getMessage());
        }
    }
}
