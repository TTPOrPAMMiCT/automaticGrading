import controllers.MainWindow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainWindow mainWindow = new MainWindow();
        mainWindow.createWindow(new ActionEvent());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
