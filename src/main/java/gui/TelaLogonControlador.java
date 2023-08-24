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
        // Carregar a imagem
        Image imagem = new Image(getClass().getResourceAsStream("logo_livraria.png"));

        // Definir a imagem no ImageView
        logo.setImage(imagem);
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
        // se o email existir no repositório
        // se a senha for igual a da pessoa do repositorio
        // aí pode ir pra tela do cliente
        ControladorPessoa cPessoa = ControladorPessoa.getInstance();
        ControladorVenda cVenda = ControladorVenda.getInstance();

        if (cPessoa.buscarPessoaPorEmail(emailLogon.getText()) != null
                && cPessoa.buscarPessoaPorEmail(emailLogon.getText()).getSenha().equals(senhaLogon.getText())) {
            Pessoa pessoaLogada = cPessoa.buscarPessoaPorEmail(emailLogon.getText());
            irParaTelaInicialCliente(event, pessoaLogada);

            // aqui também vai criar uma venda , a pessoa que acessou o sistema, e a lista de itens vai estar vazia.
            // talvez já tenha que inserir essa venda no repositorio - pra conseguir usar nas outras telas
            if (cVenda.inserirVenda(new Venda(pessoaLogada))) {
                System.out.println("Venda iniciada..:");
                System.out.println(cVenda.buscarUltimaVendaDoRepo().getPessoa().getNome());
            }

        } else {

            // aqui vem o alerta
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Entrada");
            alert.setHeaderText("Erro ao tentar entrar");
            alert.setContentText("Email não existe, ou a senha está errada ou, campo não preenchido!");

            alert.showAndWait();
            System.out.println("pessoa não existe, ou a senha está errada .");

            System.out.println("ALERT: pessoa não existe, ou a senha está errada.");
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
    public void irParaTelaInicialCliente (ActionEvent event, Pessoa pessoa) throws IOException{
        //root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tela_inicial_cliente.fxml"));
        root = loader.load();

        //TelaInicialClienteControlador telaInicialClienteControlador = loader.getController();
        //telaInicialClienteControlador.receberPessoa(pessoa);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Catálogo");
        stage.setResizable(false);
    }
}
