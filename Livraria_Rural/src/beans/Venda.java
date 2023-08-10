package beans;

import beans.Cliente;
import beans.ItemVenda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Venda {

    // Atributos
    private long id;
    private Cliente cliente;
    private ArrayList<ItemVenda> itensDaVenda;
    private LocalDateTime data;
    private float percentualDeDesconto;
    private String status;

    // Construtores (sem desconto e com desconto)
    public Venda(long id, Cliente cliente, ArrayList<ItemVenda> itensDaVenda, float percentualDeDesconto) {
        this.setId(id);
        this.setCliente(cliente);
        this.setItensDaVenda(itensDaVenda);
        this.data = LocalDateTime.now();
        this.setPercentualDeDesconto(percentualDeDesconto);
        this.status = "status inicial";
    }
    /*
    public Venda(long id, Cliente cliente, ArrayList<ItemVenda> itensDaVenda) {
        this.setId(id);
        this.setCliente(cliente);
        this.setItensDaVenda(itensDaVenda);
        this.data = LocalDateTime.now();
        this.percentualDeDesconto = 0;
        this.status = "status inicial";
    }
    */

    // Metodos
    public double calcularTotal() {
        double soma = 0;
        for (ItemVenda i : itensDaVenda) {
            soma += i.calcularTotal();
        }
        double resultado = soma - soma * this.percentualDeDesconto/100;
        return resultado;
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
    public Cliente getCliente() {
        return cliente;
    }
    public ArrayList<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }
    public LocalDateTime getData() {
        return data;
    }
    public float getPercentualDeDesconto() {
        return percentualDeDesconto;
    }
    public String getStatus() {
        return status;
    }

    // Setters com ou sem validação
    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }
    public void setPercentualDeDesconto(float percentualDeDesconto) {
        if (percentualDeDesconto >= 0 && percentualDeDesconto <= 100) {
            this.percentualDeDesconto = percentualDeDesconto;
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
    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
        }
    }
    public void setStatus(String status) {
        if (status != null && !status.isEmpty()) {
            this.status = status;
        }
    }

}
