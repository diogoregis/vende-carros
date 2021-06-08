package controle;

import modelo.Venda;
import repositorio.IVenda;

public abstract class CVenda implements IVenda {
    @Override
    public void cadastrar(Venda venda) {

    }

    @Override
    public void atualizar(Venda venda) {

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
