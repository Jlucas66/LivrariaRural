package gui;

//import Model.Book;
import beans.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.ControladorLivro;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaBuscaControlador{

    private Stage stage;
    private Scene scene;
    private Parent root;
    private List<Livro> listaRecebida;
    private String descricaoDaBusca;

    public void receberLista(List<Livro> lista) {
        this.listaRecebida = lista;
    }
    public void receberDescricaoDaBusca(String descricaoDaBusca) {
        this.descricaoDaBusca = descricaoDaBusca;
    }

    @FXML
    private Label resultadoBusca;

    @FXML
    private VBox cardLayout;

    @FXML
    private GridPane bookContainer;

    @FXML
    private Button botaoVoltar;


    private List<Livro> livrosBuscados;

    //@Override
    public void initialize() {
        resultadoBusca.setText(String.format("Mostrando resultados da busca por: %s", descricaoDaBusca));

        //livros = new ArrayList<>(livros());
        int coluna = 0;
        int linha = 1;

        try {
            for(Livro livro : this.livros()){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                VBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(livro);
                //cardLayout.getChildren().add(cardBox);

                if (coluna == 4) {
                    coluna = 0;
                    linha++;
                }

                bookContainer.add(cardBox, coluna++, linha);
                GridPane.setMargin(cardBox, new Insets(5));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }



    private List<Livro> livros(){

        // metodo retorna lista de livros

        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        return controladorLivro.getRepositorioLivro();

    }

    @FXML
    public void btnVoltar(ActionEvent event) throws IOException{
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
