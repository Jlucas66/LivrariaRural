import dados.RepositorioVenda;

public class ControladorVenda {

    // Atributos
    private RepositorioVenda repositorioVenda;
    private static ControladorVenda instance;

    // Construtor
    private ControladorVenda() {
        this.repositorioVenda = new RepositorioVenda();
    }
    public static ControladorVenda getInstance() {
        if (instance == null) {
            instance = new ControladorVenda();
        }
        return instance;
    }

    // Metodos

    // cadastrar - criar a venda, colocar no repositorio, e aplicar desconto na venda criada.


    // remover

    // atualizar status da venda baseado na data

    // delegate dos listar



}
