/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.sheintap;


/**
 *
 * @author Administrator
 */

public class Modificar_pedidosDialog extends javax.swing.JDialog {

    /**
    
     */
    String numcel, nom_art,talla,nociclo,precio, opc, color, nomcliente;
    
    BaseDatosPedidosPendientes a;
    public Modificar_pedidosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        a = new BaseDatosPedidosPendientes();
        initComponents();
    }
    public void recibirdatos(String numcel, String nom_art, String talla, String nociclo,String precio, String opc, String color, String nombrecliente){
        this.numcel= numcel;
        this.nom_art= nom_art;
        this.talla= talla;
        this.nociclo= nociclo;
        this.precio= precio;
        this.opc = opc;
        this.color= color;
        this.nomcliente= nombrecliente;
        
        textfieldnumcel.setText(this.numcel);
        textfieldNom_art.setText(this.nom_art);
        textfieldTalla.setText(this.talla);
        textfieldNociclo.setText(this.nociclo);
        textfieldPrecio.setText(this.precio);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textfieldnumcel = new javax.swing.JTextField();
        textfieldNom_art = new javax.swing.JTextField();
        textfieldTalla = new javax.swing.JTextField();
        buttonjdActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textfieldNociclo = new javax.swing.JTextField();
        textfieldPrecio = new javax.swing.JTextField();
        comboboxEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 3, 11)); // NOI18N
        jLabel1.setText("Registrar pedido");

        jLabel2.setText("Numero celular");

        jLabel3.setText("Nombre Articulo");

        jLabel4.setText("Talla");

        buttonjdActualizar.setText("Registrar");
        buttonjdActualizar.setActionCommand("Actuaiizar");
        buttonjdActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonjdActualizarMouseClicked(evt);
            }
        });

        jLabel5.setText("Nociclo");

        jLabel6.setText("Precio");

        jLabel7.setText("Estado");

        comboboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Incompleto", "Completado" }));
        comboboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxEstadoActionPerformed(evt);
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
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(buttonjdActualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldnumcel)
                            .addComponent(textfieldNom_art)
                            .addComponent(textfieldTalla)
                            .addComponent(textfieldNociclo)
                            .addComponent(textfieldPrecio)
                            .addComponent(comboboxEstado, 0, 136, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldnumcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textfieldNom_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textfieldTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textfieldNociclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textfieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboboxEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(buttonjdActualizar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonjdActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonjdActualizarMouseClicked
      
       
        
        
        
        if("Incompleto".equals(opc)){
            
            nom_art= textfieldNom_art.getText();
            talla= textfieldTalla.getText();
            nociclo= textfieldNociclo.getText();
            precio= textfieldPrecio.getText();
             a.recibirdatosviejos(numcel, nom_art, talla, nociclo, precio );
             a.actualizarPedido(numcel, nom_art, talla, nociclo, precio, opc);
        }else{
           
        }
        
    }//GEN-LAST:event_buttonjdActualizarMouseClicked

    private void comboboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxEstadoActionPerformed
        // TODO add your handling code here:
        if("Completado".equals(comboboxEstado.getSelectedItem().toString())){
            opc= "Completado";
        }else{
            opc= "Incompleto";
        }
    }//GEN-LAST:event_comboboxEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_pedidosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_pedidosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_pedidosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_pedidosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Modificar_pedidosDialog dialog = new Modificar_pedidosDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonjdActualizar;
    private javax.swing.JComboBox<String> comboboxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textfieldNociclo;
    private javax.swing.JTextField textfieldNom_art;
    private javax.swing.JTextField textfieldPrecio;
    private javax.swing.JTextField textfieldTalla;
    private javax.swing.JTextField textfieldnumcel;
    // End of variables declaration//GEN-END:variables
}