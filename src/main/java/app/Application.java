package app;

import controllers.EncryptionServicePanelController;
import controllers.FilePathPanelController;
import controllers.MainPanelController;
import controllers.mediator.NavigationManager;
import models.file.FileService;
import view.panel.EncryptionServicePanel;
import view.panel.FilePathPanel;
import view.panel.InfoPanel;
import view.panel.MainPanel;
import view.WindowAppFrame;
import lombok.Getter;

import javax.swing.*;

@Getter
public class Application {
    private MainPanelController mainPanelController;
    private FilePathPanelController filePathPanelController;
    private EncryptionServicePanelController encryptionServicePanelController;

    @Getter
    private static MainPanel mainPanel;
    @Getter
    private static FilePathPanel filePathPanel;
    @Getter
    private static EncryptionServicePanel encryptionServicePanel;
    @Getter
    private static InfoPanel infoPanel;

    @Getter
    private static FileService fileService;

    public Application(){
        initServices();
        initPanels();
        initControllers();
        initWindow();

        NavigationManager navigation = NavigationManager.getInstance();

        navigation.setParentPanel(mainPanel);
        navigation.showPanel(infoPanel.getPanel());
    }

    private void initWindow() {
        WindowAppFrame appWindow = WindowAppFrame.getInstance();
        appWindow.setWindowName("Crypto Service");
        appWindow.setWindowSize(840,540);
        appWindow.setPanel(mainPanel.getPanel());
        appWindow.showWindow();
        appWindow.build();
    }

    private void initPanels() {
        mainPanel = new MainPanel();
        filePathPanel = new FilePathPanel();
        encryptionServicePanel = new EncryptionServicePanel();
        infoPanel = new InfoPanel();
    }

    private void initServices() {
        fileService = new FileService();
    }

    private void initControllers() {
        mainPanelController = new MainPanelController(mainPanel);
        filePathPanelController = new FilePathPanelController(filePathPanel);
        encryptionServicePanelController = new EncryptionServicePanelController(encryptionServicePanel);
    }
}
