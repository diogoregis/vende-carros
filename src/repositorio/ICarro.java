package repositorio;

import modelo.Carro;

public interface ICarro {

    public void cadastrar(Carro carro);
    public void atualizar(Carro carro);
    public void remover(int id);
    public boolean existe(int id);
    public void listar();

}
