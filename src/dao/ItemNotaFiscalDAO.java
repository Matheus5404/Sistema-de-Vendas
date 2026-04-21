package dao;

import model.ItemNotaFiscal;
import java.sql.*;

public class ItemNotaFiscalDAO {

    public void inserir(ItemNotaFiscal item) {
        String sql = "INSERT INTO itens_nf(fk_prod, fk_nf, quantidade, valor_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getFkProd());
            stmt.setInt(2, item.getFkNf());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getValorUnitario());
            stmt.setDouble(5, item.getSubtotal());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir item da NF: " + e.getMessage());
        }
    }
}