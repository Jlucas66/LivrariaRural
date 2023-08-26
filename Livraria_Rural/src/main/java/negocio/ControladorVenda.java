package negocio;

import beans.ItemVenda;
import beans.Livro;
import beans.Pessoa;
import beans.Venda;
import dados.IRepositorioVenda;
import dados.RepositorioVenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorVenda {

    // Atributos
    private IRepositorioVenda repo;
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

    // remover itens da venda - recebe livro e remove do arraylist de itensvenda, se existir
    public boolean removerItensDaVenda(Venda venda, Livro livro) {
        boolean removidoComSucesso = false;
        for (int i = 0; i < venda.getItensDaVenda().size(); i++) {
            if (venda.getItensDaVenda().get(i).getLivro().equals(livro)) {
                venda.getItensDaVenda().remove(i);
            }
        }

        return removidoComSucesso;
    }


    public void diminuirQtd(ItemVenda itemVendido) {
        if (itemVendido != null && itemVendido.getLivro() != null) {
            itemVendido.getLivro().setQuantidadeNoEstoque(itemVendido.getLivro().getQuantidadeNoEstoque() - itemVendido.getQuantidade());
        }
    }
    public void aumentarQtdsDeVariosLivros(Venda venda) {
        if (!venda.getItensDaVenda().isEmpty()) {
            for (ItemVenda it : venda.getItensDaVenda()) {
                it.getLivro().setQuantidadeNoEstoque(it.getLivro().getQuantidadeNoEstoque() + it.getQuantidade());
            }
        }
    }
    public void aumentarQtdDoUltimoLivro(Venda venda) {
        if(!venda.getItensDaVenda().isEmpty()) {
            ItemVenda ultimoItem = venda.getItensDaVenda().get(venda.getItensDaVenda().size()-1);
            ultimoItem.getLivro().setQuantidadeNoEstoque(ultimoItem.getLivro().getQuantidadeNoEstoque() + ultimoItem.getQuantidade());
        }
    }
    public void aumentarQtdDeLivro(ItemVenda itemRemovido) {

        itemRemovido.getLivro().setQuantidadeNoEstoque(itemRemovido.getLivro().getQuantidadeNoEstoque() + itemRemovido.getQuantidade());
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

    public boolean removerUltimaVendaDoRepo() {
        return repo.removerUltimaVendaDoRepo();
    }

    public Venda buscarVendaPorId(long id) {
        return repo.buscarVendaPorId(id);
    }

    public boolean atualizarVendaComMesmoId(Venda novaVenda) {
        return repo.atualizarVendaComMesmoId(novaVenda);
    }

    // delegate dos listar
    public List<Venda> listarVendasPorPessoa(Pessoa pessoa) {
        return repo.listarVendasPorPessoa(pessoa);
    }
    public List<Venda> listarVendasPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repo.listarVendasPorPeriodo(inicio, fim);
    }

    public String imprimirItensVenda(Venda venda) {
        return repo.imprimirItensVenda(venda);
    }

    public Venda buscarUltimaVendaDoRepo() {
        return repo.buscarUltimaVendaDoRepo();
    }

    public void salvarVendasEmArquivo(String nomeArquivo) {
        repo.salvarVendasEmArquivo(nomeArquivo);
    }

    public void carregarVendasDeArquivo(String nomeArquivo) {
        repo.carregarVendasDeArquivo(nomeArquivo);
    }

    // Getters
    public ArrayList<Venda> getRepositorioVenda() {
        return repo.getRepositorioVenda();
    }







}
