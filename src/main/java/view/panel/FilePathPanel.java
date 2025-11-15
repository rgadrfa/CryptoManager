package view.panel;

import view.interfaces.IPanel;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

@Getter
public class FilePathPanel implements IPanel {
    private final JPanel mainPanel;

    private JTextField textFieldFile;
    private JButton buttonBrowse, buttonProcess, buttonBack;
    private JLabel labelChoose, labelPath;
    private JFileChooser fileChooser;

    private final String FILE_CHOOSER_TITLE = "Выберите файл";

    private final String LABEL_CHOOSE = "Выбор файла для обработки";
    private final String LABEL_PATH = "Путь к файлу:";

    private final String BUTTON_BROWSE = "Обзор...";
    private final String BUTTON_BACK = "Назад";
    private final String BUTTON_PROCESS = "Обработать файл";

    public FilePathPanel() {
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        setup();
    }

    private void setup() {
        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        labelChoose = new JLabel(LABEL_CHOOSE);

        panel.add(labelChoose);
        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JPanel inputPanel = new JPanel(new BorderLayout(5, 0));

        labelPath = new JLabel(LABEL_PATH);
        textFieldFile = new JTextField();
        buttonBrowse = new JButton(BUTTON_BROWSE);

        inputPanel.add(labelPath, BorderLayout.WEST);

        textFieldFile.setPreferredSize(new Dimension(100, 25));
        inputPanel.add(textFieldFile, BorderLayout.CENTER);

        inputPanel.add(buttonBrowse, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.NORTH);
        return panel;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));

        buttonBack = new JButton(BUTTON_BACK);

        buttonProcess = new JButton(BUTTON_PROCESS);
        buttonProcess.setEnabled(false);

        buttonPanel.add(buttonProcess);
        buttonPanel.add(buttonBack);

        panel.add(buttonPanel, BorderLayout.EAST);
        return panel;
    }

    public void openFileDialog() {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(FILE_CHOOSER_TITLE);

        if (fileChooser.showOpenDialog(getPanel()) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            setFilePath(selectedFile.getAbsolutePath());
        }
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }

    public String getFilePath() {
        return textFieldFile != null ? textFieldFile.getText() : "";
    }

    public void setFilePath(String filePath) {
        textFieldFile.setText(filePath);
    }
}