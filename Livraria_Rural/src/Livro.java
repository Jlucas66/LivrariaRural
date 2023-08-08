import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private String sinopse;
    private String editora;
    private String edicao;
    private Double preco;
    private Integer quantidadeNoEstoque;
    private ArrayList<Avaliacao> avaliacoes;

    public Double calcularMediaDeAvaliacoes(){

        double mediaAvaliacoes = getAvaliacoes(getNota) / getAvaliacoes().size();
        // Não consigo instanciar o atributo
        // de avaliacao chamado "nota" por algum motivo... mesmo o ArrayList sendo do tipo avaliacao

        return mediaAvaliacoes;
    }

    // Getters e Setters


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setQuantidadeNoEstoque(Integer quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
