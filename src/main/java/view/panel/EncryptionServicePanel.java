package view.panel;

import view.interfaces.IPanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class EncryptionServicePanel implements IPanel {
    private final JPanel mainPanel;

    private JComboBox<String> cryptoTypeComboBox;
    private JComboBox<String> algorithmComboBox;
    private JButton backButton;
    private JButton nextButton;

    public EncryptionServicePanel() {
        this.mainPanel = createMainPanel();
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }
}