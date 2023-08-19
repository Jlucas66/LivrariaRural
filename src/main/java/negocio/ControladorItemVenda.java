package negocio;

import beans.ItemVenda;
import beans.Livro;

public class ControladorItemVenda {
    // Atributos
    private static ControladorItemVenda instance;

    // Construtor
    private ControladorItemVenda() {}
    public static ControladorItemVenda getInstance() {
        if (instance == null) {
            instance = new ControladorItemVenda();
        }
        return instance;
    }

    // Metodos

    // livro vira do repositorio de livro, então já está validado.
    public boolean criarItemVenda(Livro livro, int quantidade) {
        boolean criadoComSucesso = false;
        if (livro != null && quantidade > 0 && quantidade <= livro.getQuantidadeNoEstoque()) {
            // atributos validados, o item venda pode ser criado
            ItemVenda item = new ItemVenda(livro, quantidade);
            criadoComSucesso = true;
        }
        return criadoComSucesso;
    }
}
