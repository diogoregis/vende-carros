package dao;

import banco.Conexao;
import modelo.Carro;
import repositorio.ICarro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Conexao.getInstance();
        String sql = "INSERT INTO carro (marcacarro, modelocarro, corcarro, precocarro, anocarro) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setFloat(4, carro.getPreco());
            stmt.setString(5, carro.getAno());
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
    public boolean atualizar(Carro carro) {
        Conexao.getInstance();
        String sql = "UPDATE carro SET marcacarro = ?, modelocarro = ?, corcarro = ?, precocarro = ?, anocarro = ? WHERE idcarro = ?";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setFloat(4, carro.getPreco());
            stmt.setString(5, carro.getAno());
            stmt.setInt(6, carro.getId());
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
        String sql = "DELETE FROM carro WHERE idcarro = ?";
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
    public Carro buscaUnica(int id) {
        String sql = "SELECT * from carro WHERE idcarro = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            Carro car = new Carro();

            while(rs.next()){
                car.setId(rs.getInt("idcarro"));
                car.setMarca(rs.getString("marcacarro"));
                car.setModelo(rs.getString("modelocarro"));
                car.setCor(rs.getString("corcarro"));
                car.setPreco(rs.getFloat("precocarro"));
                car.setAno(rs.getString("anocarro"));
            }

            return car;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            Conexao.closeConnection(Conexao.getConnection(), stmt, rs);
        }
    }

    @Override
    public List<Carro> listar() {
        String sql = "SELECT * from carro";
        List<Carro> lista = new ArrayList<Carro>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Carro carro = new Carro(Integer.parseInt(rs.getString("idcarro")), rs.getString("marcacarro"),rs.getString("modelocarro"), rs.getString("corcarro"),rs.getFloat("precocarro"), rs.getString("anocarro"));
                lista.add(carro);

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
