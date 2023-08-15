package dados;

import beans.Livro;
import beans.Pessoa;

import java.util.ArrayList;

public class RepositorioLivro implements IRepositorioLivro {

    // Atributos
    private ArrayList<Livro> repositorioLivro;

    // Construtor
    public RepositorioLivro() {
        this.repositorioLivro = new ArrayList<>();
    }

    // Metodos CRUD

        // inserirLivro
    public boolean inserirLivro(Livro livro) {
        boolean inseriu = false;
        if (livro != null) {
            boolean temLivroIgual = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {            // equals de livro por id
                    temLivroIgual = true;
                    break;
                }
            }
            if (!temLivroIgual) {
                repositorioLivro.add(livro);
                inseriu = true;
            }
        }
        return inseriu;
    }

        // removerLivro
    public boolean removerLivro(Livro livro) {
        boolean removeu = false;
        if (livro != null) {
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    repositorioLivro.remove(livro);
                    removeu = true;
                    break;
                }
            }
        }
        return removeu;
    }

    public boolean removerLivroPorId(long id) {
        boolean removeu = false;
        for (Livro liv : repositorioLivro) {
            if (liv.getId() == id) {
                repositorioLivro.remove(liv);
                removeu = true;
            }
        }
        return removeu;
    }

        // buscarLivro
    public Livro buscarLivroPorId(long id) {        // falta tratar para id inexistente
        Livro livroBuscado = null;
        int indice = 0;
        for (Livro liv : repositorioLivro) {
            if (liv.getId() == id) {
                livroBuscado = repositorioLivro.get(indice);
            }
            indice++;
        }
        return livroBuscado;
    }

        // atualizarLivro
    public boolean atualizarLivroComMesmoId(Livro novoLivro) {
        boolean atualizou = false;
        boolean livroExiste = false;
        Livro livroAtualizado = null;
        for (Livro liv : repositorioLivro) {
            if (liv.equals(novoLivro)) {
                livroExiste = true;
                livroAtualizado = liv;
                break;
            }
        }
        if (livroExiste) {
            // atualizar
            livroAtualizado.setTitulo(novoLivro.getTitulo());
            livroAtualizado.setAutor(novoLivro.getAutor());
            livroAtualizado.setGenero(novoLivro.getGenero());
            livroAtualizado.setSinopse(novoLivro.getSinopse());
            livroAtualizado.setEditora(novoLivro.getEditora());
            livroAtualizado.setEdicao(novoLivro.getEdicao());
            livroAtualizado.setPreco(novoLivro.getPreco());
            livroAtualizado.setQuantidadeNoEstoque(novoLivro.getQuantidadeNoEstoque());
            livroAtualizado.setAvaliacoes(novoLivro.getAvaliacoes());

            atualizou = true;

        }
        return atualizou;
    }


    // listarLivroPorTitulo
    // listarLivroPorGenero
    // listarLivroPorAutor
    // listarLivroPorEditora
    // listarLivroPorFaixaDePreco
    // listarLivroComMediaAvaliacaoIgualOuMaiorQue


    // Getters
    public ArrayList<Livro> getRepositorioLivro() {
        return repositorioLivro;
    }

}
