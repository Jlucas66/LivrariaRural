import beans.Promocao;
import beans.Venda;
import dados.IRepositorioVenda;

public class ControladorPromocao {

    // Atributos
    private IRepositorioVenda repositorioVenda;
    private static ControladorPromocao instance;

    // Construtor
    private ControladorPromocao() {}
    public static ControladorPromocao getInstance() {
        if (instance == null) {
            instance = new ControladorPromocao();
        }
        return instance;
    }

    // Metodos

    // a venda vai ser criada, e após a criação o desconto vai ser calculado. - controlador de vendas

    public boolean aplicarDescontoDaVenda(Venda venda) {
        boolean resultado = false;

        if (repositorioVenda.buscarVendaPorId(venda.getId()) != null) {
            // venda foi criada e está no repositorio de vendas
            //analisar itens da venda e calcular desconto.

            double desconto = 0;
            boolean descontoDataComemorativa = false;
            boolean descontoAniversario = false;
            boolean descontoVariosLivros = false;

            // datas comemorativas - natal, dia dos pais, dia das mães, dia dos namorados, mes de aniversario 10%
            if (venda.getData().getMonthValue() == 12
                || venda.getData().getMonthValue() == 6
                || venda.getData().getMonthValue() == 5
                || venda.getData().getMonthValue() == 8) {
                descontoDataComemorativa = true;
            }
            // se for mes de aniversario - 15%
            if (venda.getData().getMonthValue() == venda.getPessoa().getDataNascimento().getMonthValue()) {
                descontoAniversario = true;
            }
            // se tiver 5 ou mais livros 20%
            if (venda.livrosDaVenda().size() >= 5) {
                descontoVariosLivros = true;
            }

            // desconto não cumulativos. Vale o maior.
            if (descontoVariosLivros) {
                desconto = 20;
            } else if (descontoAniversario) {
                desconto = 15;
            } else if (descontoDataComemorativa) {
                desconto = 10;
            }

        }

        return resultado;
    }

// controlador venda criará a venda
// controlador promocao vai aplicar desconto naquela venda.


}
