package gui;

import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;
import java.util.List;

public class TelaHistoricoControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button botaoVoltar;

    @FXML
    private GridPane vendaContainer;

    @FXML
    void btnRelatorioVoltar(ActionEvent event) throws IOException {
        // volta para tela inicial Cliente
        irParaTelaInicialCliente(event);

    }

    public void initialize() {
        // set das informações
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();
        atualizarHistorico();

    }

    public void atualizarHistorico() {

        // preenche a HBox que está dentro do scroll com as cardsHistoricoVenda
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda vendaAtual = controladorVenda.buscarUltimaVendaDoRepo();

        // definir o arraylist que sera mostrado
        List<Venda> lista = controladorVenda.listarVendasPorPessoa(vendaAtual.getPessoa());
        lista.remove(lista.size()-1);

        //ordenar a lista pra aparecer as mais recentes primeiro



        int coluna = 0;
        int linha = 1;

        try {
            for(Venda venda : lista) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cardVendaDoHistorico.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardVendaDoHistoricoController cardVendaDoHistoricoController = fxmlLoader.getController();
                cardVendaDoHistoricoController.setData(venda);

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
