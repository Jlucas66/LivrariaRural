package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TelaLogonControlador {

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

    }

    @FXML
    public void btnLogonCadastrar(ActionEvent event)throws IOException {
        TelaLogon tl = new TelaLogon();
        tl.mudarDeCena("tela_cadastro.fxml");
    }

}
