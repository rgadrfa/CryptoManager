package app.controller;

import app.window.panel.MainPanel;

import javax.swing.*;

public class MainPanelController {
    private MainPanel view;
    public MainPanelController(MainPanel view){
        this.view = view;
        initController();
    }

    private void initController() {
        view.getMenuHelpItemIssues().addActionListener(
                (e) -> JOptionPane.showMessageDialog(view.getPanel(),"ЗАПОЛНИТЕЛЬ"));

    }
}
