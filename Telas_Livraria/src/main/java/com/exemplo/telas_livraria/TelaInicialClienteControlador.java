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

public class TelaInicialClienteControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Fx: ID

    @FXML
    private TextField buscarInicialCliente;

    @FXML
    private Button botaoTerror;

    @FXML
    private Button botaoRomance;

    @FXML
    private Button botaoSuspense;

    @FXML
    private Button botaoFantasia;

    @FXML
    private Button botaoFiccaoCientifica;

    @FXML
    private Button botaoBiografia;

    @FXML
    private Button botaoLupa;

    @FXML
    private Button botaoHistorico;

    @FXML
    private Button botaoCarrinho;

    @FXML
    private Button botaoMaisDetalhes;

    @FXML
    private Button botaoSairDaConta;

    // On Action

    @FXML
    public void btnInicialClienteTerror(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteRomance(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteSuspense(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteFantasia(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnInicialClienteFiccaoCientifica(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnInicialClienteBiografia(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteLupa(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteHistorico(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteCarrinho(ActionEvent event) throws IOException{
irParaTelaCarrinho(event);
    }
    @FXML
    public void btnInicialClienteMaisDetalhes(ActionEvent event) throws IOException{
irParaTelaLivro(event);
    }

    @FXML
    public void btnInicialClienteSairDaConta (ActionEvent event) throws  IOException{
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
    public void irParaTelaLivro (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_livro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Livro: Mais detalhes");
        stage.setResizable(false);
    }
    public void irParaTelaCarrinho (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Carrinho");
        stage.setResizable(false);
    }
}
