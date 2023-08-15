import beans.Pessoa;
import dados.IRepositorioPessoa;
import dados.RepositorioPessoa;

import java.time.LocalDate;

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

    public void criarECadastrarPessoa(String nome, String email, String senha, String telefone, LocalDate dataNascimento) {

        // se tiver todos os atributos não nulos e não vazios, pessoa pode ser criada
        if (nome != null && !nome.isEmpty()
                && email != null && !email.isEmpty()
                && senha != null && !senha.isEmpty()
                && telefone != null && !telefone.isEmpty()
                && dataNascimento != null) {
            Pessoa pessoa = new Pessoa(nome, email, senha, telefone, dataNascimento, false);

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
        } else {
            //System.out.println("pessoa não criada");
        }
        //System.out.println("final do metodo");
    }

    public void criarECadastrarAdministrador(String nome, String email, String senha, String telefone, LocalDate dataNascimento) {

        // se tiver todos os atributos não nulos e não vazios, pessoa pode ser criada
        if (nome != null && !nome.isEmpty()
                && email != null && !email.isEmpty()
                && senha != null && !senha.isEmpty()
                && telefone != null && !telefone.isEmpty()
                && dataNascimento != null) {
            Pessoa pessoa = new Pessoa(nome, email, senha, telefone, dataNascimento, true);

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
        } else {
            //System.out.println("pessoa não criada");
        }
        //System.out.println("final do metodo");
    }

    public void removerPessoaPorEmail(String email) {
        if (email != null && !email.isEmpty()) {
            repo.removerPessoaPorEmail(email);
        }
    }

    public Pessoa buscarPessoaPorEmail(String email) {
        return repo.buscarPessoaPorEmail(email);
    }

    // delegates
    public boolean atualizarPessoaComMesmoEmail(Pessoa novaPessoa) {
        return repo.atualizarPessoaComMesmoEmail(novaPessoa);
    }

    public IRepositorioPessoa getRepositorioPessoa() {
        return repo;
    }

    // lembrar dos listar


//    public RepositorioPessoa getRepositorioPessoa() {
//        return repositorioPessoa;
//    }




    // delegate dos listar

}
