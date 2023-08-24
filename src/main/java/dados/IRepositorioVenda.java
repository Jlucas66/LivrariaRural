package dados;

import beans.Pessoa;
import beans.Venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IRepositorioVenda {

    // Metodos CRUD

    // inserir
    boolean inserirVenda(Venda venda);

    // remover
    boolean removerVendaPorId(long id);
    public boolean removerUltimaVendaDoRepo();

    // buscar
    Venda buscarVendaPorId(long id);
    Venda buscarUltimaVendaDoRepo();

    List<Venda> listarVendasPorPessoa(Pessoa pessoa);
    List<Venda> listarVendasPorPeriodo(LocalDateTime inicio, LocalDateTime fim);
    String imprimirItensVenda(Venda venda);

    // atualizar
    boolean atualizarVendaComMesmoId(Venda novaVenda);

    // metodo atualizar atrubuto único
    /*
    void atualizarStatusDaVenda(Venda venda, StatusVenda novoStatus);
    */



    ArrayList<Venda> getRepositorioVenda();

}
