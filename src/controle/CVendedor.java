package controle;

import modelo.Vendedor;
import repositorio.IVendedor;

public abstract class CVendedor implements IVendedor {
    @Override
    public void cadastrar(Vendedor vendedor) {

    }

    @Override
    public void atualizar(Vendedor vendedor) {

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
