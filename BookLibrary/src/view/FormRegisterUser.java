package view;


import view.MainMenu;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.User;
import controller.UserDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @Author Raul
 */
public class FormRegisterUser extends javax.swing.JFrame {

    /**
     * Creates new form FormRegisterUser
     */
    public FormRegisterUser() {
        initComponents();
        configureForm();
        
        txtId.setEditable(false);
        createFormatter("##/##/####").install(txtDateBorn);
        createFormatter("(##)#####-####").install(txtTelephone);
        createFormatter("###.###.###-##").install(txtCpf);
        
        ButtonGroup bg_fg = new ButtonGroup();
        bg_fg.add(rdbActive);
        bg_fg.add(rdbInactive);
        rdbActive.setSelected(true);  
    }
    
    public FormRegisterUser(int id) {
        initComponents();
        configureForm();
        
        txtId.setEditable(false);
        
        User user = new UserDAO().searchById(id);
        
        LocalDate dateBorn = LocalDate.parse(user.getDateBorn().toString());
        
        DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        
        txtDateBorn.setText(dateBorn.format(formatOutput));
        
        ButtonGroup bg_fg = new ButtonGroup();
        bg_fg.add(rdbActive);
        bg_fg.add(rdbInactive);

        if(user.getStatus().equals("Ativo"))
            rdbActive.setSelected(true);
        else
            rdbInactive.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtId = new javax.swing.JFormattedTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JFormattedTextField();
        lblDataNascimento = new javax.swing.JLabel();
        txtDateBorn = new javax.swing.JFormattedTextField();
        lblStatus = new javax.swing.JLabel();
        rdbActive = new javax.swing.JRadioButton();
        rdbInactive = new javax.swing.JRadioButton();
        btnShowPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro");

        lblNome.setText("Nome completo:");

        lblId.setText("Id:");

        lblEmail.setText("Email:");

        lblSenha.setText("Senha:");

        btnRegister.setText("Cadastrar");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Perfil.png"))); // NOI18N

        lblCpf.setText("CPF:");

        lblTelefone.setText("Telefone:");

        lblDataNascimento.setText("Data de nascimento:");

        lblStatus.setText("Status:");

        rdbActive.setText("Ativo");

        rdbInactive.setText("Suspenso");

        btnShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/show_password.png"))); // NOI18N
        btnShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addGap(172, 172, 172)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblNome)
                                .addGap(195, 195, 195)
                                .addComponent(lblId))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblCpf)
                                .addGap(139, 139, 139)
                                .addComponent(lblTelefone))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblSenha))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(btnBack)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegister))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDateBorn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(rdbActive)
                                        .addGap(6, 6, 6)
                                        .addComponent(rdbInactive))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDataNascimento)
                                                .addGap(73, 73, 73)
                                                .addComponent(lblStatus)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtPassword))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnShowPassword)))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblId))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCpf)
                    .addComponent(lblTelefone))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addGap(6, 6, 6)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataNascimento)
                    .addComponent(lblStatus))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateBorn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbActive)
                            .addComponent(rdbInactive))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(btnRegister))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        
        //Recuperar o valor informado pelo usuário
        User user = new User();
        user.setName(txtName.getText());
        user.setCpf(txtCpf.getText());
        user.setTelephone(txtTelephone.getText());
        user.setEmail(txtEmail.getText());
        user.setPassword(new String(txtPassword.getPassword()));
        user.setStatus(rdbActive.isSelected() ? "Ativo" : "Inativo");
        
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dateBorn = LocalDate.parse(txtDateBorn.getText(), formatInput);
        
        user.setDateBorn(Date.valueOf(dateBorn.toString()));
        
        int res = -1;
        if (txtId.getText().isEmpty()){
            //Operação de INSERIR
            res = new UserDAO().add(user);
        }else{
            //Operação de ATUALIZAR
            user.setId(Integer.parseInt(txtId.getText()));
            res = new UserDAO().update(user);
        }
        
        //Verificar se deu certo
        if (res > 0){
            txtId.setText(String.valueOf(res));
            JOptionPane.showMessageDialog(
                null,"Operação realizada com sucesso!"
            );
        }else{
            JOptionPane.showMessageDialog(
                null,"Não foi possível realizar a operação!"
            );
        }
        
        FormLogin f = new FormLogin();
        f.setVisible(true);
                
        this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        FormLogin f = new FormLogin();
            f.setVisible(true);

        //Fechar o Formulário de Registro
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPasswordActionPerformed
        // TODO add your handling code here:
        if(txtPassword.getEchoChar() == '*')
            showPassword(true);
        else           
            showPassword(false);            
    }//GEN-LAST:event_btnShowPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormRegisterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JRadioButton rdbActive;
    private javax.swing.JRadioButton rdbInactive;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDateBorn;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
    
    private void configureForm(){
        //Título 
        this.setTitle("Cadastro");
        //Redimensionamento
        this.setResizable(false);
        //Centralizar na tela
        this.setLocationRelativeTo(null);
        
        //Definir o método de fechamento do form
        this.setDefaultCloseOperation(
            JFrame.DISPOSE_ON_CLOSE
        );
    }
    
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
            formatter.setPlaceholderCharacter('_');
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }

        return formatter;
    }

    private void showPassword(boolean show){
        if(show){
            txtPassword.setEchoChar((char)0);
            ImageIcon img = new ImageIcon(getClass().getResource("/images/button/disable_password.png"));
            btnShowPassword.setIcon(img);
        }
        else {
            txtPassword.setEchoChar('*');
            ImageIcon img = new ImageIcon(getClass().getResource("/images/button/show_password.png"));
            btnShowPassword.setIcon(img);
        }
    }
}
