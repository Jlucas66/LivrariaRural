package gui;

import beans.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorLivro;

import java.io.IOException;
import java.util.Locale;

public class TelaEditarLivroControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Livro livro;

    @FXML
    private TextField autorEditarLivro;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSalvarAlteracoes;

    @FXML
    private Button carregarLivro;

    @FXML
    private TextField edicaoEditarLivro;

    @FXML
    private TextField editoraEditarLivro;

    @FXML
    private TextField generoEditarLivro;

    @FXML
    private TextField idLivro;

    @FXML
    private ImageView logo1;

    @FXML
    private TextField precoEditarLivro;

    @FXML
    private TextField quantidadeNoEstoqueEditarLivro;

    @FXML
    private TextArea sinopseEditarLivro;

    @FXML
    private TextArea tituloEditarLivro;

    @FXML
    void btnSalvarAlteracoes(ActionEvent event) {
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        try {
            // tentar atualizar livro com informações da tela
            controladorLivro.atualizarLivro(new Livro(
                    Long.parseLong(idLivro.getText()),
                    tituloEditarLivro.getText(),
                    autorEditarLivro.getText(),
                    generoEditarLivro.getText(),
                    sinopseEditarLivro.getText(),
                    editoraEditarLivro.getText(),
                    edicaoEditarLivro.getText(),
                    Double.parseDouble(precoEditarLivro.getText()),
                    Integer.parseInt(quantidadeNoEstoqueEditarLivro.getText())
                    ));
            if (Integer.parseInt(quantidadeNoEstoqueEditarLivro.getText())>=0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar livro");
                alert.setHeaderText("Livro alterado!");
                alert.setContentText("Operação realizada com sucesso");

                alert.showAndWait();

                // apagar labels
                apagarTextos();

                //salvar no arquivo
                controladorLivro.salvarLivrosEmArquivo("Livraria_Rural/livros.ser");

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar livro");
                alert.setHeaderText("Quantidade inválida");
                alert.setContentText("Digite uma quantidade que não seja negativa");

                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alterar livro");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Confira se os campos estão preenchidos corretamente");

            alert.showAndWait();
        }

    }

    @FXML
    void btnEditarLivroVoltar(ActionEvent event) throws IOException {
        irParaTelaADM(event);
    }

    @FXML
    void btnCarregarLivro(ActionEvent event) {
        // carregar informações do livro
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        Livro livroBuscado = null;
        try {
            livroBuscado = controladorLivro.buscarLivroPorId(Long.parseLong(idLivro.getText()));
            if (livroBuscado == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar livro");
                alert.setHeaderText("Não existe livro com esse id");
                alert.setContentText("Digite um ID existente");

                alert.showAndWait();
            } else {
                livro = livroBuscado;
                preencherTextos();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alterar livro");
            alert.setHeaderText("Caracteres Inválidos");
            alert.setContentText("Digite um ID de livro");

            alert.showAndWait();
        }
    }
    public void preencherTextos() {
        autorEditarLivro.setText(livro.getAutor());
        tituloEditarLivro.setText(livro.getTitulo());
        edicaoEditarLivro.setText(livro.getEdicao());
        editoraEditarLivro.setText(livro.getEditora());
        generoEditarLivro.setText(livro.getGenero());
        sinopseEditarLivro.setText(livro.getSinopse());
        precoEditarLivro.setText(String.format(Locale.US, "%.2f", livro.getPreco()));
        quantidadeNoEstoqueEditarLivro.setText(String.format("%d", livro.getQuantidadeNoEstoque()));
    }
    public void apagarTextos() {
        idLivro.clear();
        autorEditarLivro.clear();
        tituloEditarLivro.clear();
        edicaoEditarLivro.clear();
        editoraEditarLivro.clear();
        generoEditarLivro.clear();
        sinopseEditarLivro.clear();
        precoEditarLivro.clear();
        quantidadeNoEstoqueEditarLivro.clear();
    }

    public void irParaTelaADM (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("ADM");
        stage.setResizable(false);
    }

}