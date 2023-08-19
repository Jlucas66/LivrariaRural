package dados;

import beans.Venda;

import java.util.ArrayList;

public interface IRepositorioVenda {

    // Metodos CRUD

    // inserir
    boolean inserirVenda(Venda venda);

    // remover
    boolean removerVendaPorId(long id);

    // buscar
    Venda buscarVendaPorId(long id);

    // atualizar
    boolean atualizarVendaComMesmoId(Venda novaVenda);

    // metodo atualizar atrubuto único
    /*
    void atualizarStatusDaVenda(Venda venda, StatusVenda novoStatus);
    */



    ArrayList<Venda> getRepositorioVenda();

}
