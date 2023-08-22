package dados;

import beans.Livro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    public void carregarLivrosDoArquivo(String arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 3) {
                    Livro livro = new Livro(Long.parseLong(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[5], partes[6], Double.parseDouble(partes[7]), Integer.parseInt(partes[8]));
                    this.repositorioLivro.add(livro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Livro> listaLivroPorTitulo(String titulo){
        List<Livro> livrosPorTitulo  =new ArrayList<>();
        for(Livro livro:repositorioLivro){
            if(livro.getTitulo().contains(titulo)){
                livrosPorTitulo.add(livro);
            }
        }
        return livrosPorTitulo;
    }

    public List<Livro> listarLivrosPorAutor(String autor){
        List<Livro> livrosPorAutor  =new ArrayList<>();
        for(Livro livro:repositorioLivro){
            if(livro.getAutor().contains(autor)){
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> listarLivrosComMediaMaiorQue(int nota){
        List<Livro> livrosComMediaMaiorQue = new ArrayList<>();
        for(Livro livro:repositorioLivro){
            if(livro.calcularMediaDeAvaliacoes()>=nota){
                livrosComMediaMaiorQue.add(livro);
            }
        }
        return livrosComMediaMaiorQue;
    }

    public List<Livro> listarLivroPorGenero(String categoria){
        List <Livro> livrosPorGenero=new ArrayList<>();
        for(Livro livro:repositorioLivro){
            if(livro.getGenero().equalsIgnoreCase(categoria)){
                livrosPorGenero.add(livro);
            }
        }
        return livrosPorGenero;
    }


    // Getters
    public ArrayList<Livro> getRepositorioLivro() {
        return repositorioLivro;
    }



}
