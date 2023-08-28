package beans;

import beans.Avaliacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Livro implements Serializable {

    // Atributos
    private long id;
    private String titulo;
    private String autor;
    private String genero;
    private String sinopse;
    private String editora;
    private String edicao;
    private double preco;
    private int quantidadeNoEstoque;
    private ArrayList<Avaliacao> avaliacoes;
    //private String capa;

    // Construtor
    public Livro(long id, String titulo, String autor, String genero, String sinopse,
                 String editora, String edicao, Double preco, Integer quantidadeNoEstoque) {
        this.id = id;
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setGenero(genero);
        this.setSinopse(sinopse);
        this.setEditora(editora);
        this.setEdicao(edicao);
        this.setPreco(preco);
        this.setQuantidadeNoEstoque(quantidadeNoEstoque);
        this.avaliacoes = new ArrayList<>();
        //this.capa = String.format("@Imagens/capas_livros/%d.jpg", this.getId());
    }

    // Metodos
    public double calcularMediaDeAvaliacoes(){
        double soma = 0;
        double media = 0;
        if (this.avaliacoes.size() != 0) {
            for (Avaliacao a : this.avaliacoes) {
                soma += a.getNota();
            }
            media = soma/this.avaliacoes.size();
        }
        return media;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return id == livro.id;
    }

    // toString
    // o que será impresso?

    // Getters
    public long getId() {
        return id;
    }
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
    public double getPreco() {
        return preco;
    }
    public int getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    // Setters com ou sem validação
    public void setId(long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }
    public void setAutor(String autor) {
        if (autor != null && !autor.isEmpty()) {
            this.autor = autor;
        }
    }
    public void setGenero(String genero) {
        if (genero != null && !genero.isEmpty()) {
            this.genero = genero;
        }
    }
    public void setSinopse(String sinopse) {
        if (sinopse != null && !sinopse.isEmpty()) {
            this.sinopse = sinopse;
        }
    }
    public void setEditora(String editora) {
        if (editora != null && !editora.isEmpty()) {
            this.editora = editora;
        }
    }
    public void setEdicao(String edicao) {
        if (edicao != null && !edicao.isEmpty()) {
            this.edicao = edicao;
        }
    }
    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
    }
    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
        if (quantidadeNoEstoque >= 0) {
            this.quantidadeNoEstoque = quantidadeNoEstoque;
        }
    }
    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}
