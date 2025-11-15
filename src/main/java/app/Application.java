package app;

import controllers.FilePathPanelController;
import controllers.MainPanelController;
import controllers.SessionSelectPanelController;
import controllers.mediator.NavigationManager;
import models.file.FileService;
import view.panel.FilePathPanel;
import view.panel.MainPanel;
import view.WindowAppFrame;
import view.panel.SessionSelectPanel;
import lombok.Getter;

@Getter
public class Application {
    private MainPanelController mainPanelController;
    private SessionSelectPanelController sessionSelectPanelController;
    private FilePathPanelController filePathPanelController;

    private static MainPanel mainPanel;
    private static SessionSelectPanel sessionSelectPanel;
    private static FilePathPanel filePathPanel;

    private static FileService fileService;

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

    private void initServices() {
        fileService = new FileService();
    }

    private void initControllers() {
        mainPanelController = new MainPanelController(mainPanel);
        sessionSelectPanelController = new SessionSelectPanelController(sessionSelectPanel);
        filePathPanelController = new FilePathPanelController(filePathPanel);
    }
}
