package controllers;

import app.Application;
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
        view.getMenuMainItemNewSession().addActionListener(e -> showFilePathPanel());
        view.getMenuHelpItemGIT().addActionListener(e -> openGitHubLink());
        view.getMenuHelpItemIssues().addActionListener(e -> openIssuesLink());
        view.getMenuMainItemExit().addActionListener(
                e -> System.exit(0)
        );
    }

    private void openGitHubLink() {
        openLink("https://github.com/rgadrfa/CryptoManager");
    }

    private void openIssuesLink() {
        openLink("https://github.com/rgadrfa/CryptoManager/issues");
    }

    public void openLink(String url){
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            navigation.showErrorMessage("Не удалось открыть ссылку: " + ex.getMessage());
        }
    }

    public void showFilePathPanel(){
        navigation.showPanel(
                Application.getFilePathPanel().getPanel()
        );
    }
}
