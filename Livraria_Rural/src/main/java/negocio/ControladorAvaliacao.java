package negocio;

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
     * avaliarLivro - cria a avaliação, e coloca a avaliação dentro do arrayList de avaliações do livro,
     *                  se a pessoa já avaliou, a nota e comentario serão atualizados.
     * @param livro - não pode ser nulo
     * @param pessoa - não pode ser nulo
     * @param nota - deve ser de 1 a 5
     * @param comentario - pode ser nulo, se a pessoa não escrever nada
     * @return true se conseguiu realizar a operação.
     */
    public boolean avaliarLivro(Livro livro, Pessoa pessoa, int nota, String comentario) {
        boolean avaliou = false;
        if (livro != null && pessoa != null && nota >= 1 && nota <= 5) {

            for (Avaliacao avaliacaoJaCadastrada : livro.getAvaliacoes()) {
                if (avaliacaoJaCadastrada.getPessoa().equals(pessoa) && avaliacaoJaCadastrada.getLivro().equals(livro)) {
                    // aqui a pessoa está tentando avaliar um livro que já avaliou
                    // então a nota e comentario vão ser alterados
                    avaliacaoJaCadastrada.setNota(nota);
                    avaliacaoJaCadastrada.setComentario(comentario);
                } else {
                    // a pessoa nunca avaliou esse livro, então pode criar avaliação
                    livro.getAvaliacoes().add(new Avaliacao(pessoa, livro, nota, comentario));
                }
            }
            avaliou = true;
        }
        return avaliou;
    }





}
