package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroLivroControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private ImageView logo;

    @FXML
    private TextField idCadastroLivro;

    @FXML
    private TextField tituloCadastroLivro;

    @FXML
    private TextField autorCadastroLivro;

    @FXML
    private TextField generoCadastroLivro;

    @FXML
    private TextField sinopseCadastroLivro;

    @FXML
    private TextField editoraCadastroLivro;

    @FXML
    private TextField edicaoCadastroLivro;

    @FXML
    private TextField precoCadastroLivro;

    @FXML
    private TextField quantidadeNoEstoqueCadastroLivro;

    @FXML
    public void btnCadastroLivroCadastrar(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnCadastroLivroCancelar(ActionEvent event) throws IOException{

    }

}
