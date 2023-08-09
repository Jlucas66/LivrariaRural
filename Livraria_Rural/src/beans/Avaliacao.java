package beans;

public class Avaliacao {

    // Atributos
    private Cliente cliente;
    private Livro livro;
    private int nota;
    private String comentario;

    // Construtores (com comentário e sem comentário)
    public Avaliacao(Cliente cliente, Livro livro, int nota, String comentario) {
        this.setCliente(cliente);
        this.setLivro(livro);
        this.nota = nota;
        this.comentario = comentario;
    }
    public Avaliacao(Cliente cliente, Livro livro, int nota) {
        this.cliente = cliente;
        this.livro = livro;
        this.nota = nota;
        this.comentario = null;
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
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
    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
        }
    }
    public void setLivro(Livro livro) {
        if (livro != null) {
            this.livro = livro;
        }
    }
    public void setNota(int nota) {
        if (nota >= 1 && nota <= 5) {
            this.nota = nota;
        }
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
