module com.exemplo.telas_livraria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.exemplo.telas_livraria to javafx.fxml;
    exports com.exemplo.telas_livraria;
}