package gui;

import beans.ItemVenda;
import beans.Livro;
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
import negocio.ControladorItemVenda;
import negocio.ControladorPromocao;
import negocio.ControladorVenda;

import java.io.IOException;

public class TelaLivroBuscadoControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Livro livroRecebido;        // atributo que virá da tela do cliente
    private Image capa;             // capa que vira da outra pág (depois ver se entra como atributo do livro)
    private String buscaRecebida;



    public void initialize() {

    }

    // quando recebe o livro da outra página, já preenche os labels
    public void receberLivro(Livro livro) {
        this.livroRecebido = livro;
        preencherLabels();
    }
    public void receberCapa(Image capa) {
        this.capa = capa;
        capaDoLivroLivro.setImage(capa);
    }
//    public void receberLista(List<Livro> lista) {
//        this.listaRecebida = lista;
//    }
    public void receberBusca(String buscaRecebida) {
        this.buscaRecebida = buscaRecebida;
    }

    // Metodo separado pra preencher os labels, pra ficar mais organizado
    private void preencherLabels() {
        if (livroRecebido != null) {
            tituloDoLivroLivro.setText(livroRecebido.getTitulo());
            precoDoLivroLivro.setText(String.format("R$ %.2f", livroRecebido.getPreco()));

            notaDasAvaliacoesLivro.setText(String.format("Média de avaliações: %.1f", livroRecebido.calcularMediaDeAvaliacoes()));

            noEstoqueLivro.setText(String.format("Em estoque: %d", livroRecebido.getQuantidadeNoEstoque()));
            descricaoDoLivroLivro.setText(String.format("Autor: %s\nSinopse: %s\nEdição: %s\nEditora: %s",
                    livroRecebido.getAutor(), livroRecebido.getSinopse(), livroRecebido.getEdicao(), livroRecebido.getEditora()));
        }
    }


    @FXML
    private TextField buscarLivro;

    @FXML
    private TextField quantidadeLivrosLivro;

    @FXML
    private ImageView capaDoLivroLivro;
    @FXML
    private ImageView lupa;
    @FXML
    private ImageView historico;
    @FXML
    private ImageView carrinho;
    @FXML
    private ImageView logo;

    @FXML
    private Label tituloDoLivroLivro;

    @FXML
    private Label notaDasAvaliacoesLivro;

    @FXML
    private Label precoDoLivroLivro;

    @FXML
    private Label noEstoqueLivro;

    @FXML
    private TextArea descricaoDoLivroLivro;

    @FXML
    private Button botaoLupa;

    @FXML
    private Button botaoHistorico;

    @FXML
    private Button botaoCarrinho;

    @FXML
    private Button botaoAdicionarAoCarrinho;

    @FXML
    private Button botaoAvaliarLivro;

    @FXML
    private Button botaoVoltar;




    // On Action






    @FXML
    public void btnLivroLupa(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnLivroHistorico(ActionEvent event) throws IOException{

    }
    @FXML
    public void btnLivroCarrinho(ActionEvent event) throws IOException{
        irParaTelaCarrinho(event);
    }
    @FXML
    public void btnLivroAdicionarAoCarrinho(ActionEvent event) throws IOException{

        // esse botão vai levar para a tela do carrinho - para evitar da pessoa apertar várias vezes o botão de add, e repetir a entrada dos dados


        // transforma o que foi digitado em inteiro
        int qtd=-1;

        try{
            qtd = Integer.parseInt(quantidadeLivrosLivro.getText());
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Entrada");
            alert.setHeaderText("Erro na quantidade!");
            alert.setContentText("Valor digitado não é um número ou espaço em branco!");

            alert.showAndWait();
            System.out.println("Alerta de quantidade maior do que a disponível no estoque, ou então digitou algo diferente de numero inteiro");
        }


        if(qtd>-1){
            System.out.println(qtd);
            // criar itemVenda
            ControladorItemVenda controladorItemVenda = ControladorItemVenda.getInstance();
            ItemVenda itemVenda = controladorItemVenda.criarItemVenda(livroRecebido, qtd);

            // add o itemVenda na venda
            ControladorVenda controladorVenda = ControladorVenda.getInstance();
            //se o item venda for colocado com sucesso dentro da venda: aplicar a promoção, diminuir qtd do livro no estoque e mudar de pág
            if (controladorVenda.colocarItensNaVenda(controladorVenda.buscarUltimaVendaDoRepo(), itemVenda)) {
                // aplicar promoção
                ControladorPromocao controladorPromocao = ControladorPromocao.getInstance();
                controladorPromocao.aplicarPromocaoNaVenda(controladorVenda.buscarUltimaVendaDoRepo());
                System.out.println("Item adicionado ao carrinho.. verificando promocoes...");

                // diminuir quantidade do livro no estoque
                controladorVenda.diminuirQtd(itemVenda);

                // mudar para pag do carrinho de compras
                root = FXMLLoader.load(getClass().getResource("tela_carrinho.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 900, 560);
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Carrinho");
                stage.setResizable(false);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Entrada");
                alert.setHeaderText("Erro na quantidade");
                alert.setContentText("Quantidade maior do que a disponível, ou a entrada é zero");

                alert.showAndWait();
                System.out.println("Alerta de quantidade maior do que a disponível no estoque, ou então digitou algo diferente de numero inteiro");
            }
        }



    }

    @FXML
    public void btnLivroAvaliarLivro (ActionEvent event) throws IOException{

    }
    @FXML
    public void pegarQuantidade (ActionEvent event) throws IOException {

    }


    //

    @FXML
    public void btnLivroVoltar(ActionEvent event) throws IOException{
irParaTelaBusca(event);
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
    public void irParaTelaCarrinho (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Carrinho");
        stage.setResizable(false);
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
        telaBuscaControlador.receberBusca(buscaRecebida);
    }


    public void qtdLivrosLivro(ActionEvent actionEvent) {

    }


}
