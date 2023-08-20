package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private ImageView capaDoLivro1;

    @FXML
    private ImageView capaDoLivro2;

    @FXML
    private ImageView capaDoLivro3;

    @FXML
    private ImageView capaDoLivro4;

    @FXML
    private Label tituloDoLivro1;

    @FXML
    private Label tituloDoLivro2;

    @FXML
    private Label tituloDoLivro3;

    @FXML
    private Label tituloDoLivro4;

    @FXML
    private Label precoDoLivro1;

    @FXML
    private Label precoDoLivro2;

    @FXML
    private Label precoDoLivro3;

    @FXML
    private Label precoDoLivro4;

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
    private Button botaoMaisDetalhes1;

    @FXML
    private Button botaoMaisDetalhes2;

    @FXML
    private Button botaoMaisDetalhes3;

    @FXML
    private Button botaoMaisDetalhes4;

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
    public void btnInicialClienteMaisDetalhes1(ActionEvent event) throws IOException{
irParaTelaLivro(event);
    }

    @FXML
    public void btnInicialClienteMaisDetalhes2(ActionEvent event) throws IOException{
        irParaTelaLivro(event);
    }

    @FXML
    public void btnInicialClienteMaisDetalhes3(ActionEvent event) throws IOException{
        irParaTelaLivro(event);
    }

    @FXML
    public void btnInicialClienteMaisDetalhes4(ActionEvent event) throws IOException{
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
