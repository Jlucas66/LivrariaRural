package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorLivro;

import java.io.IOException;

public class TelaEditarLivroControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField autorEditarLivro;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoSalvarAlteracoes;

    @FXML
    private Button carregarLivro;

    @FXML
    private TextField edicaoEditarLivro;

    @FXML
    private TextField editoraEditarLivro;

    @FXML
    private TextField generoEditarLivro;

    @FXML
    private TextField idCadastroLivro;

    @FXML
    private ImageView logo1;

    @FXML
    private TextField precoEditarLivro;

    @FXML
    private TextField quantidadeNoEstoqueEditarLivro;

    @FXML
    private TextArea sinopseEditarLivro;

    @FXML
    private TextArea tituloEditarLivro;

    @FXML
    void btnSalvarAlteracoes(ActionEvent event) {

    }

    @FXML
    void btnEditarLivroCancelar(ActionEvent event) throws IOException {
        irParaTelaADM(event);
    }

    @FXML
    void btnCarregarLivro(ActionEvent event) {
        // carregar informações do livro
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        

    }

    public void irParaTelaADM (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("ADM");
        stage.setResizable(false);
    }

}