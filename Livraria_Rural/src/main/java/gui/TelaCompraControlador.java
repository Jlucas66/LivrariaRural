package gui;

import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;


public class TelaCompraControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        //logo.setImage(new Image(getClass().getResourceAsStream("logo_livraria.png")));
    }

    @FXML
    private Button botaoVoltarAoCatalogo;
    @FXML
    private ImageView logo;

    @FXML
    public void btnCompraVoltarAoCatalogo(ActionEvent event) throws IOException {

        // quando voltar pro catálogo, criar nova venda com itens vazios e a mesma pessoa da ultima venda
        // pois a pessoa ainda está logada
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        controladorVenda.inserirVenda(new Venda(controladorVenda.buscarUltimaVendaDoRepo().getPessoa()));

        irParaTelaInicialCliente(event);
    }

    public void irParaTelaInicialCliente (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Catálogo");
        stage.setResizable(false);
    }
}
