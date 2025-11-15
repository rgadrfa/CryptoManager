package controllers;

import app.Application;
import controllers.mediator.NavigationManager;
import view.panel.FilePathPanel;

public class FilePathPanelController {
    private final FilePathPanel view;
    private final NavigationManager navigation;

    public FilePathPanelController(FilePathPanel view) {
        this.view = view;
        this.navigation = NavigationManager.getInstance();
        initController();
    }

    private void initController() {
        view.getButtonBrowse().addActionListener(e -> openFileDialog());
        view.getButtonProcess().addActionListener(e -> showEncryptionPanel());
        view.getButtonBack().addActionListener(e -> showInfPanel());
    }

    private void openFileDialog() {
        view.openFileDialog();

        boolean hasValidFile = !view.getFilePath().trim().isEmpty();

        view.getButtonProcess().setEnabled(hasValidFile);
    }

    private void processFile() {
        String filePath = view.getFilePath();

        try {
            Application.getFileService().setFirstPath(filePath);
        } catch (Exception e) {
            navigation.showErrorMessage("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    private void showEncryptionPanel() {
        processFile();
        navigation.showPanel(
                Application.getEncryptionServicePanel().getPanel()
        );
    }

    private void showInfPanel() {
        navigation.showPanel(
                Application.getInfoPanel().getPanel()
        );
    }
}
