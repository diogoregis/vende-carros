package controle;

import modelo.Vendedor;
import service.SVendedor;
import util.Tools;


public class CVendedor {

    private static CVendedor cVendedor;
    private SVendedor sVendedor = SVendedor.getInstance();

    private CVendedor(){}

    public static CVendedor getInstance(){
        if(cVendedor == null){
            cVendedor = new CVendedor();
        }
        return cVendedor;
    }

    public void cadastrar(String nome){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);
        if(SVendedor.getInstance().cadastrar(vendedor)){
            System.out.println();
            System.out.println("O vendedor " +vendedor.getNome() + " foi cadastrado com sucesso.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Erro! Não foi possivel cadastrar "+vendedor.getNome());
            System.out.println();
        }
    }

    public void atualizar(int id, String nome){
        Vendedor vendedor = new Vendedor(id, nome);
        if(SVendedor.getInstance().atualizar(vendedor)){
            System.out.println();
            System.out.println("Vendedor atualizado com sucesso !");
            Tools.pausar(1);
            System.out.println();
        }else {
            System.out.println();
            System.err.println("Falha! não foi possivel atualizar o vendedor");
            System.out.println();
        }
    }

    public void remover(int id){
        if(sVendedor.remover(id)){
            System.out.println();
            System.out.println("Sucesso! removido.");
            System.out.println();
        } else {
            System.out.println();
            System.err.println("Erro ao tentar remover.");
            System.out.println();
        }
    }

    public void buscaUnica(int id){
        Vendedor vendedor = new Vendedor();
        vendedor = sVendedor.buscaUnica(id);
        if(vendedor != null){
            System.out.println();
            System.out.println("Encontrado !");
            System.out.println("Codigo: "+vendedor.getId());
            System.out.println("Nome: "+vendedor.getNome());
            System.out.println();
        } else{
            System.out.println();
            System.err.println("Codigo de vendedor não existe.");
            System.out.println();
        }
    }

    public void listar(){
        System.out.println();
        System.out.println(".: Lista de todos os vendedores :.");
        System.out.println();
        for(Vendedor c: SVendedor.getInstance().listar()){
            System.out.println("Cod.: "+c.getId());
            System.out.println("Nome.: "+c.getNome());
            System.out.println("----------------------------");
            Tools.pausar(1);
        }
        System.out.println();

    }

}
