package TTPOrPAMMiCT.su;

import TTPOrPAMMiCT.su.gui.controllers.MainWindowController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindowController mainWindowController = new MainWindowController();
        mainWindowController.createWindow(new ActionEvent(),"mainWindow.fxml", "main_window");
    }

    public static void main(String[] args ) {
        launch(args);
    }

}
