package proyecto.sheintap;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JpVerPedidosPendientes extends javax.swing.JPanel {
    
    BaseDatosPedidosPendientes p;
    BaseDatosClientes b;
    BaseDatosCiclos c;
    String consultapedidos[][]; //Arreglo que se encarga de guardar consultas.
    String clientes[][];
    String[][] ciclos;
    int total, conteo, cantart;
    DefaultTableModel modelo;
    int seleccion;
    String numcel, nom_art, talla, nociclo, precio, opc, color, nombre;
     
    int flagCombo;
    int flagCombo2;
    public JpVerPedidosPendientes() {
        flagCombo=0;
        flagCombo2=0;
        b= new BaseDatosClientes();
        p=new BaseDatosPedidosPendientes();
        c= new BaseDatosCiclos();
        
        initComponents(); 
        verTodos();
        
        InsertarCombobox();
        total();
        
    }
    
    
    

    public void total(){
        nociclo= comboboxCiclosTotal.getSelectedItem().toString();
         consultapedidos= p.buscarPedido("mescicloaño",nociclo , ""); //lama al método de buscar pedido
         
        for (String consultapedido : consultapedidos[4]) {
            total = total + Integer.parseInt(consultapedido);
        }
        labeltotal.setText(String.valueOf(total));
        System.out.print(total);
        
        
    }
    //Metodo privado que genera una nueva tabla
    private void generarTabla(){
        //Se crea un nuevo modelo de tabla
        modelo = new DefaultTableModel();
        //Se agregan las columnas
        modelo.setColumnIdentifiers(new Object[]{"Nombre cliente","Numero celular","Nombre articulo","Color", "Talla", "MesCicloAño", "Precio", "Vendido"});
        //Se agregan las filas. 
        for(int x=0;x<consultapedidos[0].length;x++){
            modelo.addRow(new Object[]{consultapedidos[7][x],consultapedidos[0][x],consultapedidos[1][x],consultapedidos[6][x],consultapedidos[2][x],consultapedidos[3][x],consultapedidos[4][x],consultapedidos[5][x]});
        }
        //Se añade el nuevo modelo a la tabla
        TablaDatos.setModel(modelo);
        
    }
    //Metodo estatico que realiza la consulta de todos los JdRegistrarPuesto
    private void verTodos(){
        consultapedidos =p.buscarPedido("Todos","Ninguno", "");
        generarTabla();
        conteo= TablaDatos.getRowCount();
        labelcantart.setText(String.valueOf(conteo));
        System.out.print(conteo);
    }
    
    public void generarTablaporcliente(){
        //Se crea un nuevo modelo de tabla
        modelo = new DefaultTableModel();
        //Se agregan las columnas
        modelo.setColumnIdentifiers(new Object[]{"Nombre cliente","Numero celular","Nombre articulo","Color", "Talla", "MesCicloAño", "Precio", "Vendido"});
        //Se agregan las filas. 
        for(int x=0;x<consultapedidos[0].length;x++){
            modelo.addRow(new Object[]{consultapedidos[7][x],consultapedidos[0][x],consultapedidos[1][x],consultapedidos[6][x],consultapedidos[2][x],consultapedidos[3][x],consultapedidos[4][x],consultapedidos[5][x]});
        }
        //Se añade el nuevo modelo a la tabla
        TablaDatos.setModel(modelo);
    
    
    }
    
    public void verPorCliente(){
        nombre= comboboxClientes.getSelectedItem().toString();
        nociclo= comboboxciclos.getSelectedItem().toString();
        consultapedidos= p.buscarPedido("numcelciclo", nombre, nociclo);
        generarTablaporcliente();
        conteo= TablaDatos.getRowCount();
        labelcantart.setText(String.valueOf(conteo));
        System.out.print(conteo);
      
    }
    
     public void generarTablaporciclo(){
        //Se crea un nuevo modelo de tabla
        modelo = new DefaultTableModel();
        //Se agregan las columnas
        modelo.setColumnIdentifiers(new Object[]{"Nombre cliente","Numero celular","Nombre articulo","Color", "Talla", "MesCicloAño", "Precio", "Vendido"});
        //Se agregan las filas. 
        for(int x=0;x<consultapedidos[0].length;x++){
            modelo.addRow(new Object[]{consultapedidos[7][x],consultapedidos[0][x],consultapedidos[1][x],consultapedidos[6][x],consultapedidos[2][x],consultapedidos[3][x],consultapedidos[4][x],consultapedidos[5][x]});
        }
        //Se añade el nuevo modelo a la tabla
        TablaDatos.setModel(modelo);
    
    
    }
    
    public void verPorCiclo(){
        
        nociclo= comboboxCiclosTotal.getSelectedItem().toString();
        consultapedidos= p.buscarPedido("mescicloaño", nociclo, "");
        generarTablaporcliente();
        conteo= TablaDatos.getRowCount();
        labelcantart.setText(String.valueOf(conteo));
        System.out.print(conteo);
      
    }
    
    //Inserta valores a los combobox
    private void InsertarCombobox(){
       clientes= b.buscarClientesporundato("nombre", "Nada");
       comboboxClientes.removeAllItems();
        for (String item : clientes[0]) {
            comboboxClientes.addItem(item);
     }
        //para llenar el copmbobox de ciclos en búsqueda por cliente y ciclo
        ciclos= c.buscarCiclos("Todos");
        comboboxciclos.removeAllItems();
        for (String item : ciclos[0]) {
            comboboxciclos.addItem(item);
     }
        //para llenar el combobox de ciclos en búsqueda de pedidos totales
        ciclos= c.buscarCiclos("Todos");
        comboboxCiclosTotal.removeAllItems();
        for (String item : ciclos[0]) {
            comboboxCiclosTotal.addItem(item);
     }
       
    }
    
    public void generarPdf(String nombre, String numcel, String nociclo){
        GeneratePDFFileIText generar= new GeneratePDFFileIText();
        String nombrepdf= nombre+numcel+nociclo+".pdf";
        generar.recibirDatos(nombre, numcel, nociclo);
        File pdfNewFile = new File(nombrepdf);
        generar.createPDF(pdfNewFile);
        }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitulo = new javax.swing.JLabel();
        Encontrados = new javax.swing.JLabel();
        buttonvertodos = new org.edisoncor.gui.panel.PanelImage();
        labelVertodos = new javax.swing.JLabel();
        buttoneliminarpedido = new org.edisoncor.gui.panel.PanelImage();
        jLabelEliminarPedido = new javax.swing.JLabel();
        buttoningresarpuesto = new org.edisoncor.gui.panel.PanelImage();
        jLabelGenerarpdf = new javax.swing.JLabel();
        buttonmodificarpuesto = new org.edisoncor.gui.panel.PanelImage();
        jLabelModificar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDatos = new rojerusan.RSTableMetro();
        jLabelTotaldinero = new javax.swing.JLabel();
        labeltotal = new javax.swing.JLabel();
        jLabelVerporclientes = new javax.swing.JLabel();
        comboboxClientes = new javax.swing.JComboBox<>();
        buttonBuscar = new javax.swing.JButton();
        jLabelCantidadarticulos = new javax.swing.JLabel();
        labelcantart = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboboxciclos = new javax.swing.JComboBox<>();
        comboboxCiclosTotal = new javax.swing.JComboBox<>();
        buttonAceptartotal = new javax.swing.JButton();
        buttoneliminarpuesto1 = new org.edisoncor.gui.panel.PanelImage();
        jLabelEliminarart = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTitulo.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 14)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Pedidos pendientes");
        add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 170, -1));

        Encontrados.setBackground(new java.awt.Color(255, 255, 255));
        Encontrados.setForeground(new java.awt.Color(255, 255, 255));
        add(Encontrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 14, 14));

        buttonvertodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttonvertodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonvertodosMouseClicked(evt);
            }
        });

        labelVertodos.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        labelVertodos.setForeground(new java.awt.Color(255, 255, 255));
        labelVertodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVertodos.setText("Ver todos");
        labelVertodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVertodosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonvertodosLayout = new javax.swing.GroupLayout(buttonvertodos);
        buttonvertodos.setLayout(buttonvertodosLayout);
        buttonvertodosLayout.setHorizontalGroup(
            buttonvertodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonvertodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelVertodos, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonvertodosLayout.setVerticalGroup(
            buttonvertodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelVertodos, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(buttonvertodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 140, 40));

        buttoneliminarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttoneliminarpedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttoneliminarpedidoMouseClicked(evt);
            }
        });

        jLabelEliminarPedido.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        jLabelEliminarPedido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEliminarPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEliminarPedido.setText("Eliminar Pedido");
        jLabelEliminarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEliminarPedidoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttoneliminarpedidoLayout = new javax.swing.GroupLayout(buttoneliminarpedido);
        buttoneliminarpedido.setLayout(buttoneliminarpedidoLayout);
        buttoneliminarpedidoLayout.setHorizontalGroup(
            buttoneliminarpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttoneliminarpedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttoneliminarpedidoLayout.setVerticalGroup(
            buttoneliminarpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttoneliminarpedidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(buttoneliminarpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 140, 40));

        buttoningresarpuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttoningresarpuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttoningresarpuestoMouseClicked(evt);
            }
        });

        jLabelGenerarpdf.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        jLabelGenerarpdf.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGenerarpdf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGenerarpdf.setText("Generar Pdf");
        jLabelGenerarpdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGenerarpdfMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttoningresarpuestoLayout = new javax.swing.GroupLayout(buttoningresarpuesto);
        buttoningresarpuesto.setLayout(buttoningresarpuestoLayout);
        buttoningresarpuestoLayout.setHorizontalGroup(
            buttoningresarpuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelGenerarpdf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        buttoningresarpuestoLayout.setVerticalGroup(
            buttoningresarpuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelGenerarpdf, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(buttoningresarpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 140, 40));

        buttonmodificarpuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttonmodificarpuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonmodificarpuestoMouseClicked(evt);
            }
        });

        jLabelModificar.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        jLabelModificar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModificar.setText("Modificar");
        jLabelModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelModificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonmodificarpuestoLayout = new javax.swing.GroupLayout(buttonmodificarpuesto);
        buttonmodificarpuesto.setLayout(buttonmodificarpuestoLayout);
        buttonmodificarpuestoLayout.setHorizontalGroup(
            buttonmodificarpuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        buttonmodificarpuestoLayout.setVerticalGroup(
            buttonmodificarpuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(buttonmodificarpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 140, 40));

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

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
        TablaDatos.setColorBackgoundHead(new java.awt.Color(56, 56, 56));
        TablaDatos.setColorFilasBackgound2(new java.awt.Color(227, 227, 227));
        TablaDatos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        TablaDatos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        TablaDatos.setColorSelBackgound(new java.awt.Color(153, 153, 153));
        TablaDatos.setGridColor(new java.awt.Color(255, 255, 255));
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaDatos);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 700, 140));

        jLabelTotaldinero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotaldinero.setText("Total dinero: ");
        add(jLabelTotaldinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        labeltotal.setForeground(new java.awt.Color(255, 255, 255));
        add(labeltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 70, 20));

        jLabelVerporclientes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVerporclientes.setText("Ver por cliente: ");
        add(jLabelVerporclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        comboboxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxClientesActionPerformed(evt);
            }
        });
        add(comboboxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 100, -1));

        buttonBuscar.setText("Buscar");
        buttonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBuscarMouseClicked(evt);
            }
        });
        add(buttonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabelCantidadarticulos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadarticulos.setText("Cantidad de articulos: ");
        add(jLabelCantidadarticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        labelcantart.setForeground(new java.awt.Color(255, 255, 255));
        labelcantart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(labelcantart, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 60, 10));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ciclo");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 70, -1));

        comboboxciclos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboboxciclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 100, -1));

        add(comboboxCiclosTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 100, -1));

        buttonAceptartotal.setText("Aceptar");
        buttonAceptartotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAceptartotalMouseClicked(evt);
            }
        });
        add(buttonAceptartotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, -1));

        buttoneliminarpuesto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        buttoneliminarpuesto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttoneliminarpuesto1MouseClicked(evt);
            }
        });

        jLabelEliminarart.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 18)); // NOI18N
        jLabelEliminarart.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEliminarart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEliminarart.setText("Eliminar art");
        jLabelEliminarart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEliminarartMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttoneliminarpuesto1Layout = new javax.swing.GroupLayout(buttoneliminarpuesto1);
        buttoneliminarpuesto1.setLayout(buttoneliminarpuesto1Layout);
        buttoneliminarpuesto1Layout.setHorizontalGroup(
            buttoneliminarpuesto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttoneliminarpuesto1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEliminarart, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttoneliminarpuesto1Layout.setVerticalGroup(
            buttoneliminarpuesto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEliminarart, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(buttoneliminarpuesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonvertodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonvertodosMouseClicked
        // TODO add your handling code here:
        //Obtener la fila seleccionada. 
        verTodos();
    }//GEN-LAST:event_buttonvertodosMouseClicked

    private void buttoneliminarpedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttoneliminarpedidoMouseClicked
        
    }//GEN-LAST:event_buttoneliminarpedidoMouseClicked

    private void buttoningresarpuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttoningresarpuestoMouseClicked
        
    }//GEN-LAST:event_buttoningresarpuestoMouseClicked

    private void buttonmodificarpuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonmodificarpuestoMouseClicked
        
    }//GEN-LAST:event_buttonmodificarpuestoMouseClicked

    private void labelVertodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVertodosMouseClicked
        // TODO add your handling code here:
        verTodos();
    }//GEN-LAST:event_labelVertodosMouseClicked

    private void jLabelModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelModificarMouseClicked
       
        //Obtener de la fila el ID de la fila seleccionada. 
        int fila = TablaDatos.getSelectedRow(); //Guaradr el numero de fila seleccionada.
        //Si no se ha seleccionado ninguna fila, el metodo devuelve "-1";
        
        //Si no se ha seleccionado ninguna fila, el metodo devuelve "-1";
        if(fila!=-1){
            
            //Guardar el id del empleado seleccionado.
             Modificar_pedidosDialog modificarpd =new Modificar_pedidosDialog(new javax.swing.JFrame(), true);
             modificarpd.recibirdatos(numcel, nociclo,nom_art, talla, color, precio);
             modificarpd.setLocationRelativeTo(null);
             modificarpd.setVisible(true);
             verTodos();
             
             System.out.print(numcel);

            //Obtener los datos de ese empleado mediante una consulta por ID.    
            
           
            total();
            verTodos();
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona a un empleado y presiona 'Modificar Empleado'","Busqueda de empleados",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelModificarMouseClicked

    private void jLabelEliminarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEliminarPedidoMouseClicked
        // TODO add your handling code here:
        //Obtener la fila seleccionada. 
        int fila = TablaDatos.getSelectedRow();
        //Validar si hay alguna fila seleccionada
        if(TablaDatos.getSelectedRow() != -1)
        {
            //Obtener y guardar el id de la fila seleccionada.
            
            //La ventana de confirmación retorna un valor numerico equivalente a la opcion que selecciona el usuario. 
            int op=JOptionPane.showConfirmDialog(null, "Está a punto de eliminar permanentemente el pedido '"+numcel+"'", "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            //Si confirma la eliminación, el valor de op=0
            if(op==0){

                p.eliminarPedido("eliminarpedido",numcel, nom_art, precio, color, nociclo);
                total= total - Integer.parseInt(precio);
                labeltotal.setText(String.valueOf(total));
                
            }else{
                //Sí cancela la eliminacion no pasa nada
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona a un puesto y presiona 'Eliminar'" ,"Eliminacion de puestos",JOptionPane.ERROR_MESSAGE);
        }
        total=0;
            nombre= comboboxClientes.getSelectedItem().toString();
            nociclo= comboboxciclos.getSelectedItem().toString();
            consultapedidos= p.buscarPedido("nombreciclo",nombre , nociclo); //lama al método de buscar pedido
         
            for (String consultapedido : consultapedidos[4]) {
                total = total + Integer.parseInt(consultapedido);
            }
            labeltotal.setText(String.valueOf(total));
            System.out.print(total);
        
            verPorCliente();
        
    }//GEN-LAST:event_jLabelEliminarPedidoMouseClicked

    private void jLabelGenerarpdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGenerarpdfMouseClicked
       //llama a dialog de ciclo  
            if (TablaDatos.getSelectedRow() != -1) {
                
                    //seleccionamos el dato 1 de la fila y lo pasamos a numcel
                    
                    generarPdf(nombre, numcel, nociclo);
            }else {
                JOptionPane.showMessageDialog(null,"Selecciona a un cliente con su numero de ciclo y presiona 'Generar pdf'" ,"Generar pdf",JOptionPane.ERROR_MESSAGE);
            }
            
    }//GEN-LAST:event_jLabelGenerarpdfMouseClicked

    private void comboboxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxClientesActionPerformed
        // TODO add your handling code here:
        //numcel= comboboxClientes.getSelectedItem().toString();
        
    }//GEN-LAST:event_comboboxClientesActionPerformed

    private void buttonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBuscarMouseClicked
        // TODO add your handling code here:
        
        total=0;
        nombre= comboboxClientes.getSelectedItem().toString();
        nociclo= comboboxciclos.getSelectedItem().toString();
        consultapedidos= p.buscarPedido("nombreciclo",nombre , nociclo); //lama al método de buscar pedido
         
        for (String consultapedido : consultapedidos[4]) {
            total = total + Integer.parseInt(consultapedido);
        }
        labeltotal.setText(String.valueOf(total));
        System.out.print(total);
        
        verPorCliente();
    }//GEN-LAST:event_buttonBuscarMouseClicked

    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMouseClicked
        // TODO add your handling code here:
        ClaseDatosPedidos clasedatos= new ClaseDatosPedidos();
        seleccion= TablaDatos.rowAtPoint(evt.getPoint());
        
        numcel= String.valueOf(TablaDatos.getValueAt(seleccion, 1));
        nom_art= TablaDatos.getValueAt(seleccion, 2).toString();
        nombre= String.valueOf(TablaDatos.getValueAt(seleccion, 0));
        talla= String.valueOf(TablaDatos.getValueAt(seleccion, 4));
        nociclo = String.valueOf(TablaDatos.getValueAt(seleccion, 5));
        precio= TablaDatos.getValueAt(seleccion, 6).toString();
        opc=TablaDatos.getValueAt(seleccion, 7).toString();
        color= TablaDatos.getValueAt(seleccion, 3).toString();
        
        clasedatos.setNombre(String.valueOf(TablaDatos.getValueAt(seleccion, 0)));
        
        
        
        
        
        
        System.out.print("Nombre es:"+nombre+ "Numcel es: "+numcel+"Nociclo es: "+ nociclo);
    }//GEN-LAST:event_TablaDatosMouseClicked

    private void buttonAceptartotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAceptartotalMouseClicked
        // TODO add your handling code here:
        total=0;
        nociclo= comboboxCiclosTotal.getSelectedItem().toString();
         consultapedidos= p.buscarPedido("mescicloaño",nociclo , ""); //lama al método de buscar pedido
         
        for (String consultapedido : consultapedidos[4]) {
            total = total + Integer.parseInt(consultapedido);
        }
        labeltotal.setText(String.valueOf(total));
        System.out.print(total);
        verPorCiclo();  
    }//GEN-LAST:event_buttonAceptartotalMouseClicked

    private void buttoneliminarpuesto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttoneliminarpuesto1MouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_buttoneliminarpuesto1MouseClicked

    private void jLabelEliminarartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEliminarartMouseClicked
        // TODO add your handling code here:
         //Obtener la fila seleccionada. 
        int fila = TablaDatos.getSelectedRow();
        //Validar si hay alguna fila seleccionada
        if(TablaDatos.getSelectedRow() != -1)
        {
            //Obtener y guardar el id de la fila seleccionada.
            
            
            
            //La ventana de confirmación retorna un valor numerico equivalente a la opcion que selecciona el usuario. 
            int op=JOptionPane.showConfirmDialog(null, "Está a punto de eliminar permanentemente el pedido '"+numcel+"'", "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            //Si confirma la eliminación, el valor de op=0
            if(op==0){
                
                
                p.eliminarPedido("eliminarart",numcel, nom_art, precio, color, nociclo);
                total= total - Integer.parseInt(precio);
                verTodos();
                labeltotal.setText(String.valueOf(total));
                
            }else{
                //Sí cancela la eliminacion no pasa nada
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona a un puesto y presiona 'Eliminar'" ,"Eliminacion de puestos",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jLabelEliminarartMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Encontrados;
    private javax.swing.JLabel LabelTitulo;
    private rojerusan.RSTableMetro TablaDatos;
    private javax.swing.JButton buttonAceptartotal;
    private javax.swing.JButton buttonBuscar;
    private org.edisoncor.gui.panel.PanelImage buttoneliminarpedido;
    private org.edisoncor.gui.panel.PanelImage buttoneliminarpuesto1;
    private org.edisoncor.gui.panel.PanelImage buttoningresarpuesto;
    private org.edisoncor.gui.panel.PanelImage buttonmodificarpuesto;
    private org.edisoncor.gui.panel.PanelImage buttonvertodos;
    private javax.swing.JComboBox<String> comboboxCiclosTotal;
    private javax.swing.JComboBox<String> comboboxClientes;
    private javax.swing.JComboBox<String> comboboxciclos;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCantidadarticulos;
    private javax.swing.JLabel jLabelEliminarPedido;
    private javax.swing.JLabel jLabelEliminarart;
    private javax.swing.JLabel jLabelGenerarpdf;
    private javax.swing.JLabel jLabelModificar;
    private javax.swing.JLabel jLabelTotaldinero;
    private javax.swing.JLabel jLabelVerporclientes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelVertodos;
    private javax.swing.JLabel labelcantart;
    private javax.swing.JLabel labeltotal;
    // End of variables declaration//GEN-END:variables
}
