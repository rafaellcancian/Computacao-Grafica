
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    int TAMANHO = 3;

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        jTextAreaResultados.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMatrizA = new javax.swing.JTable();
        jLabelMatrizA = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMatrizB = new javax.swing.JTable();
        jLabelMatrizB = new javax.swing.JLabel();
        jComboOpcoes = new javax.swing.JComboBox<>();
        jButtonCalcular = new javax.swing.JButton();
        jTextValorX = new javax.swing.JTextField();
        jLabelVetor = new javax.swing.JLabel();
        jTextValorY = new javax.swing.JTextField();
        jTextValorZ = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaResultados = new javax.swing.JTextArea();
        jLabelResultados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cálculo com Matrizes");
        setResizable(false);

        jTableMatrizA.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTableMatrizA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Double(2.0),  new Double(3.0),  new Double(5.0)},
                { new Double(1.0),  new Double(5.0),  new Double(7.0)},
                { new Double(3.0),  new Double(4.0),  new Double(8.0)}
            },
            new String [] {
                "Coluna 1", "Coluna 2", "Coluna 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableMatrizA.setRowHeight(30);
        jScrollPane1.setViewportView(jTableMatrizA);

        jLabelMatrizA.setText("Matriz A:");

        jTableMatrizB.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTableMatrizB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Double(2.0),  new Double(2.0),  new Double(2.0)},
                { new Double(2.0),  new Double(2.0),  new Double(2.0)},
                { new Double(2.0),  new Double(2.0),  new Double(2.0)}
            },
            new String [] {
                "Coluna 1", "Coluna 2", "Coluna 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableMatrizB.setEnabled(false);
        jTableMatrizB.setRowHeight(30);
        jScrollPane2.setViewportView(jTableMatrizB);

        jLabelMatrizB.setText("Matriz B:");

        jComboOpcoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adicionar", "Subtrair", "Multiplicar por um escalar", "Dividir por um escalar", "Multiplicar por um vetor", "Multiplicar", "Transposta" }));
        jComboOpcoes.setSelectedIndex(-1);
        jComboOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboOpcoesActionPerformed(evt);
            }
        });

        jButtonCalcular.setText("CALCULAR");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jTextValorX.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorX.setText("2");
        jTextValorX.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de X:"));
        jTextValorX.setEnabled(false);

        jLabelVetor.setText("Insira os valores X, Y e Z de um vetor de 3 dimensões:");

        jTextValorY.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorY.setText("3");
        jTextValorY.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de Y:"));
        jTextValorY.setEnabled(false);

        jTextValorZ.setBackground(new java.awt.Color(240, 240, 240));
        jTextValorZ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValorZ.setText("5");
        jTextValorZ.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor de Z:"));
        jTextValorZ.setEnabled(false);

        jTextAreaResultados.setColumns(20);
        jTextAreaResultados.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextAreaResultados.setRows(5);
        jScrollPane3.setViewportView(jTextAreaResultados);

        jLabelResultados.setText("Resultados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelMatrizA)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                .addComponent(jLabelMatrizB)
                                .addComponent(jButtonCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboOpcoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelVetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextValorY, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextValorZ, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabelResultados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMatrizA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMatrizB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVetor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextValorZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalcular)
                .addGap(7, 7, 7)
                .addComponent(jLabelResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        double matrizA[][] = new double[3][3];

        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                matrizA[i][j] = (double) jTableMatrizA.getValueAt(i, j);
            }
        }

        switch (jComboOpcoes.getSelectedIndex()) {
            case 0: {
                operacoesMatrizes(matrizA, 0);
                break;
            }
            case 1: {
                operacoesMatrizes(matrizA, 1);
                break;
            }
            case 2: {
                operacoesEscalarMatrizes(matrizA, 0);
                break;
            }
            case 3: {
                operacoesEscalarMatrizes(matrizA, 1);
                break;
            }
            case 4: {
                jTextAreaResultados.setText("");
                double vetor[] = {
                    Float.parseFloat(jTextValorX.getText()),
                    Float.parseFloat(jTextValorY.getText()),
                    Float.parseFloat(jTextValorZ.getText())
                };
                double matrizC[][] = new double[3][1];
                
                for (int i = 0; i < TAMANHO; i++) {
                    if (i == 0) {
                        jTextAreaResultados.append("Matriz C:\n");
                    }
                    for (int j = 0; j < TAMANHO; j++) {
                        matrizC[i][0] += (matrizA[i][j] * vetor[j]);
                    }
                }
                for (int i = 0; i < TAMANHO; i++) {
                    jTextAreaResultados.append(matrizC[i][0] + "\n");
                }
                break;
            }
            case 5: {
                jTextAreaResultados.setText("");
                double matrizB[][] = new double[3][3];
                double matrizC[][] = new double[3][3];
                
                for (int i = 0; i < TAMANHO; i++) {
                    for (int j = 0; j < TAMANHO; j++) {
                        matrizB[i][j] = (double) jTableMatrizB.getValueAt(i, j);
                    }
                }
                
                for (int i = 0; i < TAMANHO; i++) {
                    if (i != 0) {
                        jTextAreaResultados.append("\n");
                        
                    } else {
                        jTextAreaResultados.append("Matriz C:\n");
                    }
                    for (int j = 0; j < TAMANHO; j++) {
                        for (int k = 0; k < TAMANHO; k++) {
                            matrizC[i][j] += (matrizA[i][k] * matrizB[k][j]);                            
                        }
                        jTextAreaResultados.append(matrizC[i][j] + "\t");
                    }
                }
                break;
            }
            case 6: {
                jTextAreaResultados.setText("");
                double matrizC[][] = new double[3][3];
                
                for (int i = 0; i < TAMANHO; i++) {
                    if (i != 0) {
                        jTextAreaResultados.append("\n");
                        
                    } else {
                        jTextAreaResultados.append("Matriz C:\n");
                    }
                    for (int j = 0; j < TAMANHO; j++) {
                        matrizC[i][j] = matrizA[j][i];
                        jTextAreaResultados.append(matrizC[i][j] + "\t");
                    }
                }
                break;
            }
        }
    }//GEN-LAST:event_jButtonCalcularActionPerformed

    private void jComboOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboOpcoesActionPerformed
        switch (jComboOpcoes.getSelectedIndex()) {
            case 0: {
                habilitarMatrizB();
                desabilitarFields();
                break;
            }
            case 1: {
                habilitarMatrizB();
                desabilitarFields();
                break;
            }
            case 4: {
                habilitarFields();
                desabilitarMatrizB();
                break;
            }
            case 5: {
                habilitarMatrizB();
                desabilitarFields();
                break;
            }
            default: {
                desabilitarFields();
                desabilitarMatrizB();
            }
        }
    }//GEN-LAST:event_jComboOpcoesActionPerformed

   public void desabilitarMatrizB() {
        jTableMatrizB.setEnabled(false);
    }

    public void habilitarMatrizB() {
        jTableMatrizB.setEnabled(true);
    }

    public void desabilitarFields() {
        jTextValorX.setEnabled(false);
        jTextValorY.setEnabled(false);
        jTextValorZ.setEnabled(false);
    }

    public void habilitarFields() {
        jTextValorX.setEnabled(true);
        jTextValorY.setEnabled(true);
        jTextValorZ.setEnabled(true);
    }

    public void operacoesMatrizes(double matrizA[][], int operador) {
        jTextAreaResultados.setText("");
        double matrizB[][] = new double[3][3];
        double matrizC[][] = new double[3][3];

        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                matrizB[i][j] = (double) jTableMatrizB.getValueAt(i, j);
            }
        }

        for (int i = 0; i < TAMANHO; i++) {
            if (i != 0) {
                jTextAreaResultados.append("\n");
            } else {
                jTextAreaResultados.append("Matriz C:\n");
            }
            for (int j = 0; j < TAMANHO; j++) {
                switch (operador) {
                    case 0: matrizC[i][j] = matrizA[i][j] + matrizB[i][j]; break;
                    case 1: matrizC[i][j] = matrizA[i][j] - matrizB[i][j]; break;
                }
                jTextAreaResultados.append(matrizC[i][j] + "\t");
            }
        }
    }

    public void operacoesEscalarMatrizes(double matrizA[][], int operador) {
        jTextAreaResultados.setText("");
        double matrizC[][] = new double[3][3], escalar;

        while (true) {
            escalar = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do escalar:"));
            
            if (escalar != 0 || operador == 0) {
                break;
            }
        }
        
        for (int i = 0; i < TAMANHO; i++) {
            if (i != 0) {
                jTextAreaResultados.append("\n");
            } else {
                jTextAreaResultados.append("Matriz C:\n");
            }
            for (int j = 0; j < TAMANHO; j++) {
                switch (operador) {
                    case 0: matrizC[i][j] = matrizA[i][j] * escalar; break;
                    case 1: matrizC[i][j] = matrizA[i][j] / escalar; break;
                }
                jTextAreaResultados.append(matrizC[i][j] + "\t");
            }
        }
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
    private javax.swing.JLabel jLabelMatrizA;
    private javax.swing.JLabel jLabelMatrizB;
    private javax.swing.JLabel jLabelResultados;
    private javax.swing.JLabel jLabelVetor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableMatrizA;
    private javax.swing.JTable jTableMatrizB;
    private javax.swing.JTextArea jTextAreaResultados;
    private javax.swing.JTextField jTextValorX;
    private javax.swing.JTextField jTextValorY;
    private javax.swing.JTextField jTextValorZ;
    // End of variables declaration//GEN-END:variables
}
