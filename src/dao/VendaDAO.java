package dao;

import banco.Conexao;
import modelo.*;
import repositorio.IVenda;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO implements IVenda {

    private static VendaDAO vendaDAO;
    private VendaDAO(){};

    public static VendaDAO getInstance(){
        if(vendaDAO == null){
            vendaDAO = new VendaDAO();
        }
        return vendaDAO;
    }


    @Override
    public boolean cadastrar(Venda venda) {
        Conexao.getInstance();
        String sql = "INSERT INTO venda (idcliente, idcarro, idseguro, idvendedor, idpagamento) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, venda.getCliente());
            stmt.setInt(1, venda.getCarro());
            stmt.setInt(1, venda.getSeguro());
            stmt.setInt(1, venda.getVendedor());
            stmt.setInt(1, venda.getPagamento());
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
    public boolean atualizar(Venda venda) {
        return false;
    }

    @Override
    public boolean remover(int id) {
        Conexao.getInstance();
        String sql = "DELETE FROM venda WHERE idvenda = ?";
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
    public Venda buscaUnica(Venda venda) {
        return null;
    }

    @Override
    public List<Venda> listar() {
        String sql = "SELECT * from venda";
        List<Venda> lista = new ArrayList<Venda>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conexao.getInstance();
        Cliente cliente = new Cliente();
        Seguro seguro = new Seguro();
        Pagamento pagamento = new Pagamento();
        Vendedor vendedor = new Vendedor();
        Carro carro = new Carro();


        try {
            stmt = Conexao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                cliente.setId(rs.getInt("idcliente"));
                carro.setId(rs.getInt("idcarro"));
                seguro.setId(rs.getInt("idseguro"));
                vendedor.setId(rs.getInt("idvendedor"));
                pagamento.setId(rs.getInt("idpagamento"));
                Venda venda = new Venda(rs.getInt("idvenda"), carro, seguro, vendedor, cliente, pagamento);
                lista.add(venda);

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
