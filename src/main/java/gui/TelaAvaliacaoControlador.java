package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import java.io.IOException;

public class TelaAvaliacaoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView capaDoLivro;

    @FXML
    private Label tituloDoLivro;

    @FXML
    private Label autorDoLivro;

    @FXML
    private Button botaoPublicar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextArea criticaDoLivro;

    @FXML
    private Spinner<Integer> notaDoLivro;

    @FXML
    public void btnAvaliacaoPublicar(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnAvaliacaoCancelar(ActionEvent event) throws IOException{
irParaTelaLivro(event);
    }
    // Aparentemente será necessário colocar isso aqui dentro de um initialize para funcionar...

    //SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
		//valueFactory.setValue(1);
    public void irParaTelaLivro (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_livro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Logon");
        stage.setResizable(false);
    }
}
