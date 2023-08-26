package gui;

import beans.ItemVenda;
import beans.Livro;
import beans.StatusVenda;
import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;
import java.util.List;

public class TelaCarrinhoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private List<Livro> livrosDaVenda;

    @FXML
    private Label resumoDoPedido;

    @FXML
    private Label quantidadeDeItens;

    @FXML
    private Label valorTotal;

    @FXML
    private Button botaoContinuarComprando;

    @FXML
    private Button botaoZerarCarrinho;

    @FXML
    private Button botaoRemoverUltimoLivro;

    @FXML
    private Button botaoFinalizarCompra;

    @FXML
    private GridPane livroVendaContainer;
    //private VBox containerVBox;

    public void initialize() {
    // set das informações
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();
        quantidadeDeItens.setText(String.format("Total de itens: %d", venda.qtdLivrosDaVenda()));
        valorTotal.setText(String.format("Total: R$ %.2f", venda.calcularTotal()));

        atualizarCarrinho();

    }


    public void btnCarrinhoContinuarComprando(ActionEvent event) throws IOException{
        irParaTelaInicialCliente(event);
    }
    public void btnCarrinhoFinalizarCompra(ActionEvent event) throws IOException{
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();
        // só mudar de tela se a lista de itens não estiver vazia
        if (!venda.getItensDaVenda().isEmpty()) {
            irParaTelaCompra(event);
            venda.setStatus(StatusVenda.PEDIDO_EFETUADO);

            // salvar venda no arquivo.ser
            controladorVenda.salvarVendasEmArquivo("Livraria_Rural/vendas.ser");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carrinho vazio");
            alert.setHeaderText("Você não tem itens no seu carrinho.");
            alert.setContentText("Adicione itens para conseguir finalizar uma compra.");

            alert.showAndWait();
            System.out.println("Alerta de carrinho vazio!");
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
    public void irParaTelaCompra (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_compra.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Compra finalizada");
        stage.setResizable(false);
    }

    public void btnCarrinhoZerarCarrinho(ActionEvent actionEvent) {
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();

        //readicioar as quantidades no estoque
        controladorVenda.aumentarQtdsDeVariosLivros(venda);

        //apaga a lista
        venda.getItensDaVenda().clear();

        //atualizar labels e lista
        quantidadeDeItens.setText(String.format("Total de itens: %d", venda.qtdLivrosDaVenda()));
        valorTotal.setText(String.format("Total: R$ %.2f", venda.calcularTotal()));
        //detalhesDoCarrinho.setText(controladorVenda.imprimirItensVenda(venda));
        atualizarCarrinho();

    }

    public void btnCarrinhoRemoverUltimoLivro(ActionEvent actionEvent) {
        // remover ultima entrada do carrinho - quando apagar, adicionar a quantidade de volta no estoque
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();

        // se a lista de itens não estiver vazia

        if (!venda.getItensDaVenda().isEmpty()) {
            // readicionar a quantidade do ultimo livro da lista do carrinho
            controladorVenda.aumentarQtdDoUltimoLivro(venda);

            //apaga o ultimo item do carrinho
            venda.getItensDaVenda().remove(venda.getItensDaVenda().size()-1);

            //atualizar labels e lista
            quantidadeDeItens.setText(String.format("Total de itens: %d", venda.qtdLivrosDaVenda()));
            valorTotal.setText(String.format("Total: R$ %.2f", venda.calcularTotal()));
            //detalhesDoCarrinho.setText(controladorVenda.imprimirItensVenda(venda));

            //atualizarCarrinho();
        }


    }

    public void atualizarCarrinho() {
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();

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
}
