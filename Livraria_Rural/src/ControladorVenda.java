import beans.ItemVenda;
import beans.Pessoa;
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

    // criar a venda - validar se a venda tem todos os atributos válidos - não precisa, acho

    // cadastrar a venda - colocar a venda dentro do repositório
    public boolean inserirVenda(Venda venda) {
        boolean cadastradoComSucesso = false;
        if (venda != null && venda.getPessoa() != null) {
            cadastradoComSucesso = repo.inserirVenda(venda);
        }

        return cadastradoComSucesso;
    }

    // colocar itens dentro da venda - recebe objeto itemvenda e add no arraylist de itens venda
    public boolean colocarItensNaVenda(Venda venda, ItemVenda itemVendido) {
        boolean colocadoComSucesso = false;
        if (itemVendido != null) {
            venda.getItensDaVenda().add(itemVendido);
            colocadoComSucesso = true;
        }
        return colocadoComSucesso;
    }

    // aplicar desconto - esse foi no controlador promocao

    // atualizar status - vai manter?
    // diminuir qtd do livro - vai ser no controlador venda, ou no de livro?
    public void diminuirQtd(ItemVenda itemVendido) {
        if (itemVendido != null && itemVendido.getLivro() != null) {
            itemVendido.getLivro().setQuantidadeNoEstoque(itemVendido.getLivro().getQuantidadeNoEstoque() - itemVendido.getQuantidade());
        }
    }

    // atualizar venda (caso precise alterar alguma coisa)
    public boolean atualizarVenda(Venda novaVenda) {
        boolean atualizadoComSucesso = false;
        if (novaVenda != null && novaVenda.getPessoa() != null) {
            atualizadoComSucesso = repo.atualizarVendaComMesmoId(novaVenda);
        }
        return atualizadoComSucesso;
    }


    // delegates - remover, buscar, listar

    public boolean removerVendaPorId(long id) {
        return repo.removerVendaPorId(id);
    }
    public Venda buscarVendaPorId(long id) {
        return repo.buscarVendaPorId(id);
    }
    public boolean atualizarVendaComMesmoId(Venda novaVenda) {
        return repo.atualizarVendaComMesmoId(novaVenda);
    }
    // delegate dos listar

    // Getters
    public ArrayList<Venda> getRepositorioVenda() {
        return repo.getRepositorioVenda();
    }

}
