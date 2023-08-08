public class Avaliacao {
    private Cliente cliente;
    private Livro livro;
    private  Integer nota;
    private String comentario;

    // Getters e Setters


    public Cliente getCliente() {
        return cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public Integer getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
