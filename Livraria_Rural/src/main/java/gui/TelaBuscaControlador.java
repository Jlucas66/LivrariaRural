package gui;

//import Model.Book;
import beans.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.ControladorLivro;

import java.io.IOException;
import java.util.List;

public class TelaBuscaControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String buscaRecebida;
    private String generoRecebido;

    @FXML
    private Label resultadoBusca;
    @FXML
    private VBox cardLayout;
    @FXML
    private GridPane bookContainer;
    @FXML
    private Button botaoVoltar;
    @FXML
    public void btnVoltar(ActionEvent event) throws IOException{
        irParaTelaInicialCliente(event);
    }

    public void receberBusca(String buscaRecebida, String generoRecebido) {
        this.buscaRecebida = buscaRecebida;
        this.generoRecebido = generoRecebido;
        inicializarTela();
    }
    public void inicializarTela() {

        int coluna = 0;
        int linha = 1;

        try {
            for(Livro livro : livros()){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                VBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(livro);
                cardController.setBuscaRecebida(buscaRecebida);
                cardController.setGeneroRecebido(generoRecebido);

                if (coluna == 4) {
                    coluna = 0;
                    linha++;
                }

                bookContainer.add(cardBox, coluna++, linha);
                GridPane.setMargin(cardBox, new Insets(5));
            }

            if(livros().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Busca");
                alert.setHeaderText("Busca por livro");
                alert.setContentText("Não foi encontrado nenhum livro ou autor com esse nome !");

                alert.showAndWait();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private List<Livro> livros(){
        // metodo retorna lista de livros
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        List<Livro> lista = controladorLivro.listaLivroPorBusca(buscaRecebida, generoRecebido);
        return lista;
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
