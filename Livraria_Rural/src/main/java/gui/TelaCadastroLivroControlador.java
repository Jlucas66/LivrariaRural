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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import negocio.ControladorLivro;

import java.io.IOException;

public class TelaCadastroLivroControlador {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private ImageView logo;

    @FXML
    private TextField idCadastroLivro;

    @FXML
    private TextArea tituloCadastroLivro;

    @FXML
    private TextField autorCadastroLivro;

    @FXML
    private TextField generoCadastroLivro;

    @FXML
    private TextArea sinopseCadastroLivro;

    @FXML
    private TextField editoraCadastroLivro;

    @FXML
    private TextField edicaoCadastroLivro;

    @FXML
    private TextField precoCadastroLivro;

    @FXML
    private TextField quantidadeNoEstoqueCadastroLivro;

    @FXML
    public void btnCadastroLivroCadastrar(ActionEvent event) throws IOException{
        ControladorLivro cLivro=ControladorLivro.getInstance();
        boolean erroConvercaoNum=false;
        double preco=-1;
        int qtd=-1;
        long id=-1;

        try{
            preco=Double.parseDouble(precoCadastroLivro.getText());
            id=Long.parseLong(idCadastroLivro.getText());
            qtd=Integer.parseInt(quantidadeNoEstoqueCadastroLivro.getText());
        }
        catch (NumberFormatException e){
            erroConvercaoNum=true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastrar Livro");
            alert.setHeaderText("Erro ao cadastrar livro");
            alert.setContentText("Valores digitados em preço, quantidade ou id não são valores inteiros ou, os campos estão vazios !");

            alert.showAndWait();

        }

        if(!erroConvercaoNum){
            if(preco >0 && qtd>0 && id>0){
                if(idCadastroLivro.getText()!=null&& tituloCadastroLivro.getText()!=null&& autorCadastroLivro.getText()!=null&&
                        generoCadastroLivro.getText()!=null&& sinopseCadastroLivro.getText()!=null
                        &&editoraCadastroLivro.getText()!=null&& edicaoCadastroLivro.getText()!=null ){
                    //criando livro
                    Livro  livro=new Livro(id,tituloCadastroLivro.getText(), autorCadastroLivro.getText(),
                            generoCadastroLivro.getText(), sinopseCadastroLivro.getText(), editoraCadastroLivro.getText(),
                            edicaoCadastroLivro.getText(), preco,qtd);
                    if(cLivro.cadastrarLivro(livro)){

                        cLivro.salvarLivrosEmArquivo("Livraria_Rural/livros.ser");
                        irParaTelaAdm(event);
                        // alerta de sucesso
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Cadastrar Livro");
                        alert.setHeaderText(String.format("%s", livro.getTitulo()));
                        alert.setContentText("Cadastrado com sucesso!");

                        alert.showAndWait();
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Cadastrar Livro");
                        alert.setHeaderText("Erro ao cadastrar livro");
                        alert.setContentText("Livro com mesmo Id já existente ou os campos estão vazios !");

                        alert.showAndWait();
                    }

                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastrar Livro");
                alert.setHeaderText("Erro ao cadastrar livro");
                alert.setContentText("Os valores de Preço, Quantidade e Id de livros não podem ser 0!");

                alert.showAndWait();
            }

        }

    }

    @FXML
    public void btnCadastroLivroCancelar(ActionEvent event) throws IOException{
        // volta para tela adm
        irParaTelaAdm(event);
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
