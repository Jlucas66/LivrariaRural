package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nomeCadastro;
    @FXML
    private TextField emailCadastro;
    @FXML
    private TextField senhaCadastro;
    @FXML
    private TextField enderecoCadastro;
    @FXML
    private TextField dataDeNascimentoCadastro;

    @FXML
    private Button botaoCadastrar;
    @FXML
    private Button botaoVoltar;

    public void btnCadastroCadastrar(ActionEvent event)throws IOException {
irParaTelaLogon(event);
    }

    public void btnCadastroVoltar(ActionEvent event) throws IOException{
irParaTelaLogon(event);
    }
    public void irParaTelaLogon (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_logon.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Logon");
        stage.setResizable(false);
    }
}
