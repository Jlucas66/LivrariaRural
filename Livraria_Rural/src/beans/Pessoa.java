package beans;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {

    // Atributos
    protected String nome;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String endereco;
    protected LocalDate dataNascimento;

    // Construtor

    public Pessoa(String nome, String email, String senha, String telefone, LocalDate dataNascimento) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setTelefone(telefone);
        this.setDataNascimento(dataNascimento);
        this.endereco = null;
    }

    // Metodos

    // equals - comparar email e telefone
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return this.email.equals(pessoa.email) && this.telefone.equals(pessoa.telefone);
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

}
