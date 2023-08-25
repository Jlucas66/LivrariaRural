package grid.gridpanedinamica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("tela_busca.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tela_busca.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 560);
        primarystage.setTitle("Hello!");
        primarystage.setScene(scene);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
