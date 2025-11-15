package view.panel;

import view.interfaces.IPanel;

import javax.swing.*;
import java.awt.*;

public class InfoPanel implements IPanel {
    private final JPanel mainPanel;
    private JLabel labelInf;
    private final String LABEL_INF = "Выберете задачу";

    public InfoPanel() {
        mainPanel = new JPanel(new BorderLayout());

        setup();
    }

    private void setup() {
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        labelInf = new JLabel(LABEL_INF);
        labelInf.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInf.setForeground(Color.GRAY);
        panel.add(labelInf);
        return panel;
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }
}
