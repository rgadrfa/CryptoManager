package controllers;

import controllers.mediator.NavigationManager;
import view.panel.EncryptionServicePanel;
import view.panel.FilePathPanel;

import javax.swing.*;
import java.io.File;

public class FilePathPanelController {
    private final FilePathPanel view;
    private final NavigationManager navigation;

    public FilePathPanelController(FilePathPanel view) {
        this.view = view;
        this.navigation = NavigationManager.getInstance();
        initController();
    }

    private void initController() {
        view.getBrowseButton().addActionListener(e -> openFileDialog());
        view.getProcessButton().addActionListener(e -> processFile());
        view.getBackButton().addActionListener(e ->
                navigation.showPanel(new EncryptionServicePanel().getPanel()));
    }

    private void openFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите файл");

        int result = fileChooser.showOpenDialog(view.getPanel());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            view.setFilePath(selectedFile.getAbsolutePath());
            view.getProcessButton().setEnabled(true);
        }
    }

    private void processFile() {
        String filePath = view.getFilePath();

        if (filePath == null || filePath.trim().isEmpty()) {
            navigation.showErrorMessage("Пожалуйста, выберите файл");
            return;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            navigation.showErrorMessage("Файл не существует: " + filePath);
            return;
        }

        if (!file.canRead()) {
            navigation.showErrorMessage("Невозможно прочитать файл: " + filePath);
            return;
        }

        try {
            // TODO: Реализовать обработку файла
            navigation.showInfoMessage("Файл успешно обработан: " + file.getName());
        } catch (Exception e) {
            navigation.showErrorMessage("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}
