package beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa {

    // Atributos
    private ArrayList<Venda> historicoDeCompras;

    // Construtor
    public Cliente(String nome, String email, String senha,
                   String telefone, LocalDate dataNascimento) {
        super(nome, email, senha, telefone, dataNascimento);
        this.historicoDeCompras = new ArrayList<>();
    }

    // Metodos

    // equals

    // toString

    // Getters e Setters
    public ArrayList<Venda> getHistoricoDeCompras() {
        return historicoDeCompras;
    }
    public void setHistoricoDeCompras(ArrayList<Venda> historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }

}
