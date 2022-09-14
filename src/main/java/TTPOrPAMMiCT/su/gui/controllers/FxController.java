package TTPOrPAMMiCT.su.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.IOException;

@Getter
@Setter
abstract class FxController {
    private static MainWindowController mainWindowController;
    private Stage stage = new Stage();
    private Scene scene;
    private boolean isAliveWindow;

    public void createWindow(ActionEvent actionEvent, String nameFile, String nameWindow) {
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("/windows/fxml/" + nameFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setScene(new Scene(parent));
        getStage().setScene(getScene());
        getStage().setTitle(nameWindow);
        getStage().show();
        setAliveWindow(true);
        getStage().setOnCloseRequest(event -> setAliveWindow(false));
        initialize();
    }

    @FXML
    abstract void initialize();
}
