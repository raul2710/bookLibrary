/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GenreDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Genre;

/**
 *
 * @author Raul
 */
public class FormTableUpdate extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormTableUpdate
     */
    public FormTableUpdate() {
        initComponents();
        
        this.setTitle("Pesquisa de livros");
        this.setResizable(false);
        this.setMaximizable(false);
        this.setIconifiable(false);
        this.setClosable(true);

        configureTable();
        
        List<Genre> genreListId = new GenreDAO().listById();
        fillTable(genreListId);
        
        configureButtonGroup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbId = new javax.swing.JRadioButton();
        rdbName = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabGenre = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        rdbId.setText("Id");
        rdbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbIdActionPerformed(evt);
            }
        });

        rdbName.setText("Nome");

        jLabel1.setText("Pesquisar:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Atualizar ");

        tabGenre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabGenre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabGenreMouseClicked(evt);
            }
        });
        tabGenre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabGenreKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabGenre);

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(6, 6, 6)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rdbName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdbId))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbId)
                        .addComponent(rdbName))
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbIdActionPerformed

    private void tabGenreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabGenreMouseClicked
        //Double click
        if (evt.getClickCount() == 2) {
            //Descobrir a linha selecionada
            int linha = tabGenre.getSelectedRow();

            //Recuperar o ID selecionado
            int id = Integer.parseInt(
                tabGenre.getValueAt(linha, 0).toString()
            );

            //Abrir o FormCadastro
            FormRegisterGenre f = new FormRegisterGenre(id);
            this.getDesktopPane().add(f);
            f.setVisible(true);

            //Fechar o FormPesquisa
            //this.dispose();
        }
    }//GEN-LAST:event_tabGenreMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formFocusGained

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        updateTableGenre();
    }//GEN-LAST:event_formInternalFrameActivated

    private void tabGenreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabGenreKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtSearch.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                    null, "Informe o critério de pesquisa."
                );
            } else {
                configureTable();
                // PESQUISAR POR NOME
                List<Genre> lista = new GenreDAO().searchByName(txtSearch.getText());
                if (lista.size() > 0) {
                    DefaultTableModel m = (DefaultTableModel) tabGenre.getModel();
                    for (Genre espec : lista) {
                        m.addRow(new Object[]{
                            espec.getId(),
                            espec.getName()
                        });
                    }
                    tabGenre.setModel(m);
                } else {
                    JOptionPane.showMessageDialog(
                        null, "Nenhum registro encontrado."
                    );
                }
            }
        }
    }//GEN-LAST:event_tabGenreKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbId;
    private javax.swing.JRadioButton rdbName;
    private javax.swing.JTable tabGenre;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    
    private void configureButtonGroup() {

        ButtonGroup bg = new ButtonGroup();

        bg.add(rdbId);
        bg.add(rdbName);

        rdbId.setSelected(true);
    }
    
    private void fillTable(List<Genre> genreList) {
        
        if (genreList.size() > 0) {
            DefaultTableModel m = (DefaultTableModel) tabGenre.getModel();
            for (Genre g : genreList) {
                m.addRow(new Object[]{
                    g.getId(),
                    g.getName()
                });
            }
            tabGenre.setModel(m);
        } else {
            JOptionPane.showMessageDialog(
                    null, "Nenhum registro encontrado."
            );
        }
    }

    private void configureTable() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.addColumn("Id");
        m.addColumn("Nome");

        m.setNumRows(0);
        tabGenre.setModel(m);
    }
    
    private void updateTableGenre(){
        List<Genre> genreList = null;
        
        if(rdbName.isSelected())
            genreList = new GenreDAO().listById();
        else 
            genreList = new GenreDAO().listById();
        
        fillTable(genreList);
    }
}