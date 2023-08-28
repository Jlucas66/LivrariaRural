package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaListaDePromocoesControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea listaDePromocoes;

    @FXML
    void btnPromocoesVoltar(ActionEvent event) throws IOException {
irParaTelaADM(event);
    }

    public void irParaTelaADM (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("ADM");
        stage.setResizable(false);
    }

}
