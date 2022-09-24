package TTPOrPAMMiCT.su.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Objects;

@Getter
@Setter
abstract class FxController {
    private static MainWindowController mainWindowController;
    private Stage stage = new Stage();
    private Scene scene;
    private boolean isAliveWindow;

    public void createWindow(ActionEvent actionEvent, String nameFile, String nameWindow) {
        try {
           Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/windows/fxml/" + nameFile)));
            setScene(new Scene(parent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getStage().setScene(getScene());
        getStage().setTitle(nameWindow);
        getStage().show();
        setAliveWindow(true);
        getStage().setOnCloseRequest(event -> setAliveWindow(false));
    }

    @FXML
    abstract void initialize();
}
