package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class TelaCadastroPromocaoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView logo;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField tipoDaPromocaoCadastroPromocao;

    @FXML
    private TextField valorDoDescontoCadastroPromocao;

    @FXML
    private DatePicker dataDeInicioCadastroPromocao;

    @FXML
    private DatePicker dataDeFimCadastroPromocao;

    @FXML
    public void btnCadastroPromocaoCadastrar(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnCadastroPromocaoCancelar(ActionEvent event) throws IOException{

    }

}
