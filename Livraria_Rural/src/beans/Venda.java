package beans;

import beans.Cliente;
import beans.ItemVenda;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {

    // Atributos
    private Cliente cliente;
    private ArrayList<ItemVenda> itensDaVenda;
    private LocalDateTime data;
    private float percentualDeDesconto;
    private String status;

    // Construtores (sem desconto e com desconto)
    public Venda(Cliente cliente, ArrayList<ItemVenda> itensDaVenda, float percentualDeDesconto) {
        this.cliente = cliente;
        this.setItensDaVenda(itensDaVenda);
        this.data = LocalDateTime.now();
        this.setPercentualDeDesconto(percentualDeDesconto);
        this.status = "status inicial";
    }
    public Venda(Cliente cliente, ArrayList<ItemVenda> itensDaVenda) {
        this.cliente = cliente;
        this.setItensDaVenda(itensDaVenda);
        this.data = LocalDateTime.now();
        this.percentualDeDesconto = 0;
        this.status = "status inicial";
    }

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

    // toString

    private Double valorTotal1 = 0.0; // por que esse atributo?

    private double calcularDesconto(){ // Tirei o static para conseguir usar o atributo da classe

        float descontoPor100 = percentualDeDesconto / 100;
        double desconto = getValorTotal1() * descontoPor100;

        return desconto;
    }
    /*
    public Double calcularTotal(){

        double valorTotal = getValorTotal1() - calcularDesconto();

        return valorTotal;
    } */

    // Getters
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
    public double getValorTotal1() {        // por que?
        return valorTotal1;
    }

    // Setters com ou sem validação
    public void setValorTotal1(double valorTotal1) {        // pq?
        this.valorTotal1 = valorTotal1;
    }
    public void setPercentualDeDesconto(float percentualDeDesconto) {
        if (percentualDeDesconto >= 0 || percentualDeDesconto <= 100) {
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
}
