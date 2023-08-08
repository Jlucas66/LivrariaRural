import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {
    private Cliente cliente;
    private ArrayList<ItemVenda> itensDaVenda;
    private LocalDateTime data;
    private Float percentualDeDesconto;

    private Double valorTotal1 = 0.0;

    private Double calcularDesconto(){ // Tirei o static para conseguir usar o atributo da classe

        float descontoPor100 = percentualDeDesconto / 100;
        double desconto = getValorTotal1() * descontoPor100;

        return desconto;
    }
    public Double calcularTotal(){

        double valorTotal = getValorTotal1() - calcularDesconto();

return valorTotal;
    }

// Getters e Setters

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Float getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public Double getValorTotal1() {
        return valorTotal1;
    }

    public void setValorTotal1(Double valorTotal1) {
        this.valorTotal1 = valorTotal1;
    }

    public void setPercentualDeDesconto(Float percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setItensDaVenda(ArrayList<ItemVenda> itensDaVenda) {
        this.itensDaVenda = itensDaVenda;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
