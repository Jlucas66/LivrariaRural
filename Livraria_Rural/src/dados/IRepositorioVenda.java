package dados;

import beans.StatusVenda;
import beans.Venda;

import java.util.ArrayList;

public interface IRepositorioVenda {

    // Metodos CRUD

    // inserir
    void inserirVenda(Venda venda);

    // remover
    void removerVendaPorId(long id);

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
