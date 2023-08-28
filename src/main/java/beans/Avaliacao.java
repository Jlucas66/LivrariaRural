package beans;

import java.io.Serializable;

public class Avaliacao implements Serializable {

    // Atributos
    private Pessoa pessoa;
    private Livro livro;
    private int nota;
    private String comentario;

    // Construtores (com comentário e sem comentário)
    public Avaliacao(Pessoa pessoa, Livro livro, int nota, String comentario) {
        this.setPessoa(pessoa);
        this.setLivro(livro);
        this.nota = nota;
        this.comentario = comentario;
    }
    public Avaliacao(Pessoa pessoa, Livro livro, int nota) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.nota = nota;
        this.comentario = null;
    }

    // Getters
    public Pessoa getPessoa() {
        return pessoa;
    }
    public Livro getLivro() {
        return livro;
    }
    public int getNota() {
        return nota;
    }
    public String getComentario() {
        return comentario;
    }

    // Setters com ou sem validação
    public void setPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
    }
    public void setLivro(Livro livro) {
        if (livro != null) {
            this.livro = livro;
        }
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
