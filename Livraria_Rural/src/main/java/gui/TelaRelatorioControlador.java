package gui;

import beans.ItemVenda;
import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;

public class TelaRelatorioControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button botaoGerarRelatorio;

    @FXML
    private Button botaoSair;

    @FXML
    private DatePicker dataDeFim;

    @FXML
    private DatePicker dataDeInicio;

    @FXML
    private TextField digiteUmID;

    @FXML
    private TextArea outputRelatorio;

    @FXML
    private GridPane vendaContainer;

    @FXML
    void btnRelatorioGerarRelatorio(ActionEvent event) {
        // preenche a HBox que está dentro do scroll com as cardsVenda
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        //Venda venda = controladorVenda.buscarUltimaVendaDoRepo();

        int coluna = 0;
        int linha = 1;

        try {
            for(Venda venda : controladorVenda.getRepositorioVenda() ){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cardVenda.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardVendaController cardVendaController = fxmlLoader.getController();
                cardVendaController.setData(venda);

                if (coluna == 1) {
                    coluna = 0;
                    linha++;
                }

                vendaContainer.add(cardBox, coluna++, linha);
                GridPane.setMargin(cardBox, new Insets(5));
            }
        } catch (IOException e){
            e.printStackTrace();
        }






    }

    @FXML
    void btnRelatorioSair(ActionEvent event) throws IOException {
        // volta para a tela de adm
        irParaTelaInicialAdm(event);
    }

    @FXML
    void clicarNaVenda(MouseEvent event) {
        // vai para tela parecida com carrinho, mostrando os livros daquela venda, com botão para voltar para a tela anterior
    }

    public void irParaTelaInicialAdm (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Catálogo");
        stage.setResizable(false);
    }

}
