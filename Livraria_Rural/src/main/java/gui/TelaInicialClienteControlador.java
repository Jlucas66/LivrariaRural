package gui;

import beans.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorLivro;
import negocio.ControladorVenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelaInicialClienteControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private List<Livro> livros;     // atributo que virá de outro canto pra ser usado nessa tela

    // metodo que será realizado assim que a tela iniciar - preencher labels..
    public void initialize() {
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        this.livros = controladorLivro.getRepositorioLivro();

        // setar itens no choicebox
        for (Livro livro : controladorLivro.getRepositorioLivro()) {
            generos.getItems().add(livro.getGenero());
        }
        ola.setText(String.format("Olá, %s!", controladorVenda.buscarUltimaVendaDoRepo().getPessoa().getNome()));



        // setar os livros
        tituloDoLivro1.setText(livros.get(0).getTitulo());
        tituloDoLivro2.setText(livros.get(1).getTitulo());
        tituloDoLivro3.setText(livros.get(2).getTitulo());
        tituloDoLivro4.setText(livros.get(3).getTitulo());
        precoDoLivro1.setText(String.format("R$ %.2f", livros.get(0).getPreco()));
        precoDoLivro2.setText(String.format("R$ %.2f", livros.get(1).getPreco()));
        precoDoLivro3.setText(String.format("R$ %.2f", livros.get(2).getPreco()));
        precoDoLivro4.setText(String.format("R$ %.2f", livros.get(3).getPreco()));
        List<ImageView> capas = new ArrayList<>();
        capas.add(capaDoLivro1);
        capas.add(capaDoLivro2);
        capas.add(capaDoLivro3);
        capas.add(capaDoLivro4);



        for (int i = 0; i < 4; i++) {
            capas.get(i).setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/%d.jpg", livros.get(i).getId()))));
        }



    }


    //Fx: ID

    @FXML
    private TextField buscarInicialCliente;
    @FXML
    private ImageView capaDoLivro1;
    @FXML
    private ImageView capaDoLivro2;
    @FXML
    private ImageView capaDoLivro3;
    @FXML
    private ImageView capaDoLivro4;
    @FXML
    private Label tituloDoLivro1;
    @FXML
    private Label tituloDoLivro2;
    @FXML
    private Label tituloDoLivro3;
    @FXML
    private Label tituloDoLivro4;
    @FXML
    private Label precoDoLivro1;
    @FXML
    private Label precoDoLivro2;
    @FXML
    private Label precoDoLivro3;
    @FXML
    private Label precoDoLivro4;

    @FXML
    private Button botaoLupa;
    @FXML
    private Button botaoHistorico;
    @FXML
    private Button botaoCarrinho;
    @FXML
    private Button botaoMaisDetalhes1;
    @FXML
    private Button botaoMaisDetalhes2;
    @FXML
    private Button botaoMaisDetalhes3;
    @FXML
    private Button botaoMaisDetalhes4;
    @FXML
    private Button botaoSairDaConta;
    @FXML
    private ChoiceBox<String> generos;
    @FXML
    private Label ola;

    // On


    @FXML
    public void btnInicialClienteLupa(ActionEvent event) throws IOException{
        // vai para tela_busca com lista baseado na String digitada pelo usuario
        irParaTelaBusca(event);
    }
    @FXML
    public void btnInicialClienteHistorico(ActionEvent event) throws IOException{
        // vai para tela de histórico do cliente
        irParaTelaHistorico(event);
    }
    @FXML
    public void btnInicialClienteCarrinho(ActionEvent event) throws IOException{
        // vai para tela de carrinho
        irParaTelaCarrinho(event);
    }

    @FXML
    public void btnInicialClienteSairDaConta (ActionEvent event) throws  IOException{

        //se a venda não foi finalizada, a quantidade de livros tem que voltar ao que tava antes
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        controladorVenda.aumentarQtdsDeVariosLivros(controladorVenda.buscarUltimaVendaDoRepo());
        //apagar a ultima venda
        controladorVenda.removerUltimaVendaDoRepo();

        irParaTelaLogon(event);
    }
    public void irParaTelaLogon (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_logon.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Logon");
        stage.setResizable(false);
    }
    public void irParaTelaLivro (ActionEvent event, Livro livro) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_livro.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Livro: Mais detalhes");
        stage.setResizable(false);

        // Passar livro para proxima tela
        TelaLivroControlador telaLivroControlador = loader.getController();
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        telaLivroControlador.receberPessoa(controladorVenda.buscarUltimaVendaDoRepo().getPessoa());
        //passando pesso ah pessoa da tela clinte para a tela do livro
        telaLivroControlador.receberLivro(livro);


    }
    public void irParaTelaBusca (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_busca.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Resultado da busca");
        stage.setResizable(false);

        // mandar string do textfield pra tela de busca
        TelaBuscaControlador telaBuscaControlador = loader.getController();
        telaBuscaControlador.receberBusca(buscarInicialCliente.getText(), generos.getSelectionModel().getSelectedItem());
    }
    public void irParaTelaCarrinho (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Carrinho");
        stage.setResizable(false);
    }
    public void irParaTelaHistorico (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tela_historico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Carrinho");
        stage.setResizable(false);
    }


    @FXML
    public void btnInicialClienteMaisDetalhes1(ActionEvent event) throws IOException{
    // aqui vai pra tela do livro selecionado dentro do array list inicial
    irParaTelaLivro(event, livros.get(0));
}

    public void btnInicialClienteMaisDetalhes2(ActionEvent event) throws IOException {
        irParaTelaLivro(event, livros.get(1));

    }

    public void btnInicialClienteMaisDetalhes3(ActionEvent event) throws IOException {
        irParaTelaLivro(event, livros.get(2));

    }

    public void btnInicialClienteMaisDetalhes4(ActionEvent event) throws IOException {
        irParaTelaLivro(event, livros.get(3));

    }

}
