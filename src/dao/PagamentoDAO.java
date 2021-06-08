package dao;

import banco.Conexao;
import modelo.Pagamento;
import repositorio.IPagamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO implements IPagamento {

    private static PagamentoDAO pagamentoDAO;
    private PagamentoDAO(){

    }

    public static PagamentoDAO getInstance(){
        if(pagamentoDAO == null){
            pagamentoDAO = new PagamentoDAO();
        }
        return pagamentoDAO;
    }

    @Override
    public boolean cadastrar(Pagamento pagamento) {
        Conexao.getInstance();
        String sql = "INSERT INTO pagamento (tipopagamento) VALUES (?)";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, pagamento.getTipo());
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
        String sql = "DELETE FROM pagamento WHERE idpagamento = ?";
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
    public List<Pagamento> listar() {
        String sql = "SELECT * from pagamento";
        List<Pagamento> lista = new ArrayList<Pagamento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Pagamento pagamento = new Pagamento(Integer.parseInt(rs.getString("idpagamento")), rs.getString("tipopagamento"));
                lista.add(pagamento);

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
