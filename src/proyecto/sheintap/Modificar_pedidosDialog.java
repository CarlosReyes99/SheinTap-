/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.sheintap;

/**
 *
 * @author MrX
 */
public class Modificar_pedidosDialog extends javax.swing.JDialog {
String numcel, nombreart, talla, color, precio, ciclo;
BaseDatosPedidosPendientes pp;
    /** Creates new form Modificar_pedidosDialog
     * @param parent */
    public Modificar_pedidosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pp= new BaseDatosPedidosPendientes();
    }

    public void recibirdatos(String number, String cicle, String nameart, String size, String colorart, String price){
        this.numcel= number;
        this.nombreart= nameart;
        this.talla= size;
        this.color= colorart;
        this.precio= price;
        
        textfieldNombreart.setText(nombreart);
        textfieldTalla.setText(talla);
        textfieldColor.setText(color);
        textfieldPrecio.setText(precio);
        labelnombre.setText(numcel);
        labelnociclo.setText(cicle);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelnombre = new javax.swing.JLabel();
        labelnomart = new javax.swing.JLabel();
        labeltalla = new javax.swing.JLabel();
        labelcolor = new javax.swing.JLabel();
        labelprecio = new javax.swing.JLabel();
        textfieldNombreart = new javax.swing.JTextField();
        textfieldTalla = new javax.swing.JTextField();
        textfieldColor = new javax.swing.JTextField();
        textfieldPrecio = new javax.swing.JTextField();
        labelnociclo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelnombre.setText("jLabel1");
        labelnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelnombreMouseClicked(evt);
            }
        });

        labelnomart.setText("Nombre artículo");

        labeltalla.setText("Talla artículo");

        labelcolor.setText("Color artículo");

        labelprecio.setText("Precio artículo");

        textfieldNombreart.setText("jTextField1");

        textfieldTalla.setText("jTextField2");

        textfieldColor.setText("jTextField3");

        textfieldPrecio.setText("jTextField4");

        labelnociclo.setText("jLabel1");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(labelnomart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 110, Short.MAX_VALUE)
                        .add(textfieldNombreart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(labeltalla, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(textfieldTalla, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(labelcolor)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(textfieldColor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(labelprecio)
                            .add(labelnombre))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(textfieldPrecio, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .add(labelnociclo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(99, 99, 99)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelnomart)
                    .add(textfieldNombreart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labeltalla)
                    .add(textfieldTalla, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelcolor)
                    .add(textfieldColor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelprecio)
                    .add(textfieldPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(47, 47, 47)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelnombre)
                    .add(labelnociclo))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelnombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelnombreMouseClicked
        // TODO add your handling code here:
        
       pp.recibirdatosviejos(numcel, nombreart, talla,precio);
        System.out.print("El nombre del articulo es: "+ textfieldNombreart.getText()+ "\n"+"La talla del articulo es: "+ textfieldTalla.getText()+ "\n"+"El color del articulo es: "+ textfieldColor.getText()+ "\n"+"El precio del articulo es: "+ textfieldPrecio.getText()+ "\n");
        pp.actualizarPedido(numcel, ciclo, textfieldNombreart.getText(), textfieldTalla.getText(), textfieldPrecio.getText());
        
    }//GEN-LAST:event_labelnombreMouseClicked

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
    private javax.swing.JLabel labelcolor;
    private javax.swing.JLabel labelnociclo;
    private javax.swing.JLabel labelnomart;
    private javax.swing.JLabel labelnombre;
    private javax.swing.JLabel labelprecio;
    private javax.swing.JLabel labeltalla;
    private javax.swing.JTextField textfieldColor;
    private javax.swing.JTextField textfieldNombreart;
    private javax.swing.JTextField textfieldPrecio;
    private javax.swing.JTextField textfieldTalla;
    // End of variables declaration//GEN-END:variables

}
