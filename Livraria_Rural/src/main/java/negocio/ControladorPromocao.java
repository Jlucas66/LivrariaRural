package negocio;

import beans.Promocao;
import beans.TipoPromocao;
import beans.Venda;
import dados.IRepositorioPromocoes;
import dados.RepositorioPromocoes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ControladorPromocao {

    // Atributos
    private static ControladorPromocao instance;
    private IRepositorioPromocoes repPromocao;
    // Construtor
    private ControladorPromocao() {
        this.repPromocao =new RepositorioPromocoes();
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
        if(nomePromocaoNova!=null && !nomePromocaoNova.isEmpty()&&
        inicio!=null && fim!=null ){
                promocao= new Promocao(inicio,fim,porcentagemDesconto,nomePromocaoNova);
                repPromocao.cadastrarPromocao(promocao);

        }
        return inseriu;
        }

    public boolean removerPromocaoPorNome(String nomePromocao){
        boolean removido = false;
        if(nomePromocao!=null && !nomePromocao.isEmpty()){
            removido =true;
            repPromocao.removerPromocaoPorNome(nomePromocao);
        }
        return removido;
    }

    public boolean atualizarPromocao(String nomePromocao,double percentualPromocao,LocalDate inicio,LocalDate fim){
        boolean atualizou=false;
        if(nomePromocao!=null && !nomePromocao.isEmpty()&& inicio!=null && fim!=null){
            Promocao promocao=new Promocao(inicio,fim,percentualPromocao,nomePromocao);
            repPromocao.atualizarPromocao(promocao);
            atualizou=true;
        }
        return atualizou;

    }

    public void carregarPessoasDeArquivo(String nomeArquivo){
        repPromocao.carregarPessoasDeArquivo(nomeArquivo);
    }
    public void salvarPessoasEmArquivo(String nomeArquivo){
        repPromocao.salvarPessoasEmArquivo(nomeArquivo);
    }
    public Promocao buscarPorNome(String nomePromocao){
            return repPromocao.buscarPromocaoPorNome(nomePromocao);

    }
}
