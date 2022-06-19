package visao.animal;

import controlador.CAnimal;
import static controlador.CAnimal.converteStringDate;
import javax.swing.JOptionPane;
import modelo.DAO.DAOAnimal;
import modelo.dominio.Animal;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class AtualizarFormulario extends javax.swing.JFrame {

    /**
     * Creates new form AtualizarFormulario
     */
    public AtualizarFormulario() {
        initComponents();
    }
    
    public AtualizarFormulario(Animal animal) {
        initComponents();
        
        String[] auxDataNascimentoVetor = CAnimal.converteDataString(animal.getDataNascimento())
                .split("/");
        String auxDataNascimento = "";
        
        for(int i = 0; i < auxDataNascimentoVetor.length; i++){
            auxDataNascimento += auxDataNascimentoVetor[i];
        }
        
        campoNomeAnimal.setText(animal.getNomeAnimal());
        campoNumeroCadastro.setText(animal.getNumeroCadastro());
        campoApelido.setText(animal.getApelido());
        campoEspecie.setText(animal.getEspecie());
        campoRaca.setText(animal.getRaca());
        textAreaInformacoes.setText(animal.getInformacoes());
        
        if(animal.getSexo().equals("Fêmea")){
        radioFemea.setSelected(true);  
      
        } else {
        radioMacho.setSelected(true);
        }
        
        comboPorte.setSelectedItem(animal.getPorte()); 
        campoDataNascimento.setText(auxDataNascimento);
        campoCor.setText(animal.getCor());
        campoPeso.setText(animal.getPeso());
        
        
    
    }                       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoNomeAnimal = new javax.swing.JTextField();
        campoNumeroCadastro = new javax.swing.JTextField();
        campoEspecie = new javax.swing.JTextField();
        campoRaca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInformacoes = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboPorte = new javax.swing.JComboBox<>();
        radioFemea = new javax.swing.JRadioButton();
        radioMacho = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoDataNascimento = new javax.swing.JFormattedTextField();
        campoCor = new javax.swing.JTextField();
        campoPeso = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botaoAtualizar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        campoApelido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atualizar Animal");

        jPanel1.setBackground(new java.awt.Color(165, 232, 255));

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atualizar Animal");

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel2.setText("Nome do animal:");

        jLabel3.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel3.setText("Apelido:");

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel4.setText("Espécie:");

        jLabel5.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel5.setText("Raça:");

        campoNumeroCadastro.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel6.setText("Informações importantes:");

        textAreaInformacoes.setColumns(20);
        textAreaInformacoes.setRows(5);
        jScrollPane1.setViewportView(textAreaInformacoes);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logoborda.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel7.setText("Sexo:");

        jLabel8.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel8.setText("Porte:");

        comboPorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande" }));
        comboPorte.setSelectedIndex(-1);

        radioFemea.setBackground(new java.awt.Color(165, 232, 255));
        grupoSexo.add(radioFemea);
        radioFemea.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        radioFemea.setText("Fêmea");

        radioMacho.setBackground(new java.awt.Color(165, 232, 255));
        grupoSexo.add(radioMacho);
        radioMacho.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        radioMacho.setText("Macho");

        jLabel9.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel9.setText("Cor:");

        jLabel10.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel10.setText("Peso: (kg)");

        jLabel12.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel12.setText("Data de nascimento:");

        try {
            campoDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel2.setBackground(new java.awt.Color(165, 232, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 100, 0));

        botaoAtualizar.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botaoAtualizar);

        botaoVoltar.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(botaoVoltar);

        jLabel13.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel13.setText("N° Cadastro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(radioFemea)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(radioMacho))
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel7))
                                            .addGap(87, 87, 87)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel8)))
                                        .addComponent(campoNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(campoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(campoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(campoRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(373, 373, 373)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6)
                            .addComponent(campoNumeroCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(campoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumeroCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioFemea)
                            .addComponent(radioMacho))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoCor, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(campoPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        
        Animal animal = new Animal();
        
        animal.setNomeAnimal(campoNomeAnimal.getText());
        animal.setNumeroCadastro(campoNumeroCadastro.getText());
        animal.setApelido(campoApelido.getText());
        animal.setEspecie(campoEspecie.getText());
        animal.setRaca(campoRaca.getText());
        animal.setInformacoes(textAreaInformacoes.getText());
        
        String sexo = "";
        if(radioFemea.isSelected())
        {
            sexo = "Fêmea";
        }
        if(radioMacho.isSelected())
        {
            sexo = "Macho";
        }
        animal.setSexo(sexo);
        
        animal.setPorte(comboPorte.getSelectedItem().toString());
        
        if(!campoDataNascimento.getText().equals("  /  /    ")){
            animal.setDataNascimento(converteStringDate(campoDataNascimento.getText()));
        }
 
        animal.setCor(campoCor.getText());
        animal.setPeso(campoPeso.getText());
       

        DAOAnimal atualizar = new DAOAnimal();
        if (atualizar.alteraAnimal(animal)) {
            JOptionPane.showMessageDialog(null, "Animal atualizado com sucesso!");
            
            this.dispose();
            new AtualizarAnimal().setVisible(true);
        }
                                                   
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    public void limparCampos(){
        campoNomeAnimal.setText("");
        campoNumeroCadastro.setText("");
        campoApelido.setText("");
        campoEspecie.setText("");
        campoRaca.setText("");
        textAreaInformacoes.setText("");
        comboPorte.setSelectedItem(0);
        campoDataNascimento.setText("");
        campoCor.setText("");
        campoPeso.setText("");
        
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
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoApelido;
    private javax.swing.JTextField campoCor;
    private javax.swing.JFormattedTextField campoDataNascimento;
    private javax.swing.JTextField campoEspecie;
    private javax.swing.JTextField campoNomeAnimal;
    private javax.swing.JTextField campoNumeroCadastro;
    private javax.swing.JTextField campoPeso;
    private javax.swing.JTextField campoRaca;
    private javax.swing.JComboBox<String> comboPorte;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioFemea;
    private javax.swing.JRadioButton radioMacho;
    private javax.swing.JTextArea textAreaInformacoes;
    // End of variables declaration//GEN-END:variables
}
