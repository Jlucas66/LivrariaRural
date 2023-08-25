package grid.gridpanedinamica;

import Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CardController {
    @FXML
    private Button botaoMaisDetalhes;

    @FXML
    private AnchorPane box;

    @FXML
    private ImageView capaDoLivro;

    @FXML
    private Label precoDoLivro;

    @FXML
    private Label tituloDoLivro;

    @FXML
    void btnCardMaisDetalhes(ActionEvent event) throws IOException {

    }
    public void setData(Book book){
        Image image = new Image(getClass().getResourceAsStream(book.getCapa()));
        capaDoLivro.setImage(image);
        tituloDoLivro.setText(book.getNome());
        precoDoLivro.setText(book.getPreco());
    }
}
