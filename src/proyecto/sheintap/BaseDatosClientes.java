package proyecto.sheintap;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BaseDatosClientes {
    Connection conexion;
    int valida;
    public BaseDatosClientes(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sheintap","postgres","toor055");
            //JOptionPane.showMessageDialog(null,"La conexion fue exitosa","Conexion base de datos",JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"La conexion no fue exitosa"+e.getMessage(),"Conexion de base de datos",JOptionPane.ERROR_MESSAGE);
        }
    }
    public BaseDatosClientes(String usuario,String contraseña){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectof",usuario,contraseña);
            JOptionPane.showMessageDialog(null,"Bienvenido: "+usuario,"Conexion base de datos",JOptionPane.INFORMATION_MESSAGE);
            valida=1;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"La conexion no fue exitosa"+e.getMessage(),"Conexion de base de datos",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //InsertarClientes
    public void insertarClientes(String numcel,String nombre,String dir){
        try{
            Statement st=conexion.createStatement();
            boolean x= st.execute("insert into clientes values('"+numcel+"','"+nombre+"','"+dir+"');");
            if(x==false){
               JOptionPane.showMessageDialog(null,"Cliente registrado correctamente","Insersion de Cliente",JOptionPane.INFORMATION_MESSAGE);  
            }
       
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(null,"Error al insertar"+e.getMessage(),"Insersion de cliente",JOptionPane.ERROR_MESSAGE); 
        }
        
    }
    
    public String[][] buscarClientesporundato(String busqueda, String dato) {
        String [][] empleadodato=new String[1][1];
        String numcel[][];
        int fila;
        String condicion;
        String estandar, seleccion;
        String consulta;
        condicion="";
        try{
            //Crea el statemen
            Statement st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            /*Dado a que siempre se requiere los mismos datos en cada posible consulta, la primera parte de la consulta se guarda en 
            la cadena "estandar" mientras que en la cadena "consulta" se almacena la condicion a seguir que diferencia a cada consulta*/
            estandar="select * from clientes order by nombre";
            switch(busqueda){
                case "numcel":
                    condicion="select numcel from clientes";
                    break;
                case "nombre":
                    try{
                    
                    consulta = "select nombre from clientes order by nombre";
                    //Crea el resulset que retornará un objeto
                    
                    ResultSet rs=st.executeQuery(consulta);
                    //Envia la posicion a la ultima fila de la consulta
                    rs.last();
                    //Obten el numero de fila en donde se encuentra rs
                    fila =rs.getRow();
                    //Agrega esa posicion a fila y esa será la dimension del arreglo.
                    empleadodato= new String[1][fila];
                    int i=0;
                    //Regresa el rs a la posicion anterior a la primera
                    rs.beforeFirst();
                     while(rs.next()){
                    empleadodato[0][i]=rs.getString("nombre");
                    

                    i++;
                }//termina while para llenar empleadodato
            
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de un dato empleado",JOptionPane.ERROR_MESSAGE);
                }
                    
                    
                
            }//termina swicth 
            
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de un dato empleado",JOptionPane.ERROR_MESSAGE);
        }
            
            
            
        
        return empleadodato;
    }
            
    public String[][] buscarClientes(String busqueda, String dato) {
        String [][] empleado=new String[1][1];
        String numcel[][];
        int fila;
        String condicion;
        String estandar, seleccion;
        String consulta;
        condicion="";
        try{
            //Crea el statemen
            Statement st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            /*Dado a que siempre se requiere los mismos datos en cada posible consulta, la primera parte de la consulta se guarda en 
            la cadena "estandar" mientras que en la cadena "consulta" se almacena la condicion a seguir que diferencia a cada consulta*/
            estandar="select * from clientes order by nombre";
            switch(busqueda){
                case "numcel":
                    condicion="select numcel from clientes";
                    break;
                case "nombre":
                    estandar = "select nombre from clientes order by nombre";
                    condicion="";
                break;
                case "Apellido materno":
                    condicion="where e.apellidomat='"+dato+"'";
                break;
                case "Puesto":
                    condicion="where p.nompuesto='"+dato+"'";
                break;
                case "Sexo":
                    condicion="where e.sexo='"+dato+"'";
                break;
                case "Todos":
                    //no se hace nada 
                break;
                case "Cualquiera":
                //condicion="where e.id_empleado='"+dato+"' or e.nombrepila='"+dato+"' or e.apellidopat='"+dato+"' or e.apellidomat='"+dato+"' or p.nompuesto='"+dato+"' or e.sexo='"+dato+"'";
                break;
            }//termina swicth 
            consulta=""+estandar+" "+condicion;
            //Crea el resulset que retornará un objeto
            ResultSet rs=st.executeQuery(consulta);
            //Envia la posicion a la ultima fila de la consulta
            rs.last();
            //Obten el numero de fila en donde se encuentra rs
            fila =rs.getRow();
            //Agrega esa posicion a fila y esa será la dimension del arreglo.
            empleado= new String[3][fila];
            int i=0;
            //Regresa el rs a la posicion anterior a la primera
            rs.beforeFirst();
            
            
            while(rs.next()){
                empleado[0][i]=rs.getString("numcel");
                empleado[1][i]=rs.getString("nombre");
                empleado[2][i]=rs.getString("direccion");

                i++;
            }
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de empleaos",JOptionPane.ERROR_MESSAGE);
        }
        return empleado; 
    }
    
    
    
    
    //Eliminar cliente
    public void eliminarCliente(String numcel){
        try{
            Statement st=conexion.createStatement();
            int x=st.executeUpdate("delete from clientes where numcel='"+numcel+"'");
            if(x==1){
               JOptionPane.showMessageDialog(null,"Cliente eliminado con exito","Eliminación de cliente",JOptionPane.INFORMATION_MESSAGE);
            }      
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(null," "+e.getMessage(),"Eliminación de cliente",JOptionPane.ERROR_MESSAGE); 
        }
    }
   
    //Actualizar cliente
    public void actualizarCliente(String numcelant,String numcelnew,String nombre,String ciudad){
        try{
            Statement st=conexion.createStatement();
            int x=st.executeUpdate("UPDATE public.clientes SET numcel='"+numcelnew+"',nombre='"+nombre+"',ciudad='"+ciudad+"' where numcel= '"+numcelant+"'; ");
            if(x==1){
               JOptionPane.showMessageDialog(null,"Cliente actualizado con exito","Modificacion de Cliente",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al actualizar Cliente. Cliente no encontrado","Eliminación de Cliente",JOptionPane.INFORMATION_MESSAGE);
            }
       
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(null," "+e.getMessage(),"Eliminación de Cliente",JOptionPane.ERROR_MESSAGE); 
        }
    }
    
   
    
    
    
    
    
    
    
   
    }     

