package repositorio;

import modelo.Venda;

public interface IVenda {

    public void cadastrar(Venda venda);
    public void atualizar(Venda venda);
    public void remover(int id);
    public boolean existe(int id);
    public void listar();

}
