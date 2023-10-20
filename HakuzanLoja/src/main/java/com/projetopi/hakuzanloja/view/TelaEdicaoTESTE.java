/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projetopi.hakuzanloja.view;

import com.projetopi.hakuzanloja.controller.NivelDao;
import com.projetopi.hakuzanloja.controller.UsuarioDao;
import com.projetopi.hakuzanloja.model.Nivel;
import com.projetopi.hakuzanloja.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 *
 * @author snubd
 */
public class TelaEdicaoTESTE extends javax.swing.JFrame {

    private Usuario usuarioEditar;
    private List<Nivel> niveis = new NivelDao().listarTodos();

    /**
     * Creates new form TelaCadastro
     */
    public TelaEdicaoTESTE() {

        initComponents();
        carregaComboNivel();
    }

    private void limparCampos(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setText(""); // Limpa o conteúdo do JTextField
            } else if (component instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) component;
                comboBox.setSelectedIndex(0); // Define a seleção para o primeiro item (ou -1 para nenhum item selecionado)
            } else if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                checkBox.setSelected(false); // Desmarca a caixa de seleção
            } else if (component instanceof Container) {
                limparCampos((Container) component); // Recursivamente, limpa os campos dentro de outros contêineres (painéis, etc.)
            }
        }
    }

    private void carregaComboNivel() {
        cbxNiveis.removeAllItems(); // inicia combo vazio para evitar repetições

        for (Nivel nivel : this.niveis) {
            cbxNiveis.addItem(nivel);
        }

        cbxNiveis.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Nivel) {
                    Nivel nivel = (Nivel) value;
                    setText(nivel.getId() + ". " + nivel.getDescNiveis()); // Exibir a descrição do nível
                }
                return this;
            }
        });
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnCadastraUser = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRuaBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscarEmail = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        btnNivel = new javax.swing.JButton();
        cbxNiveis = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDescNivel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEmailBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(62, 62, 62));
        jPanel1.setPreferredSize(new java.awt.Dimension(779, 416));

        jPanel2.setBackground(new java.awt.Color(237, 237, 237));

        btnFecharTela.setText("X");
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(btnFecharTela)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnFecharTela)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefone");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnCadastraUser.setText("Cadastrar");
        btnCadastraUser.setBorder(null);
        btnCadastraUser.setFocusable(false);
        btnCadastraUser.setOpaque(true);
        btnCadastraUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastraUserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCadastraUserMousePressed(evt);
            }
        });
        btnCadastraUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraUserActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Endereço");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Logradouro");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bairro");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cidade");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CEP");

        btnListar.setText("listar");
        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });

        btnEditar.setText("editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        btnBuscarEmail.setText("buscarPorEmail");
        btnBuscarEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarEmailMouseClicked(evt);
            }
        });

        btnExcluir.setText("excluir");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Estado");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("numero");

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        btnNivel.setText("cad Nivel");
        btnNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNivelMouseClicked(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nivel");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nivel");

        txtDescNivel.setText("Desc Nivel");
        txtDescNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescNivelMouseClicked(evt);
            }
        });
        txtDescNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescNivelActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Buscar User");

        txtEmailBuscar.setText("email");
        txtEmailBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtPassword)
                                    .addComponent(txtNome)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnListar)
                                .addGap(30, 30, 30)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarEmail)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addGap(14, 14, 14)
                                .addComponent(btnNivel)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadastraUser, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxNiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(402, 402, 402))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmailBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBairro)
                                            .addComponent(txtRuaBairro)
                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEstado))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNumero))))
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(180, 180, 180)))))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNiveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRuaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmailBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastraUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar)
                    .addComponent(btnEditar)
                    .addComponent(btnBuscarEmail)
                    .addComponent(btnExcluir)
                    .addComponent(btnNivel))
                .addGap(19, 19, 19))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 470));

        setSize(new java.awt.Dimension(768, 470));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnCadastraUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraUserActionPerformed

        
    }//GEN-LAST:event_btnCadastraUserActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        TelaLogin tll = new TelaLogin();
        dispose();
        tll.setVisible(true);
        
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void btnCadastraUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastraUserMouseClicked

        Usuario usuario = new Usuario();

        usuario.setNome(txtNome.getText());
        usuario.setDocumento(txtCPF.getText());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setEmail(txtEmail.getText());
        usuario.setLogin(txtLogin.getText());
        usuario.setSenha(txtPassword.getText());
        usuario.setLogradouro(txtRuaBairro.getText());
        usuario.setBairro(txtBairro.getText());
        usuario.setCidade(txtCidade.getText());
        usuario.setCep(txtCEP.getText());
        usuario.setUf(txtEstado.getText());
        usuario.setNumero(txtNumero.getText());
        try {
            usuario.setNivel( (Nivel) cbxNiveis.getSelectedItem());
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Erro ao definir nivel ao usuario. \n" + err.getMessage());
        }

        UsuarioDao dao = new UsuarioDao();
        dao.cadastrar(usuario);

    }//GEN-LAST:event_btnCadastraUserMouseClicked

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNivelMouseClicked

