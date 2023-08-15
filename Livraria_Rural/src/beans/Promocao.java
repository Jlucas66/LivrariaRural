package beans;

import java.util.ArrayList;

public class Promocao {

    // Atributos
    private TipoPromocao tipoPromocao;
    private double percentualDesconto;
    private Venda venda;


    // Construtor
    public Promocao(Venda venda) {
        this.tipoPromocao = TipoPromocao.NENHUMA;
        this.percentualDesconto = 0;
        this.venda = venda;
    }

    // Metodos


    // equals

    // toString

    // Getters
    public double getPercentualDesconto() {
        return percentualDesconto;
    }
    public Venda getVenda() {
        return venda;
    }

    // Setters com ou sem validação
    public void setPercentualDesconto(double percentualDesconto) {     // seria private?
        this.percentualDesconto = percentualDesconto;
    }
    public void setVenda(Venda venda) {
        if (venda != null) {
            this.venda = venda;
        }
    }
    public void setTipoPromocao(TipoPromocao tipoPromocao) {
        this.tipoPromocao = tipoPromocao;
    }
}
