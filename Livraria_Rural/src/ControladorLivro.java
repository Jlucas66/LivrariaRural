import dados.RepositorioLivro;

public class ControladorLivro {

    // Atributos
    private RepositorioLivro repositorioLivro;
    private static ControladorLivro instance;

    // Construtor
    private ControladorLivro() {
        this.repositorioLivro = new RepositorioLivro();
    }
    public static ControladorLivro getInstance() {
        if (instance == null) {
            instance = new ControladorLivro();
        }
        return instance;
    }

    // Metodos

    // cadastrar
    // remover

    // delegate dos listar






}
