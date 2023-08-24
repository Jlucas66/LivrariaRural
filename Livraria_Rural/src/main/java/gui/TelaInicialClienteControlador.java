package gui;

import beans.Livro;
import beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    //private Pessoa pessoaRecebida;  // pessoa que virá da tela logon

    // metodo que será realizado assim que a tela iniciar - preencher labels..
    public void initialize() {
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        this.livros = controladorLivro.getRepositorioLivro();

        // setar imagens
        //logo.setImage(new Image(getClass().getResourceAsStream("logo_livraria.png")));
        //carrinho.setImage(new Image(getClass().getResourceAsStream("Imagens/carrinho.png")));
       // historico.setImage(new Image(getClass().getResourceAsStream("Imagens/historico.png")));
       // lupa.setImage(new Image(getClass().getResourceAsStream("Imagens/lupinha.png")));



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
            capas.get(i).setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/%d.jpg", livros.get(i+1).getId()))));
        }



    }

//    public void receberPessoa(Pessoa pessoaRecebida) {
//        this.pessoaRecebida = pessoaRecebida;
//    }

    //Fx: ID

    @FXML
    private ImageView logo;
    @FXML
    private ImageView lupa;
    @FXML
    private ImageView historico;
    @FXML
    private ImageView carrinho;

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
    private Button botaoTerror;

    @FXML
    private Button botaoRomance;

    @FXML
    private Button botaoSuspense;

    @FXML
    private Button botaoFantasia;

    @FXML
    private Button botaoFiccaoCientifica;

    @FXML
    private Button botaoBiografia;

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






    // On

    @FXML
    public void btnInicialClienteTerror(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteRomance(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteSuspense(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteFantasia(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnInicialClienteFiccaoCientifica(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnInicialClienteBiografia(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteLupa(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteHistorico(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnInicialClienteCarrinho(ActionEvent event) throws IOException{

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

//        root = FXMLLoader.load(getClass().getResource("tela_livro.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_livro.fxml"));
        root = loader.load();

        // dizer qual o controlador da proxima tela (não funcionou com getInstance)
        TelaLivroControlador telaLivroControlador = loader.getController();
        // usar o metodo da tela que vai receber o objeto
        telaLivroControlador.receberLivro(livro);

        // passando capa do livro - PROVISÓRIO - modificar
        if (livro.getId() == 1) {
            telaLivroControlador.receberCapa(capaDoLivro1.getImage());
        } else if (livro.getId() == 2) {
            telaLivroControlador.receberCapa(capaDoLivro2.getImage());
        } else if (livro.getId() == 3) {
            telaLivroControlador.receberCapa(capaDoLivro3.getImage());
        } else if (livro.getId() == 4) {
            telaLivroControlador.receberCapa(capaDoLivro4.getImage());
        }


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Livro: Mais detalhes");
        stage.setResizable(false);

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
