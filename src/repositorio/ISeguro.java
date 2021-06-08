package repositorio;

import modelo.Seguro;

import java.util.List;

public interface ISeguro {

    public boolean cadastrar(Seguro seguro);
    public boolean atualizar(Seguro seguro);
    public boolean remover(int id);
    public Seguro buscaUnica(int id);
    public List<Seguro> listar();

}
