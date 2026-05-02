package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_vendas?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() throws SQLException {
        try {
            // MySQL Connector/J 8+
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            try {
                // Compatibilidade com versões antigas do connector
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e2) {
                throw new SQLException(
                        "Driver JDBC do MySQL não encontrado. "
                        + "Adicione o mysql-connector-j ao classpath do projeto no NetBeans.",
                        e2
                );
            }
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    static Object getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
