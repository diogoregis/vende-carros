package dao;

import banco.Conexao;
import modelo.Cliente;
import repositorio.ICliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ICliente {

    private static ClienteDAO clienteDAO;

    private ClienteDAO(){

    }

    public static ClienteDAO getInstance() {
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }


    @Override
    public boolean cadastrar(Cliente cliente) {
        Conexao.getInstance();
        String sql = "INSERT INTO cliente (nomecliente, fonecliente, emailcliente) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt);
        }

    }

    @Override
    public boolean atualizar(Cliente cliente) {
        Conexao.getInstance();
        String sql = "UPDATE cliente SET nomecliente = ?, fonecliente = ?, emailcliente = ? WHERE idcliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt);
        }

    }


    @Override
    public boolean remover(int id) {
        Conexao.getInstance();
        String sql = "DELETE FROM cliente WHERE idcliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt);
        }

    }

    @Override
    public Cliente buscaUnica(Cliente cliente) {
        String sql = "SELECT * from cliente WHERE idcliente = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1,cliente.getId());
            rs = stmt.executeQuery();

            Cliente cli = new Cliente();

            while(rs.next()){
                cli.setId(rs.getInt("idcliente"));
                cli.setNome(rs.getString("nomecliente"));
                cli.setTelefone(rs.getString("fonecliente"));
                cli.setEmail(rs.getString("emailcliente"));
            }

            return cli;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt, rs);
        }
    }

    @Override
    public List<Cliente> listar() {
        String sql = "SELECT * from cliente";
        List<Cliente> lista = new ArrayList<Cliente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Cliente cli = new Cliente(Integer.parseInt(rs.getString("idcliente")), rs.getString("nomecliente"), rs.getString("fonecliente"), rs.getString("emailcliente"));
                lista.add(cli);

            }
            return lista;

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt, rs);
        }


        return lista;

    }
}
