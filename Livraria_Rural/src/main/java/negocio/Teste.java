package negocio;

import beans.*;
import org.controlsfx.control.PropertySheet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

                System.out.println();


                //criando os livros
                //Terror
                //Livro livro1 = new Livro(long id, String titulo, String autor, String genero, String sinopse, String editora, String edicao, Double preco, Integer quantidadeNoEstoque);

                Livro livro1 = new Livro(1, "O Iluminado", "Stephen King", "Terror", "Um homem e sua família se mudam para um hotel isolado no inverno, mas eventos sobrenaturais começam a acontecer.","Suma", "2ª edição", 29.99, 20);
                Livro livro2 = new Livro(2, "Psicose", "Robert Bloch", "Terror", "Uma mulher comete um erro fatal ao parar em um motel isolado administrado por um zelador perturbado.", "Darkside Books", "2ª edição", 24.99, 18);
                Livro livro3 = new Livro(3, "O Exorcista", "William Peter Blatty", "Terror", "Um padre é chamado para realizar um exorcismo em uma jovem possuída por uma entidade maligna.", "HarperCollins", "1ª edição", 27.50, 23);
                Livro livro4 = new Livro(4, "Cemitério Maldito", "Stephen King", "Terror", "Uma família descobre um cemitério que pode trazer os mortos de volta à vida, mas com consequências terríveis.", "Suma", "3ª edição", 22.75, 6);
                Livro livro5 = new Livro(5, "It: A Coisa", "Stephen King", "Terror", "Um grupo de amigos enfrenta uma entidade maligna que assume a forma de seus piores medos.", "Suma", "1ª edição", 34.50, 17);
                Livro livro6 = new Livro(6, "O Chamado de Cthulhu", "H.P. Lovecraft", "Terror", "Um conto de horror cósmico que envolve a descoberta de uma antiga entidade que ameaça a sanidade humana.", "Darkside Books", "2ª edição", 18.99, 19);
                Livro livro7 = new Livro(7, "O Médico e o Monstro", "Robert Louis Stevenson", "Terror", "Um médico cria uma poção que libera seus impulsos mais sombrios, transformando-o no cruel Mr. Hyde.", "Pandorga Editora", "1ª edição", 20.00, 4);
                Livro livro8 = new Livro(8, "A Assombração da Casa da Colina", "Shirley Jackson", "Terror", "Um grupo de pessoas passa uma noite em uma mansão assombrada para provar a existência de atividade paranormal.", "Alfaguara", "2ª edição", 26.25, 22);
                Livro livro9 = new Livro(9, "Carrie, a Estranha", "Stephen King", "Terror", "Uma adolescente com poderes telecinéticos busca vingança contra seus colegas após anos de humilhação.", "Suma", "2ª edição", 23.50, 10);
                Livro livro10 = new Livro(10, "O Bebê de Rosemary", "Ira Levin", "Terror", "Uma mulher grávida suspeita que seu marido e seus vizinhos têm planos sinistros para seu filho por nascer.", "Darkside Books", "1ª edição", 21.99, 31);


                //Ficção Científica

                Livro livro11 = new Livro(11, "1984", "George Orwell", "Ficção Científica", "Em um mundo totalitário, um homem luta contra o sistema opressivo que controla todos os aspectos da vida.", "Via Leitura", "1ª edição", 28.50, 17);
                Livro livro12 = new Livro(12, "Duna", "Frank Herbert", "Ficção Científica", "Em um planeta desértico, uma história épica se desenrola, envolvendo política, religião e recursos preciosos.", "Aleph", "2ª edição", 32.00, 24);
                Livro livro13 = new Livro(13, "Neuromancer", "William Gibson", "Ficção Científica", "Um hacker é contratado para realizar uma tarefa impossível em um mundo digitalizado e distópico.", "Aleph", "1ª edição", 23.75, 18);
                Livro livro14 = new Livro(14, "Fundação", "Isaac Asimov", "Ficção Científica", "Um matemático desenvolve um método para prever o futuro e tenta guiar a humanidade através da queda do Império Galáctico.", "Aleph", "3ª edição", 26.99, 26);
                Livro livro15 = new Livro(15, "Blade Runner", "Philip K. Dick", "Ficção Científica", "No futuro, um detetive é encarregado de caçar replicantes, androides quase indistinguíveis de humanos.", "Aleph", "2ª edição", 19.50, 9);
                Livro livro16 = new Livro(16, "O Fim da Eternidade", "Isaac Asimov", "Ficção Científica", "Uma organização chamada Eternidade manipula a história humana para melhorar o futuro, mas nem tudo sai como planejado.", "Aleph", "1ª edição", 24.25, 15);
                Livro livro17 = new Livro(17, "O Homem do Castelo Alto", "Philip K. Dick", "Ficção Científica", "Em um mundo onde os Aliados perderam a Segunda Guerra Mundial, a vida segue um curso diferente sob o domínio japonês e nazista.", "Aleph", "1ª edição", 22.00, 12);
                Livro livro18 = new Livro(18, "Eu, Robô", "Isaac Asimov", "Ficção Científica", "Uma coletânea de histórias sobre robôs e as complexas relações entre humanos e máquinas inteligentes.", "Aleph", "2ª edição", 27.50, 10);
                Livro livro19 = new Livro(19, "Solaris", "Stanisław Lem", "Ficção Científica", "Uma equipe de cientistas que estuda um oceano vivo em um planeta distante enfrenta enigmas inexplicáveis e assustadores.", "Aleph", "1ª edição", 29.99, 23);
                Livro livro20 = new Livro(20, "A Mão Esquerda da Escuridão", "Ursula K. Le Guin", "Ficção Científica", "Um diplomata humano é enviado para um planeta cujos habitantes podem mudar de gênero, desafiando as normas de identidade de gênero.", "Aleph", "2ª edição", 21.75, 16);

                //Fantasia

                Livro livro21 = new Livro(21, "O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", "Fantasia", "Um jovem hobbit é incumbido de destruir um anel maligno que pode trazer a ruína ao mundo.", "Martins Fontes", "1ª edição", 35.99, 17);
                Livro livro22 = new Livro(22, "As Crônicas de Nárnia: O Leão, a Feiticeira e o Guarda-Roupa", "C.S. Lewis", "Fantasia", "Quatro crianças descobrem um mundo mágico através de um guarda-roupa e se envolvem em uma luta pelo destino de Nárnia.", "Martins Fontes", "2ª edição", 21.25, 25);
                Livro livro23 = new Livro(23, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", "Um jovem bruxo descobre seu verdadeiro destino ao ingressar na Escola de Magia e Bruxaria de Hogwarts.", "Rocco", "1ª edição", 29.00, 10);
                Livro livro24 = new Livro(24, "O Nome do Vento", "Patrick Rothfuss", "Fantasia", "A história do lendário Kvothe, um homem de muitas façanhas, contada por ele mesmo.", "Arqueiro", "1ª edição", 27.50, 27);
                Livro livro25 = new Livro(25, "A Guerra dos Tronos", "George R.R. Martin", "Fantasia", "Intrigas, poder e magia se entrelaçam enquanto famílias nobres disputam o trono de Westeros.", "Suma", "2ª edição", 31.75, 4);
                Livro livro26 = new Livro(26, "O Hobbit", "J.R.R. Tolkien", "Fantasia", "Um hobbit relutante parte em uma jornada épica para ajudar um grupo de anões a recuperar seu reino e tesouro perdidos.", "HarperCollins", "1ª edição", 24.99, 18);
                Livro livro27 = new Livro(27, "Percy Jackson e o Ladrão de Raios", "Rick Riordan", "Fantasia", "Um adolescente descobre que é um semideus e embarca em uma missão para evitar uma guerra entre os deuses gregos.", "Intrínseca", "1ª edição", 18.50, 36);
                Livro livro28 = new Livro(28, "O Vento pela Fechadura", "Stephen King", "Fantasia", "Dentro do mundo da série A Torre Negra, Roland Deschain enfrenta um desafio mágico enquanto conta uma história a seus companheiros.", "Suma", "2ª edição", 20.25, 19);
                Livro livro29 = new Livro(29, "O Ladrão de Raios", "Cornelia Funke", "Fantasia", "Um garoto e sua irmã viajam para dentro de um livro mágico onde enfrentam vilões e desafios perigosos.", "Intrínseca", "1ª edição", 23.99, 3);
                Livro livro30 = new Livro(30, "A Bússola de Ouro", "Philip Pullman", "Fantasia", "Uma jovem chamada Lyra embarca em uma jornada para o norte em busca de seu amigo sequestrado e descobre segredos mágicos e aterrorizantes.", "Suma", "2ª edição", 22.75, 12);

                //Suspense

                Livro livro31 = new Livro(31, "Garota Exemplar", "Gillian Flynn", "Suspense", "Quando a esposa de Nick desaparece, ele se torna o principal suspeito, e segredos sombrios emergem.", "Intrínseca", "1ª edição", 27.99, 28);
                Livro livro32 = new Livro(32, "O Silêncio dos Inocentes", "Thomas Harris", "Suspense", "Uma jovem agente do FBI busca a ajuda de um notório psicopata encarcerado para capturar outro serial killer.", "Record", "2ª edição", 25.50, 16);
                Livro livro33 = new Livro(33, "Sob a Redoma", "Stephen King", "Suspense", "Uma cidade é inexplicavelmente isolada por uma cúpula invisível, e seus habitantes lutam para sobreviver e desvendar o mistério.", "Suma", "1ª edição", 29.75, 25);
                Livro livro34 = new Livro(34, "Antes de Dormir", "S.J. Watson", "Suspense", "Uma mulher acorda todas as manhãs sem lembrar de nada, e começa a duvidar de quem pode confiar.", "Record", "1ª edição", 23.25, 19);
                Livro livro35 = new Livro(35, "A Garota no Trem", "Paula Hawkins", "Suspense", "Uma mulher observa diariamente uma casa durante seu trajeto de trem, mas acaba envolvida em um mistério sombrio.", "Record", "2ª edição", 21.99, 37);
                Livro livro36 = new Livro(36, "O Colecionador", "John Fowles", "Suspense", "Um homem perturbado sequestra uma mulher que ele considera a obra-prima de sua coleção pessoal.", "Darkside", "1ª edição", 18.50, 24);
                Livro livro37 = new Livro(37, "A Garota do Gelo", "Robert Bryndza", "Suspense", "Uma detetive investiga um serial killer que tem como alvo mulheres jovens, enquanto lida com seus próprios traumas.", "Gutenberg", "1ª edição", 20.00, 33);
                Livro livro38 = new Livro(38, "A Sombra do Vento", "Carlos Ruiz Zafón", "Suspense", "Um jovem se envolve em uma trama misteriosa após descobrir um livro de um autor desconhecido.", "Suma", "2ª edição", 24.75, 12);
                Livro livro39 = new Livro(39, "O Homem de Giz", "C.J. Tudor", "Suspense", "Um grupo de amigos é assombrado por eventos perturbadores do passado quando sinais enigmáticos reaparecem.", "Intrínseca", "1ª edição", 22.99, 10);
                Livro livro40 = new Livro(40, "A Última Casa da Rua", "Lily Blake", "Suspense", "Uma adolescente se muda para uma nova cidade e descobre segredos obscuros sobre a casa vizinha.", "Moderna", "1ª edição", 19.25, 26);
                
                //Romance

                Livro livro41 = new Livro(41, "Orgulho e Preconceito", "Jane Austen", "Romance", "Um romance clássico que segue as complexas relações entre Elizabeth Bennet e Mr. Darcy.", "Martin Claret", "1ª edição", 24.99, 10);
                Livro livro42 = new Livro(42, "Como Eu Era Antes de Você", "Jojo Moyes", "Romance", "Uma jovem cuidadora se envolve emocionalmente com um homem paralisado e muda sua perspectiva sobre a vida.", "Intrínseca", "2ª edição", 28.50, 18);
                Livro livro43 = new Livro(43, "Outlander", "Diana Gabaldon", "Romance", "Uma enfermeira da Segunda Guerra viaja no tempo e se apaixona por um guerreiro escocês no século XVIII.", "Arqueiro", "1ª edição", 32.75, 25);
                Livro livro44 = new Livro(44, "Cinquenta Tons de Cinza", "E.L. James", "Romance", "O encontro entre uma estudante universitária e um empresário leva a um relacionamento complexo e sensual.", "Intrínseca", "1ª edição", 19.99, 37);
                Livro livro45 = new Livro(45, "A Culpa É das Estrelas", "John Green", "Romance", "Dois adolescentes com câncer se apaixonam e enfrentam desafios emocionais e físicos juntos.", "Intrínseca", "2ª edição", 23.25, 19);
                Livro livro46 = new Livro(46, "P.S. Eu Te Amo", "Cecelia Ahern", "Romance", "Uma mulher lida com a perda de seu marido através de uma série de cartas planejadas deixadas para ela.", "HarperCollins", "1ª edição", 21.50, 36);
                Livro livro47 = new Livro(47, "Eleanor & Park", "Rainbow Rowell", "Romance", "Dois adolescentes desajustados se aproximam enquanto compartilham músicas e histórias em quadrinhos.", "Seguinte", "1ª edição", 18.75, 24);
                Livro livro48 = new Livro(48, "Me Chame Pelo Seu Nome", "André Aciman", "Romance", "Durante um verão na Itália, um jovem descobre sua sexualidade ao se apaixonar pelo convidado de seu pai.", "Intrínseca", "2ª edição", 26.00, 16);
                Livro livro49 = new Livro(49, "O Amor nos Tempos do Cólera", "Gabriel García Márquez", "Romance", "Dois amantes se encontram após décadas separados, explorando o amor e a paixão em suas vidas posteriores.", "Record", "1ª edição", 30.25, 33);
                Livro livro50 = new Livro(50, "O Diário de Bridget Jones", "Helen Fielding", "Romance", "Uma mulher solteira lida com a vida amorosa, o trabalho e as pressões sociais em seu diário cômico.", "Paralela", "1ª edição", 22.99, 25);

                controladorLivro.cadastrarLivro(livro1);
                controladorLivro.cadastrarLivro(livro2);
                controladorLivro.cadastrarLivro(livro3);
                controladorLivro.cadastrarLivro(livro4);
                controladorLivro.cadastrarLivro(livro5);
                controladorLivro.cadastrarLivro(livro6);
                controladorLivro.cadastrarLivro(livro7);
                controladorLivro.cadastrarLivro(livro8);
                controladorLivro.cadastrarLivro(livro9);
                controladorLivro.cadastrarLivro(livro10);

                controladorLivro.cadastrarLivro(livro11);
                controladorLivro.cadastrarLivro(livro12);
                controladorLivro.cadastrarLivro(livro13);
                controladorLivro.cadastrarLivro(livro14);
                controladorLivro.cadastrarLivro(livro15);
                controladorLivro.cadastrarLivro(livro16);
                controladorLivro.cadastrarLivro(livro17);
                controladorLivro.cadastrarLivro(livro18);
                controladorLivro.cadastrarLivro(livro19);
                controladorLivro.cadastrarLivro(livro20);

                controladorLivro.cadastrarLivro(livro21);
                controladorLivro.cadastrarLivro(livro22);
                controladorLivro.cadastrarLivro(livro23);
                controladorLivro.cadastrarLivro(livro24);
                controladorLivro.cadastrarLivro(livro25);
                controladorLivro.cadastrarLivro(livro26);
                controladorLivro.cadastrarLivro(livro27);
                controladorLivro.cadastrarLivro(livro28);
                controladorLivro.cadastrarLivro(livro29);
                controladorLivro.cadastrarLivro(livro30);

                controladorLivro.cadastrarLivro(livro31);
                controladorLivro.cadastrarLivro(livro32);
                controladorLivro.cadastrarLivro(livro33);
                controladorLivro.cadastrarLivro(livro34);
                controladorLivro.cadastrarLivro(livro35);
                controladorLivro.cadastrarLivro(livro36);
                controladorLivro.cadastrarLivro(livro37);
                controladorLivro.cadastrarLivro(livro38);
                controladorLivro.cadastrarLivro(livro39);
                controladorLivro.cadastrarLivro(livro40);

                controladorLivro.cadastrarLivro(livro41);
                controladorLivro.cadastrarLivro(livro42);
                controladorLivro.cadastrarLivro(livro43);
                controladorLivro.cadastrarLivro(livro44);
                controladorLivro.cadastrarLivro(livro45);
                controladorLivro.cadastrarLivro(livro46);
                controladorLivro.cadastrarLivro(livro47);
                controladorLivro.cadastrarLivro(livro48);
                controladorLivro.cadastrarLivro(livro49);
                controladorLivro.cadastrarLivro(livro50);

                controladorLivro.salvarLivrosEmArquivo("Livraria_Rural/livros.ser");

                






//                //criando vendas no repor 3 vendas para testar
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
