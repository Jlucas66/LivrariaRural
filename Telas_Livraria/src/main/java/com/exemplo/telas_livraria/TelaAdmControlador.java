package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaAdmControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Fx: ID

    @FXML
    private Button botaoCadastrarLivros;

    @FXML
    private Button botaoRelatorioDeCompras;

    @FXML
    private Button botaoListaDeClientes;

    @FXML
    private Button botaoSair;

    //On Action

    @FXML
    public void btnADMCadastrarLivros (ActionEvent event) throws IOException {

    }
    @FXML
    public void btnADMRelatorioDeCompras (ActionEvent event) throws IOException{

    }
    @FXML
    public void btnADMListaDeClientes (ActionEvent event) throws IOException{

    }
    @FXML
    public void btnADMSair (ActionEvent event) throws IOException{
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
