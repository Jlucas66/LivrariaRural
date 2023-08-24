package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Promocao implements Serializable {

    // Atributos
    private LocalDate inicio;
    private LocalDate fim;
    private double percentualDesconto;
    private String nomePromocao;

    // Construtor
    public Promocao(LocalDate inicio,LocalDate fim,double percentualDesconto,String nomePromocao) {
        this.percentualDesconto = percentualDesconto;
        this.nomePromocao = nomePromocao;
        this.inicio=inicio;
        this.fim=fim;
    }

    // Metodos


    // equals

    // toString

    // Getters

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    // Setters com ou sem validação

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public void setPercentualDesconto(double percentualDesconto) {     // seria private?
        this.percentualDesconto = percentualDesconto;
    }


}
