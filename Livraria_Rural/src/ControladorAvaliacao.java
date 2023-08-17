import beans.Avaliacao;
import beans.Livro;
import beans.Pessoa;

public class ControladorAvaliacao {

    // Atributos
    private static ControladorAvaliacao instance;

    // Construtor
    private ControladorAvaliacao() {}
    public static ControladorAvaliacao getInstance() {
        if (instance == null) {
            instance = new ControladorAvaliacao();
        }
        return instance;
    }

    // Metodos

    /**
     * avaliarLivro - cria a avaliação, e coloca a avaliação dentro do arrayList de avaliações do livro.
     * @param livro - não pode ser nulo
     * @param pessoa - não pode ser nulo
     * @param nota - deve ser de 1 a 5
     * @return true se conseguiu realizar a operação.
     */
    public boolean avaliarLivro(Livro livro, Pessoa pessoa, int nota) {
        boolean avaliou = false;
        if (livro != null && pessoa != null && nota >= 1 && nota <= 5) {
            // pode avaliar
            livro.getAvaliacoes().add(new Avaliacao(pessoa, livro, nota));

            avaliou = true;
        }
        return avaliou;
    }




}
