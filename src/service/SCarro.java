package service;

import dao.CarroDAO;
import modelo.Carro;
import repositorio.ICarro;

import java.util.List;

public class SCarro {

    private static SCarro sCarro;
    private ICarro iCarro = CarroDAO.getInstance();

    private SCarro(){

    }

    public static SCarro getInstance(){
        if(sCarro == null){
            sCarro = new SCarro();
        }
        return sCarro;
    }

    public boolean cadastrar(Carro carro){
        return iCarro.cadastrar(carro);
    }

    public boolean atualizar(Carro carro){
        return iCarro.atualizar(carro);
    }

    public boolean remover(int id){
        return iCarro.remover(id);
    }

    public Carro buscaUnica(int id){
        return iCarro.buscaUnica(id);
    }

    public List<Carro> listar(){
        return iCarro.listar();
    }


}
