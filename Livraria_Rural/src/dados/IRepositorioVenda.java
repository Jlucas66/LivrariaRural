package dados;

import beans.Venda;

public interface IRepositorioVenda {

    // Metodos CRUD

    // inserir
    void inserirVenda(Venda venda);

    // remover
    void removerVendaPorId(long id);

    // buscar
    Venda buscarVendaPorId(long id);

    // atualizar
    void atualizarStatusDaVenda(Venda venda, String novoStatus);

}
