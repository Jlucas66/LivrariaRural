package com.exemplo.telas_livraria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCarrinhoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label detalhesDoCarrinho;

    @FXML
    private Label resumoDoPedido;

    @FXML
    private Label quantidadeDeItens;

    @FXML
    private Label valorTotal;

    @FXML
    private Button botaoContinuarComprando;
    @FXML
    private Button botaoFinalizarCompra;

    public void btnCarrinhoContinuarComprando(ActionEvent event) throws IOException{
        irParaTelaInicialCliente(event);
    }
    public void btnCarrinhoFinalizarCompra(ActionEvent event) throws IOException{
        irParaTelaCompra(event);
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
    public void irParaTelaCompra (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_compra.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Compra finalizada");
        stage.setResizable(false);
    }
}
