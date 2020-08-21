
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    int TAMANHO = 3;

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextValorX = new javax.swing.JTextField();
        jLabelExercicio = new javax.swing.JLabel();
        jTextValorY = new javax.swing.JTextField();
        jTextValorZ = new javax.swing.JTextField();
        jButtonCalcular = new javax.swing.JButton();
        jComboOpcoes = new javax.swing.JComboBox<>();
        jTextValorXAux = new javax.swing.JTextField();
        jTextValorYAux = new javax.swing.JTextField();
        jTextValorZAux = new javax.swing.JTextField();
        jLabelNovoVetor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cálculo com Vetores");
        setResizable(false);

        jTextValorX.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorX.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de X:"));

        jLabelExercicio.setText("Insira os valores X, Y e Z de um vetor de 3 dimensões:");

        jTextValorY.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorY.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de Y:"));

        jTextValorZ.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorZ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorZ.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de Z:"));

        jButtonCalcular.setText("CALCULAR");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jComboOpcoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calcular o tamanho", "Normalizar", "Adicionar", "Subtrair", "Multiplicar por um escalar", "Dividir por um escalar", "Calcular o produto escalar" }));
        jComboOpcoes.setSelectedIndex(-1);
        jComboOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboOpcoesActionPerformed(evt);
            }
        });

        jTextValorXAux.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorXAux.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorXAux.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de X:"));
        jTextValorXAux.setEnabled(false);

        jTextValorYAux.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorYAux.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorYAux.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de Y:"));
        jTextValorYAux.setEnabled(false);

        jTextValorZAux.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorZAux.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorZAux.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de Z:"));
        jTextValorZAux.setEnabled(false);

        jLabelNovoVetor.setText("Vetor auxiliar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelExercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextValorY, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextValorZ, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButtonCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboOpcoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextValorXAux, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextValorYAux, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextValorZAux, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelNovoVetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelExercicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNovoVetor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextValorXAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorYAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorZAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jComboOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalcular)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        double vetorA[] = {
            Float.parseFloat(jTextValorX.getText()),
            Float.parseFloat(jTextValorY.getText()),
            Float.parseFloat(jTextValorZ.getText())
        };

        switch (jComboOpcoes.getSelectedIndex()) {
            case 0: {
                double tamanho = calcularTamanhoVetor(vetorA[0], vetorA[1], vetorA[2]);
                JOptionPane.showMessageDialog(null, "O tamanho do vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2] + ") é: " + tamanho);
                break;
            }
            case 1: {
                double vetorB[] = new double[TAMANHO], tamanho;
                tamanho = calcularTamanhoVetor(vetorA[0], vetorA[1], vetorA[2]);

                for (int i = 0; i < TAMANHO; i++) {
                    vetorB[i] = vetorA[i] / tamanho;
                }

                JOptionPane.showMessageDialog(null, "O vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2] + ") normalizado é: "
                        + "(" + vetorB[0] + ", " + vetorB[1] + ", " + vetorB[2] + ")");
                break;
            }
            case 2: {
                double vetorB[] = {
                    Float.parseFloat(jTextValorXAux.getText()),
                    Float.parseFloat(jTextValorYAux.getText()),
                    Float.parseFloat(jTextValorZAux.getText())
                };
                double vetorC[] = new double[TAMANHO];

                for (int i = 0; i < TAMANHO; i++) {
                    vetorC[i] = vetorA[i] + vetorB[i];
                }

                JOptionPane.showMessageDialog(null, "A soma do vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2] + ") com o vetor "
                        + "(" + vetorB[0] + ", " + vetorB[1] + ", " + vetorB[2] + ") é: (" + vetorC[0] + ", " + vetorC[1] + ", " + vetorC[2] + ")");
                break;
            }
            case 3: {
                double vetorB[] = {
                    Float.parseFloat(jTextValorXAux.getText()),
                    Float.parseFloat(jTextValorYAux.getText()),
                    Float.parseFloat(jTextValorZAux.getText())
                };
                double vetorC[] = new double[TAMANHO];

                for (int i = 0; i < TAMANHO; i++) {
                    vetorC[i] = vetorA[i] - vetorB[i];
                }

                JOptionPane.showMessageDialog(null, "A subtração do vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2] + ") com o vetor "
                        + "(" + vetorB[0] + ", " + vetorB[1] + ", " + vetorB[2] + ") é: (" + vetorC[0] + ", " + vetorC[1] + ", " + vetorC[2] + ")");
                break;
            }
            case 4: {
                double vetorB[] = new double[TAMANHO], escalar;
                escalar = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do escalar:"));

                for (int i = 0; i < TAMANHO; i++) {
                    vetorB[i] = vetorA[i] * escalar;
                }

                JOptionPane.showMessageDialog(null, "O resultado da multiplicação do vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2]
                        + ") pelo escalar " + escalar + " é: (" + vetorB[0] + ", " + vetorB[1] + ", " + vetorB[2] + ")");
                break;
            }
            case 5: {
                double vetorB[] = new double[TAMANHO], escalar;
                escalar = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do escalar:"));

                for (int i = 0; i < TAMANHO; i++) {
                    vetorB[i] = vetorA[i] / escalar;
                }

                JOptionPane.showMessageDialog(null, "O resultado da divisão do vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2]
                        + ") pelo escalar " + escalar + " é: (" + vetorB[0] + ", " + vetorB[1] + ", " + vetorB[2] + ")");
                break;
            }
            case 6: {
                double vetorB[] = {
                    Float.parseFloat(jTextValorXAux.getText()),
                    Float.parseFloat(jTextValorYAux.getText()),
                    Float.parseFloat(jTextValorZAux.getText())
                };

                double produtoEscalar = ((vetorA[0] * vetorB[0]) + (vetorA[1] * vetorB[1]) + (vetorA[2] * vetorB[2]));
                JOptionPane.showMessageDialog(null, "O produto escalar do vetor (" + vetorA[0] + ", " + vetorA[1] + ", " + vetorA[2] + ") pelo vetor "
                        + "(" + vetorB[0] + ", " + vetorB[1] + ", " + vetorB[2] + ") é: " + produtoEscalar);
                break;
            }
        }
    }//GEN-LAST:event_jButtonCalcularActionPerformed

    private void jComboOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboOpcoesActionPerformed
        switch (jComboOpcoes.getSelectedIndex()) {
            case 2: {
                habilitarFields();
                break;
            }
            case 3: {
                habilitarFields();
                break;
            }
            case 6: {
                habilitarFields();
                break;
            }
            default: {
                desabilitarFields();
            }
        }
    }//GEN-LAST:event_jComboOpcoesActionPerformed

    public void desabilitarFields() {
        jTextValorXAux.setEnabled(false);
        jTextValorYAux.setEnabled(false);
        jTextValorZAux.setEnabled(false);
    }

    public void habilitarFields() {
        jTextValorXAux.setEnabled(true);
        jTextValorYAux.setEnabled(true);
        jTextValorZAux.setEnabled(true);
    }

    public double calcularTamanhoVetor(double X, double Y, double Z) {
        double tamanho = Math.sqrt((Math.pow(X, 2)) + (Math.pow(Y, 2)) + (Math.pow(Z, 2)));
        return tamanho;
    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JComboBox<String> jComboOpcoes;
    private javax.swing.JLabel jLabelExercicio;
    private javax.swing.JLabel jLabelNovoVetor;
    private javax.swing.JTextField jTextValorX;
    private javax.swing.JTextField jTextValorXAux;
    private javax.swing.JTextField jTextValorY;
    private javax.swing.JTextField jTextValorYAux;
    private javax.swing.JTextField jTextValorZ;
    private javax.swing.JTextField jTextValorZAux;
    // End of variables declaration//GEN-END:variables
}
