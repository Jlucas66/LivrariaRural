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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import negocio.ControladorLivro;

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
    private TextArea tituloCadastroLivro;

    @FXML
    private TextField autorCadastroLivro;

    @FXML
    private TextField generoCadastroLivro;

    @FXML
    private TextArea sinopseCadastroLivro;

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
        ControladorLivro cLivro=ControladorLivro.getInstance();


        // se tudo no livro estiver ok (campos preenchidos, e quantidade sendo um número inteiro maior ou igual a zero)

        // cadastrar livro

        // salvar arquivo livros.ser

    }

    @FXML
    public void btnCadastroLivroCancelar(ActionEvent event) throws IOException{
        // volta para tela adm
        irParaTelaAdm(event);
    }

    public void irParaTelaAdm (ActionEvent event) throws IOException{
        //root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_adm.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Administrador");
        stage.setResizable(false);
    }
}
