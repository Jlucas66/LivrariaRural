package gui;

import beans.Avaliacao;
import beans.Livro;
import beans.Pessoa;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import negocio.ControladorLivro;

import java.io.IOException;

public class TelaAvaliacaoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Livro livroRecebido;

    private Pessoa pessoaRecebida;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView capaDoLivro;

    @FXML
    private Label tituloDoLivro;

    @FXML
    private Label autorDoLivro;

    @FXML
    private Button botaoPublicar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextArea criticaDoLivro;

    @FXML
    private Spinner<Integer> notaDoLivro;

    public void initialize(){
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        notaDoLivro.setValueFactory(valueFactory);//guardando o valor do spinner
        ControladorLivro cLivro=ControladorLivro.getInstance();
        cLivro.carregarLivrosDeArquivo("Livraria_Rural/livros.ser");

    }

    public void receberLivroEPoessoa(Livro livro, Pessoa pessoa) {
        this.livroRecebido = livro;
        this.pessoaRecebida=pessoa;
        preencherLabels();
    }


    public void preencherLabels(){
        if(livroRecebido!=null){
            tituloDoLivro.setText(livroRecebido.getTitulo());
            autorDoLivro.setText(livroRecebido.getAutor());
            try{
                capaDoLivro.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/%d.jpg", livroRecebido.getId()))));
            }catch (Exception e){
                capaDoLivro.setImage(new Image(getClass().getResourceAsStream(String.format("Imagens/capas_livros/sem_capa.jpg"))));
            }
        }
    }
    @FXML
    public void btnAvaliacaoPublicar(ActionEvent event) throws IOException{
        boolean avaliou=false;
        String critica=null;
        try{
            critica=criticaDoLivro.getText();
        }catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Avaliação");
            alert.setHeaderText("Erro ao cadastrar a avaliação");
            alert.setContentText(" O campo de crítica do livro está vazio !");

            alert.showAndWait();
        }


        if(critica!=null && !critica.isEmpty()){
            ControladorLivro cLivro=ControladorLivro.getInstance();
            Avaliacao avaliacao=new Avaliacao(pessoaRecebida,livroRecebido, notaDoLivro.getValue(), criticaDoLivro.getText());
            for(Livro l:cLivro.getRepositorioLivro()){
                if(l.getTitulo().equalsIgnoreCase(livroRecebido.getTitulo())){
                    l.getAvaliacoes().add(avaliacao);
                    break;
                }
            }
            livroRecebido.getAvaliacoes().add(avaliacao);
            //livroRecebido.getAvaliacoes().add(avaliacao);
            avaliou=true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Avaliação");
            alert.setHeaderText(null);
            alert.setContentText("Avaliação cadastrada!");

            alert.showAndWait();
            cLivro.salvarLivrosEmArquivo("Livraria_Rural/livros.ser");

            irParaTelaLivro(event);

        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Avaliação");
            alert.setHeaderText("Erro ao cadastrar a avaliação");
            alert.setContentText(" O campo de crítica do livro está vazio !");

            alert.showAndWait();
        }
    }

    @FXML
    public void btnAvaliacaoCancelar(ActionEvent event) throws IOException{
        irParaTelaLivro(event);
    }
    @FXML
    public void irParaTelaLivro (ActionEvent event) throws IOException{
        //root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_livro.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Livro: Mais detalhes");
        stage.setResizable(false);

        TelaLivroControlador telaLivroControlador=loader.getController();
        telaLivroControlador.receberLivro(livroRecebido);


    }
    // Aparentemente será necessário colocar isso aqui dentro de um initialize para funcionar...

    //SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
		//valueFactory.setValue(1);
}
