package service;

import dao.VendedorDAO;
import modelo.Vendedor;
import repositorio.IVendedor;

import java.util.List;

public class SVendedor {

    private static SVendedor sVendedor;
    private IVendedor iVendedor = VendedorDAO.getInstance();

    private SVendedor(){

    }

    public static SVendedor getInstance(){
        if(sVendedor == null){
            sVendedor = new SVendedor();
        }
        return sVendedor;
    }

    public boolean cadastrar(Vendedor vendedor){
        return VendedorDAO.getInstance().cadastrar(vendedor);

    }

    public boolean atualizar(Vendedor vendedor){
        return iVendedor.atualizar(vendedor);
    }

    public boolean remover(int id){
        return iVendedor.remover(id);
    }

    public Vendedor buscaUnica(int id){
        return iVendedor.buscaUnica(id);
    }

    public List<Vendedor> listar(){
        return iVendedor.listar();
    }

}
