package gui;

import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CardVendaDoRelatorioController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Venda vendaPassada;
    private List<Venda> listaDoRelatorio;

    @FXML
    private Label clienteVenda;

    @FXML
    private Label dataVenda;

    @FXML
    private Label valorVenda;

    @FXML
    private Hyperlink visualizarVenda;

    @FXML
    private Label idVenda;


    @FXML
    void hyperVisualizar(ActionEvent event) throws IOException {
        // vai para tela parecida com a do carrinho, pra ver os livros que tem na venda
        irParaTelaVisualizarVenda(event);
    }

    public void setData(Venda venda){
        //book = livro;

        dataVenda.setText(String.format("%1$td/%1$tm/%1$ty", venda.getData()));
        clienteVenda.setText(venda.getPessoa().getNome());
        valorVenda.setText(String.format("R$ %.2f", venda.calcularTotal()));
        idVenda.setText(String.format("[ %d ]", venda.getId()));
        vendaPassada = venda;

    }
    public void irParaTelaVisualizarVenda (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_visualizar_venda_relatorio.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Conteudo da Venda");
        stage.setResizable(false);

        // dizer qual o controlador da proxima tela
        TelaVisualizarVendaRelatorioControlador telaVisualizarVendaRelatorioControlador = loader.getController();
        // usar o metodo da tela que vai receber o objeto
        telaVisualizarVendaRelatorioControlador.receberVenda(vendaPassada);
        telaVisualizarVendaRelatorioControlador.receberLista(listaDoRelatorio);


    }

    public List<Venda> getListaDoRelatorio() {
        return listaDoRelatorio;
    }

    public void setListaDoRelatorio(List<Venda> listaDoRelatorio) {
        this.listaDoRelatorio = listaDoRelatorio;
    }
}
