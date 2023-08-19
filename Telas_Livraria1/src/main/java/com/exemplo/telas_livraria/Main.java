package com.exemplo.telas_livraria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

@Override
public void start(Stage stage) throws IOException {
    try{

        Parent root = FXMLLoader.load(getClass().getResource("tela_logon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Logon");
        stage.setResizable(false);

    }catch (Exception e){
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
launch();
    }
}
