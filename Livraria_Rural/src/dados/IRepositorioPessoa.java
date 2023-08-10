package dados;

import beans.Pessoa;

import java.time.LocalDate;

public interface IRepositorioPessoa {

    // Metodos CRUD

        // inserir
    void inserirPessoa(Pessoa pessoa);

        // remover
    void removerPessoaPorEmail(String email);

        // buscar
    Pessoa buscarPessoaPorEmail(String email);

        // atualizar
    void atualizarNome(Pessoa pessoa, String novoNome);
    void atualizarEmail(Pessoa pessoa, String novoEmail);
    void atualizarSenha(Pessoa pessoa, String novaSenha);
    void atualizarTelefone(Pessoa pessoa, String novoTelefone);
    void atualizarEndereco(Pessoa pessoa, String novoEndereco);
    void atualizarDataNascimento(Pessoa pessoa, LocalDate novaData);

}
