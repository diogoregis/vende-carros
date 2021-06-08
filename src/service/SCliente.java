package service;

import dao.ClienteDAO;
import modelo.Cliente;
import repositorio.ICliente;

import java.util.List;

public class SCliente {

    private static SCliente sCliente;
    private ICliente iCliente = ClienteDAO.getInstance();


    private SCliente(){

    }

    public static SCliente getInstance(){
        if(sCliente == null){
            sCliente = new SCliente();
        }
        return sCliente;
    }

    public static boolean cadastrar(Cliente cliente){
        return ClienteDAO.getInstance().cadastrar(cliente);

    }

    public static List<Cliente> listar(){
        return ClienteDAO.getInstance().listar();
    }

    public static boolean remover(int id){
        return ClienteDAO.getInstance().remover(id);
    }

    public static boolean atualizar(Cliente cliente){
        return ClienteDAO.getInstance().atualizar(cliente);
    }

    public static Cliente buscaUnica(Cliente cliente){
        return ClienteDAO.getInstance().buscaUnica(cliente);
    }


}
