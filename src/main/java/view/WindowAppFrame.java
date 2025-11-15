package view;

import view.interfaces.IConstructFrame;

import javax.swing.*;
import java.awt.*;

public class WindowAppFrame implements IConstructFrame {
    public final JFrame mainFrame;
    private final JPanel mainPanel;
    private static WindowAppFrame instance;

    private WindowAppFrame() {
        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
    }

    public void build() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    public static WindowAppFrame getInstance() {
        if (instance == null) {
            instance = new WindowAppFrame();
        }
        return instance;
    }

    public void showWindow() {
        mainFrame.setVisible(true);
    }

    public void setWindowSize(int width, int height) {
        mainFrame.setBounds(new Rectangle(width, height));
    }

    public void setWindowName(String windowName) {
        mainFrame.setTitle(windowName);
    }

    @Override
    public void setPanel(JPanel mainPanel) {
        this.mainPanel.add(mainPanel);
        mainFrame.add(this.mainPanel);
    }

    @Override
    public JPanel getPanel() {
        return null;
    }
}
