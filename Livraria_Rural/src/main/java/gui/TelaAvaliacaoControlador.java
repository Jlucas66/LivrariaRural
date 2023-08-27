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

    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);


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
        notaDoLivro.setValueFactory(valueFactory);//guardando o valor do spinner
        if(notaDoLivro.getValue()>=1 && criticaDoLivro.getText()!=null){
            Avaliacao avaliacao=new Avaliacao(pessoaRecebida,livroRecebido, notaDoLivro.getValue(), criticaDoLivro.getText());
            livroRecebido.getAvaliacoes().add(avaliacao);
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
