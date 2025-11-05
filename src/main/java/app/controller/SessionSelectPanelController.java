package app.controller;

import app.mediator.NavigationManager;
import app.window.panel.FilePathPanel;
import app.window.panel.SessionSelectPanel;

public class SessionSelectPanelController {
    private final SessionSelectPanel view;
    private final NavigationManager navigation;
    public SessionSelectPanelController(SessionSelectPanel view){
        this.view = view;
        this.navigation = NavigationManager.getInstance();
        initController();
    }

    private void initController() {
        view.getNewSessionButton().addActionListener(e ->
                navigation.showPanel(new FilePathPanel().getPanel())
        );
    }

}
