package repositorio;

import modelo.Seguro;

public interface ISeguro {

    public void cadastrar(Seguro seguro);
    public void atualizar(Seguro seguro);
    public void remover(int id);
    public boolean existe(int id);
    public void listar();

}
