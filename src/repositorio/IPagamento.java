package repositorio;

import modelo.Pagamento;

import java.util.List;

public interface IPagamento {

    public boolean cadastrar(Pagamento pagamento);
    public boolean remover(int id);
    public List<Pagamento> listar();

}
