package dados;

import beans.Livro;
import beans.StatusVenda;
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
    public boolean atualizarVendaComMesmoId(Venda novaVenda) {
        boolean atualizou = false;
        boolean vendaExiste = false;
        Venda vendaAtualizada = null;
        for (Venda v : repositorioVenda) {
            if (v.equals(novaVenda)) {
                vendaExiste = true;
                vendaAtualizada = v;
                break;
            }
        }
        if (vendaExiste) {
            // atualizar
            vendaAtualizada.setPessoa(novaVenda.getPessoa());
            vendaAtualizada.setItensDaVenda(novaVenda.getItensDaVenda());
            vendaAtualizada.setData(novaVenda.getData());
            vendaAtualizada.setPromocao(novaVenda.getPromocao());
            vendaAtualizada.setStatus(novaVenda.getStatus());

            atualizou = true;
        }
        return atualizou;
    }

    // metodo atualizar atributo único - melhor no controlador, que vai mudar o status da venda baseado na data
    /*
    public void atualizarStatusDaVenda(Venda venda, StatusVenda novoStatus) {
        if (venda != null) {
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
    */

    // listarVendasPorPeriodo
    // listarVendasPorCliente
    // listarVendasQueContemLivro


    // Getters
    public ArrayList<Venda> getRepositorioVenda() {
        return repositorioVenda;
    }

}
