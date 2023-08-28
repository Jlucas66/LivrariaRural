package gui;

import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelaRelatorioControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private List<Venda> listaRecebida;

    @FXML
    private Button botaoGerarRelatorio;

    @FXML
    private Button botaoVoltar;

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
        System.out.println(dataDeInicio.getValue());
        System.out.println(dataDeFim.getValue());
        // gerar a lista
        List<Venda> lista = new ArrayList<>();

        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        lista = controladorVenda.listarVendasPorPeriodo(dataDeInicio.getValue(), dataDeFim.getValue());

        if (lista.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Entrada");
            alert.setHeaderText("Não foram feitas vendas nesse período");
            alert.setContentText("Selecione outras datas de inicio e fim");

            alert.showAndWait();
            System.out.println("Alerta de não seleção de datas");
        }
        atualizarRelatorio(lista);
    }

    @FXML
    void btnRelatorioVoltar(ActionEvent event) throws IOException {
        // volta para a tela de adm
        irParaTelaInicialAdm(event);
    }
    public void atualizarRelatorio(List<Venda> listaDeVendas) {
        // preenche a HBox que está dentro do scroll com as cardsVenda
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        //Venda venda = controladorVenda.buscarUltimaVendaDoRepo();


        int coluna = 0;
        int linha = 1;

        try {
            for(Venda venda : listaDeVendas){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cardVendaDoRelatorio.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardVendaDoRelatorioController cardVendaDoRelatorioController = fxmlLoader.getController();
                cardVendaDoRelatorioController.setData(venda);
                cardVendaDoRelatorioController.setListaDoRelatorio(listaDeVendas);

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


    public void irParaTelaInicialAdm (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Catálogo");
        stage.setResizable(false);
    }
    public void receberLista(List<Venda> lista) {
        this.listaRecebida = lista;
        atualizarRelatorio(lista);
    }

}
