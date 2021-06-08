package dao;

import banco.Conexao;
import modelo.Vendedor;
import repositorio.IVendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements IVendedor {

    private static VendedorDAO vendedorDAO;

    private VendedorDAO(){

    }

    public static VendedorDAO getInstance(){
        if(vendedorDAO == null){
            vendedorDAO = new VendedorDAO();
        }
        return vendedorDAO;
    }



    @Override
    public boolean cadastrar(Vendedor vendedor) {
        Conexao.getInstance();
        String sql = "INSERT INTO vendedor (nomevendedor) VALUES (?)";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
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
    public boolean atualizar(Vendedor vendedor) {
        Conexao.getInstance();
        String sql = "UPDATE vendedor SET nomevendedor = ? WHERE idvendedor = ?";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setInt(2, vendedor.getId());
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
        String sql = "DELETE FROM vendedor WHERE idvendedor = ?";
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
    public Vendedor buscaUnica(int id) {
        String sql = "SELECT * from vendedor WHERE idvendedor = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            Vendedor vende = new Vendedor();

            while(rs.next()){
                vende.setId(rs.getInt("idvendedor"));
                vende.setNome(rs.getString("nomevendedor"));

            }

            return vende;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt, rs);
        }
    }

    @Override
    public List<Vendedor> listar() {
        String sql = "SELECT * from vendedor";
        List<Vendedor> lista = new ArrayList<Vendedor>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Vendedor vendedor = new Vendedor(Integer.parseInt(rs.getString("idvendedor")), rs.getString("nomevendedor"));
                lista.add(vendedor);

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
