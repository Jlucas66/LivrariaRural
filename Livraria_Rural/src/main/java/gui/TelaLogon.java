package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLogon extends Application {

    private static Stage stg;

    public void start(Stage logon1) throws IOException {
        stg = logon1;
        Parent root = FXMLLoader.load(getClass().getResource("tela_logon.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(TelaLogon.class.getResource("tela_inicial_cliente.fxml"));
        //Scene cena1 = new Scene(fxmlLoader.load(), 600,400);
        logon1.setTitle("Login");
        logon1.setResizable(false);
        logon1.setScene(new Scene(root, 600, 400));
        logon1.show();
    }
    public void mudarDeCena(String fxml) throws IOException{
        Parent tela = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(tela);
    }

    public static void main(String[] args) {
launch();
    }
}
