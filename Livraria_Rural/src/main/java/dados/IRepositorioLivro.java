package dados;

import beans.Livro;

import java.util.ArrayList;
import java.util.List;

public interface IRepositorioLivro {

    // Metodos CRUD

        // inserir
    boolean inserirLivro(Livro livro);

        // remover
    boolean removerLivro(Livro livro);
    boolean removerLivroPorId(long id);

        // buscar
    Livro buscarLivroPorId(long id);
    Livro buscaLivroGenero(String genero); 

        // atualizar
    boolean atualizarLivroComMesmoId(Livro novoLivro);
    /*
    void atualizarTitulo(Livro livro, String novoTitulo);
    void atualizarAutor(Livro livro, String novoAutor);
    void atualizarGenero(Livro livro, String novoGenero);
    void atualizarSinopse(Livro livro, String novaSinopse);
    void atualizarEditora(Livro livro, String novaEditora);
    void atualizarEdicao(Livro livro, String novaEdicao);
    void atualizarPreco(Livro livro, double novoPreco);
    void atualizarQuantidadeEstoque(Livro livro, int novaQuantidade);
    */

    void carregarLivrosDoArquivo(String arquivo);
    void salvarLivrosEmArquivo(String nomeArquivo);
    void carregarLivrosDeArquivo(String nomeArquivo);

    List<Livro> listaLivroPorBusca(String busca, String genero);
    List<Livro> listaLivroPorTitulo(String titulo);
    List<Livro> listarLivrosPorAutor(String autor);
    List<Livro> listarLivrosComMediaMaiorQue(int nota);
    List<Livro> listarLivroPorGenero(String categoria);



    ArrayList<Livro> getRepositorioLivro();
}
