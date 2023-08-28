package negocio;

import beans.*;
import org.controlsfx.control.PropertySheet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

public class Teste {
        public static void main(String[] args) {
                ControladorPessoa controladorPessoa = ControladorPessoa.getInstance();
                ControladorLivro controladorLivro = ControladorLivro.getInstance();
                ControladorVenda controladorVenda = ControladorVenda.getInstance();
                ControladorPromocao controladorPromocao = ControladorPromocao.getInstance();

                controladorPessoa.carregarPessoasDeArquivo("Livraria_Rural/pessoas.ser");
                controladorLivro.carregarLivrosDeArquivo("Livraria_Rural/livros.ser");
                controladorVenda.carregarVendasDeArquivo("Livraria_Rural/vendas.ser");
                controladorPromocao.carregarPromocaoDeArquivo("Livraria_Rural/promocao.ser");

                System.out.println("tamanho de pessoas.ser = " + controladorPessoa.getRepositorioPessoa().size());
                System.out.println("tamanho de vendas.ser = " + controladorVenda.getRepositorioVenda().size());
                System.out.println("tamanho de promocao.ser = " + controladorPromocao.getRepositorioPromocao().size());
                System.out.println("tamanho de livros.ser = " + controladorLivro.getRepositorioLivro().size());

                for (Promocao p : controladorPromocao.getRepositorioPromocao()) {
                        System.out.println(p.getNomePromocao());
                        System.out.printf("%1$td/%1$tm/%1$ty\n", p.getInicio());
                        System.out.printf("%1$td/%1$tm/%1$ty\n", p.getFim());

                }

                System.out.println();

                System.out.println("testando avaliações");
                for (Livro i : controladorLivro.getRepositorioLivro()) {
                        System.out.println(i.getId() + " - " + i.getAvaliacoes().size());
                }
                System.out.println(controladorLivro.buscarLivroPorId(4).getAvaliacoes().get(0).getPessoa().getNome());

                System.out.println();



//                //criar 3 vendas para testar
//                System.out.println(controladorVenda.inserirVenda(new Venda(controladorPessoa.buscarPessoaPorEmail("martha@email.com"))));
//                System.out.println(controladorVenda.inserirVenda(new Venda(controladorPessoa.buscarPessoaPorEmail("alex@email.com"))));
//                System.out.println(controladorVenda.inserirVenda(new Venda(controladorPessoa.buscarPessoaPorEmail("caio@email.com"))));
//
//                // itens de venda
//                ItemVenda itemvenda1 = new ItemVenda(controladorLivro.buscarLivroPorId(1), 1);
//                ItemVenda itemvenda2 = new ItemVenda(controladorLivro.buscarLivroPorId(2), 1);
//                ItemVenda itemvenda3 = new ItemVenda(controladorLivro.buscarLivroPorId(3), 1);
//                ItemVenda itemvenda4 = new ItemVenda(controladorLivro.buscarLivroPorId(4), 1);
//                ItemVenda itemvenda5 = new ItemVenda(controladorLivro.buscarLivroPorId(5), 1);
//                ItemVenda itemvenda6 = new ItemVenda(controladorLivro.buscarLivroPorId(6), 1);
//                ArrayList<ItemVenda> itens1 = new ArrayList<>();
//                ArrayList<ItemVenda> itens2 = new ArrayList<>();
//                itens1.add(itemvenda1);
//                itens1.add(itemvenda2);
//                itens1.add(itemvenda3);
//                itens2.add(itemvenda4);
//                itens2.add(itemvenda5);
//                itens2.add(itemvenda6);
//                System.out.println(controladorVenda.getRepositorioVenda().size());
//                for (Venda v : controladorVenda.getRepositorioVenda()) {
//                        System.out.println("imprimindo venda");
//                        System.out.println(v.getPessoa().getNome());
//                }
//
//                // colocar itens venda dentro das vendas
//                controladorVenda.getRepositorioVenda().get(0).setItensDaVenda(itens1);
//                controladorVenda.getRepositorioVenda().get(1).setItensDaVenda(itens2);
//                controladorVenda.getRepositorioVenda().get(2).setItensDaVenda(itens1);
//
//                // salvar essas vendas no repositório
//                controladorVenda.salvarVendasEmArquivo("Livraria_Rural/vendas.ser");

                // criar usuários não administradores
//                controladorPessoa.criarECadastrarPessoa("Martha", "martha@email.com", "1234", "Rua 1", LocalDate.of(1989,3,25));
//                controladorPessoa.criarECadastrarPessoa("João", "joao@email.com", "1234", "Rua 2", LocalDate.of(1995,9,15));
//                controladorPessoa.criarECadastrarPessoa("Alex", "alex@email.com", "1234", "Rua 3", LocalDate.of(2004,12,15));
//                controladorPessoa.criarECadastrarPessoa("Caio", "caio@email.com", "1234", "Rua 4", LocalDate.of(2004,5,15));
//                controladorPessoa.criarECadastrarPessoa("Elys", "elys@email.com", "1234", "Rua 5", LocalDate.of(1983,1,28));
//                controladorPessoa.criarECadastrarPessoa("Teresa", "teresa@email.com", "1234", "Rua 6", LocalDate.of(1955,8,1));

                // criar usuários administradores
                //controladorPessoa.criarECadastrarAdministrador("Administrador", "adm@email.com", "1234", "Rua qualquer", LocalDate.of(1982,3,5));

                //carregar objetos do arquivo ser
                //controladorPessoa.carregarPessoasDeArquivo("Livraria_Rural/pessoas.ser");
                //controladorPessoa.removerPessoaPorEmail("adm2@email.com");
                // verificar conteúdo do repo pessoa
//                for (Pessoa p : controladorPessoa.getRepositorioPessoa()) {
//                        System.out.println(p.getNome());
//                }

                // salvar no arquivo ser
                //controladorPessoa.salvarPessoasEmArquivo("Livraria_Rural/pessoas.ser");

                //LocalDate d1Inicio=LocalDate.of(2023,8,1);
                //LocalDate d1Fim=LocalDate.of(2023,8,30);
                //Promocao pDiaDosPais=new Promocao(d1Inicio,d1Fim,5,"Dia dos Pais");

                //ControladorPromocao controladorPromocao= ControladorPromocao.getInstance();
               // controladorPromocao.cadastraNovaPromocao(d1Inicio,d1Fim,5,"Dia dos Pais");


                //controladorPromocao.salvarPprEmArquivo("Livraria_Rural/promocao.ser");
                //controladorPromocao.carregarPessoasDeArquivo("Livraria_Rural/promocao.ser");






        }
}
