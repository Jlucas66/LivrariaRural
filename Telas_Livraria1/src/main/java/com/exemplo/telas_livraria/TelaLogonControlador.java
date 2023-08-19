package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLogonControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button botaoCadastrar;
    @FXML
    private Button botaoEntrar;
    @FXML
    private TextField emailLogon;
    @FXML
    private PasswordField senhaLogon;

    @FXML
    public void btnLogonEntrar(ActionEvent event) throws IOException{
irParaTelaInicialCliente(event);
    }

    @FXML
    public void btnLogonCadastrar(ActionEvent event)throws IOException {
       irParaTelaCadastro(event);
    }

    public void irParaTelaCadastro (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_cadastro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastre-se");
        stage.setResizable(false);
    }
    public void irParaTelaInicialCliente (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Catálogo");
        stage.setResizable(false);
    }
}
