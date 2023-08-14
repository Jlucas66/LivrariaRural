package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TelaCadastroControlador {

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

    }

    public void btnCadastroVoltar(ActionEvent event) throws IOException{
        TelaCadastro tc = new TelaCadastro();
        tc.mudarDeCena("tela_logon.fxml");

    }

}
