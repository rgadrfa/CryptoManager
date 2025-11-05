package app;

import app.controller.FilePathPanelController;
import app.controller.MainPanelController;
import app.controller.SessionSelectPanelController;
import app.mediator.NavigationManager;
import app.window.panel.FilePathPanel;
import app.window.panel.MainPanel;
import app.window.WindowAppFrame;
import app.window.panel.SessionSelectPanel;

public class Application {
    private MainPanelController mainPanelController;
    private SessionSelectPanelController sessionSelectPanelController;
    private FilePathPanelController filePathPanelController;

    private MainPanel mainPanel;
    private SessionSelectPanel sessionSelectPanel;
    private FilePathPanel filePathPanel;

    public Application(){
        initPanels();
        initControllers();
        initWindow();

        NavigationManager navigation = NavigationManager.getInstance();

        navigation.setMainContainer(mainPanel);
        navigation.showPanel(sessionSelectPanel.getPanel());
    }

    private void initWindow() {
        WindowAppFrame appWindow = WindowAppFrame.getInstance();
        appWindow.setWindowName("Crypto Service");
        appWindow.setWindowSize(640,440);
        appWindow.setPanel(mainPanel.getPanel());
        appWindow.showWindow();
        appWindow.build();
    }

    private void initPanels() {
        mainPanel = new MainPanel();
        sessionSelectPanel = new SessionSelectPanel();
        filePathPanel = new FilePathPanel();
    }

    private void initControllers() {
        mainPanelController = new MainPanelController(mainPanel);
        sessionSelectPanelController = new SessionSelectPanelController(sessionSelectPanel);
        filePathPanelController = new FilePathPanelController(filePathPanel);
    }
}
