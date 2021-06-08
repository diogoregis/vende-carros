package repositorio;

import modelo.Venda;

import java.util.List;

public interface IVenda {

    public boolean cadastrar(Venda venda);
    public boolean atualizar(Venda venda);
    public boolean remover(int id);
    public Venda buscaUnica(Venda venda);
    public List<Venda> listar();

}
