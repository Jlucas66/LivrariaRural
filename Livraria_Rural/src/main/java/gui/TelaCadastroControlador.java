package gui;

import beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorPessoa;

import java.io.IOException;
import java.time.LocalDate;

public class TelaCadastroControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        logo.setImage(new Image(getClass().getResourceAsStream("logo_livraria.png")));

    }

    @FXML
    private TextField nomeCadastro;
    @FXML
    private TextField emailCadastro;
    @FXML
    private TextField senhaCadastro;
    @FXML
    private TextField enderecoCadastro;
    @FXML
    private DatePicker dataDeNascimentoCadastro;
    @FXML
    private ImageView logo;

    @FXML
    private Button botaoCadastrar;
    @FXML
    private Button botaoVoltar;

    public void btnCadastroCadastrar(ActionEvent event)throws IOException {
        // se os campos estiverem preenchidos
        // se o email já não foi cadastrado
        // Criar nova pessoa e add ao repositório
        // se tudo bem, voltar para tela de logon
        ControladorPessoa cPessoa = ControladorPessoa.getInstance();

        if (cPessoa.criarECadastrarPessoa(nomeCadastro.getText(), emailCadastro.getText(), senhaCadastro.getText(), enderecoCadastro.getText(), dataDeNascimentoCadastro.getValue())) {
            cPessoa.salvarPessoaNoArquivo(cPessoa.buscarPessoaPorEmail(emailCadastro.getText()), "Livraria_Rural/pessoas.csv");
            cPessoa.salvarPessoasEmArquivo("Livraria_Rural/pessoas.ser");
            irParaTelaLogon(event);

        } else {

            // aqui vem o alerta de que algum campo está vazio ou o email já existe
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastrar");
            alert.setHeaderText("Erro ao tentar cadastrar");
            alert.setContentText("Email já existente ou campos não preenchidos!");

            alert.showAndWait();
            System.out.println("Pessoa não existe, ou a senha está errada .");

            System.out.println("algo está faltando ou o email já está cadastrado");
        }

        //imprimindo no sistema só pra ver se deu certo - pode apagar depois.
        for (Pessoa p : cPessoa.getRepositorioPessoa()) {
            System.out.println(p.getNome());
            System.out.println(p.getEmail());
            System.out.println(p.getSenha());
        }

    }

    public void btnCadastroVoltar(ActionEvent event) throws IOException{
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
}
