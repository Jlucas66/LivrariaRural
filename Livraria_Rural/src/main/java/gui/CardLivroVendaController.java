package gui;

import beans.ItemVenda;
import beans.Livro;
import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;

public class CardLivroVendaController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ItemVenda item;

    @FXML
    private ImageView capa;

    @FXML
    private Label preco;

    @FXML
    private Label quantidade;

    @FXML
    private Label titulo;

    @FXML
    private Label valorTotal;

    @FXML
    private Hyperlink remover;

    @FXML
    void hyperRemover(ActionEvent event) throws IOException {
        // remove o livro da venda
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();
        controladorVenda.removerItensDaVenda(venda, item.getLivro());

        // atualiza a quantidade no estoque
        controladorVenda.aumentarQtdDeLivro(item);

        // atualizar carrinho
        irParaTelaCarrinho(event);
    }

    public void setData(ItemVenda itemVenda){
        item = itemVenda;

        try {
            capa.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/%d.jpg", itemVenda.getLivro().getId()))));
        } catch (Exception e) {
            capa.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/sem_capa.jpg"))));
        }
        titulo.setText(itemVenda.getLivro().getTitulo());
        preco.setText(String.format("R$ %.2f", itemVenda.getLivro().getPreco()));
        quantidade.setText(String.format("Quantidade: %d", itemVenda.getQuantidade()));
        valorTotal.setText(String.format("R$ %.2f", itemVenda.calcularTotal()));
    }

    public void irParaTelaCarrinho (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tela_carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Carrinho");
        stage.setResizable(false);
    }
}
