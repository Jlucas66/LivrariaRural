import beans.*;
import dados.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestePrincipal {
    public static void main(String[] args) {

        // instanciar interfaces
        IRepositorioPessoa repositorioPessoa = new RepositorioPessoa();
        IRepositorioLivro repositorioLivro = new RepositorioLivro();
        IRepositorioVenda repositorioVenda = new RepositorioVenda();

        // criar Administradores
        Administrador adm1 = new Administrador("Administrador1", "adm1@email.com", "senha1", "999991234", LocalDate.of(1989, 3, 25));
        Administrador adm2 = new Administrador("Administrador2", "adm2@email.com", "senha2", "999991235", LocalDate.of(1990, 4, 5));
        Administrador adm3 = new Administrador("Administrador3", "adm3@email.com", "senha3", "999991236", LocalDate.of(1991, 5, 2));
        Administrador adm4 = new Administrador("Administrador4", "adm4@email.com", "senha4", "999991237", LocalDate.of(1992, 6, 15));
        Administrador adm5 = new Administrador("Administrador5", "adm5@email.com", "senha5", "999991238", LocalDate.of(1993, 7, 20));
        repositorioPessoa.inserirPessoa(adm1);
        repositorioPessoa.inserirPessoa(adm2);
        repositorioPessoa.inserirPessoa(adm3);
        repositorioPessoa.inserirPessoa(adm4);
        repositorioPessoa.inserirPessoa(adm5);

        // criar Clientes
        Cliente c1 = new Cliente("Cliente1", "cliente1@email.com", "s1", "988881234", LocalDate.of(1995, 8, 2));
        Cliente c2 = new Cliente("Cliente2", "cliente2@email.com", "s2", "988881235", LocalDate.of(2000, 2, 3));
        Cliente c3 = new Cliente("Cliente3", "cliente3@email.com", "s3", "988881236", LocalDate.of(1998, 2, 4));
        Cliente c4 = new Cliente("Cliente4", "cliente4@email.com", "s4", "988881237", LocalDate.of(1975, 3, 21));
        Cliente c5 = new Cliente("Cliente5", "cliente5@email.com", "s5", "988881238", LocalDate.of(1988, 12, 11));
        Cliente c6 = new Cliente("Cliente6", "cliente6@email.com", "s1", "988881239", LocalDate.of(1997, 11, 19));
        Cliente c7 = new Cliente("Cliente7", "cliente7@email.com", "s3", "988881231", LocalDate.of(1999, 1, 30));
        Cliente c8 = new Cliente("Cliente8", "cliente8@email.com", "s8", "988881232", LocalDate.of(2002, 9, 17));
        Cliente c9 = new Cliente("Cliente9", "cliente9@email.com", "s9", "988881233", LocalDate.of(2000, 5, 8));
        Cliente c10 = new Cliente("Cliente10", "cliente10@email.com", "s11", "988881233", LocalDate.of(1992, 10, 9));
        Cliente c11 = new Cliente("Cliente11", "cliente10@email.com", "s11", "988881111", LocalDate.of(1992, 1, 9));
        repositorioPessoa.inserirPessoa(c1);
        repositorioPessoa.inserirPessoa(c2);
        repositorioPessoa.inserirPessoa(c3);
        repositorioPessoa.inserirPessoa(c4);
        repositorioPessoa.inserirPessoa(c5);
        repositorioPessoa.inserirPessoa(c6);
        repositorioPessoa.inserirPessoa(c7);
        repositorioPessoa.inserirPessoa(c8);
        repositorioPessoa.inserirPessoa(c9);
        repositorioPessoa.inserirPessoa(c10);
        repositorioPessoa.inserirPessoa(c11);   // cliente com email igual


        // criar Livros
        Livro livro1 = new Livro(1001, "Titulo 1", "Autor 1", "Genero 1", "Sinopse 1", "Editora A", "1", 40.0,5);
        Livro livro2 = new Livro(1002, "Titulo 2", "Autor 1", "Genero 1", "Sinopse 2", "Editora A", "3", 55.0,5);
        Livro livro3 = new Livro(1003, "Titulo 3", "Autor 1", "Genero 2", "Sinopse 3", "Editora B", "4", 50.0,5);
        Livro livro4 = new Livro(1004, "Titulo 4", "Autor 1", "Genero 2", "Sinopse 4", "Editora B", "1", 71.0,5);
        Livro livro5 = new Livro(1005, "Titulo 5", "Autor 2", "Genero 1", "Sinopse 5", "Editora C", "2", 25.0,5);
        Livro livro6 = new Livro(1006, "Titulo 6", "Autor 2", "Genero 1", "Sinopse 6", "Editora A", "1", 120.0,5);
        Livro livro7 = new Livro(1007, "Titulo 7", "Autor 2", "Genero 1", "Sinopse 7", "Editora B", "1", 140.0,5);
        Livro livro8 = new Livro(1008, "Titulo 8", "Autor 3", "Genero 3", "Sinopse 8", "Editora A", "1", 64.0,5);
        Livro livro9 = new Livro(1009, "Titulo 9", "Autor 3", "Genero 3", "Sinopse 9", "Editora C", "1", 49.0,5);
        Livro livro10 = new Livro(1010, "Titulo 10", "Autor 3", "Genero 3", "Sinopse 10", "Editora D", "1", 55.0,5);
        Livro livro11 = new Livro(1011, "Titulo 11", "Autor 3", "Genero 4", "Sinopse 11", "Editora D", "1", 48.0,5);
        Livro livro12 = new Livro(1012, "Titulo 12", "Autor 4", "Genero 4", "Sinopse 12", "Editora E", "1", 37.0,5);
        Livro livro13 = new Livro(1013, "Titulo 13", "Autor 4", "Genero 4", "Sinopse 13", "Editora E", "1", 129.0,5);
        Livro livro14 = new Livro(1014, "Titulo 14", "Autor 4", "Genero 1", "Sinopse 14", "Editora B", "1", 46.0,5);
        Livro livro15 = new Livro(1015, "Titulo 15", "Autor 5", "Genero 2", "Sinopse 15", "Editora B", "1", 85.0,5);
        Livro livro16 = new Livro(1016, "Titulo 16", "Autor 5", "Genero 2", "Sinopse 16", "Editora A", "1", 115.0,5);
        Livro livro17 = new Livro(1017, "Titulo 17", "Autor 5", "Genero 1", "Sinopse 17", "Editora C", "1", 44.0,5);
        Livro livro18 = new Livro(1018, "Titulo 18", "Autor 5", "Genero 1", "Sinopse 18", "Editora D", "1", 52.0,5);
        Livro livro19 = new Livro(1019, "Titulo 19", "Autor 6", "Genero 2", "Sinopse 19", "Editora D", "1", 42.0,5);
        Livro livro20 = new Livro(1020, "Titulo 20", "Autor 6", "Genero 2", "Sinopse 20", "Editora C", "1", 30.0,5);
        repositorioLivro.inserirLivro(livro1);
        repositorioLivro.inserirLivro(livro2);
        repositorioLivro.inserirLivro(livro3);
        repositorioLivro.inserirLivro(livro4);
        repositorioLivro.inserirLivro(livro5);
        repositorioLivro.inserirLivro(livro6);
        repositorioLivro.inserirLivro(livro7);
        repositorioLivro.inserirLivro(livro8);
        repositorioLivro.inserirLivro(livro9);
        repositorioLivro.inserirLivro(livro10);
        repositorioLivro.inserirLivro(livro11);
        repositorioLivro.inserirLivro(livro12);
        repositorioLivro.inserirLivro(livro13);
        repositorioLivro.inserirLivro(livro14);
        repositorioLivro.inserirLivro(livro15);
        repositorioLivro.inserirLivro(livro16);
        repositorioLivro.inserirLivro(livro17);
        repositorioLivro.inserirLivro(livro18);
        repositorioLivro.inserirLivro(livro19);
        repositorioLivro.inserirLivro(livro20);

        // avaliar Livros
        Avaliacao aval1 = new Avaliacao(c1, livro1, 4);
        Avaliacao aval2 = new Avaliacao(c1, livro2, 3);
        Avaliacao aval3 = new Avaliacao(c2, livro3, 4);
        Avaliacao aval4 = new Avaliacao(c3, livro1, 5);
        Avaliacao aval5 = new Avaliacao(c4, livro2, 5);
        Avaliacao aval6 = new Avaliacao(c5, livro3, 2);
        Avaliacao aval7 = new Avaliacao(c5, livro1, 2);
        Avaliacao aval8 = new Avaliacao(c4, livro3, 3);
        Avaliacao aval9 = new Avaliacao(c3, livro3, 3);
        Avaliacao aval10 = new Avaliacao(c2, livro4, 2, "Deixou a desejar");
        Avaliacao aval11 = new Avaliacao(c2, livro2, 1, "Esperava bem mais!");

        // criar Venda / ItemVenda
        ItemVenda iv1 = new ItemVenda(livro1, 2);
        ItemVenda iv2 = new ItemVenda(livro2, 1);
        ItemVenda iv3 = new ItemVenda(livro3, 3);
        ItemVenda iv4 = new ItemVenda(livro4, 1);
        ItemVenda iv5 = new ItemVenda(livro5, 2);
        ItemVenda iv6 = new ItemVenda(livro6, 1);
        ItemVenda iv7 = new ItemVenda(livro6, 1);
        ItemVenda iv8 = new ItemVenda(livro8, 2);
        ItemVenda iv9 = new ItemVenda(livro9, 1);
        ItemVenda iv10 = new ItemVenda(livro10, 1);
        ArrayList<ItemVenda> itens1 = new ArrayList<>();
        ArrayList<ItemVenda> itens2 = new ArrayList<>();
        ArrayList<ItemVenda> itens3 = new ArrayList<>();
        ArrayList<ItemVenda> itens4 = new ArrayList<>();
        ArrayList<ItemVenda> itens5 = new ArrayList<>();
        itens1.add(iv1);
        itens1.add(iv2);
        itens2.add(iv3);
        itens2.add(iv4);
        itens3.add(iv5);
        itens3.add(iv6);
        itens4.add(iv7);
        itens4.add(iv8);
        itens5.add(iv9);
        itens5.add(iv10);
        Venda v1 = new Venda(1, c1, itens1, 0);
        Venda v2 = new Venda(2, c2, itens2, 10);
        Venda v3 = new Venda(3, c3, itens3, 20);
        Venda v4 = new Venda(4, c4, itens4, 0);
        Venda v5 = new Venda(5, c5, itens5, 5);
        Venda v6 = new Venda(6, c6, itens1, 0);
        repositorioVenda.inserirVenda(v1);
        repositorioVenda.inserirVenda(v2);
        repositorioVenda.inserirVenda(v3);
        repositorioVenda.inserirVenda(v4);
        repositorioVenda.inserirVenda(v5);
        repositorioVenda.inserirVenda(v6);


        // buscar pessoa
        System.out.println("buscando pessoa:");
        Pessoa p1 = repositorioPessoa.buscarPessoaPorEmail("cliente9@email.com");
        System.out.println(p1.getNome());

        // remover pessoa
        System.out.println("\nremovendo pessoa:");
        repositorioPessoa.removerPessoaPorEmail("cliente9@email.com");
        Pessoa p2 = repositorioPessoa.buscarPessoaPorEmail("cliente9@email.com");   // falta tratamento de erro
        System.out.println(p2);

        // atualizar pessoa
        System.out.println("\natualizando pessoa:");
        System.out.println(c1.getEndereco());       // imprimindo null - tratar para imprimir outra coisa
        repositorioPessoa.atualizarEndereco(c1, "Rua 1, 111");
        System.out.println(c1.getEndereco());
        repositorioPessoa.atualizarEndereco(c1, "");
        System.out.println(c1.getEndereco());

        // buscar livro
        System.out.println("\nbuscando livro :");
        System.out.println(repositorioLivro.buscarLivroPorId(1001).getTitulo());
        //System.out.println(repositorioLivro.buscarLivroPorId(4001).getTitulo());    // tratar para id invalido

        // remover livro
        System.out.println("\nremovendo livro :");
        System.out.println(repositorioLivro.buscarLivroPorId(1020).getTitulo());
        repositorioLivro.removerLivro(livro20);
        System.out.println(repositorioLivro.buscarLivroPorId(1020));

        // atualizar livro
        System.out.println("\natualizando livro :");
        System.out.println(livro19.getEditora());
        repositorioLivro.atualizarEditora(livro19, "Arqueiro");
        System.out.println(livro19.getEditora());

        // buscar venda
        System.out.println("\nbuscando venda :");
        System.out.println(repositorioVenda.buscarVendaPorId(1).calcularTotal());
        System.out.println(repositorioVenda.buscarVendaPorId(2).getCliente().getNome());

        System.out.println("\nverificando se desconto está funcionando::");
        Venda v7 = new Venda(7, c4, itens4, 0);
        Venda v8 = new Venda(8, c4, itens4, 10);
        System.out.println(v7.calcularTotal());
        System.out.println(v8.calcularTotal());
        System.out.println();

        // remover venda
        System.out.println("\nremovendo venda :");
        System.out.println(repositorioVenda.buscarVendaPorId(5).calcularTotal());
        System.out.println(repositorioVenda.buscarVendaPorId(5).getCliente().getNome());
        repositorioVenda.removerVendaPorId(5);
        //System.out.println(repositorioVenda.buscarVendaPorId(5).calcularTotal());   // falta tratar para venda inexistente
        //System.out.println(repositorioVenda.buscarVendaPorId(5).getCliente().getNome()); // falta tratar para venda inexistente

        // atualizar venda
        System.out.println("\natualizando venda :");
        System.out.println(v1.getStatus());
        //repositorioVenda.atualizarStatusDaVenda(v1,"concluída");
        System.out.println(v1.getStatus());

        System.out.println();

        System.out.println("\nconteúdo do repositório de pessoa:");
        for (Pessoa p : repositorioPessoa.getRepositorioPessoa()) {
            System.out.println(p.getEmail());
        }

        System.out.println();

        System.out.println("\nconteúdo do repositório de livro:");
        System.out.println();
        for (Livro liv : repositorioLivro.getRepositorioLivro()) {
            System.out.println(liv.getTitulo());
        }

        System.out.println();

        System.out.println("\nconteúdo do repositório de venda:");
        for (Venda v : repositorioVenda.getRepositorioVenda()) {
            System.out.println(v.getCliente().getNome());
        }







    }
}
