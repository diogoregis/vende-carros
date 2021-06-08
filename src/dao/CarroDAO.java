package dao;

import modelo.Carro;
import repositorio.ICarro;

import java.util.List;

public class CarroDAO implements ICarro {

    private static CarroDAO carroDAO;

    private CarroDAO(){

    }

    public static CarroDAO getInstance(){
        if(carroDAO == null){
            carroDAO = new CarroDAO();
        }
        return carroDAO;
    }

    @Override
    public boolean cadastrar(Carro carro) {
        return false;
    }

    @Override
    public boolean atualizar(Carro carro) {
        return false;
    }

    @Override
    public boolean remover(int id) {
        return false;
    }

    @Override
    public Carro buscaUnica(int id) {
        return null;
    }

    @Override
    public List<Carro> listar() {
        return null;
    }
}
