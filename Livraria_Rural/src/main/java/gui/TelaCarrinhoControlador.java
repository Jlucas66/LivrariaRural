package gui;

import beans.ItemVenda;
import beans.StatusVenda;
import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorVenda;

import java.io.IOException;

public class TelaCarrinhoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea detalhesDoCarrinho;

    @FXML
    private Label resumoDoPedido;

    @FXML
    private Label quantidadeDeItens;

    @FXML
    private Label valorTotal;

    @FXML
    private Button botaoContinuarComprando;
    
    @FXML
    private Button botaoFinalizarCompra;

    @FXML
    private ImageView logo;

    public void initialize() {
    // set das informações
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        Venda venda = controladorVenda.buscarUltimaVendaDoRepo();
        quantidadeDeItens.setText(String.format("Total de itens: %d", venda.qtdLivrosDaVenda()));
        valorTotal.setText(String.format("Total: R$ %.2f", venda.calcularTotal()));
        detalhesDoCarrinho.setText(controladorVenda.imprimirItensVenda(venda));

        // set das imagens
        //logo.setImage(new Image(getClass().getResourceAsStream("logo_livraria.png")));


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
        detalhesDoCarrinho.setText(controladorVenda.imprimirItensVenda(venda));

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
            detalhesDoCarrinho.setText(controladorVenda.imprimirItensVenda(venda));
        }


    }
}
