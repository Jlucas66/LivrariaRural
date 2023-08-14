package com.exemplo.telas_livraria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class TelaLogon extends Application {

    public void start(Stage logon1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogon.class.getResource("tela_cadastro.fxml"));
        Scene cena1 = new Scene(fxmlLoader.load(), 600,400);
        logon1.setTitle("Login");
        logon1.setResizable(false);
        logon1.setScene(cena1);
        logon1.show();
    }

    public static void main(String[] args) {
launch();
    }
}
