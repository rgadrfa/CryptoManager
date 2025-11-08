package app;

import controllers.FilePathPanelController;
import controllers.MainPanelController;
import controllers.SessionSelectPanelController;
import controllers.mediator.NavigationManager;
import view.panel.FilePathPanel;
import view.panel.MainPanel;
import view.WindowAppFrame;
import view.panel.SessionSelectPanel;
import lombok.Getter;

public class Application {
    private MainPanelController mainPanelController;
    private SessionSelectPanelController sessionSelectPanelController;
    private FilePathPanelController filePathPanelController;

    @Getter
    private static MainPanel mainPanel;
    @Getter
    private static SessionSelectPanel sessionSelectPanel;
    @Getter
    private static FilePathPanel filePathPanel;

    public Application(){
        initPanels();
        initControllers();
        initWindow();

        NavigationManager navigation = NavigationManager.getInstance();

        navigation.setParentPanel(mainPanel);
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
