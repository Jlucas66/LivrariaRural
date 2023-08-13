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
    public void inserirPessoa(Pessoa pessoa) {
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
            }
        }
    }

        // removerPessoa
    public void removerPessoaPorEmail(String email) {
        if (email != null && !email.isEmpty()) {
            repositorioPessoa.removeIf(p -> p.getEmail().equals(email));
        }
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

    // metodos atualizar por cada atributo
    /*
    public void atualizarNome(Pessoa pessoa, String novoNome) {
        if (pessoa != null && novoNome != null && !novoNome.isEmpty()) {
            boolean pessoaExisteNoRepositorio = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {
                    pessoaExisteNoRepositorio = true;
                    break;
                }
            }
            if (pessoaExisteNoRepositorio) {
                pessoa.setNome(novoNome);
            }
        }
    }
    public void atualizarEmail(Pessoa pessoa, String novoEmail) {
        if (pessoa != null && novoEmail != null && !novoEmail.isEmpty()) {
            boolean pessoaExisteNoRepositorio = false;
            boolean emailJaExiste = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {
                    pessoaExisteNoRepositorio = true;
                }
                if (p.getEmail().equals(novoEmail)) {
                    emailJaExiste = true;
                }
            }
            if (pessoaExisteNoRepositorio && !emailJaExiste) {
                pessoa.setEmail(novoEmail);
            }
        }
    }
    public void atualizarSenha(Pessoa pessoa, String novaSenha) {
        if (pessoa != null && novaSenha != null && !novaSenha.isEmpty()) {
            boolean pessoaExisteNoRepositorio = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {
                    pessoaExisteNoRepositorio = true;
                    break;
                }
            }
            if (pessoaExisteNoRepositorio) {
                pessoa.setSenha(novaSenha);
            }
        }
    }
    public void atualizarTelefone(Pessoa pessoa, String novoTelefone) {
        if (pessoa != null && novoTelefone != null && !novoTelefone.isEmpty()) {
            boolean pessoaExisteNoRepositorio = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {
                    pessoaExisteNoRepositorio = true;
                    break;
                }
            }
            if (pessoaExisteNoRepositorio) {
                pessoa.setTelefone(novoTelefone);
            }
        }
    }
    public void atualizarEndereco(Pessoa pessoa, String novoEndereco) {
        if (pessoa != null && novoEndereco != null && !novoEndereco.isEmpty()) {
            boolean pessoaExisteNoRepositorio = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {
                    pessoaExisteNoRepositorio = true;
                    break;
                }
            }
            if (pessoaExisteNoRepositorio) {
                pessoa.setEndereco(novoEndereco);
            }
        }
    }
    public void atualizarDataNascimento(Pessoa pessoa, LocalDate novaData) {
        if (pessoa != null && novaData != null) {
            boolean pessoaExisteNoRepositorio = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {
                    pessoaExisteNoRepositorio = true;
                    break;
                }
            }
            if (pessoaExisteNoRepositorio) {
                pessoa.setDataNascimento(novaData);
            }
        }
    }
    */

    // listarClientes
    // listarAdministradores
    // listarClientesPor?
    // listarAdministradoresPor?
    // listarHistoricoDeComprasDoClientePorPeriodo
    // listarHistoricoDeComprasDoClienteTotal



    // Getters
    public ArrayList<Pessoa> getRepositorioPessoa() {
        return repositorioPessoa;
    }

}
