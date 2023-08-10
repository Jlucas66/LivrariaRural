package dados;

import beans.Livro;
import beans.Venda;

import java.util.ArrayList;

public class RepositorioVenda implements IRepositorioVenda {

    // Atributos
    private ArrayList<Venda> repositorioVenda;

    // Construtor
    public RepositorioVenda() {
        this.repositorioVenda = new ArrayList<>();
    }

    // Metodos CRUD

        // inserirVenda
    public void inserirVenda(Venda venda) {
        if (venda != null) {
            boolean existeVendaIgual = false;
            for (Venda v : repositorioVenda) {         // equals de Venda compara id
                if (v.equals(venda)) {
                    existeVendaIgual = true;
                }
                break;
            }
            if (!existeVendaIgual) {
                repositorioVenda.add(venda);
            }
        }
    }

        // removerVenda
    public void removerVendaPorId(long id) {
        repositorioVenda.removeIf(v -> v.getId() == id);
    }

        // buscarVenda
    public Venda buscarVendaPorId(long id) {
        Venda vendaBuscada = null;
        int indice = 0;
        for (Venda v : repositorioVenda) {
            if (v.getId() == id) {
                vendaBuscada = repositorioVenda.get(indice);
            }
            indice++;
        }
        return vendaBuscada;
    }       // tratar para id inexistente

        // atualizarVenda
    public void atualizarStatusDaVenda(Venda venda, String novoStatus) {
        if (venda != null && novoStatus != null && !novoStatus.isEmpty()) {
            boolean vendaExisteNoRepositorio = false;
            for (Venda v : repositorioVenda) {
                if (v.equals(venda)) {
                    vendaExisteNoRepositorio = true;
                    break;
                }
            }
            if (vendaExisteNoRepositorio) {
                venda.setStatus(novoStatus);
            }
        }
    }


    // listarVendasPorPeriodo
    // listarVendasPorCliente
    // listarVendasQueContemLivro


    // Getters
    public ArrayList<Venda> getRepositorioVenda() {
        return repositorioVenda;
    }

}
