package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroAdmControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView logo;

    @FXML
    private TextField nomeCadastroADM;

    @FXML
    private TextField emailCadastroADM;

    @FXML
    private PasswordField senhaCadastroADM;

    @FXML
    private TextField telefoneCadastroADM;

    @FXML
    private DatePicker dataDeNascimentoCadastroADM;

    @FXML
    private Button cadastrarCadastroADM;

    @FXML
    private Button voltarCadastroADM;

    @FXML
    public void btnCadastroADMCadastrar(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnCadastroADMVoltar(ActionEvent event) throws IOException{
irParaTelaInicialADM(event);
    }
    public void irParaTelaInicialADM (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Logon");
        stage.setResizable(false);
    }
}