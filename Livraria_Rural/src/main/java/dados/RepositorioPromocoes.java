package dados;

import beans.Pessoa;
import beans.Promocao;
import beans.TipoPromocao;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioPromocoes implements IRepositorioPromocoes{
    //repositorio de enums
    private List<TipoPromocao> repoPromocoesEnum;
    private List<Promocao> repoPromocoes;//novo
    public RepositorioPromocoes(){
        repoPromocoes=new ArrayList<>();
        repoPromocoesEnum=new ArrayList<>();
    }

    //repositorio de promoções

    public List<TipoPromocao> listarTodasPromocoesEnum(){

        //adicionando todas os enum TipoPromoção e colocando em um arrayList
        repoPromocoesEnum.addAll(Arrays.asList(TipoPromocao.values()));
        return repoPromocoesEnum;
    }

    public boolean cadastrarPromocao(Promocao promocao){
        boolean cadastrado=false;
        if(promocao!=null){
            boolean mesmaPromocao=false;
            for(Promocao p:repoPromocoes){
                if(p.getNomePromocao().equalsIgnoreCase(promocao.getNomePromocao()) ||
                        p.getInicio().isEqual(promocao.getInicio())
                && p.getFim().isEqual(promocao.getFim())) {
                    mesmaPromocao = true;
                    break;
                }
            }
            if(!mesmaPromocao){
                cadastrado=true;
                System.out.println("promocao cadastrada");
                repoPromocoes.add(promocao);
            }
        }
        return cadastrado;
    }

    public boolean removerPromocaoPorNome(String nomePromocao){
        boolean removeu=false;
        if(nomePromocao!=null && !nomePromocao.isEmpty()){
            for(Promocao p:repoPromocoes){
                if(p.getNomePromocao().equalsIgnoreCase(nomePromocao)){
                    repoPromocoes.remove(p);
                    removeu =true;
                }
            }
        }
        return removeu;
    }

    public Promocao buscarPromocaoPorNome(String nomePromocao){
        Promocao promocao=null;
        if(nomePromocao!=null && !nomePromocao.isEmpty()){
            for(Promocao p:repoPromocoes){
                if(p.getNomePromocao().equalsIgnoreCase(nomePromocao)) {
                    promocao=p;
                }
            }
        }
        return promocao;
    }

    public boolean atualizarPromocao(Promocao promocao){
        boolean cadastrou =false;
        if(promocao!=null){
            for(Promocao p:repoPromocoes){
                if(p.getNomePromocao().equalsIgnoreCase(promocao.getNomePromocao())){
                    p.setNomePromocao(promocao.getNomePromocao());
                    p.setPercentualDesconto(promocao.getPercentualDesconto());
                    p.setInicio(promocao.getInicio());
                    p.setFim(promocao.getFim());
                    cadastrou=true;
                    break;
                }
            }

        }
        return cadastrou;

    }

    public void salvarPromocaoEmArquivo(String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(repoPromocoes);
            System.out.println("Promoçoes salvas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarPromocaoDeArquivo(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            repoPromocoes = (ArrayList<Promocao>) inputStream.readObject();
            System.out.println("Promoções carregadas com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    List <Promocao> getRepoPromocoes(){
        return repoPromocoes;
    }
}
