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
    public ItemVenda criarItemVenda(Livro livro, int quantidade) {
        //boolean criadoComSucesso = false;
        ItemVenda item = null;
        if (livro != null && quantidade > 0 && quantidade <= livro.getQuantidadeNoEstoque()) {
            // atributos validados, o item venda pode ser criado
            item = new ItemVenda(livro, quantidade);

            // adicionar no arrayList<> de vendas


            //criadoComSucesso = true;
        }
        //return criadoComSucesso;
        return item;
    }
}
