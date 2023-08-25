package Model;

public class Book {
    private String nome;
    private String capa;
    private String preco;

    public String getCapa() {
        return capa;
    }

    public String getNome() {
        return nome;
    }


    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
}
