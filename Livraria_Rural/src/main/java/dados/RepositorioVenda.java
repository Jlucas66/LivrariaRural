package dados;

import beans.ItemVenda;
import beans.Pessoa;
import beans.Venda;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVenda implements IRepositorioVenda {

    // Atributos
    private ArrayList<Venda> repositorioVenda;

    // Construtor
    public RepositorioVenda() {
        this.repositorioVenda = new ArrayList<>();
    }

    // Metodos CRUD

        // inserirVenda
    public boolean inserirVenda(Venda venda) {
        boolean inseriu = false;

        if (venda != null) {
            boolean existeVendaIgual = false;
            // se o repositorio tiver tamanho zero, id = 1
            if (repositorioVenda.size() == 0) {
                venda.setId(1);
            } else {
                venda.setId(this.buscarUltimaVendaDoRepo().getId() + 1);
            }

            // acho que não precisa comparar venda igual.
            for (Venda v : repositorioVenda) {         // equals de Venda compara id
                if (v.equals(venda)) {
                    existeVendaIgual = true;
                }
                break;
            }
            if (!existeVendaIgual) {
                repositorioVenda.add(venda);
                inseriu = true;
            }
        }
        return inseriu;
    }

        // removerVenda
    public boolean removerVendaPorId(long id) {         // tratar para id inexistente
        boolean removeu = false;
        //repositorioVenda.removeIf(v -> v.getId() == id);
        for (Venda v : repositorioVenda) {
            if (v.getId() == id) {
                repositorioVenda.remove(v);
                removeu = true;
            }
        }
        return removeu;
    }
    public boolean removerUltimaVendaDoRepo() {
        boolean removeu = false;
        repositorioVenda.remove(repositorioVenda.size()-1);
        return removeu;
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

    public Venda buscarUltimaVendaDoRepo() {
        Venda vendaBuscada = null;
        vendaBuscada = repositorioVenda.get(repositorioVenda.size()-1);
        return vendaBuscada;
    }

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

    public List<Venda> listarVendasPorPessoa(Pessoa pessoa){
        List<Venda> listarVendasPorpessoa=new ArrayList<>();
        if(pessoa !=null){
            int indice=0;
            for(Venda v:repositorioVenda) {
                if (pessoa.equals(v.getPessoa())) {
                    listarVendasPorpessoa.add(v);
                }
                indice++;
            }
        }
        return listarVendasPorpessoa;

    }

    public List<Venda> listarVendasPorPeriodo(LocalDate inicio, LocalDate fim){
        List<Venda> vendasPorPeriodo=new ArrayList<>();
        if(inicio!=null && fim!=null){
            for(Venda v:repositorioVenda){
                if(v.getData().isAfter(inicio) && v.getData().isBefore(fim)){
                    vendasPorPeriodo.add(v);
                }
            }
        }
        return vendasPorPeriodo;
    }

    // listar em String itens da venda para mostrar na tela do carrinho de compras
    public String imprimirItensVenda(Venda venda) {
        int numero = 1;
        String lista = "";
        lista += String.format("%s    %10s |  %4s  |   %10s           %S", "ITEM", "PREÇO", "QTD", "TOTAL", "TITULO\n");
        for (ItemVenda i : venda.getItensDaVenda()) {
            lista += String.format("( %2d )  R$ %10.2f |   %4d     | R$ %10.2f     - %s\n", numero, i.getLivro().getPreco(), i.getQuantidade(), i.calcularTotal(), i.getLivro().getTitulo());
            numero++;
        }

        return lista;
    }


    public Venda buscarUltimaVendaDePessoa(Pessoa pessoa){
        List<Venda> vendasDePessoa=new ArrayList<>();
        int ultimo;
        for(Venda venda:repositorioVenda){
            if(venda.getPessoa().getNome().equalsIgnoreCase(pessoa.getNome())){
                vendasDePessoa.add(venda);
            }
        }
        ultimo=vendasDePessoa.size();
        return vendasDePessoa.get(ultimo-1);
    }



    // listarVendasPorPeriodo
    // listarVendasPorCliente
    // listarVendasPorClientePorPeriodo
    // listarVendasQueContemLivro


    public void salvarVendasEmArquivo(String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(repositorioVenda);
            System.out.println("Vendas salvas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarVendasDeArquivo(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            repositorioVenda = (ArrayList<Venda>) inputStream.readObject();
            System.out.println("Vendas carregadas com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // Getters
    public ArrayList<Venda> getRepositorioVenda() {
        return repositorioVenda;
    }

}