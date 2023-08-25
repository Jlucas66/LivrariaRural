package grid.gridpanedinamica;

import Model.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox cardLayoout;
private List<Book> livros;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
livros = new ArrayList<>(livros());
try {
    for(int i = 0; i < livros.size(); i++){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("card.fxml"));
        HBox cardBox = fxmlLoader.load();
        CardController cardController = fxmlLoader.getController();
        cardController.setData(livros.get(i));
        cardLayoout.getChildren().add(cardBox);
    }

} catch (IOException e){
    e.printStackTrace();
}
    }
    private List<Book> livros(){
        List<Book> ls = new ArrayList<>();
        Book book1 = new Book();
        book1.setNome("Crepúsculo");
        book1.setCapa("@../../../../../../../OneDrive/Área%20de%20Trabalho/exemplo_capa2.jpg");
        book1.setPreco("R$ 50,00");
        ls.add(book1);

        Book book2 = new Book();
        book2.setNome("Crepúsculo 2");
        book2.setCapa("@../../../../../../../OneDrive/Área%20de%20Trabalho/exemplo_capa2.jpg");
        book2.setPreco("R$ 60,00");
        ls.add(book2);

        Book book3 = new Book();
        book3.setNome("Crepúsculo 3");
        book3.setCapa("@../../../../../../../OneDrive/Área%20de%20Trabalho/exemplo_capa2.jpg");
        book3.setPreco("R$ 70,00");
        ls.add(book3);

        return ls;
    }
}
