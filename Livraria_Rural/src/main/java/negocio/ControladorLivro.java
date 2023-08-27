package negocio;

import beans.ItemVenda;
import beans.Livro;
import dados.IRepositorioLivro;
import dados.RepositorioLivro;

import java.util.ArrayList;
import java.util.List;

public class ControladorLivro {

    // Atributos
    private IRepositorioLivro repo;
    private static ControladorLivro instance;

    // Construtor
    private ControladorLivro() {
        this.repo = new RepositorioLivro();
    }
    public static ControladorLivro getInstance() {
        if (instance == null) {
            instance = new ControladorLivro();
        }
        return instance;
    }

    // Metodos

    // diminuirQtdDoEstoque - livro e qdtVendida virão dos itens da venda, já verificados para não serem válidos
    public void diminuirQtdDoLivro(ItemVenda itemVendido) {
        if (itemVendido != null && itemVendido.getLivro() != null) {
            repo.buscarLivroPorId(itemVendido.getLivro().getId()).setQuantidadeNoEstoque(itemVendido.getLivro().getQuantidadeNoEstoque() - itemVendido.getQuantidade());
        }
    }
    public void aumentarQtdDoLivro(ItemVenda itemRemovidoDaVenda) {
        repo.buscarLivroPorId(itemRemovidoDaVenda.getLivro().getId()).setQuantidadeNoEstoque(itemRemovidoDaVenda.getLivro().getQuantidadeNoEstoque() + itemRemovidoDaVenda.getQuantidade());
    }

    // alterarPrecoDoLivro - alteração só do preço de um livro existente
    public void mudarPrecoDoLivro(Livro livro, double novoPreco) {
        if (livro != null) {
            repo.buscarLivroPorId(livro.getId()).setPreco(novoPreco);
        }
    }

    // cadastrar - verificar se os atributos de livro são válidos
    public boolean cadastrarLivro(Livro livro) {

        boolean cadastradoComSucesso = false;

        if (livro != null && livro.getId() > 0
        && livro.getTitulo() != null && !livro.getTitulo().isEmpty()
        && livro.getAutor() != null && !livro.getAutor().isEmpty()
        && livro.getGenero() != null && !livro.getGenero().isEmpty()
        && livro.getSinopse() != null && !livro.getSinopse().isEmpty()
        && livro.getEditora() != null && !livro.getEditora().isEmpty()
        && livro.getEdicao() != null && !livro.getEdicao().isEmpty()
        && livro.getPreco() >= 0 && livro.getQuantidadeNoEstoque() >=0) {
            // livro tem todos os atributos válidos e pode ser cadastrado
            cadastradoComSucesso = repo.inserirLivro(livro);
        }
        return cadastradoComSucesso;
    }

    // alterar - verificar se os atributos do novoLivro são válidos
    public boolean atualizarLivro(Livro novoLivro) {

        boolean atualizadoComSucesso = false;

        if (novoLivro != null && novoLivro.getId() > 0
                && novoLivro.getTitulo() != null && !novoLivro.getTitulo().isEmpty()
                && novoLivro.getAutor() != null && !novoLivro.getAutor().isEmpty()
                && novoLivro.getGenero() != null && !novoLivro.getGenero().isEmpty()
                && novoLivro.getSinopse() != null && !novoLivro.getSinopse().isEmpty()
                && novoLivro.getEditora() != null && !novoLivro.getEditora().isEmpty()
                && novoLivro.getEdicao() != null && !novoLivro.getEdicao().isEmpty()
                && novoLivro.getPreco() >= 0 && novoLivro.getQuantidadeNoEstoque() >=0) {
            // livro tem todos os atributos válidos e pode substituir
            atualizadoComSucesso = repo.atualizarLivroComMesmoId(novoLivro);
        }
        return atualizadoComSucesso;
    }


    // delegate - remover, buscar, listar

    public boolean removerLivro(Livro livro) {
        return repo.removerLivro(livro);
    }
    public boolean removerLivroPorId(long id) {
        return repo.removerLivroPorId(id);
    }
    public Livro buscarLivroPorId(long id) {
        return repo.buscarLivroPorId(id);
    }


    // delegate dos listar


    public List<Livro> listaLivroPorTituloOuAutor(String busca, String genero) {
        return repo.listaLivroPorBusca(busca, genero);
    }

    public List<Livro> listaLivroPorTitulo(String titulo) {
        return repo.listaLivroPorTitulo(titulo);
    }

    public List<Livro> listarLivrosPorAutor(String autor) {
        return repo.listarLivrosPorAutor(autor);
    }

    public List<Livro> listarLivrosComMediaMaiorQue(int nota) {
        return repo.listarLivrosComMediaMaiorQue(nota);
    }

    public List<Livro> listarLivroPorGenero(String categoria) {
        return repo.listarLivroPorGenero(categoria);
    }

    public void carregarLivrosDoArquivo(String arquivo) {
        repo.carregarLivrosDoArquivo(arquivo);
    }
    public void salvarLivrosEmArquivo(String nomeArquivo) {
        repo.salvarLivrosEmArquivo(nomeArquivo);
    }
    public void carregarLivrosDeArquivo(String nomeArquivo) {
        repo.carregarLivrosDeArquivo(nomeArquivo);
    }


    // Getters


    public ArrayList<Livro> getRepositorioLivro() {
        return repo.getRepositorioLivro();
    }
}
