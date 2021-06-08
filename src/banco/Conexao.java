package banco;
import java.sql.*;

public class Conexao {

    private static Conexao conexao;
    private static String driver ="org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/dbveiculos";
    private static String user = "postgres";
    private static String pass = "@Hoje2019";

    private Conexao() {

    }

    public static Conexao getInstance() {
        if(conexao == null)
            conexao = new Conexao();

        return conexao;
    }

    public static Connection getConnection() {

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException("ERRO "+ e);
        } catch (SQLException e) {

            throw new RuntimeException("ERRO "+ e);
        }


    }

    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        closeConnection(conn);
    }


    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        closeConnection(conn, stmt);
    }
}
