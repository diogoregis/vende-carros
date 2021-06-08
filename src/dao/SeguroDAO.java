package dao;

import banco.Conexao;
import modelo.Seguro;
import repositorio.ISeguro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeguroDAO implements ISeguro {

    private static SeguroDAO seguroDAO;

    private SeguroDAO(){

    }

    public static SeguroDAO getInstance(){
        if(seguroDAO == null){
            seguroDAO = new SeguroDAO();
        }
        return seguroDAO;
    }

    @Override
    public boolean cadastrar(Seguro seguro) {
        Conexao.getInstance();
        String sql = "INSERT INTO seguro (tiposeguro) VALUES (?)";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, seguro.getTipo());
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
    public boolean atualizar(Seguro seguro) {
        Conexao.getInstance();
        String sql = "UPDATE seguro SET tiposeguro WHERE idseguro = ?";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, seguro.getTipo());
            stmt.setInt(2, seguro.getId());
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
        String sql = "DELETE FROM seguro WHERE idseguro = ?";
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
    public Seguro buscaUnica(int id) {
        String sql = "SELECT * from seguro WHERE idseguro = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            Seguro seg = new Seguro();

            while(rs.next()){
                seg.setId(rs.getInt("idseguro"));
                seg.setTipo(rs.getString("tiposeguro"));

            }

            return seg;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt, rs);
        }
    }

    @Override
    public List<Seguro> listar() {
        String sql = "SELECT * from seguro";
        List<Seguro> lista = new ArrayList<Seguro>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Seguro seguro = new Seguro(Integer.parseInt(rs.getString("idseguro")), rs.getString("tiposeguro"));
                lista.add(seguro);

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
