import beans.Promocao;
import beans.TipoPromocao;
import beans.Venda;
import dados.IRepositorioVenda;

public class ControladorPromocao {

    // Atributos
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
    /**
     * Método que define a promoção da venda.
     * Cria uma promoção inicial com desconto 0. Verifica se pode ter outro desconto. Atualiza o tipo de desconto.
     * Coloca a promoção da venda dentro da Venda.
     * @param venda - não pode ser nula.
     * @return true se a aplicação foi bem sucedida.
     */
    public boolean aplicarPromocaoNaVenda(Venda venda) {
        boolean aplicouPromocao = false;
        // criar promoção
        if (venda != null) {
            Promocao promocao = new Promocao(venda); // nenhuma promoção e desconto = 0

            // calcular percentual de desconto e atualizar o tipo da promocao
            int mesDaVenda = venda.getData().getMonthValue();
            int mesDeAniversario = venda.getPessoa().getDataNascimento().getMonthValue();

            // varios livros > aniversario > datas comemorativas
            if (venda.qtdLivrosDaVenda() >= 5) {
                promocao.setTipoPromocao(TipoPromocao.CINCO_OU_MAIS_LIVROS);
                promocao.setPercentualDesconto(20);
            } else if (mesDaVenda == mesDeAniversario) {
                promocao.setTipoPromocao(TipoPromocao.ANIVERSARIO);
                promocao.setPercentualDesconto(10);
            } else {
                switch (mesDaVenda) {
                    case 5 -> {
                        promocao.setTipoPromocao(TipoPromocao.DIA_DAS_MAES);
                        promocao.setPercentualDesconto(5);
                    }
                    case 6 -> {
                        promocao.setTipoPromocao(TipoPromocao.DIA_DOS_NAMORADOS);
                        promocao.setPercentualDesconto(5);
                    }
                    case 8 -> {
                        promocao.setTipoPromocao(TipoPromocao.DIA_DOS_PAIS);
                        promocao.setPercentualDesconto(5);
                    }
                    case 12 -> {
                        promocao.setTipoPromocao(TipoPromocao.NATAL);
                        promocao.setPercentualDesconto(10);
                    }
                }
            }

            // colocar a promoção dentro da venda
            venda.setPromocao(promocao);
            aplicouPromocao = true;
        }
        return aplicouPromocao;
    }




}
