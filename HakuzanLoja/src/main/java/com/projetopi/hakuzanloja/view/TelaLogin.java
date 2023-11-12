/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projetopi.hakuzanloja.view;


import com.projetopi.hakuzanloja.controller.UsuarioDao;
import com.projetopi.hakuzanloja.model.UsuarioAtual;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form telaLogin
     */
    public TelaLogin(){
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnFecharTela = new javax.swing.JButton();
        btnValidaLogin = new com.k33ptoo.components.KButton();
        jLabel4 = new javax.swing.JLabel();
        btnValidaLogin2 = new com.k33ptoo.components.KButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblOvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        txtLogin.setBackground(new java.awt.Color(237, 237, 237));
        txtLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha");

        txtSenha.setBackground(new java.awt.Color(237, 237, 237));
        txtSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        btnFecharTela.setBackground(new java.awt.Color(245, 245, 245));
        btnFecharTela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFecharTela.setForeground(new java.awt.Color(255, 255, 255));
        btnFecharTela.setText("X");
        btnFecharTela.setBorder(null);
        btnFecharTela.setDefaultCapable(false);
        btnFecharTela.setFocusPainted(false);
        btnFecharTela.setFocusable(false);
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        btnValidaLogin.setText("Entrar");
        btnValidaLogin.setBorderPainted(false);
        btnValidaLogin.setkBorderRadius(40);
        btnValidaLogin.setkEndColor(new java.awt.Color(0, 0, 0));
        btnValidaLogin.setkFillButton(false);
        btnValidaLogin.setkHoverEndColor(new java.awt.Color(0, 0, 0));
        btnValidaLogin.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        btnValidaLogin.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnValidaLogin.setkStartColor(new java.awt.Color(204, 204, 204));
        btnValidaLogin.setOpaque(true);
        btnValidaLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidaLoginMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("OU");

        btnValidaLogin2.setText("Cadastrar");
        btnValidaLogin2.setBorderPainted(false);
        btnValidaLogin2.setkBorderRadius(40);
        btnValidaLogin2.setkEndColor(new java.awt.Color(204, 204, 204));
        btnValidaLogin2.setkHoverEndColor(new java.awt.Color(0, 0, 0));
        btnValidaLogin2.setkHoverForeGround(new java.awt.Color(102, 102, 102));
        btnValidaLogin2.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        btnValidaLogin2.setkStartColor(new java.awt.Color(0, 0, 0));
        btnValidaLogin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidaLogin2MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("HAKUZAN");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Lojas");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Esqueceu sua senha?");
        jButton1.setBorder(null);

        lblOvo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TelaLogin.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOvo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(btnValidaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel4)
                            .addGap(33, 33, 33)
                            .addComponent(btnValidaLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtSenha)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblOvo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel27)))
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValidaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidaLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 580, 580));

        setSize(new java.awt.Dimension(559, 554));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnValidaLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidaLoginMouseClicked
        String login = txtLogin.getText();
        String senha = String.valueOf(txtSenha.getPassword());

        UsuarioDao u = new UsuarioDao();
        try {

            ResultSet reslt = u.validarLogin(login, senha);
            
            
            if (reslt.next()){
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                 this.setVisible(false);
                // COLOCAR TELA QUE IRA SER ABERTA
                if(reslt.getLong("PK_ID")  == (long)1){
                    
                    TelaInicialParaAdmin telaIni = new TelaInicialParaAdmin();
                    telaIni.setVisible(true);
                    UsuarioAtual.setUserAtual(u.buscarUsuarioPorEmail(reslt.getString("DS_EMAIL")));
                    
                }else{
                    
                    TelaInicialCliente tic = new TelaInicialCliente();
                    tic.setVisible(true);
                    UsuarioAtual.setUserAtual(u.buscarUsuarioPorEmail(reslt.getString("DS_EMAIL")));
                
                }
                   
                    
                

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

    private void btnValidaLogin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidaLogin2MouseClicked
        TelaAutoCadastroCliente tacc = new TelaAutoCadastroCliente();
        dispose();
        tacc.setVisible(true);
    }//GEN-LAST:event_btnValidaLogin2MouseClicked



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAutoCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAutoCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAutoCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAutoCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharTela;
    private com.k33ptoo.components.KButton btnValidaLogin;
    private com.k33ptoo.components.KButton btnValidaLogin2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblOvo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
