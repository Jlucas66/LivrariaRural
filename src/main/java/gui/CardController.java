package gui;

import beans.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CardController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Livro book;
    private String buscaRecebida;
    private String generoRecebido;

    @FXML
    private VBox box;

    @FXML
    private ImageView capaDoLivro;

    @FXML
    private Label precoLivro;

    @FXML
    private Label autorLivro;

    @FXML
    private Hyperlink tituloLivro;

    @FXML
    void linkLivro(ActionEvent event) throws IOException {
        irParaTelaLivro(event, book);
    }


    public void setData(Livro livro){
        book = livro;

        try {
            capaDoLivro.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/%d.jpg", livro.getId()))));
        } catch (Exception e) {
            capaDoLivro.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/sem_capa.jpg"))));
        }
        tituloLivro.setText(livro.getTitulo());
        precoLivro.setText(String.format("R$ %.2f", livro.getPreco()));
        autorLivro.setText(livro.getAutor());
    }
    public void irParaTelaLivro (ActionEvent event, Livro livro) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_livro_buscado.fxml"));
        root = loader.load();

        // dizer qual o controlador da proxima tela (não funcionou com getInstance)
        TelaLivroBuscadoControlador telaLivroBuscadoControlador = loader.getController();
        // usar o metodo da tela que vai receber o objeto
        telaLivroBuscadoControlador.receberLivro(livro);
        telaLivroBuscadoControlador.receberBusca(buscaRecebida, generoRecebido);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Livro: Mais detalhes");
        stage.setResizable(false);

    }

    public String getBuscaRecebida() {
        return buscaRecebida;
    }

    public void setBuscaRecebida(String buscaRecebida) {
        this.buscaRecebida = buscaRecebida;
    }

    public String getGeneroRecebido() {
        return generoRecebido;
    }

    public void setGeneroRecebido(String generoRecebido) {
        this.generoRecebido = generoRecebido;
    }
}

