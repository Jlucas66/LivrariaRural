package negocio;

import beans.Promocao;
import beans.Venda;
import dados.IRepositorioPromocoes;
import dados.RepositorioPromocao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ControladorPromocao {

    // Atributos
    private static ControladorPromocao instance;
    private IRepositorioPromocoes repo;
    // Construtor
    private ControladorPromocao() {
        this.repo =new RepositorioPromocao();
    }
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

        // verificar se a data da venda está entre alguma das datas das promoções do repositório
        LocalDate dataVenda = venda.getData();

        for (Promocao promo : repo.getRepositorioPromocao()) {
            if (dataVenda.isAfter(promo.getInicio()) && dataVenda.isBefore(promo.getFim())
                    || dataVenda.isEqual(promo.getInicio()) || dataVenda.isEqual(promo.getFim())) {
                // a promoção se aplica para essa venda
                // mas antes tem que checar se já tem uma promoção aplicada. Se sim, vai valer a que tiver maior desconto
                if (venda.getPromocao() == null || venda.getPromocao().getPercentualDesconto() < promo.getPercentualDesconto()) {
                    venda.setPromocao(promo);
                }
            }
        }

        // criar promoção
        /*if (venda != null) {
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
        }*/
        return aplicouPromocao;
    }

    public boolean cadastraNovaPromocao(LocalDate inicio, LocalDate fim, double porcentagemDesconto,String nomePromocaoNova){
        boolean inseriu=false;
        boolean existeData=false;
        Promocao promocao;

        if(nomePromocaoNova!=null && !nomePromocaoNova.isEmpty()&& inicio!=null && fim!=null && porcentagemDesconto>0 ){
            promocao = new Promocao(inicio,fim,porcentagemDesconto,nomePromocaoNova);
            repo.cadastrarPromocao(promocao);
            inseriu=true;
        }
        return inseriu;
    }

    public boolean removerPromocaoPorNome(String nomePromocao){     // só precisa de um delegate. Não precisa mais validar
        boolean removido = false;
        if(nomePromocao!=null && !nomePromocao.isEmpty()){
            removido =true;
            repo.removerPromocaoPorNome(nomePromocao);
        }
        return removido;
    }

    public boolean atualizarPromocao(String nomePromocao,double percentualPromocao,LocalDate inicio,LocalDate fim){
        boolean atualizou=false;
        if(nomePromocao!=null && !nomePromocao.isEmpty()&& inicio!=null && fim!=null){
            Promocao promocao=new Promocao(inicio,fim,percentualPromocao,nomePromocao);
            repo.atualizarPromocao(promocao);
            atualizou=true;
        }
        return atualizou;

    }

    public void carregarPromocaoDeArquivo(String nomeArquivo){
        repo.carregarPromocaoDeArquivo(nomeArquivo);
    }
    public void salvarPromocaoEmArquivo(String nomeArquivo){
        repo.salvarPromocaoEmArquivo(nomeArquivo);
    }
    public Promocao buscarPorNome(String nomePromocao){
            return repo.buscarPromocaoPorNome(nomePromocao);
    }

    public List<Promocao> getRepositorioPromocao() {
        return repo.getRepositorioPromocao();
    }
}
