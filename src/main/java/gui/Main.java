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


        LocalDate d1= LocalDate.of(2003,4,26);

        //controladorPessoa.criarECadastrarPessoa("Caio Gabriel","caio@email.com","1234",
                //"rua a", d1);
        //controladorPessoa.salvarPessoasEmArquivo("Livraria_Rural/pessoas.ser");
        /*LocalDate d1Inicio=LocalDate.of(2023,8,1);
        LocalDate d1Fim=LocalDate.of(2023,8,30);
        controladorPromocao.cadastraNovaPromocao(d1Inicio,d1Fim,5,"Dia dos Pais");
        controladorPromocao.salvarPromocaoEmArquivo("Livraria_Rural/promocao.ser");

        */


        //controladorPessoa.criarECadastrarAdministrador("Administrador", "adm@email.com", "1234", "Rua qualquer", LocalDate.of(1989,3,25));
       // controladorPessoa.salvarPessoasEmArquivo("Livraria_Rural/pessoas.ser");
        // carregar livros do arquivo CSV
        //controladorLivro.carregarLivrosDoArquivo("Livraria_Rural/livros.csv");
        //controladorPessoa.carregarPessoasDoArquivo("Livraria_Rural/pessoas.csv");

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
