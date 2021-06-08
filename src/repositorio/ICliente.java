package repositorio;

import modelo.Cliente;

import java.util.List;

public interface ICliente {

    public boolean cadastrar(Cliente cliente);
    public boolean atualizar(Cliente cliente);
    public boolean remover(int id);
    public Cliente buscaUnica(Cliente cliente);
    public List<Cliente> listar();

}
