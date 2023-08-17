import beans.ItemVenda;
import beans.Livro;
import beans.Pessoa;
import dados.IRepositorioPessoa;
import dados.RepositorioPessoa;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {

        ControladorPessoa controladorPessoa = ControladorPessoa.getInstance();
        ControladorLivro controladorLivro = ControladorLivro.getInstance();

        controladorPessoa.criarECadastrarPessoa("vazio", "email", "senha", "telefone", LocalDate.of(1989,3,25));


        for (Pessoa p : controladorPessoa.getRepositorioPessoa()) {
            System.out.println(p.getNome());
        }

        System.out.println();

        controladorPessoa.criarECadastrarAdministrador("martha", "email3", "senha", "telefone", LocalDate.of(1989,3,25));
        controladorPessoa.criarECadastrarPessoa("martha2", "email2", "senha", "telefone", LocalDate.of(1989,3,25));
        controladorPessoa.criarECadastrarPessoa("joao1", "email5", "senha", "telefone", LocalDate.of(1989,3,25));
        controladorPessoa.criarECadastrarPessoa("joao2", "email5", "senha", "telefone", LocalDate.of(1989,3,25));

        Pessoa p1 = new Pessoa("joao1", "email5", "senha", "telefone", LocalDate.of(1989,3,25), false);
        Pessoa p2 = new Pessoa("joao2", "email5", "senha", "telefone", LocalDate.of(1989,3,25), false);

        //controladorPessoa.atualizarPessoaComMesmoEmail(new Pessoa("jj", "email5", "senha", "telefone", LocalDate.of(1989,3,25), false));

        for (Pessoa p : controladorPessoa.getRepositorioPessoa()) {
            System.out.println(p.getNome());
        }

        controladorPessoa.removerPessoaPorEmail("email3");
        controladorPessoa.removerPessoaPorEmail("email5");

        System.out.println();
        for (Pessoa p : controladorPessoa.getRepositorioPessoa()) {
            System.out.println(p.getNome());
        }

        System.out.println(controladorPessoa.buscarPessoaPorEmail("emailnaoexiste")); //retorna nulo

        // LIVROS

        // criar livros
        Livro l1 = new Livro(1, "Titulo1", "autor1", "genero1", "sinope1", "editora1", "1", 20.90, 5);
        Livro l2 = new Livro(2, "Titulo2", "autor1", "genero1", "sinope1", "editora1", "1", 20.90, 5);
        Livro l3 = new Livro(3, "Titulo3", "autor1", "genero1", "sinope1", "editora1", "1", 20.90, 5);
        Livro l4 = new Livro(4, "Titulo4", "autor1", "genero1", "sinope1", "editora1", "1", 20.90, 5);
        Livro l5 = new Livro(1, "Titulo5", "autor1", "genero1", "sinope1", "editora1", "1", 20.90, 5);

        // cadastrar livros
        controladorLivro.cadastrarLivro(l1);
        controladorLivro.cadastrarLivro(l2);
        controladorLivro.cadastrarLivro(l3);
        controladorLivro.cadastrarLivro(l4);
        controladorLivro.cadastrarLivro(l5); // não cadastrou pq o id é igual


        for (Livro i : controladorLivro.getRepositorioLivro()) {
            System.out.println(i.getQuantidadeNoEstoque());
        }
        System.out.println();

        // diminuir qtd no estoque a partir do item venda
        ItemVenda it = new ItemVenda(l1, 2);
        controladorLivro.diminuirQtdDoLivro(it);
        for (Livro i : controladorLivro.getRepositorioLivro()) {
            System.out.println(i.getQuantidadeNoEstoque());
        }







    }
}
