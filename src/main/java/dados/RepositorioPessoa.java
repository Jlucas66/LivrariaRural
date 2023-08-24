package dados;

import beans.Pessoa;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RepositorioPessoa implements IRepositorioPessoa {

    // Atributos
    private ArrayList<Pessoa> repositorioPessoa;

    // Construtor
    public RepositorioPessoa() {
        this.repositorioPessoa = new ArrayList<>();
    }

    // Metodos CRUD

        // inserirPessoa - verifica se existe pessoa com mesmo email
    public boolean inserirPessoa(Pessoa pessoa) {
        boolean inseriu = false;
        if (pessoa != null) {
            boolean mesmoEmail = false;
            for (Pessoa p : repositorioPessoa) {
                if (p.equals(pessoa)) {     // equals de Pessoa compara os emails
                    mesmoEmail = true;
                    break;
                }
            }
            if (!mesmoEmail) {
                repositorioPessoa.add(pessoa);
                inseriu = true;
            }
        }
        return inseriu;
    }

        // removerPessoa
    public boolean removerPessoaPorEmail(String email) {
        boolean removeu = false;
        if (email != null && !email.isEmpty()) {
            repositorioPessoa.removeIf(p -> p.getEmail().equals(email));
            removeu = true;
        }
        return removeu;
    }

        // buscarPessoa
    public Pessoa buscarPessoaPorEmail(String email) {      // fazer tratamento de erro caso procure uma pessoa que não exista
        Pessoa p = null;
        if (email != null && !email.isEmpty()) {
            int indice = 0;
            for (Pessoa i : repositorioPessoa) {
                if (i.getEmail().equals(email)) {
                    p = repositorioPessoa.get(indice);
                }
                indice++;
            }
        }
        return p;
    }

        // atualizarPessoa
    public boolean atualizarPessoaComMesmoEmail(Pessoa novaPessoa) {
        boolean atualizou = false;
        boolean pessoaExiste = false;
        Pessoa pessoaAtualizada = null;
        for (Pessoa p : repositorioPessoa) {
            if(p.equals(novaPessoa)) {
                pessoaExiste = true;
                pessoaAtualizada = p;
                break;
            }
        }
        if (pessoaExiste) {
            //atualizar
            pessoaAtualizada.setNome(novaPessoa.getNome());
            pessoaAtualizada.setEmail(novaPessoa.getEmail());
            pessoaAtualizada.setSenha(novaPessoa.getSenha());
            pessoaAtualizada.setTelefone(novaPessoa.getTelefone());
            pessoaAtualizada.setDataNascimento(novaPessoa.getDataNascimento());
            pessoaAtualizada.setEndereco(novaPessoa.getEndereco());
            pessoaAtualizada.setAdministrador(novaPessoa.isAdministrador());

            atualizou = true;
        }
        return atualizou;
    }


    // listarPessoasNaoAdministradores
    // listarPessoasAdministradores
    // listarPessoasNaoAdministradoresPor?
    // listarAdministradoresPor?
    // listarHistoricoDeComprasDoClientePorPeriodo - foi pra venda
    // listarHistoricoDeComprasDoClienteTotal - foi pra venda



    public void carregarPessoasDoArquivo(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");

                String nome = partes[0];
                String email = partes[1];
                String senha = partes[2];
                String endereco = partes[3];
                LocalDate dataNascimento = LocalDate.parse(partes[4], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                boolean adm = Boolean.parseBoolean(partes[5]);

                Pessoa pessoa = new Pessoa(nome, email, senha, endereco, dataNascimento, adm);
                this.repositorioPessoa.add(pessoa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarPessoaNoArquivo(Pessoa pessoa, String nomeArquivo) throws IOException {
        String linha = String.format("%s;%s;%s;%s;%s;%b",
                pessoa.getNome(), pessoa.getEmail(), pessoa.getSenha(), pessoa.getEndereco(),
                pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                pessoa.isAdministrador());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Erro ao salvar pessoa no arquivo", e);
        }

        System.out.println("Pessoa salva com sucesso!");
    }
//    public void salvarPessoaNaoAdmNoArquivo(Pessoa pessoa, String nomeArquivo) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
//            String linha = String.format("%s;%s;%s;%s;%s;%b",
//                    pessoa.getNome(), pessoa.getEmail(), pessoa.getSenha(), pessoa.getEndereco(),
//                    pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
//                    pessoa.isAdministrador());
//            writer.write(linha);
//            writer.newLine();
//
//            System.out.println("Pessoa salva com sucesso!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // Getters
    public ArrayList<Pessoa> getRepositorioPessoa() {
        return repositorioPessoa;
    }

}
