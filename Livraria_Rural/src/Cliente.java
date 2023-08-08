import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    private String endereco;
    private LocalDate dataNascimento;

    private ArrayList<Venda> historicoDeCompras;

    // Getters e Setters


    public String getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public ArrayList<Venda> getHistoricoDeCompras() {
        return historicoDeCompras;
    }

    public void setHistoricoDeCompras(ArrayList<Venda> historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
