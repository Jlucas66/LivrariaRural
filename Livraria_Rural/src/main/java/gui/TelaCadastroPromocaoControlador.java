package gui;

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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import negocio.ControladorPromocao;

import java.io.IOException;
import java.util.Date;

public class TelaCadastroPromocaoControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView logo;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField tipoDaPromocaoCadastroPromocao;

    @FXML
    private TextField valorDoDescontoCadastroPromocao;

    @FXML
    private DatePicker dataDeInicioCadastroPromocao;

    @FXML
    private DatePicker dataDeFimCadastroPromocao;

    @FXML
    public void btnCadastroPromocaoCadastrar(ActionEvent event) throws IOException{
        double valorDesconto=-1;
        boolean erroConveNum=false;
        try{
            valorDesconto=Double.parseDouble(valorDoDescontoCadastroPromocao.getText());
        }
        catch(NumberFormatException e){
            erroConveNum=true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastrar Promoção");
            alert.setHeaderText("Erro ao cadastrar promoção");
            alert.setContentText("Valor não inteiro digitado em valor ou os campos estão vazios !");

            alert.showAndWait();
        }
        //para não aparecer a mensagem 2 vezes
        if(!erroConveNum){
            if(valorDesconto>0){
                ControladorPromocao cPromocao=ControladorPromocao.getInstance();
                if(cPromocao.cadastraNovaPromocao(dataDeInicioCadastroPromocao.getValue(),dataDeFimCadastroPromocao.getValue(),
                        valorDesconto,tipoDaPromocaoCadastroPromocao.getText())){
                    cPromocao.salvarPromocaoEmArquivo("Livraria_Rural/promocao.ser");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Promoção");
                    alert.setHeaderText(null);
                    alert.setContentText("Promoção cadastrada!");

                    alert.showAndWait();

                    irParaTelaInicialAdm(event);
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cadastrar Promoção");
                    alert.setHeaderText("Erro ao tentar cadastrar promoção");
                    alert.setContentText("Promoção com mesmo nome ou data já existente ou os campos não preenchidos!");

                    alert.showAndWait();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastrar Promoção");
                alert.setHeaderText("Erro ao cadastrar promoção");
                alert.setContentText("Não é possível cadastrar promoção com valor 0 !");

                alert.showAndWait();
            }
        }



    }

    @FXML
    public void btnCadastroPromocaoCancelar(ActionEvent event) throws IOException{
        irParaTelaInicialAdm(event);
    }

    @FXML void irParaTelaInicialAdm(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("tela_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 560);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro de Administrador");
        stage.setResizable(false);
    }

}
