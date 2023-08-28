package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaAdmControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Fx: ID
    @FXML
    private ImageView logo;
    @FXML
    private Label bemVindoADM;
    @FXML
    private Button botaoCadastrarLivros;
    @FXML
    private Button botaoListaDeLivros;
    @FXML
    private Button botaoEditarLivros;
    @FXML
    private Button botaoListaDePromocoes;
    @FXML
    private Button botaoCadastrarAdministradores;
    @FXML
    private Button botaoCadastrarNovasPromocoes;
    @FXML
    private Button botaoRelatorioDeCompras;
    @FXML
    private Button botaoSair;

    //On Action
    @FXML
    public void btnADMListaDeLivros (ActionEvent event) throws IOException{
        // vai para tela de lista de livros
        irParaTelaListaLivros(event);
    }
    @FXML
    public void btnADMEditarLivros(ActionEvent event) throws IOException{
        // vai para tela de editar livros
    }
    @FXML
    public void btnADMListaDePromocoes(ActionEvent event) throws IOException{
        // vai para tela de lista de promoções
        irParaTelaListaPromocoes(event);
    }
    @FXML
    public void btnADMCadastrarLivros (ActionEvent event) throws IOException {
        // vai para tela de cadastro de livro
        irParaTelaCadastroLivro(event);

    }
    @FXML
    public void btnADMCadastrarAdministradores (ActionEvent event) throws IOException{

        // vai para tela de cadastro de adm
        irParaTelaCadastroAdm(event);
    }

    @FXML
    public void btnADMCadastrarNovasPromocoes (ActionEvent event) throws IOException{
        irParaTelaCadastroPromocao(event);
    }

    @FXML
    public void btnADMRelatorioDeCompras (ActionEvent event) throws IOException{
        // vai pra tela relatorio
        root = FXMLLoader.load(getClass().getResource("tela_relatorio.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Relatorio de vendas");
        stage.setResizable(false);

    }
    @FXML
    public void btnADMListaDeClientes (ActionEvent event) throws IOException{

    }
    @FXML
    public void btnADMSair (ActionEvent event) throws IOException{
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
    public void irParaTelaCadastroAdm (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_cadastro_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro de Administrador");
        stage.setResizable(false);
    }
    public void irParaTelaCadastroLivro (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_cadastro_livro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro de Livro");
        stage.setResizable(false);
    }
    public void irParaTelaCadastroPromocao (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_cadastro_promocao.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro de Promocao");
        stage.setResizable(false);
    }
    public void irParaTelaListaPromocoes (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_lista_promocoes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Promocoes cadastradas");
        stage.setResizable(false);
    }
    public void irParaTelaListaLivros (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_lista_livros.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Livros cadastrados");
        stage.setResizable(false);
    }
}
