package gui;

import beans.Livro;
import beans.Promocao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.ControladorLivro;
import negocio.ControladorPromocao;

import java.io.IOException;

public class TelaListaDeLivrosControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        String lista = "";
        for (Livro liv : controladorLivro.getRepositorioLivro()) {
            lista += String.format("[ ID: %d ] [Estoque: %d] - %s (R$ %.2f)\n", liv.getId(), liv.getQuantidadeNoEstoque(), liv.getTitulo(), liv.getPreco());
        }
        listaDeLivros.setText(lista);
    }

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea listaDeLivros;

    @FXML
    void btnListaDeLivrosVoltar(ActionEvent event) throws IOException {
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
