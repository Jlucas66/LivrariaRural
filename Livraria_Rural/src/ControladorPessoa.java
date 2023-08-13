import dados.RepositorioPessoa;

public class ControladorPessoa {

    // Atributos
    private RepositorioPessoa repositorioPessoa;
    private static ControladorPessoa instance;

    // Construtor
    private ControladorPessoa() {
        this.repositorioPessoa = new RepositorioPessoa();
    }
    public static ControladorPessoa getInstance() {
        if (instance == null) {
            instance = new ControladorPessoa();
        }
        return instance;
    }

    // Metodos

    // cadastrar
    // remover

    // delegate dos listar

}
