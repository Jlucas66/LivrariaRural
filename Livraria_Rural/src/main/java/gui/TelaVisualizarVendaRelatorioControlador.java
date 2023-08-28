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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;
import java.util.List;

public class TelaVisualizarVendaRelatorioControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Venda vendaRecebida;
    private List<Venda> listaRecebida;

    @FXML
    private Button botaoVoltar;
    @FXML
    private Label dataVenda;
    @FXML
    private Label descontoPromocao;
    @FXML
    private GridPane livroVendaContainer;
    @FXML
    private ImageView logo;
    @FXML
    private Label nomePromocao;
    @FXML
    private Label valorTotalDaVenda;
    @FXML
    void btnHistoricoVoltar(ActionEvent event) throws IOException {
        irParaTelaRelatorio(event);
    }

    public void receberVenda(Venda venda) {
        this.vendaRecebida = venda;
        atualizarVendas();
    }
    public void receberLista(List<Venda> lista) {
        this.listaRecebida = lista;
    }

    public void initialize() {

    }

    public void atualizarVendas() {
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = vendaRecebida;


        //preencher labels
        dataVenda.setText(String.format("%1$td/%1$tm/%1$ty", venda.getData()));
        valorTotalDaVenda.setText(String.format("R$ %.2f", venda.calcularTotal()));

        if (venda.getPromocao() != null) {
            nomePromocao.setText(venda.getPromocao().getNomePromocao());
            descontoPromocao.setText(String.format("Desconto de %.0f%%", venda.getPromocao().getPercentualDesconto()));
        }

        // carregar o HBox com os quadros de venda
        int coluna = 0;
        int linha = 1;

        try {
            for(ItemVenda i : venda.getItensDaVenda()){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cardLivroVenda.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardLivroVendaController cardLivroVendaController = fxmlLoader.getController();
                cardLivroVendaController.setData(i);
                // tirar o hyperlink remover
                cardLivroVendaController.ocultarHyperlink();

                if (coluna == 2) {
                    coluna = 0;
                    linha++;
                }

                livroVendaContainer.add(cardBox, coluna++, linha);
                GridPane.setMargin(cardBox, new Insets(5));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void irParaTelaRelatorio (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_relatorio.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Relatorio de vendas");
        stage.setResizable(false);

        // passar a lista de volta para a tela relatorio
        TelaRelatorioControlador telaRelatorioControlador = loader.getController();
        telaRelatorioControlador.receberLista(listaRecebida);
    }

    public List<Venda> getListaRecebida() {
        return listaRecebida;
    }

    public void setListaRecebida(List<Venda> listaRecebida) {
        this.listaRecebida = listaRecebida;
    }
}
