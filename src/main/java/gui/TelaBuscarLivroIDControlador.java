package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class TelaBuscarLivroIDControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button botaoBuscar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField buscarLivroPorID;

    @FXML
    private TextArea mostrarLivroID;

    @FXML
    void btnBuscarLivroIDBuscar(ActionEvent event) throws IOException{

    }

    @FXML
    void btnListaDeLivrosVoltar(ActionEvent event) throws IOException{
irParaTelaADM(event);
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
