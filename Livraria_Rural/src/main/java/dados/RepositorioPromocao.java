package dados;

import beans.Promocao;
import beans.TipoPromocao;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioPromocao implements IRepositorioPromocoes{
    //repositorio de enums

    private List<TipoPromocao> repoPromocoesEnum; // não precisa desse atributo

    private List<Promocao> repositorioPromocao;//novo
    public RepositorioPromocao(){
        repositorioPromocao =new ArrayList<>();
        //repoPromocoesEnum=new ArrayList<>();     // não precisa do enum. Os tipos de promoção serão definidas pelo nome.
    }

    //repositorio de promoções

//    public List<TipoPromocao> listarTodasPromocoesEnum(){
//
//        //adicionando todas os enum TipoPromoção e colocando em um arrayList
//        repoPromocoesEnum.addAll(Arrays.asList(TipoPromocao.values()));
//        return repoPromocoesEnum;
//    }

    public boolean cadastrarPromocao(Promocao promocao){
        boolean cadastrado=false;
        if(promocao!=null){
            boolean mesmaPromocao=false;
            for(Promocao p: repositorioPromocao){
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
                repositorioPromocao.add(promocao);
            }
        }
        return cadastrado;
    }

    public boolean removerPromocaoPorNome(String nomePromocao){
        boolean removeu=false;
        if(nomePromocao!=null && !nomePromocao.isEmpty()){
            for(Promocao p: repositorioPromocao){
                if(p.getNomePromocao().equalsIgnoreCase(nomePromocao)){
                    repositorioPromocao.remove(p);
                    removeu =true;
                }
            }
        }
        return removeu;
    }

    public Promocao buscarPromocaoPorNome(String nomePromocao){
        Promocao promocao=null;
        if(nomePromocao!=null && !nomePromocao.isEmpty()){
            for(Promocao p: repositorioPromocao){
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
            for(Promocao p: repositorioPromocao){
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
            outputStream.writeObject(repositorioPromocao);
            System.out.println("Promoçoes salvas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarPromocaoDeArquivo(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            repositorioPromocao = (ArrayList<Promocao>) inputStream.readObject();
            System.out.println("Promoções carregadas com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List <Promocao> getRepositorioPromocao(){
        return repositorioPromocao;
    }
}
