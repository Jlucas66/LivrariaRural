package com.exemplo.telas_livraria;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastro extends Application {
    private static Stage stg1;

    public void start(Stage cadastro1) throws IOException {
        stg1 = cadastro1;
        Parent root = FXMLLoader.load(getClass().getResource("tela_cadastro.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(TelaLogon.class.getResource("tela_cadastro.fxml"));
        //Scene cena1 = new Scene(fxmlLoader.load(), 600,400);
        cadastro1.setTitle("Cadastro");
        cadastro1.setResizable(false);
        cadastro1.setScene(new Scene(root, 600, 400));
        cadastro1.show();
    }
    public void mudarDeCena(String fxml) throws IOException{
        Parent tela = FXMLLoader.load(getClass().getResource(fxml));
        stg1.getScene().setRoot(tela);
    }

    public static void main(String[] args) {
launch();
    }
}
