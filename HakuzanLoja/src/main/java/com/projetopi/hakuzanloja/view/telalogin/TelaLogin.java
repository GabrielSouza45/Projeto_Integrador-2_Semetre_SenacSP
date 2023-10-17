/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projetopi.hakuzanloja.view.telalogin;


import com.mysql.cj.protocol.Resultset;
import com.projetopi.hakuzanloja.controler.pedido.FormaDePagamentoDao;
import com.projetopi.hakuzanloja.controler.pedido.ItensPedidoDao;
import com.projetopi.hakuzanloja.controler.pedido.PedidoDao;
import com.projetopi.hakuzanloja.controler.usuario.NivelDao;
import com.projetopi.hakuzanloja.controler.produto.CategoriaDao;
import com.projetopi.hakuzanloja.controler.produto.ProdutoDao;
import com.projetopi.hakuzanloja.controler.usuario.UsuarioDao;
import com.projetopi.hakuzanloja.view.TelaInicial;
import com.projetopi.hakuzanloja.view.usuario.TelaCadastroAPartirLogin;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form telaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFecharTela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnValidaLogin = new javax.swing.JButton();
        btnCadastroAbrir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(237, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(62, 62, 62));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 158, 416));

        btnFecharTela.setBackground(new java.awt.Color(245, 245, 245));
        btnFecharTela.setText("X");
        btnFecharTela.setBorder(null);
        btnFecharTela.setDefaultCapable(false);
        btnFecharTela.setFocusable(false);
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFecharTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 0, 30, 30));

        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 40, 30));
        jPanel1.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 270, -1));

        jLabel2.setText("Senha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 260, -1));

        btnValidaLogin.setText("Entrar");
        btnValidaLogin.setBorder(null);
        btnValidaLogin.setFocusable(false);
        btnValidaLogin.setOpaque(true);
        btnValidaLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidaLoginMouseClicked(evt);
            }
        });
        btnValidaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidaLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnValidaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 80, 30));

        btnCadastroAbrir.setBackground(new java.awt.Color(237, 237, 237));
        btnCadastroAbrir.setForeground(new java.awt.Color(0, 0, 255));
        btnCadastroAbrir.setText("cadastro ?");
        btnCadastroAbrir.setBorder(null);
        btnCadastroAbrir.setFocusable(false);
        btnCadastroAbrir.setOpaque(true);
        btnCadastroAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastroAbrirMouseClicked(evt);
            }
        });
        btnCadastroAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroAbrirActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastroAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, 20));

        jLabel3.setText("Não tem");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 768, 416));

        setSize(new java.awt.Dimension(768, 416));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnValidaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnValidaLoginActionPerformed

    private void btnValidaLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidaLoginMouseClicked
        

        String login = txtLogin.getText();
        String senha = String.valueOf(txtSenha.getPassword());

        UsuarioDao u = new UsuarioDao();
        try {

            ResultSet reslt = u.validarLogin(login, senha);
            if (reslt.next()){

                // COLOCAR TELA QUE IRA SER ABERTA
                TelaInicial telaIni = new TelaInicial();
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                this.setVisible(false);
                telaIni.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Usuário ou senha inválidos",
                        "Erro de operação",
                        JOptionPane.WARNING_MESSAGE);
            }

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        
    }//GEN-LAST:event_btnValidaLoginMouseClicked

    private void btnCadastroAbrirActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }

    private void btnCadastroAbrirMouseClicked(java.awt.event.MouseEvent evt) {

        TelaCadastroAPartirLogin tlc = new TelaCadastroAPartirLogin();
        dispose();
        tlc.setVisible(true);
        
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroAbrir;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JButton btnValidaLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}