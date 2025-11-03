package app;

import app.window.panel.MainPanel;
import app.window.WindowAppFrame;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        WindowAppFrame appWindow = WindowAppFrame.getInstance();
        appWindow.setWindowName("Crypto Service");
        appWindow.setWindowSize(840,540);
        appWindow.setPanel(new MainPanel().getPanel());
        appWindow.showWindow();
        appWindow.build();
    }
}
