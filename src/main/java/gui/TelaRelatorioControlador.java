package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaRelatorioControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField digiteUmID;

    @FXML
    private DatePicker dataDeInicio;

    @FXML
    private DatePicker dataDeFim;

    @FXML
    private TextArea outputRelatorio;

    @FXML
    private Button botaoGerarRelatorio;

    @FXML
    private Button botaoSair;

    @FXML
    public void btnRelatorioGerarRelatorio(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnRelatorioSair(ActionEvent event) throws IOException{
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
