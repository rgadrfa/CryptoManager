package app.window;

import app.window.interfaces.IConstructFrame;

import javax.swing.*;
import java.awt.*;

// - Использование паттерна синглтон
public class WindowAppFrame implements IConstructFrame {
    public final JFrame MAIN_FRAME;
    private final JPanel MAIN_PANEL;
    private static WindowAppFrame INSTANCE;

    private WindowAppFrame() {
        MAIN_FRAME = new JFrame();
        MAIN_FRAME.setLayout(new BorderLayout());
        MAIN_PANEL = new JPanel(new BorderLayout());
    }

    public void build() {
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.setResizable(false);
    }

    public static WindowAppFrame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WindowAppFrame();
        }
        return INSTANCE;
    }

    public void showWindow() {
        MAIN_FRAME.setVisible(true);
    }

    public void setWindowSize(int width, int height) {
        MAIN_FRAME.setBounds(new Rectangle(width, height));
    }

    public void setWindowName(String windowName) {
        MAIN_FRAME.setTitle(windowName);
    }

    @Override
    public void setPanel(JPanel mainPanel) {
        MAIN_PANEL.add(mainPanel);
        MAIN_FRAME.add(MAIN_PANEL);
    }
}
