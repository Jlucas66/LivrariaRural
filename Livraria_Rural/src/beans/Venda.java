package beans;

import beans.Cliente;
import beans.ItemVenda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Venda {

    // Atributos
    private long id;
    private Pessoa pessoa;
    private ArrayList<ItemVenda> itensDaVenda;
    private LocalDateTime data;
    private Promocao promocao;
    private StatusVenda status;

    // Construtores (sem desconto e com desconto)
    public Venda(long id, Pessoa pessoa, ArrayList<ItemVenda> itensDaVenda, Promocao promocao) {
        this.setId(id);
        this.setPessoa(pessoa);
        this.setItensDaVenda(itensDaVenda);
        this.data = LocalDateTime.now();
        this.promocao = promocao;
        this.status = StatusVenda.EM_ABERTO;
    }

    // Metodos
    public double calcularTotal() {
        double soma = 0;
        for (ItemVenda i : itensDaVenda) {
            soma += i.calcularTotal();
        }
        double resultado = soma - soma * this.getPromocao().getPercentualDesconto()/100;
        return resultado;
    }
    // listar livros da venda - pra usar na promocao
    public ArrayList<Livro> livrosDaVenda() {
        ArrayList<Livro> lista = new ArrayList<>();
        for(ItemVenda i : this.itensDaVenda) {
            livrosDaVenda().add(i.getLivro());
        }
        return lista;
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
    public LocalDateTime getData() {
        return data;
    }
    public StatusVenda getStatus() {
        return status;
    }
    public Promocao getPromocao() {
        return promocao;
    }

    // Setters com ou sem validação
    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }
    public void setData(LocalDateTime data) {       // nem precisa, se for data now.
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
