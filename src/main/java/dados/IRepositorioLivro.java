package dados;

import beans.Livro;

import java.util.ArrayList;

public interface IRepositorioLivro {

    // Metodos CRUD

        // inserir
    boolean inserirLivro(Livro livro);

        // remover
    boolean removerLivro(Livro livro);
    boolean removerLivroPorId(long id);

        // buscar
    Livro buscarLivroPorId(long id);

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
    ArrayList<Livro> getRepositorioLivro();
}
