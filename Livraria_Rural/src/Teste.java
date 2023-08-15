import beans.Pessoa;
import dados.IRepositorioPessoa;
import dados.RepositorioPessoa;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {

        ControladorPessoa controladorPessoa = ControladorPessoa.getInstance();

        controladorPessoa.criarECadastrarPessoa("vazio", "email", "senha", "telefone", LocalDate.of(1989,3,25));


        for (Pessoa p : controladorPessoa.getRepositorioPessoa().getRepositorioPessoa()) {
            System.out.println(p.getNome());
        }

        System.out.println();

        controladorPessoa.criarECadastrarAdministrador("martha", "email3", "senha", "telefone", LocalDate.of(1989,3,25));
        controladorPessoa.criarECadastrarPessoa("martha2", "email2", "senha", "telefone", LocalDate.of(1989,3,25));
        controladorPessoa.criarECadastrarPessoa("joao1", "email5", "senha", "telefone", LocalDate.of(1989,3,25));
        //controladorPessoa.criarECadastrarPessoa("joao2", "email5", "senha", "telefone", LocalDate.of(1989,3,25));

//        Pessoa p1 = new Pessoa("joao1", "email5", "senha", "telefone", LocalDate.of(1989,3,25), false);
//        Pessoa p2 = new Pessoa("joao2", "email5", "senha", "telefone", LocalDate.of(1989,3,25), false);

        controladorPessoa.atualizarPessoaComMesmoEmail(new Pessoa("jj", "email5", "senha", "telefone", LocalDate.of(1989,3,25), false));

        for (Pessoa p : controladorPessoa.getRepositorioPessoa().getRepositorioPessoa()) {
            System.out.println(p.getNome());
        }

        controladorPessoa.removerPessoaPorEmail("email3");
        controladorPessoa.removerPessoaPorEmail("email5");

        System.out.println();
        for (Pessoa p : controladorPessoa.getRepositorioPessoa().getRepositorioPessoa()) {
            System.out.println(p.getNome());
        }


        System.out.println(controladorPessoa.buscarPessoaPorEmail("emailnaoexiste")); //retorna nulo

    }
}
