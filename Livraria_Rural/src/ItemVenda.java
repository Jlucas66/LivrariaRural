public class ItemVenda {
    private Livro livro;
    private  Integer quantidade;

    public Double calcularTotal(){ // Tirei o static deste também

        double precoTotal = livro.getPreco() * getQuantidade();

        return precoTotal;
    }

    // Getters e Setters


    public Livro getLivro() {
        return livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
