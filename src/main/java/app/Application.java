package app;

public class Application {
    public static void main(String[] args) {
        window.WindowAppFrame appWindow = window.WindowAppFrame.getInstance();
        appWindow.setWindowName("Crypto Service");
        appWindow.setWindowSize(840,540);
        appWindow.setPanel(new window.MainPanel().getPanel());
        appWindow.showWindow();
        appWindow.build();
    }
}
