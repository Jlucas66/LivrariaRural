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
import negocio.ControladorLivro;
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
    private String generoRecebido;



    public void initialize() {
        // setar itens no choicebox
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        for (Livro livro : controladorLivro.getRepositorioLivro()) {
            generos.getItems().add(livro.getGenero());
        }

    }
    public void receberLivro(Livro livro) {
        this.livroRecebido = livro;
        preencherLabels();
    }
    public void receberBusca(String buscaRecebida, String generoRecebido) {
        this.buscaRecebida = buscaRecebida;
        this.generoRecebido = generoRecebido;
    }


    @FXML
    private TextField buscarLivro;
    @FXML
    private ChoiceBox<String> generos;
    @FXML
    private TextField quantidadeLivrosLivro;
    @FXML
    private ImageView capaDoLivroLivro;

    @FXML
    private Label autorLivro;
    @FXML
    private Label edicaoLivro;
    @FXML
    private Label editoraLivro;
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

    // On Action
    @FXML
    public void btnLivroAvaliarLivro (ActionEvent event) throws IOException{
        // vai pra tela de avaliação

    }
    @FXML
    public void btnLivroLupa(ActionEvent event) throws IOException{
        // vai pra tela de busca
        irParaTelaBusca(event);
    }
    @FXML
    public void btnLivroHistorico(ActionEvent event) throws IOException{
        // vai pra tela de historico
        irParaTelaHistorico(event);
    }
    @FXML
    public void btnLivroCarrinho(ActionEvent event) throws IOException{
        irParaTelaCarrinho(event);
    }
    @FXML
    public void btnLivroVoltar(ActionEvent event) throws IOException{
        irParaTelaBusca(event);
    }
    @FXML
    public void btnLivroAdicionarAoCarrinho(ActionEvent event) throws IOException{

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
                irParaTelaCarrinho(event);

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

    private void preencherLabels() {
        if (livroRecebido != null) {
            tituloDoLivroLivro.setText(livroRecebido.getTitulo());
            precoDoLivroLivro.setText(String.format("R$ %.2f", livroRecebido.getPreco()));
            notaDasAvaliacoesLivro.setText(String.format("⭐⭐⭐⭐⭐  %.1f / 5", livroRecebido.calcularMediaDeAvaliacoes()));
            noEstoqueLivro.setText(String.format("Em estoque: %d", livroRecebido.getQuantidadeNoEstoque()));
            descricaoDoLivroLivro.setText(livroRecebido.getSinopse());
            edicaoLivro.setText(String.format("Edição: %s", livroRecebido.getEdicao()));
            editoraLivro.setText(String.format("Editora: %s", livroRecebido.getEditora()));
            autorLivro.setText(livroRecebido.getAutor());
            try {
                capaDoLivroLivro.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/%d.jpg", livroRecebido.getId()))));
            } catch (Exception e) {
                capaDoLivroLivro.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/sem_capa.jpg"))));
            }        }
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
    public void irParaTelaHistorico (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tela_historico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

        // mandar string do textfield e genero do choice box pra tela de busca
        TelaBuscaControlador telaBuscaControlador = loader.getController();
        telaBuscaControlador.receberBusca(buscaRecebida, generoRecebido);
    }



}
