package beans;

public class ItemVenda {

    // Atributos
    private Livro livro;
    private  int quantidade;

    // Construtor
    public ItemVenda(Livro livro, int quantidade) {
        this.setLivro(livro);
        this.setQuantidade(quantidade);
    }

    // Metodos
    public double calcularTotal(){ // Tirei o static deste também
        return this.livro.getPreco() * this.quantidade;
    }

    // equals?

    // toString

    // Getters
    public Livro getLivro() {
        return livro;
    }
    public int getQuantidade() {
        return quantidade;
    }

    // Setters com ou sem validação
    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        }
    }
    public void setLivro(Livro livro) {
        if (livro != null) {
            this.livro = livro;
        }
    }

}