//        Deletar Nivel selecionado na comboBox: {
            Nivel nivel = (Nivel) cbxNiveis.getSelectedItem();
            NivelDao dao = new NivelDao();
            dao.excluir(nivel);
            carregaComboNivel();
//        }

//        Adicionar Nivel Digitado na txtDescNivel (Não permite duplicados){
//            Nivel nivel = new Nivel();
//            nivel.setDescNiveis(txtDescNivel.getText());
//            NivelDao dao = new NivelDao();
//            dao.incluirNivel(nivel);
//        }

//        Procurar Nivel pelo id {
//            Nivel nivel = new NivelDao().buscarNivelPorId(id);
//        }




    }//GEN-LAST:event_btnNivelMouseClicked

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked

        UsuarioDao dao = new UsuarioDao();
        List<Usuario> users = dao.listarTodos();

        for (Usuario us : users){ // Botar numa tabela
            System.out.println(us.getId()+"\n " + us.getNome()+"\n " + us.getEmail()+"\n " + (us.getNivel() != null ? us.getNivel().getDescNiveis() : ""));
        }

    }//GEN-LAST:event_btnListarMouseClicked

    private void txtDescNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescNivelActionPerformed

    private void txtDescNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescNivelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescNivelMouseClicked

    private void txtEmailBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailBuscarMouseClicked

    private void btnBuscarEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarEmailMouseClicked

        this.usuarioEditar = new UsuarioDao().buscarUsuarioPorEmail(txtEmailBuscar.getText());
        txtLogin.setText(usuarioEditar.getLogin());
        txtPassword.setText(usuarioEditar.getSenha());
        txtNome.setText(usuarioEditar.getNome());
        txtTelefone.setText(usuarioEditar.getTelefone());
        txtEmail.setText(usuarioEditar.getEmail());
        txtCPF.setText(usuarioEditar.getDocumento());
        txtRuaBairro.setText(usuarioEditar.getLogradouro());
        txtBairro.setText(usuarioEditar.getBairro());
        txtCidade.setText(usuarioEditar.getCidade());
        txtCEP.setText(usuarioEditar.getCep());
        txtNumero.setText(usuarioEditar.getNumero());
        txtEstado.setText(usuarioEditar.getUf());

    }//GEN-LAST:event_btnBuscarEmailMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked

        usuarioEditar.setNome(txtNome.getText());
        usuarioEditar.setDocumento(txtCPF.getText());
        usuarioEditar.setTelefone(txtTelefone.getText());
        usuarioEditar.setEmail(txtEmail.getText());
        usuarioEditar.setLogin(txtLogin.getText());
        usuarioEditar.setSenha(txtPassword.getText());
        usuarioEditar.setLogradouro(txtRuaBairro.getText());
        usuarioEditar.setBairro(txtBairro.getText());
        usuarioEditar.setCidade(txtCidade.getText());
        usuarioEditar.setCep(txtCEP.getText());
        usuarioEditar.setUf(txtEstado.getText());
        usuarioEditar.setNumero(txtNumero.getText());
        try {
            usuarioEditar.setNivel( (Nivel) cbxNiveis.getSelectedItem());
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Erro ao definir nivel ao usuarioEditar. \n" + err.getMessage());
        }

        UsuarioDao dao = new UsuarioDao();
        dao.editar(this.usuarioEditar);

        limparCampos(this.getContentPane());

    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnCadastraUserMousePressed(java.awt.event.MouseEvent evt) {                                             



        
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoTESTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoTESTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoTESTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoTESTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new TelaEdicaoTESTE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEmail;
    private javax.swing.JButton btnCadastraUser;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNivel;
    private javax.swing.JComboBox<Nivel> cbxNiveis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDescNivel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailBuscar;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRuaBairro;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
