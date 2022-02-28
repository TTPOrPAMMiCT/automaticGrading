import controllers.MainWindowController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainWindowController mainWindowController = new MainWindowController();
        mainWindowController.createWindow(new ActionEvent());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
