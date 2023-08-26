package gui;

import beans.Livro;
import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class CardVendaController {

    @FXML
    private Label clienteVenda;

    @FXML
    private Label dataVenda;

    @FXML
    private Label valorVenda;

    @FXML
    private Hyperlink visualizarVenda;

    @FXML
    void hyperVisualizar(ActionEvent event) {
        // vai para tela parecida com a do carrinho, pra ver os livros que tem na venda

    }

    public void setData(Venda venda){
        //book = livro;

        dataVenda.setText(String.format("%1$td/%1$tm?%1$ty", venda.getData()));
        clienteVenda.setText(venda.getPessoa().getNome());
        valorVenda.setText(String.format("R$ %.2f", venda.calcularTotal()));

    }
}
