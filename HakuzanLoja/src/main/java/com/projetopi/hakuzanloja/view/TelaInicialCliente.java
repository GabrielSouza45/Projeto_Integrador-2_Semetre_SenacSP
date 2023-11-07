package com.projetopi.hakuzanloja.view;

import java.awt.Color;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Lucas
 */
public class TelaInicialCliente extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicialCliente
     */
    public TelaInicialCliente() {
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

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Geral = new javax.swing.JPanel();
        Coluna = new javax.swing.JPanel();
        btn_Navegar = new javax.swing.JPanel();
        ind_Navegar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Sacola = new javax.swing.JPanel();
        ind_Sacola = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btn_MeusPedidos = new javax.swing.JPanel();
        ind_MeusPedidos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_MeuPerfil = new javax.swing.JPanel();
        ind_MeuPerfil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_TrocarUsuario = new javax.swing.JPanel();
        ind_TrocarUsuario = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_Ajudar = new javax.swing.JPanel();
        ind_Ajuda = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Title = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DesktopApareceTelas = new javax.swing.JDesktopPane();

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("X");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("X");

        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(596, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(544, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Geral.setLayout(new java.awt.BorderLayout());

        Coluna.setBackground(new java.awt.Color(51, 51, 51));
        Coluna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColunaMousePressed(evt);
            }
        });
        Coluna.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Navegar.setBackground(new java.awt.Color(51, 51, 51));
        btn_Navegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_NavegarMousePressed(evt);
            }
        });
        btn_Navegar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_Navegar.setBackground(new java.awt.Color(204, 204, 204));
        ind_Navegar.setForeground(new java.awt.Color(255, 255, 255));
        ind_Navegar.setOpaque(false);
        ind_Navegar.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_NavegarLayout = new javax.swing.GroupLayout(ind_Navegar);
        ind_Navegar.setLayout(ind_NavegarLayout);
        ind_NavegarLayout.setHorizontalGroup(
            ind_NavegarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_NavegarLayout.setVerticalGroup(
            ind_NavegarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_Navegar.add(ind_Navegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAVEGAR");
        btn_Navegar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 30));

        Coluna.add(btn_Navegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 225, -1));

        btn_Sacola.setBackground(new java.awt.Color(51, 51, 51));
        btn_Sacola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_SacolaMousePressed(evt);
            }
        });
        btn_Sacola.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_Sacola.setBackground(new java.awt.Color(204, 204, 204));
        ind_Sacola.setForeground(new java.awt.Color(255, 255, 255));
        ind_Sacola.setOpaque(false);
        ind_Sacola.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_SacolaLayout = new javax.swing.GroupLayout(ind_Sacola);
        ind_Sacola.setLayout(ind_SacolaLayout);
        ind_SacolaLayout.setHorizontalGroup(
            ind_SacolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_SacolaLayout.setVerticalGroup(
            ind_SacolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_Sacola.add(ind_Sacola, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SACOLA");
        btn_Sacola.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 30));

        Coluna.add(btn_Sacola, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 225, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Lojas");
        Coluna.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 61, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("HAKUZAN");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        Coluna.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 71, 130, -1));

        btn_MeusPedidos.setBackground(new java.awt.Color(51, 51, 51));
        btn_MeusPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_MeusPedidosMousePressed(evt);
            }
        });
        btn_MeusPedidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_MeusPedidos.setBackground(new java.awt.Color(204, 204, 204));
        ind_MeusPedidos.setForeground(new java.awt.Color(255, 255, 255));
        ind_MeusPedidos.setOpaque(false);
        ind_MeusPedidos.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_MeusPedidosLayout = new javax.swing.GroupLayout(ind_MeusPedidos);
        ind_MeusPedidos.setLayout(ind_MeusPedidosLayout);
        ind_MeusPedidosLayout.setHorizontalGroup(
            ind_MeusPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_MeusPedidosLayout.setVerticalGroup(
            ind_MeusPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_MeusPedidos.add(ind_MeusPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MEUS PEDIDOS");
        btn_MeusPedidos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 30));

        Coluna.add(btn_MeusPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, -1));

        btn_MeuPerfil.setBackground(new java.awt.Color(51, 51, 51));
        btn_MeuPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_MeuPerfilMousePressed(evt);
            }
        });
        btn_MeuPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_MeuPerfil.setBackground(new java.awt.Color(204, 204, 204));
        ind_MeuPerfil.setForeground(new java.awt.Color(255, 255, 255));
        ind_MeuPerfil.setOpaque(false);
        ind_MeuPerfil.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_MeuPerfilLayout = new javax.swing.GroupLayout(ind_MeuPerfil);
        ind_MeuPerfil.setLayout(ind_MeuPerfilLayout);
        ind_MeuPerfilLayout.setHorizontalGroup(
            ind_MeuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_MeuPerfilLayout.setVerticalGroup(
            ind_MeuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_MeuPerfil.add(ind_MeuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MEU PERFIL");
        btn_MeuPerfil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 30));

        Coluna.add(btn_MeuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 225, -1));

        btn_TrocarUsuario.setBackground(new java.awt.Color(51, 51, 51));
        btn_TrocarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_TrocarUsuarioMousePressed(evt);
            }
        });
        btn_TrocarUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_TrocarUsuario.setBackground(new java.awt.Color(204, 204, 204));
        ind_TrocarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        ind_TrocarUsuario.setOpaque(false);
        ind_TrocarUsuario.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_TrocarUsuarioLayout = new javax.swing.GroupLayout(ind_TrocarUsuario);
        ind_TrocarUsuario.setLayout(ind_TrocarUsuarioLayout);
        ind_TrocarUsuarioLayout.setHorizontalGroup(
            ind_TrocarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_TrocarUsuarioLayout.setVerticalGroup(
            ind_TrocarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_TrocarUsuario.add(ind_TrocarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TROCAR DE USUARIO");
        btn_TrocarUsuario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 30));

        Coluna.add(btn_TrocarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 225, -1));

        btn_Ajudar.setBackground(new java.awt.Color(51, 51, 51));
        btn_Ajudar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_AjudarMousePressed(evt);
            }
        });
        btn_Ajudar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_Ajuda.setBackground(new java.awt.Color(204, 204, 204));
        ind_Ajuda.setForeground(new java.awt.Color(255, 255, 255));
        ind_Ajuda.setOpaque(false);
        ind_Ajuda.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_AjudaLayout = new javax.swing.GroupLayout(ind_Ajuda);
        ind_Ajuda.setLayout(ind_AjudaLayout);
        ind_AjudaLayout.setHorizontalGroup(
            ind_AjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_AjudaLayout.setVerticalGroup(
            ind_AjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_Ajudar.add(ind_Ajuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AJUDA");
        btn_Ajudar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 30));

        Coluna.add(btn_Ajudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 225, -1));
        Coluna.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 560, 240, 310));

        Geral.add(Coluna, java.awt.BorderLayout.LINE_START);

        Title.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SEJA BEM VINDO A LOJA HAKUZAN");

        javax.swing.GroupLayout TitleLayout = new javax.swing.GroupLayout(Title);
        Title.setLayout(TitleLayout);
        TitleLayout.setHorizontalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1125, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TitleLayout.setVerticalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(jLabel11))
        );

        Geral.add(Title, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout DesktopApareceTelasLayout = new javax.swing.GroupLayout(DesktopApareceTelas);
        DesktopApareceTelas.setLayout(DesktopApareceTelasLayout);
        DesktopApareceTelasLayout.setHorizontalGroup(
            DesktopApareceTelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1114, Short.MAX_VALUE)
        );
        DesktopApareceTelasLayout.setVerticalGroup(
            DesktopApareceTelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );

        Geral.add(DesktopApareceTelas, java.awt.BorderLayout.CENTER);

        getContentPane().add(Geral, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ColunaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColunaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColunaMousePressed

    private void btn_AjudarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AjudarMousePressed
        setColor(btn_Ajudar);
        resetColor(btn_Sacola);
        resetColor(btn_MeusPedidos);
        resetColor(btn_MeuPerfil);
        resetColor(btn_TrocarUsuario);
        resetColor(btn_Navegar);
        ind_Navegar.setOpaque(false);
        ind_Sacola.setOpaque(false);
        ind_MeusPedidos.setOpaque(false);
        ind_MeuPerfil.setOpaque(false);
        ind_TrocarUsuario.setOpaque(false);
        ind_Ajuda.setOpaque(true);
    }//GEN-LAST:event_btn_AjudarMousePressed

    private void btn_TrocarUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrocarUsuarioMousePressed
        setColor(btn_TrocarUsuario);
        resetColor(btn_Sacola);
        resetColor(btn_MeusPedidos);
        resetColor(btn_MeuPerfil);
        resetColor(btn_Navegar);
        resetColor(btn_Ajudar);
        ind_Navegar.setOpaque(false);
        ind_Sacola.setOpaque(false);
        ind_MeusPedidos.setOpaque(false);
        ind_MeuPerfil.setOpaque(false);
        ind_TrocarUsuario.setOpaque(true);
        ind_Ajuda.setOpaque(false);
    }//GEN-LAST:event_btn_TrocarUsuarioMousePressed

    private void btn_MeuPerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MeuPerfilMousePressed
        setColor(btn_MeuPerfil);
        resetColor(btn_Sacola);
        resetColor(btn_MeusPedidos);
        resetColor(btn_Navegar);
        resetColor(btn_TrocarUsuario);
        resetColor(btn_Ajudar);
        ind_Navegar.setOpaque(false);
        ind_Sacola.setOpaque(false);
        ind_MeusPedidos.setOpaque(false);
        ind_MeuPerfil.setOpaque(true);
        ind_TrocarUsuario.setOpaque(false);
        ind_Ajuda.setOpaque(false);
        
        MeuPerfilCliente mpc = new MeuPerfilCliente();
        DesktopApareceTelas.add(mpc);
        mpc.setVisible(true);
        
    }//GEN-LAST:event_btn_MeuPerfilMousePressed

    private void btn_MeusPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MeusPedidosMousePressed
        setColor(btn_MeusPedidos);
        resetColor(btn_Sacola);
        resetColor(btn_Navegar);
        resetColor(btn_MeuPerfil);
        resetColor(btn_TrocarUsuario);
        resetColor(btn_Ajudar);
        ind_Navegar.setOpaque(false);
        ind_Sacola.setOpaque(false);
        ind_MeusPedidos.setOpaque(true);
        ind_MeuPerfil.setOpaque(false);
        ind_TrocarUsuario.setOpaque(false);
        ind_Ajuda.setOpaque(false);

    }//GEN-LAST:event_btn_MeusPedidosMousePressed

    private void btn_SacolaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SacolaMousePressed
        setColor(btn_Sacola);
        resetColor(btn_Navegar);
        resetColor(btn_MeusPedidos);
        resetColor(btn_MeuPerfil);
        resetColor(btn_TrocarUsuario);
        resetColor(btn_Ajudar);
        ind_Navegar.setOpaque(false);
        ind_Sacola.setOpaque(true);
        ind_MeusPedidos.setOpaque(false);
        ind_MeuPerfil.setOpaque(false);
        ind_TrocarUsuario.setOpaque(false);
        ind_Ajuda.setOpaque(false);
    }//GEN-LAST:event_btn_SacolaMousePressed

    private void btn_NavegarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NavegarMousePressed
        setColor(btn_Navegar);
        resetColor(btn_Sacola);
        resetColor(btn_MeusPedidos);
        resetColor(btn_MeuPerfil);
        resetColor(btn_TrocarUsuario);
        resetColor(btn_Ajudar);
        ind_Navegar.setOpaque(true);
        ind_Sacola.setOpaque(false);
        ind_MeusPedidos.setOpaque(false);
        ind_MeuPerfil.setOpaque(false);
        ind_TrocarUsuario.setOpaque(false);
        ind_Ajuda.setOpaque(false);
        
        
        
        

    }//GEN-LAST:event_btn_NavegarMousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel7MousePressed
    
    void setColor(JPanel panel){
        panel.setBackground(new Color(153,153,153));
    }
    
    void resetColor(JPanel panel){
        panel.setBackground(new Color(51,51,51));
    } 
        
        
        
        
        
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Coluna;
    private javax.swing.JDesktopPane DesktopApareceTelas;
    private javax.swing.JPanel Geral;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel Title;
    private javax.swing.JPanel btn_Ajudar;
    private javax.swing.JPanel btn_MeuPerfil;
    private javax.swing.JPanel btn_MeusPedidos;
    private javax.swing.JPanel btn_Navegar;
    private javax.swing.JPanel btn_Sacola;
    private javax.swing.JPanel btn_TrocarUsuario;
    private javax.swing.JPanel ind_Ajuda;
    private javax.swing.JPanel ind_MeuPerfil;
    private javax.swing.JPanel ind_MeusPedidos;
    private javax.swing.JPanel ind_Navegar;
    private javax.swing.JPanel ind_Sacola;
    private javax.swing.JPanel ind_TrocarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
