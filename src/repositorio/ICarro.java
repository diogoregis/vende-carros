package repositorio;

import modelo.Carro;

import java.util.List;

public interface ICarro {

    public boolean cadastrar(Carro carro);
    public boolean atualizar(Carro carro);
    public boolean remover(int id);
    public Carro buscaUnica(int id);
    public List<Carro> listar();
}
