package gui;

import beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControladorPessoa;

import java.io.IOException;

public class TelaCadastroAdmControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView logo;

    @FXML
    private TextField nomeCadastroADM;

    @FXML
    private TextField emailCadastroADM;

    @FXML
    private PasswordField senhaCadastroADM;

    @FXML
    private TextField enderecoCadastroADM;

    @FXML
    private DatePicker dataDeNascimentoCadastroADM;

    @FXML
    private Button cadastrarCadastroADM;

    @FXML
    private Button voltarCadastroADM;

    @FXML
    public void btnCadastroADMCadastrar(ActionEvent event) throws IOException{
        // se estiver com todos os campos validados, pode cadastrar com o metodo criarECadastrarAdministrador
        // se tudo bem, voltar para tela de logon
        ControladorPessoa cPessoa = ControladorPessoa.getInstance();

        if (cPessoa.criarECadastrarAdministrador(nomeCadastroADM.getText(), emailCadastroADM.getText(), senhaCadastroADM.getText(), enderecoCadastroADM.getText(), dataDeNascimentoCadastroADM.getValue())) {

            // atualizar repositório
            cPessoa.salvarPessoasEmArquivo("Livraria_Rural/pessoas.ser");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro Administrador");
            alert.setHeaderText(null);
            alert.setContentText("Administrador cadastrado com sucesso!");

            alert.showAndWait();

            // mudar de tela
            irParaTelaAdm(event);

        } else {

            // alerta de que algum campo está vazio ou o email já existe
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastrar");
            alert.setHeaderText("Erro ao tentar cadastrar");
            alert.setContentText("Email já existente ou campos não preenchidos!");

            alert.showAndWait();

        }
    }

    @FXML
    public void btnCadastroADMVoltar(ActionEvent event) throws IOException{
        // voltar para a tela de adm
        irParaTelaAdm(event);

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
    public void irParaTelaAdm (ActionEvent event) throws IOException{
        //root = FXMLLoader.load(getClass().getResource("tela_inicial_cliente.fxml"));
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
