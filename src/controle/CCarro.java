package controle;

import modelo.Carro;
import service.SCarro;
import util.Tools;

public class CCarro {

    private static CCarro cCarro;
    private SCarro sCarro = SCarro.getInstance();

    private CCarro(){

    }

    public static CCarro getInstance(){
        if(cCarro == null){
            cCarro = new CCarro();
        }
        return cCarro;
    }


    public void cadastrar(String marca, String modelo, String cor, float preco, String ano) {
        Carro carro = new Carro(1, marca, modelo, cor, preco, ano);
        if(sCarro.cadastrar(carro)){
            System.out.println();
            System.out.println("Sucesso ! "+modelo+" cadastrado com sucesso.");
            System.out.println();
        }else {
            System.out.println();
            System.out.println("Não foi possivel cadastrar "+modelo);
            System.out.println();
        }


    }


    public void atualizar(int id, String marca, String modelo, String cor, float preco, String ano) {
        Carro carro = new Carro(id, marca, modelo, cor, preco, ano);
        if(sCarro.atualizar(carro)){
            System.out.println();
            System.out.println("Sucesso ! atualizado com sucesso.");
            System.out.println();
        }else {
            System.out.println();
            System.err.println("Não foi possivel atualizar ");
            System.out.println();
        }


    }

    public void remover(int id) {
        if(sCarro.remover(id)){
            System.out.println();
            System.out.println("Sucesso! O carro de codigo "+id+" foi removido");
            System.out.println();
        }else{
            System.out.println();
            System.err.println("Não foi possivel remover");
            System.out.println();
        }

    }

    public void buscaUnica(int id) {
        Carro carro = new Carro();
        carro = sCarro.buscaUnica(id);
        if(carro != null){
            System.out.println();
            System.out.println("Carro encontrado");
            Tools.pausar(1);
            System.out.println("------------------------");
            System.out.println("Id: "+ carro.getId());
            System.out.println("Marca: "+carro.getMarca());
            System.out.println("Modelo: "+carro.getModelo());
            System.out.println("Ano: "+carro.getAno());
            System.out.println("Cor: "+carro.getCor());
            System.out.println("Preço: "+Tools.precoFormata(carro.getPreco()));
            System.out.println("------------------------");
            Tools.pausar(1);
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Não foi encontrado !");
            System.out.println();
        }

    }


    public void listar() {
        System.out.println();
        System.out.println(".: Lista de todos os carros cadastrados :.");
        System.out.println();
        for(Carro c: sCarro.listar()){
            System.out.println("Cod.: "+c.getId());
            System.out.println("Marca.: "+c.getMarca());
            System.out.println("Modelo.: "+c.getModelo());
            System.out.println("Ano.: "+c.getAno());
            System.out.println("Cor.: "+c.getCor());
            System.out.println("Preço.: "+Tools.precoFormata(c.getPreco()));
            System.out.println("----------------------------");
            Tools.pausar(1);
        }
        System.out.println();

    }
}
