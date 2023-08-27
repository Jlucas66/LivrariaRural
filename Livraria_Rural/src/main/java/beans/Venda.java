package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda implements Serializable {

    // Atributos
    //public static long indice = 0;
    private long id;
    private Pessoa pessoa;
    private ArrayList<ItemVenda> itensDaVenda;
    private LocalDate data;
    private Promocao promocao;
    private StatusVenda status;

    // Construtor
    public Venda(Pessoa pessoa) {
        //indice++;
        //this.setId(id);
        this.setPessoa(pessoa);
        this.itensDaVenda = new ArrayList<>();
        this.data = LocalDate.now();
        this.promocao = null;
        this.status = StatusVenda.EM_ABERTO;

    }

    // Metodos
    public double calcularTotal() {
        double soma = 0;
        for (ItemVenda i : itensDaVenda) {
            soma += i.calcularTotal();
        }
        double resultado = 0;
        if (promocao != null) {
            resultado = soma - soma * this.getPromocao().getPercentualDesconto()/100;
        } else {
            resultado = soma;
        }
        return resultado;
    }

    // listar quantidade de livros da venda - pra usar na promocao
    public int qtdLivrosDaVenda() {
        int quantidade = 0;
        for(ItemVenda i : this.itensDaVenda) {
            quantidade += i.getQuantidade();
        }
        return quantidade;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;
        Venda venda = (Venda) o;
        return id == venda.id;
    }

    // toString

    // Getters
    public long getId() {
        return id;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public ArrayList<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }
    public LocalDate getData() {
        return data;
    }
    public StatusVenda getStatus() {
        return status;
    }
    public Promocao getPromocao() {
        return promocao;
    }

//    public static long getIndice() {
//        return indice;
//    }

    // Setters com ou sem validação
    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }
    public void setData(LocalDate data) {       // nem precisa, se for data now.
        this.data = data;
    }
    public void setItensDaVenda(ArrayList<ItemVenda> itensDaVenda) {
        if (itensDaVenda != null && !itensDaVenda.isEmpty()) {
            this.itensDaVenda = itensDaVenda;
        }
    }
    public void setPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
    }

    public void setStatus(StatusVenda status) {
        this.status = status;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }
}
