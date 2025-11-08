package view.panel;

import view.interfaces.IPanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class SessionSelectPanel implements IPanel {

    private final JPanel mainPanel;

    private JButton newSessionButton, loadSessionButton;

    public SessionSelectPanel() {
        mainPanel = new JPanel(new BorderLayout());
        setup();
    }

    private void setup(){
        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
    }

    public JPanel createNorthPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Выбор сессии");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 270, 20, 0));
        panel.add(titleLabel, BorderLayout.CENTER);
        return panel;
    }

    public JPanel createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 100, 150, 100)); // отступы

        newSessionButton = new JButton("Новая сессия");
        loadSessionButton = new JButton("Загрузить сессию");

        Dimension buttonSize = new Dimension(0, 20); // ширина 0 - растягивается, высота 60
        newSessionButton.setPreferredSize(buttonSize);
        loadSessionButton.setPreferredSize(buttonSize);

        panel.add(newSessionButton);
        panel.add(loadSessionButton);

        return panel;
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }
}