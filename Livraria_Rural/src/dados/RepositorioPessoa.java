package dados;

import beans.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioPessoa implements IRepositorioPessoa {

    // Atributos
    private ArrayList<Pessoa> repositorioPessoa;

    // Construtor
    public RepositorioPessoa() {
        this.repositorioPessoa = new ArrayList<>();
    }

    // Metodos CRUD

        // inserirPessoa
        public boolean inserirPessoa(Pessoa pessoa) {
            boolean inseriu = false;
            if (pessoa != null) {
                boolean mesmoEmail = false;
                for (Pessoa p : repositorioPessoa) {
                    if (p.equals(pessoa)) {     // equals de Pessoa compara os emails
                        mesmoEmail = true;
                        break;
                    }
                }
                if (!mesmoEmail) {
                    repositorioPessoa.add(pessoa);
                    inseriu = true;
                }
            }
            return inseriu;
        }

        // removerPessoa
        public boolean removerPessoaPorEmail(String email) {
            boolean removeu = false;
            if (email != null && !email.isEmpty()) {
                repositorioPessoa.removeIf(p -> p.getEmail().equals(email));
                removeu = true;
            }
            return removeu;
        }

        // buscarPessoa
    public Pessoa buscarPessoaPorEmail(String email) {      // fazer tratamento de erro caso procure uma pessoa que não exista
        Pessoa p = null;
        if (email != null && !email.isEmpty()) {
            int indice = 0;
            for (Pessoa i : repositorioPessoa) {
                if (i.getEmail().equals(email)) {
                    p = repositorioPessoa.get(indice);
                }
                indice++;
            }
        }
        return p;
    }

        // atualizarPessoa
    public boolean atualizarPessoaComMesmoEmail(Pessoa novaPessoa) {
        boolean atualizou = false;
        boolean pessoaExiste = false;
        Pessoa pessoaAtualizada = null;
        for (Pessoa p : repositorioPessoa) {
            if(p.equals(novaPessoa)) {
                pessoaExiste = true;
                pessoaAtualizada = p;
                break;
            }
        }
        if (pessoaExiste) {
            //atualizar
            pessoaAtualizada.setNome(novaPessoa.getNome());
            pessoaAtualizada.setEmail(novaPessoa.getEmail());
            pessoaAtualizada.setSenha(novaPessoa.getSenha());
            pessoaAtualizada.setTelefone(novaPessoa.getTelefone());
            pessoaAtualizada.setDataNascimento(novaPessoa.getDataNascimento());
            pessoaAtualizada.setEndereco(novaPessoa.getEndereco());
            pessoaAtualizada.setAdministrador(novaPessoa.isAdministrador());

            atualizou = true;
        }
        return atualizou;
    }


    // listarPessoasNaoAdministradores
    // listarPessoasAdministradores
    // listarPessoasNaoAdministradoresPor?
    // listarAdministradoresPor?
    // listarHistoricoDeComprasDoClientePorPeriodo - foi pra venda
    // listarHistoricoDeComprasDoClienteTotal - foi pra venda



    // Getters
    public ArrayList<Pessoa> getRepositorioPessoa() {
        return repositorioPessoa;
    }

}
