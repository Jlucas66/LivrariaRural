package dados;

import beans.Pessoa;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioPessoa {

    // Metodos CRUD

        // inserir
    boolean inserirPessoa(Pessoa pessoa);

        // remover
    boolean removerPessoaPorEmail(String email);

        // buscar
    Pessoa buscarPessoaPorEmail(String email);

        // atualizar
    boolean atualizarPessoaComMesmoEmail(Pessoa novaPessoa);

    /*
    void atualizarNome(Pessoa pessoa, String novoNome);
    void atualizarEmail(Pessoa pessoa, String novoEmail);
    void atualizarSenha(Pessoa pessoa, String novaSenha);
    void atualizarTelefone(Pessoa pessoa, String novoTelefone);
    void atualizarEndereco(Pessoa pessoa, String novoEndereco);
    void atualizarDataNascimento(Pessoa pessoa, LocalDate novaData);
    */

    void carregarPessoasDoArquivo(String nomeArquivo);
    void salvarPessoaNoArquivo(Pessoa pessoa, String nomeArquivo) throws IOException;
    void carregarPessoasDeArquivo(String nomeArquivo);
    void salvarPessoasEmArquivo(String nomeArquivo);

    ArrayList<Pessoa> getRepositorioPessoa();


}
