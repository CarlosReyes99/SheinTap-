package proyecto.sheintap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JpVerCiclos extends javax.swing.JPanel {

    BaseDatosCiclos v;//Declaración del objeto de uso global
    String[][] consultaVacaciones; //Declaracion de arreglo que guarda los resultados de cualquier consulta. 
    DefaultTableModel modelo; //Declaracion del modelo de la tabla de uso global. 
    String tiempo;
    
    int flagcombo;
    public JpVerCiclos() {
        initComponents();
        v=new BaseDatosCiclos();
        flagcombo=0;
        verTodos();
        
        
       
        
    }

    
    
     private void generarTabla(){
        //Se crea un nuevo modelo de tabla
        modelo = new DefaultTableModel();
        //Se agregan las columnas
        modelo.setColumnIdentifiers(new Object[]{"Mes, ciclo y año"});
        //Se agregan las filas. 
        for(int x=0;x<consultaVacaciones[0].length;x++){
            modelo.addRow(new Object[]{consultaVacaciones[0][x]});
        }
        //Se añade el nuevo modelo a la tabla
        TablaDatos.setModel(modelo);
       
    }
     private void verTodos(){
        consultaVacaciones =v.buscarCiclos("Todos");
        generarTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Encontrados = new javax.swing.JLabel();
        buttonregistrarciclos = new org.edisoncor.gui.panel.PanelImage();
        labelRegistrar = new javax.swing.JLabel();
        buttoneliminarciclos = new org.edisoncor.gui.panel.PanelImage();
        jlabelEliminarciclo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatos = new rojerusan.RSTableMetro();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CICLOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Mostrando los registros de vacaciones. Seleccione un registro y presione la opción que desee.");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));
        add(Encontrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 50, 20));

        buttonregistrarciclos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttonregistrarciclos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonregistrarciclosMouseClicked(evt);
            }
        });

        labelRegistrar.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        labelRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegistrar.setText("Registrar");
        labelRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegistrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonregistrarciclosLayout = new javax.swing.GroupLayout(buttonregistrarciclos);
        buttonregistrarciclos.setLayout(buttonregistrarciclosLayout);
        buttonregistrarciclosLayout.setHorizontalGroup(
            buttonregistrarciclosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonregistrarciclosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonregistrarciclosLayout.setVerticalGroup(
            buttonregistrarciclosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        add(buttonregistrarciclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 170, 50));

        buttoneliminarciclos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttoneliminarciclos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttoneliminarciclosMouseClicked(evt);
            }
        });

        jlabelEliminarciclo.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        jlabelEliminarciclo.setForeground(new java.awt.Color(255, 255, 255));
        jlabelEliminarciclo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelEliminarciclo.setText("Eliminar");
        jlabelEliminarciclo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabelEliminarcicloMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttoneliminarciclosLayout = new javax.swing.GroupLayout(buttoneliminarciclos);
        buttoneliminarciclos.setLayout(buttoneliminarciclosLayout);
        buttoneliminarciclosLayout.setHorizontalGroup(
            buttoneliminarciclosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttoneliminarciclosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelEliminarciclo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttoneliminarciclosLayout.setVerticalGroup(
            buttoneliminarciclosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabelEliminarciclo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        add(buttoneliminarciclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 170, 50));

        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaDatos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 100, 710, 120));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonregistrarciclosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonregistrarciclosMouseClicked
        
    }//GEN-LAST:event_buttonregistrarciclosMouseClicked

    private void buttoneliminarciclosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttoneliminarciclosMouseClicked
        // TODO add your handling code here:
        //Obtener la fila seleccionada. 
        int fila = TablaDatos.getSelectedRow();
        //Validar si hay alguna fila seleccionada
        if(fila!=-1)
        {
            //Obtener y guardar el folio de la fila seleccionada.
            String nociclo=(String) modelo.getValueAt(fila,0);
            //La ventana de confirmación retorna un valor numerico equivalente a la opcion que selecciona el usuario. 
            int op= JOptionPane.showConfirmDialog(null, "Está a punto de eliminar permanentemente el registro de vacaciones'"+nociclo+"'. ¿Desea continuar?", "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            //Si confirma la eliminación, el valor de op=0
            if(op==0){
                v.eliminarQuincena(nociclo);
            }else{
                //Sí cancela la eliminacion no pasa nada
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un registro y presione 'Eliminar'" ,"Menu de vacaciones",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttoneliminarciclosMouseClicked

    private void labelRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistrarMouseClicked
        // TODO add your handling code here:
// TODO add your handling code here:
        Registrar_cicloDialog ciclo =new Registrar_cicloDialog(new javax.swing.JFrame(), true);
        ciclo.setLocationRelativeTo(null);
        ciclo.setVisible(true);
        verTodos();
    }//GEN-LAST:event_labelRegistrarMouseClicked

    private void jlabelEliminarcicloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelEliminarcicloMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
        //Obtener la fila seleccionada. 
        int fila = TablaDatos.getSelectedRow();
        //Validar si hay alguna fila seleccionada
        if(fila!=-1)
        {
            //Obtener y guardar el folio de la fila seleccionada.
            String nociclo=(String) modelo.getValueAt(fila,0);
            //La ventana de confirmación retorna un valor numerico equivalente a la opcion que selecciona el usuario. 
            int op= JOptionPane.showConfirmDialog(null, "Está a punto de eliminar permanentemente el registro de vacaciones'"+nociclo+"'. ¿Desea continuar?", "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            //Si confirma la eliminación, el valor de op=0
            if(op==0){
                v.eliminarQuincena(nociclo);
                verTodos();
            }else{
                //Sí cancela la eliminacion no pasa nada
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un registro y presione 'Eliminar'" ,"Menu de vacaciones",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jlabelEliminarcicloMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Encontrados;
    private rojerusan.RSTableMetro TablaDatos;
    private org.edisoncor.gui.panel.PanelImage buttoneliminarciclos;
    private org.edisoncor.gui.panel.PanelImage buttonregistrarciclos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabelEliminarciclo;
    private javax.swing.JLabel labelRegistrar;
    // End of variables declaration//GEN-END:variables
}
