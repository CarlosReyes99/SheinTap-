package proyecto.sheintap;

import java.awt.HeadlessException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Pregunta_cicloDialog extends javax.swing.JDialog {
    Calendar cal= Calendar.getInstance();
    String añociclo, numcel, nombre;
   
    public Pregunta_cicloDialog(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        
        initComponents();
        
        añociclo = Integer.toString(cal.get(Calendar.YEAR));
        labelaño.setText(añociclo);
        labelnumcel.setText(numcel);
        //pone al año automáticamente
        
        
        //pone visibles los botones
        
        //ButtonGuardar.setEnabled(true);
        
       
        
        
    }
    
    //Metodo que recibe datos para poder llenar los TextFields en caso de modificacion de Puestos.
    public void recibirDatos(String numcelu, String nom){
       this.numcel= numcelu;
       this.nombre= nom;
       labelnumcel.setText(numcelu);
       labelnombre.setText(nom);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinField1 = new com.toedter.components.JSpinField();
        jButton1 = new javax.swing.JButton();
        LabelNombrePuesto = new javax.swing.JLabel();
        ButtonGuardar = new javax.swing.JButton();
        LabelTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboboxNumeroCiclo = new javax.swing.JComboBox<>();
        comboboxMes = new javax.swing.JComboBox<>();
        labelaño = new javax.swing.JLabel();
        labelnombre = new javax.swing.JLabel();
        labelnumcel = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        LabelNombrePuesto.setText("Numero de ciclo:");

        ButtonGuardar.setText("BUSCAR");
        ButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarActionPerformed(evt);
            }
        });

        LabelTitulo.setText("BUSCADOR DE CICLOS");

        jLabel1.setText("Mes");

        jLabel3.setText("Año:");

        comboboxNumeroCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        comboboxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo ", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        labelaño.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelNombrePuesto)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelnumcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboboxNumeroCiclo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboboxMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelaño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitulo)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombrePuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxNumeroCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelaño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelnumcel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonGuardar)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
       try{
            //Obtener los intervalos de tiempo. 
       
       
        String mescicloaño = comboboxMes.getSelectedItem().toString() + comboboxNumeroCiclo.getSelectedItem().toString() + añociclo;
        System.out.println("El mescicloaño es: "+mescicloaño);
        
        
        Registrar_pedidosDialog dialogregistrar =new Registrar_pedidosDialog(new javax.swing.JFrame(), true);
        dialogregistrar.recibirdatos(numcel, mescicloaño, nombre);
        dialogregistrar.setLocationRelativeTo(null);
        dialogregistrar.setVisible(true);
        
        
        
       
   
        
        
        
        
        
        
        }catch (HeadlessException e){
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Buscador de ciclo",JOptionPane.ERROR_MESSAGE);
        }
                              
    }//GEN-LAST:event_ButtonGuardarActionPerformed


    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JLabel LabelNombrePuesto;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JComboBox<String> comboboxMes;
    private javax.swing.JComboBox<String> comboboxNumeroCiclo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JLabel labelaño;
    private javax.swing.JLabel labelnombre;
    private javax.swing.JLabel labelnumcel;
    // End of variables declaration//GEN-END:variables
}
