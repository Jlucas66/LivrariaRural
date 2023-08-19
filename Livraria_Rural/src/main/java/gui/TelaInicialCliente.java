package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialCliente extends Application {
    private static Stage stg2;

    public void start(Stage inicial1) throws IOException {
        stg2 = inicial1;
        Parent root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(TelaLogon.class.getResource("tela_inicial_cliente.fxml"));
        //Scene cena1 = new Scene(fxmlLoader.load(), 600,400);
        inicial1.setTitle("Login");
        inicial1.setResizable(false);
        inicial1.setScene(new Scene(root, 900, 560));
        inicial1.show();
    }
    public void mudarDeCena(String fxml) throws IOException{
        Parent tela = FXMLLoader.load(getClass().getResource(fxml));
        stg2.getScene().setRoot(tela);
    }
    public static void main(String[] args) {
        launch();
    }
}
