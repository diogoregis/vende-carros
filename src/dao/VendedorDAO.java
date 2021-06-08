package dao;

import modelo.Vendedor;
import repositorio.IVendedor;

import java.util.List;

public class VendedorDAO implements IVendedor {

    private static VendedorDAO vendedorDAO;

    private VendedorDAO(){

    }

    public static VendedorDAO getInstance(){
        if(vendedorDAO == null){
            vendedorDAO = new VendedorDAO();
        }
        return vendedorDAO;
    }



    @Override
    public boolean cadastrar(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean atualizar(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean remover(int id) {
        return false;
    }

    @Override
    public Vendedor buscaUnica(Vendedor vendedor) {
        return null;
    }

    @Override
    public List<Vendedor> listar() {
        return null;
    }
}
