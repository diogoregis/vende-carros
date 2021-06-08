package service;

import dao.VendaDAO;
import modelo.Venda;
import repositorio.IVenda;

import java.util.List;

public class SVenda {

    private static SVenda sVenda;
    private IVenda iVenda = VendaDAO.getInstance();

    private SVenda(){};

    public static SVenda getInstance(){
        if(sVenda==null){
            sVenda = new SVenda();
        }
        return sVenda;
    }

    public boolean cadastrar(Venda venda){
        return iVenda.cadastrar(venda);
    }

    public boolean remover(int id){
        return iVenda.remover(id);
    }

    public List<Venda> listar(){
        return iVenda.listar();
    }

}
