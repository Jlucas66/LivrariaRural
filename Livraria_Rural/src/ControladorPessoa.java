import beans.Pessoa;
import dados.IRepositorioPessoa;
import dados.RepositorioPessoa;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorPessoa {

    // Atributos
    private IRepositorioPessoa repo;
    private static ControladorPessoa instance;

    // Construtor
    private ControladorPessoa() {
        this.repo = new RepositorioPessoa();
    }
    public static ControladorPessoa getInstance() {
        if (instance == null) {
            instance = new ControladorPessoa();
        }
        return instance;
    }

    // Metodos
    // duvidas:
    // metodo para criar pessoa separado do metodo para inserir no repositorio?
    // metodo de remover com parametro de pessoa, ou de email?
    // metodo de atualizar com pessoa criada antes, ou criar dentro do parametro?

    public boolean criarECadastrarPessoa(String nome, String email, String senha, String telefone, LocalDate dataNascimento) {

        boolean cadastradoComSucesso = false;

        // se tiver todos os atributos não nulos e não vazios, pessoa pode ser criada
        if (nome != null && !nome.isEmpty()
                && email != null && !email.isEmpty()
                && senha != null && !senha.isEmpty()
                && telefone != null && !telefone.isEmpty()
                && dataNascimento != null) {
            Pessoa pessoa = new Pessoa(nome, email, senha, telefone, dataNascimento, false);

            /*
            // verificar se o email já está cadastrado - não precisa, pois o repositório já faz essa validação
            boolean existePessoaIgual = false;
            for (Pessoa p : repo.getRepositorioPessoa()) {
                if (p.equals(pessoa)) {
                    existePessoaIgual = true;
                    break;
                }
            }

            // adicionar ao repositorio
            if (!existePessoaIgual) {
                repo.inserirPessoa(pessoa);
            }
            */

            // add pessoa criada ao repositório
            cadastradoComSucesso = repo.inserirPessoa(pessoa);
        }
        return cadastradoComSucesso;
    }

    public boolean criarECadastrarAdministrador(String nome, String email, String senha, String telefone, LocalDate dataNascimento) {

        boolean cadastradoComSucesso = false;

        // se tiver todos os atributos não nulos e não vazios, pessoa pode ser criada
        if (nome != null && !nome.isEmpty()
                && email != null && !email.isEmpty()
                && senha != null && !senha.isEmpty()
                && telefone != null && !telefone.isEmpty()
                && dataNascimento != null) {
            Pessoa pessoa = new Pessoa(nome, email, senha, telefone, dataNascimento, true);

            /*
            // verificar se o email já está cadastrado
            boolean existePessoaIgual = false;
            for (Pessoa p : repo.getRepositorioPessoa()) {
                if (p.equals(pessoa)) {
                    existePessoaIgual = true;
                    break;
                }
            }

            // adicionar ao repositorio
            if (!existePessoaIgual) {
                repo.inserirPessoa(pessoa);
            }
            */
            // add pessoa criada ao repositório
            cadastradoComSucesso = repo.inserirPessoa(pessoa);
        }
        return cadastradoComSucesso;
    }

    //atualizar - Precisa validar se a novaPessoa tem todos os atributos não nulos e preenchidos
    // OBS: pode ter um método que cria a nova pessoa e tenta atualizar, igual ao criar e cadastrar
    public boolean atualizarPessoa(Pessoa novaPessoa) {

        boolean atualizadoComSucesso = false;

        // se tiver todos os atributos não nulos e não vazios, novaPessoa pode substituir
        if (novaPessoa.getNome() != null && !novaPessoa.getNome().isEmpty()
                && novaPessoa.getEmail() != null && !novaPessoa.getEmail().isEmpty()
                && novaPessoa.getSenha() != null && !novaPessoa.getSenha().isEmpty()
                && novaPessoa.getTelefone() != null && !novaPessoa.getTelefone().isEmpty()
                && novaPessoa.getDataNascimento() != null) {
            atualizadoComSucesso = repo.atualizarPessoaComMesmoEmail(novaPessoa);
        }
        return atualizadoComSucesso;
    }

    // delegates
    public Pessoa buscarPessoaPorEmail(String email) {
        return repo.buscarPessoaPorEmail(email);
    }
    public boolean removerPessoaPorEmail(String email) {
        return repo.removerPessoaPorEmail(email);
    }

    // delegate dos listar






    // Getters
//    public IRepositorioPessoa getRepositorioPessoa() {
//        return repo;
//    }
    public ArrayList<Pessoa> getRepositorioPessoa() {
        return repo.getRepositorioPessoa();
    }



}
