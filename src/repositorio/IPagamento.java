package repositorio;

import modelo.Pagamento;

public interface IPagamento {

    public void cadastrar(Pagamento pagamento);
    public void atualizar(Pagamento pagamento);
    public void remover(int id);
    public boolean existe(int id);
    public void listar();

}
