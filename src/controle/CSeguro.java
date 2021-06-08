package controle;

import modelo.Seguro;
import service.SSeguro;
import util.Tools;

public class CSeguro {

    private static CSeguro cSeguro;
    private SSeguro sSeguro = SSeguro.getInstance();

    private CSeguro(){

    }

    public static CSeguro getInstance(){
        if(cSeguro == null){
            cSeguro = new CSeguro();
        }
        return cSeguro;
    }

    public void cadastrar(String tipo){
        Seguro seguro = new Seguro();
        seguro.setTipo(tipo);
        if(sSeguro.cadastrar(seguro)){
            System.out.println();
            System.out.println("Cadastrado com sucesso");
            Tools.pausar(1);
            System.out.println();
        } else {
            System.out.println();
            System.err.println("Erro ao tentar cadastrar");
            Tools.pausar(1);
            System.out.println();
        }

    }

    public void remover(int id){
        if(sSeguro.remover(id)){
            System.out.println();
            System.out.println("Sucesso! seguro "+id+" foi removido");
            System.out.println();
        }else{
            System.out.println();
            System.err.println("Não foi possivel remover");
            System.out.println();
        }

    }

    public void listar(){
        System.out.println();
        System.out.println(".: Lista de todos os seguros cadastrados :.");
        System.out.println();
        for(Seguro c: sSeguro.listar()){
            System.out.println("Cod.: "+c.getId());
            System.out.println("Marca.: "+c.getTipo());
            System.out.println("----------------------------");
            Tools.pausar(1);
        }
        System.out.println();

    }
    }
