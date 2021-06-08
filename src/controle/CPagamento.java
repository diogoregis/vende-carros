package controle;

import modelo.Pagamento;
import repositorio.IPagamento;

public abstract class CPagamento implements IPagamento {
    @Override
    public void cadastrar(Pagamento pagamento) {

    }

    @Override
    public void atualizar(Pagamento pagamento) {

    }

    @Override
    public void remover(int id) {

    }

    @Override
    public boolean existe(int id) {
        return false;
    }

    @Override
    public void listar() {

    }
}
