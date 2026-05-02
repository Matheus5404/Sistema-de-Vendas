package view;

import dao.ClienteDAO;
import dao.Conexao;
import dao.ProdutoDAO;
import dao.ItemNotaFiscalDAO;
import dao.NotaFiscalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Produto;
import model.ItemNotaFiscal;
import model.NotaFiscal;
import java.text.MessageFormat;

public class FrmNotaFiscal extends javax.swing.JFrame {

    public FrmNotaFiscal() {
        initComponents();
        limparTabela();
        carregarClientes();
        carregarProdutos();
        limparCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtTotalNf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmissaoNf = new javax.swing.JTable();
        btnCriarNF = new javax.swing.JButton();
        btnAdicionarItem = new javax.swing.JButton();
        btnfinalizarNF = new javax.swing.JButton();
        btnImprimirNf = new javax.swing.JButton();
        txtComboCliente = new javax.swing.JComboBox<>();
        txtComboProduto = new javax.swing.JComboBox<>();
        txtDataEmissao = new javax.swing.JFormattedTextField();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("EMISSÃO DE NOTA FISCAL");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Dados da Nota Fiscal");

        jLabel2.setText("Data:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Produto:");

        jLabel7.setText("Valor Unitário:");

        jLabel8.setText("Subtotal:");

        jLabel9.setText("Total NF:");

        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });

        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        txtTotalNf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalNfActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Itens da Nota Fiscal");

        tabelaEmissaoNf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Produto", "Valor Unitário", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tabelaEmissaoNf);

        btnCriarNF.setText("Criar NF");
        btnCriarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarNFActionPerformed(evt);
            }
        });

        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnfinalizarNF.setText("Finalizar NF");
        btnfinalizarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizarNFActionPerformed(evt);
            }
        });

        btnImprimirNf.setText("Imprimir");
        btnImprimirNf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirNfActionPerformed(evt);
            }
        });

        txtComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboClienteActionPerformed(evt);
            }
        });

        txtComboProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboProdutoActionPerformed(evt);
            }
        });

        txtDataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtComboCliente, 0, 254, Short.MAX_VALUE)
                                .addComponent(txtComboProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTotalNf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCriarNF)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionarItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnfinalizarNF)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimirNf)))
                        .addGap(0, 256, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensagem)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTotalNf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtComboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addComponent(jLabel10)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblMensagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarNF)
                    .addComponent(btnAdicionarItem)
                    .addComponent(btnfinalizarNF)
                    .addComponent(btnImprimirNf))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed

    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private int nfAtual = -1;
    private double totalNota = 0;

    private String montarTextoNF() {
        StringBuilder texto = new StringBuilder();

        texto.append("NOTA FISCAL Nº ").append(nfAtual).append("\n");
        texto.append("Cliente: ").append(txtComboCliente.getSelectedItem()).append("\n");
        texto.append("Data: ").append(txtDataEmissao.getText()).append("\n\n");

        texto.append("ITENS DA NOTA FISCAL\n");

        for (int i = 0; i < tabelaEmissaoNf.getRowCount(); i++) {
            texto.append("Produto: ").append(tabelaEmissaoNf.getValueAt(i, 1)).append("\n");
            texto.append("Valor Unitário: R$ ").append(tabelaEmissaoNf.getValueAt(i, 2)).append("\n");
            texto.append("Subtotal: R$ ").append(tabelaEmissaoNf.getValueAt(i, 3)).append("\n\n");
        }

        texto.append("Total da NF: R$ ").append(txtTotalNf.getText());

        return texto.toString();
    }

    private void limparTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaEmissaoNf.getModel();
        modelo.setRowCount(0);
    }

    private int obterIdClienteSelecionado() {
        Object selecionado = txtComboCliente.getSelectedItem();
        if (selecionado == null) {
            throw new IllegalArgumentException("Selecione um cliente.");
        }

        String texto = selecionado.toString().trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Selecione um cliente válido.");
        }

        // Aceita formato "1", "1 - Nome" ou "1: Nome"
        String idTexto = texto.split("[^0-9]", 2)[0];
        if (idTexto.isEmpty()) {
            throw new IllegalArgumentException("Não foi possível identificar o ID do cliente selecionado.");
        }
        return Integer.parseInt(idTexto);
    }

    private void carregarClientes() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.listar();

        txtComboCliente.removeAllItems();

        for (Cliente c : clientes) {
            txtComboCliente.addItem(c.getId() + " - " + c.getNome());
        }
    }

    private void carregarProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listar();

        txtComboProduto.removeAllItems();

        for (Produto p : produtos) {
            txtComboProduto.addItem(p.getId() + " - " + p.getNome());
        }
    }

    private int obterIdProdutoSelecionado() {
        Object selecionado = txtComboProduto.getSelectedItem();

        if (selecionado == null) {
            throw new IllegalArgumentException("Selecione um produto.");
        }

        String texto = selecionado.toString().trim();
        String idTexto = texto.split("[^0-9]", 2)[0];

        return Integer.parseInt(idTexto);
    }

    private String obterNomeProdutoSelecionado() {
        String texto = txtComboProduto.getSelectedItem().toString();

        if (texto.contains("-")) {
            return texto.split("-", 2)[1].trim();
        }

        return texto;
    }

    private void limparCampos() {
        txtValorUnitario.setText("");
        txtSubtotal.setText("");
        txtTotalNf.setText("0.00");
    }

    public void atualizarTotal(int idNotaFiscal, double valorTotal) {
        String sql = "UPDATE nota_fiscal SET valor_total = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, valorTotal);
            stmt.setInt(2, idNotaFiscal);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar total da NF: " + e.getMessage());
        }
    }

    public void inserir(ItemNotaFiscal item) {
        String sql = "INSERT INTO item_nota_fiscal(fk_nota_fiscal, fk_produto, valor_unitario, subtotal) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getFkNotaFiscal());
            stmt.setInt(2, item.getFkProduto());
            stmt.setDouble(3, item.getValorUnitario());
            stmt.setDouble(4, item.getSubtotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir item da NF: " + e.getMessage());
        }
    }

    private void btnCriarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarNFActionPerformed
        try {
            NotaFiscal nf = new NotaFiscal();
            nf.setFkCliente(obterIdClienteSelecionado());

            String dataTexto = txtDataEmissao.getText().trim();

            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataUtil = formato.parse(dataTexto);
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            nf.setDataEmissao(dataSql);
            nf.setValorTotal(0);

            NotaFiscalDAO dao = new NotaFiscalDAO();
            nfAtual = dao.inserir(nf);

            if (nfAtual > 0) {
                JOptionPane.showMessageDialog(this, "NF criada com código: " + nfAtual);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível criar a NF.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dados inválidos: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCriarNFActionPerformed

    private void txtComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboClienteActionPerformed

    }//GEN-LAST:event_txtComboClienteActionPerformed

    private void txtComboProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboProdutoActionPerformed
        try {
            int idProduto = obterIdProdutoSelecionado();

            ProdutoDAO dao = new ProdutoDAO();
            Produto p = dao.buscarPorId(idProduto);

            if (p != null) {
                txtValorUnitario.setText(String.valueOf(p.getValor()));
                txtSubtotal.setText(String.valueOf(p.getValor()));
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtComboProdutoActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed

    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtTotalNfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalNfActionPerformed

    }//GEN-LAST:event_txtTotalNfActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        try {
            if (nfAtual == -1) {
                JOptionPane.showMessageDialog(this, "Crie uma NF antes de adicionar itens.");
                return;
            }

            int idProduto = obterIdProdutoSelecionado();
            String nomeProduto = obterNomeProdutoSelecionado();

            double valorUnitario = Double.parseDouble(txtValorUnitario.getText().replace(",", "."));
            double subtotal = Double.parseDouble(txtSubtotal.getText().replace(",", "."));

            // 👉 SALVA NO BANCO
            ItemNotaFiscal item = new ItemNotaFiscal();
            item.setFkNotaFiscal(nfAtual);
            item.setFkProduto(idProduto);
            item.setValorUnitario(valorUnitario);
            item.setSubtotal(subtotal);

            ItemNotaFiscalDAO dao = new ItemNotaFiscalDAO();
            dao.inserir(item);

            // 👉 ADICIONA NA TABELA (AQUI É O TRECHO QUE VOCÊ PERGUNTOU)
            DefaultTableModel modelo = (DefaultTableModel) tabelaEmissaoNf.getModel();

            modelo.addRow(new Object[]{
                idProduto,
                nomeProduto,
                valorUnitario,
                subtotal
            });

            // 👉 ATUALIZA TOTAL
            totalNota += subtotal;
            txtTotalNf.setText(String.valueOf(totalNota));

            JOptionPane.showMessageDialog(this, "Item adicionado com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Informe valores numéricos válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar item: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void btnfinalizarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizarNFActionPerformed
        try {
            if (nfAtual == -1) {
                lblMensagem.setText("Nenhuma NF foi criada.");
                return;
            }

            NotaFiscalDAO dao = new NotaFiscalDAO();
            dao.atualizarTotal(nfAtual, totalNota);

            // 👉 AQUI É O QUE VOCÊ QUER
            lblMensagem.setText("NF finalizada com sucesso!");

        } catch (Exception e) {
            lblMensagem.setText("Erro ao finalizar NF.");
        }
    }//GEN-LAST:event_btnfinalizarNFActionPerformed

    private void btnImprimirNfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirNfActionPerformed
        try {
            if (nfAtual == -1) {
                lblMensagem.setText("Nenhuma NF foi criada para imprimir.");
                return;
            }

            if (tabelaEmissaoNf.getRowCount() == 0) {
                lblMensagem.setText("Adicione itens antes de imprimir a NF.");
                return;
            }

            MessageFormat cabecalho = new MessageFormat(
                    "NOTA FISCAL Nº " + nfAtual + " - Cliente: " + txtComboCliente.getSelectedItem()
            );

            MessageFormat rodape = new MessageFormat(
                    "Total da NF: R$ " + txtTotalNf.getText()
            );

            boolean imprimiu = tabelaEmissaoNf.print(
                    javax.swing.JTable.PrintMode.FIT_WIDTH,
                    cabecalho,
                    rodape
            );

            if (imprimiu) {
                lblMensagem.setText("NF enviada para impressão.");
            } else {
                lblMensagem.setText("Impressão cancelada.");
            }

        } catch (Exception e) {
            lblMensagem.setText("Erro ao imprimir NF.");
            JOptionPane.showMessageDialog(this, "Erro ao imprimir: " + e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirNfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNotaFiscal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCriarNF;
    private javax.swing.JButton btnImprimirNf;
    private javax.swing.JButton btnfinalizarNF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensagem;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tabelaEmissaoNf;
    private javax.swing.JComboBox<String> txtComboCliente;
    private javax.swing.JComboBox<String> txtComboProduto;
    private javax.swing.JFormattedTextField txtDataEmissao;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotalNf;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
