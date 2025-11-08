package view.panel;

import view.interfaces.IPanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class FilePathPanel implements IPanel {
    private final JPanel mainPanel;

    private JTextField fileTextField;
    private JButton browseButton;
    private JButton processButton;
    private JButton backButton;

    public FilePathPanel() {
        this.mainPanel = createMainPanel();
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(createNorthPanel(), BorderLayout.NORTH);
        panel.add(createCenterPanel(), BorderLayout.CENTER);
        panel.add(createSouthPanel(), BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel titleLabel = new JLabel("Выбор файла для обработки");
        panel.add(titleLabel);

        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel inputPanel = new JPanel(new BorderLayout(5, 0));

        JLabel fileLabel = new JLabel("Путь к файлу:");
        inputPanel.add(fileLabel, BorderLayout.WEST);

        fileTextField = new JTextField();
        fileTextField.setPreferredSize(new Dimension(300, 25));
        inputPanel.add(fileTextField, BorderLayout.CENTER);

        browseButton = new JButton("Обзор...");
        inputPanel.add(browseButton, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        backButton = new JButton("Назад");
        buttonPanel.add(backButton);

        processButton = new JButton("Обработать файл");
        processButton.setEnabled(false);
        buttonPanel.add(processButton);

        panel.add(buttonPanel, BorderLayout.EAST);

        return panel;
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }

    public String getFilePath() {
        return fileTextField != null ? fileTextField.getText() : "";
    }

    public void setFilePath(String filePath) {
        if (fileTextField != null) {
            fileTextField.setText(filePath);
        }
    }
}