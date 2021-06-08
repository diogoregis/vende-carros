package controle;

import modelo.Seguro;
import repositorio.ISeguro;

public abstract class CSeguro implements ISeguro {
    @Override
    public void cadastrar(Seguro seguro) {

    }

    @Override
    public void atualizar(Seguro seguro) {

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
