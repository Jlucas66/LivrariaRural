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
    public void inserirLivro(Livro livro) {
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
            }
        }
    }

        // removerLivro
    public void removerLivro(Livro livro) {
        if (livro != null) {
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    repositorioLivro.remove(livro);
                    break;
                }
            }
        }
    }
    public void removerLivroPorId(long id) {
        repositorioLivro.removeIf(liv -> liv.getId() == id);
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
    public void atualizarTitulo(Livro livro, String novoTitulo) {
        if (livro != null && novoTitulo != null && !novoTitulo.isEmpty()) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setTitulo(novoTitulo);
            }
        }
    }
    public void atualizarAutor(Livro livro, String novoAutor) {
        if (livro != null && novoAutor != null && !novoAutor.isEmpty()) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setAutor(novoAutor);
            }
        }
    }
    public void atualizarGenero(Livro livro, String novoGenero) {
        if (livro != null && novoGenero != null && !novoGenero.isEmpty()) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setGenero(novoGenero);
            }
        }
    }
    public void atualizarSinopse(Livro livro, String novaSinopse) {
        if (livro != null && novaSinopse != null && !novaSinopse.isEmpty()) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setSinopse(novaSinopse);
            }
        }
    }
    public void atualizarEditora(Livro livro, String novaEditora) {
        if (livro != null && novaEditora != null && !novaEditora.isEmpty()) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setEditora(novaEditora);
            }
        }
    }
    public void atualizarEdicao(Livro livro, String novaEdicao) {
        if (livro != null && novaEdicao != null && !novaEdicao.isEmpty()) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setEdicao(novaEdicao);
            }
        }
    }
    public void atualizarPreco(Livro livro, double novoPreco) {
        if (livro != null && novoPreco >= 0) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setPreco(novoPreco);
            }
        }
    }
    public void atualizarQuantidadeEstoque(Livro livro, int novaQuantidade) {
        if (livro != null && novaQuantidade >= 0) {
            boolean livroExisteNoRepositorio = false;
            for (Livro liv : repositorioLivro) {
                if (liv.equals(livro)) {
                    livroExisteNoRepositorio = true;
                    break;
                }
            }
            if (livroExisteNoRepositorio) {
                livro.setQuantidadeNoEstoque(novaQuantidade);
            }
        }
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
