package dao;

import model.NotaFiscal;
import java.sql.*;

public class NotaFiscalDAO {

    public int inserir(NotaFiscal nf) {
        String sql = "INSERT INTO nf(fk_cliente, data_emissao, valor_total) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, nf.getFkCliente());
            stmt.setDate(2, nf.getDataEmissao());
            stmt.setDouble(3, nf.getValorTotal());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir NF: " + e.getMessage(), e);
        }

        return -1;
    }

    public void atualizarTotal(int nfId, double total) {
        String sql = "UPDATE nf SET valor_total = ? WHERE nf_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, total);
            stmt.setInt(2, nfId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar total da NF: " + e.getMessage(), e);
        }
    }
}