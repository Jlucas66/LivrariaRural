package dados;

import beans.Promocao;
import beans.TipoPromocao;

import java.util.List;

public interface IRepositorioPromocoes {
    public List<TipoPromocao> listarTodasPromocoesEnum();
    public boolean cadastrarPromocao(Promocao promocao);
    public boolean removerPromocaoPorNome(String nomePromocao);
    public Promocao buscarPromocaoPorNome(String nomePromocao);
    public boolean atualizarPromocao(Promocao promocao);

    public void salvarPessoasEmArquivo(String nomeArquivo);
    public void carregarPessoasDeArquivo(String nomeArquivo);
}
