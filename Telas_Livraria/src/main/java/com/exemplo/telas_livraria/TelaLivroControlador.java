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

public class TelaLivroControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField buscarLivro;

    @FXML
    private TextField quantidadeLivrosLivro;

    @FXML
    private ImageView capaDoLivroLivro;

    @FXML
    private Label tituloDoLivroLivro;

    @FXML
    private Label notaDasAvaliacoesLivro;

    @FXML
    private Label precoDoLivroLivro;

    @FXML
    private Label noEstoqueLivro;

    @FXML
    private Label descricaoDoLivroLivro;

    @FXML
    private Button botaoLupa;

    @FXML
    private Button botaoHistorico;

    @FXML
    private Button botaoCarrinho;

    @FXML
    private Button botaoAdicionarAoCarrinho;

    @FXML
    private Button botaoAvaliarLivro;

    @FXML
    private Button botaoVoltar;

    // On Action

    @FXML
    public void btnLivroLupa(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnLivroHistorico(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnLivroCarrinho(ActionEvent event) throws IOException{
irParaTelaCarrinho(event);
    }
    @FXML
    public void btnLivroAdicionarAoCarrinho(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnLivroAvaliarLivro (ActionEvent event) throws IOException{

    }

    @FXML
    public void qtdLivrosLivro(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnLivroVoltar(ActionEvent event) throws IOException{
irParaTelaInicialCliente(event);
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
