package gui;

import beans.Livro;
import beans.Pessoa;
import beans.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorPessoa;
import negocio.ControladorVenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelaLogonControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {

    }

    @FXML
    private Button botaoCadastrar;
    @FXML
    private Button botaoEntrar;
    @FXML
    private TextField emailLogon;
    @FXML
    private PasswordField senhaLogon;
    @FXML
    private ImageView logo;

    @FXML
    public void btnLogonEntrar(ActionEvent event) throws IOException{
        ControladorPessoa controladorPessoa = ControladorPessoa.getInstance();
        ControladorVenda controladorVenda = ControladorVenda.getInstance();

        if (controladorPessoa.buscarPessoaPorEmail(emailLogon.getText()) != null
                && controladorPessoa.buscarPessoaPorEmail(emailLogon.getText()).getSenha().equals(senhaLogon.getText())) {
            Pessoa pessoaLogada = controladorPessoa.buscarPessoaPorEmail(emailLogon.getText());

            if (!pessoaLogada.isAdministrador()) {
                irParaTelaInicialCliente(event);

                // aqui também vai criar uma venda, a pessoa que acessou o sistema, e a lista de itens vai estar vazia.
                if (controladorVenda.inserirVenda(new Venda(pessoaLogada))) {
                    System.out.println("Venda iniciada..:");
                }

            } else {
                // vai para a tela de adm
                irParaTelaAdm(event);
            }

        } else {

            // aqui vem o alerta
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Entrada");
            alert.setHeaderText("Erro ao tentar entrar");
            alert.setContentText("Email não existe, ou a senha está errada ou, campo não preenchido!");

            alert.showAndWait();
        }
    }

    @FXML
    public void btnLogonCadastrar(ActionEvent event)throws IOException {
       irParaTelaCadastro(event);
    }

    public void irParaTelaCadastro (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_cadastro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastre-se");
        stage.setResizable(false);
    }
    public void irParaTelaInicialCliente (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_inicial_cliente.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Catálogo");
        stage.setResizable(false);
    }

    public void irParaTelaAdm (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_adm.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Administrador");
        stage.setResizable(false);
    }


}
