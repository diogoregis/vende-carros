package repositorio;

import modelo.Vendedor;

import java.util.List;

public interface IVendedor {

    public boolean cadastrar(Vendedor vendedor);
    public boolean atualizar(Vendedor vendedor);
    public boolean remover(int id);
    public Vendedor buscaUnica(Vendedor vendedor);
    public List<Vendedor> listar();

}
