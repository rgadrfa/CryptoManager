package app.controller;

import app.window.panel.FilePathPanel;
import app.window.panel.SessionSelectPanel;

public class SessionSelectPanelController {
    private SessionSelectPanel view;
    public SessionSelectPanelController(SessionSelectPanel view){
        this.view = view;
        initController();
    }

    private void initController() {
        // Обработчик для кнопки "Создать новую сессию"
        view.getButtonNewSession().addActionListener(
                (e) -> view.getFIRST_PANEL().setPanel(
                        new FilePathPanel(view.getFIRST_PANEL()).getPanel()
                )
        );

        // Обработчик для кнопки "Открыть существующую сессию"
        view.getButtonOldSession().addActionListener(
                (e) -> {
                    System.out.println("Открыть существующую сессию");
                }
        );
    }

}
