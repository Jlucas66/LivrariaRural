import beans.ItemVenda;
import beans.Venda;
import dados.RepositorioVenda;

import java.util.ArrayList;

public class ControladorVenda {

    // Atributos
    private RepositorioVenda repo;
    private static ControladorVenda instance;

    // Construtor
    private ControladorVenda() {
        this.repo = new RepositorioVenda();
    }
    public static ControladorVenda getInstance() {
        if (instance == null) {
            instance = new ControladorVenda();
        }
        return instance;
    }

    // Metodos

    // criar a venda - validar se a venda tem todos os atributos válidos
    // cadastrar a venda - colocar a venda dentro do repositório
    // colocar itens dentro da venda - recebe objeto itemvenda e add no arraylist de itens venda
    // aplicar desconto - esse foi no controlador promocao
    // atualizar status - vai manter?
    // diminuir qtd do livro - vai ser no controlador venda, ou no de livro?
    public void diminuirQtd(ItemVenda itemVendido) {
        if (itemVendido != null && itemVendido.getLivro() != null) {
            itemVendido.getLivro().setQuantidadeNoEstoque(itemVendido.getLivro().getQuantidadeNoEstoque() - itemVendido.getQuantidade());
        }
    }


    // delegates - remover, buscar, listar

    public boolean removerVendaPorId(long id) {
        return repo.removerVendaPorId(id);
    }
    public Venda buscarVendaPorId(long id) {
        return repo.buscarVendaPorId(id);
    }

    // delegate dos listar




    // Getters
    public ArrayList<Venda> getRepositorioVenda() {
        return repo.getRepositorioVenda();
    }

}
