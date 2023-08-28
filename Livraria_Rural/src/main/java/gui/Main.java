package gui;

import beans.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.ControladorLivro;
import negocio.ControladorPessoa;
import negocio.ControladorPromocao;
import negocio.ControladorVenda;

import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application {

@Override
public void start(Stage stage) throws IOException {
    try{
        ControladorLivro controladorLivro = ControladorLivro.getInstance();
        ControladorPessoa controladorPessoa = ControladorPessoa.getInstance();
        ControladorVenda controladorVenda = ControladorVenda.getInstance();
        ControladorPromocao controladorPromocao=ControladorPromocao.getInstance();


        // carregar repositorios do arquivo serializabe
        controladorLivro.carregarLivrosDeArquivo("Livraria_Rural/livros.ser");
        controladorPessoa.carregarPessoasDeArquivo("Livraria_Rural/pessoas.ser");
        controladorVenda.carregarVendasDeArquivo("Livraria_Rural/vendas.ser");
        controladorPromocao.carregarPromocaoDeArquivo("Livraria_Rural/promocao.ser");


        Parent root = FXMLLoader.load(getClass().getResource("tela_logon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Logon");
        stage.setResizable(false);

    }catch (Exception e){
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
launch();
    }
}
