package negocio;

import beans.*;

import java.time.LocalDate;

public class Teste {
        public static void main(String[] args) {
                ControladorPessoa controladorPessoa = ControladorPessoa.getInstance();
                ControladorLivro controladorLivro = ControladorLivro.getInstance();
                ControladorVenda controladorVenda = ControladorVenda.getInstance();

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
                controladorPessoa.carregarPessoasDeArquivo("Livraria_Rural/pessoas.ser");
                //controladorPessoa.removerPessoaPorEmail("adm2@email.com");
                // verificar conteúdo do repo pessoa
                for (Pessoa p : controladorPessoa.getRepositorioPessoa()) {
                        System.out.println(p.getNome());
                }

                // salvar no arquivo ser
                controladorPessoa.salvarPessoasEmArquivo("Livraria_Rural/pessoas.ser");

                LocalDate d1Inicio=LocalDate.of(2023,8,1);
                LocalDate d1Fim=LocalDate.of(2023,8,30);
                //Promocao pDiaDosPais=new Promocao(d1Inicio,d1Fim,5,"Dia dos Pais");

                ControladorPromocao controladorPromocao= ControladorPromocao.getInstance();
                controladorPromocao.cadastraNovaPromocao(d1Inicio,d1Fim,5,"Dia dos Pais");


                //controladorPromocao.salvarPprEmArquivo("Livraria_Rural/promocao.ser");
                //controladorPromocao.carregarPessoasDeArquivo("Livraria_Rural/promocao.ser");






        }
}
