package beans;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    // Atributos
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    private LocalDate dataNascimento;
    private boolean administrador;

    // Construtor

    public Pessoa(String nome, String email, String senha, String telefone, LocalDate dataNascimento, boolean adm) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setTelefone(telefone);
        this.setDataNascimento(dataNascimento);
        this.endereco = null;
        this.administrador = adm;
    }

    // Metodos

    // equals - comparar email
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return this.email.equals(pessoa.email);
    }

    // toString


    // Getters
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public boolean isAdministrador() {
        return administrador;
    }

    // Setters com ou sem validação
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }
    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }
    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        }
    }
    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.isEmpty()) {
            this.telefone = telefone;
        }
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento != null) {
            this.dataNascimento = dataNascimento;
        }
    }
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
