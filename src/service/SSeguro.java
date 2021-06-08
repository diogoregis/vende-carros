package service;

import dao.SeguroDAO;
import modelo.Seguro;
import repositorio.ISeguro;

import java.util.List;

public class SSeguro {

    private static SSeguro sSeguro;
    private ISeguro iSeguro = SeguroDAO.getInstance();

    private SSeguro(){}

    public static SSeguro getInstance(){
        if(sSeguro == null){
            sSeguro = new SSeguro();
        }
        return sSeguro;
    }

    public boolean cadastrar(Seguro seguro){
        return iSeguro.cadastrar(seguro);
    }

    public boolean atualizar (Seguro seguro){
        return sSeguro.atualizar(seguro);
    }

    public boolean remover (int id){
        return iSeguro.remover(id);
    }

    public Seguro buscaUnica(int id){
        return iSeguro.buscaUnica(id);
    }

    public List<Seguro> listar(){
        return iSeguro.listar();
    }

}
