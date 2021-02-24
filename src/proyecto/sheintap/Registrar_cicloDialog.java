package proyecto.sheintap;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Registrar_cicloDialog extends javax.swing.JDialog {

    BaseDatosCiclos q;
    String idpuesto; //String auxiliar que sirve al momendo de modificar un puesto. 
    public Registrar_cicloDialog(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        q=new BaseDatosCiclos();
        ButtonGuardarCambios.setEnabled(false);
        ButtonGuardarCambios.setVisible(false);
        ButtonGuardar.setEnabled(true);
        Año.setEnabled(false);
       
        
        
    }
    
    //Metodo que recibe datos para poder llenar los TextFields en caso de modificacion de Puestos.
    public void recibirDatos(String año, String no){
       
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinField1 = new com.toedter.components.JSpinField();
        jButton1 = new javax.swing.JButton();
        LabelNombrePuesto = new javax.swing.JLabel();
        ButtonGuardar = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();
        LabelTitulo = new javax.swing.JLabel();
        ButtonGuardarCambios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Año = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        comboboxNumeroCiclo = new javax.swing.JComboBox<>();
        comboboxMes = new javax.swing.JComboBox<>();

        jButton1.setText("jButton1");

        LabelNombrePuesto.setText("Numero de ciclo:");

        ButtonGuardar.setText("GUARDAR");
        ButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("CANCELAR");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        LabelTitulo.setText("REGISTRO DE CICLOS");

        ButtonGuardarCambios.setText("Guardar cambios");
        ButtonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarCambiosActionPerformed(evt);
            }
        });

        jLabel1.setText("Mes");

        jLabel3.setText("Año:");

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboboxNumeroCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        comboboxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo ", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(LabelTitulo)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonGuardarCambios)
                .addGap(37, 37, 37)
                .addComponent(ButtonGuardar)
                .addGap(28, 28, 28)
                .addComponent(ButtonCancelar)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelNombrePuesto)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Año)
                    .addComponent(comboboxNumeroCiclo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboboxMes, 0, 81, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonGuardarCambios)
                    .addComponent(ButtonGuardar)
                    .addComponent(ButtonCancelar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
       // try{
            //Obtener los intervalos de tiempo. 
       Calendar cal= Calendar.getInstance();
       
        
        String mescicloaño = comboboxMes.getSelectedItem().toString() + comboboxNumeroCiclo.getSelectedItem().toString() + String.valueOf(cal.get(Calendar.YEAR));
        
        
        
        
       
   
        
        System.out.println("El mescicloaño es: "+mescicloaño);
        System.out.println("quincena: "+(String) comboboxNumeroCiclo.getSelectedItem());
        
        
        q.insertarCiclo(mescicloaño);
        //}catch (Exception e){
            //JOptionPane.showMessageDialog(null,""+e.getMessage(),"Registro de quincena",JOptionPane.ERROR_MESSAGE);
        //}
                              
    }//GEN-LAST:event_ButtonGuardarActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        int año;
//        int añof;
//        año=FechaInicial.getCalendar().get(Calendar.YEAR);
//        añof=FechaFinal1.getCalendar().get(Calendar.YEAR);
//        if(año>0){
//            if(año==añof){
//                Año.setText(""+año);
//                ButtonGuardar.setEnabled(true);
//            }else{
//                JOptionPane.showMessageDialog(null,"Intervalo de quincena demasiado largo","Registro de quincena",JOptionPane.ERROR_MESSAGE);
//            }
//        }else{
//            JOptionPane.showMessageDialog(null,"Debes ingresar un periodo de tiempo","Registro de quincena",JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    private void ButtonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarCambiosActionPerformed
        //Obtener los intervalos de tiempo.
       

       
    }//GEN-LAST:event_ButtonGuardarCambiosActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Año;
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JButton ButtonGuardarCambios;
    private javax.swing.JLabel LabelNombrePuesto;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JComboBox<String> comboboxMes;
    private javax.swing.JComboBox<String> comboboxNumeroCiclo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private com.toedter.components.JSpinField jSpinField1;
    // End of variables declaration//GEN-END:variables
}
