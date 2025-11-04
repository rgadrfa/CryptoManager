package app;

import app.controller.MainPanelController;
import app.controller.SessionSelectPanelController;
import app.window.panel.MainPanel;
import app.window.WindowAppFrame;
import app.window.panel.SessionSelectPanel;

public class Application {
    private MainPanelController mainPanelController;
    private SessionSelectPanelController sessionSelectPanelController;
    public MainPanel mainPanel;
    public SessionSelectPanel sessionSelectPanel;

    public Application(){
        initPanels();
        initControllers();
        initWindow();
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
        sessionSelectPanel = mainPanel.getSessionSelectPanel();
    }

    private void initControllers() {
        mainPanelController = new MainPanelController(mainPanel);
        sessionSelectPanelController = new SessionSelectPanelController(sessionSelectPanel);
    }
}
