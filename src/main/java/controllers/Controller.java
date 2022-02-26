package controllers;


import javafx.event.ActionEvent;
import java.io.IOException;

public abstract class Controller {
    private static MainWindowController mainWindowController;

    public abstract void createWindow(ActionEvent actionEvent) throws IOException;

    public static MainWindowController getMainWindowController() {
        return mainWindowController;
    }

    public static void setMainWindowController(MainWindowController mainWindowController) {
        Controller.mainWindowController = mainWindowController;
    }

}
