package proyecto.sheintap;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BaseDatosPedidosPendientes {
    Connection conexion;
    int valida;
    String nomartv, tallav, preciov, numcelv;
    
    public void recibirdatosviejos(String numcel, String nomart, String talla,  String precio){
    this.nomartv= nomart;
    this.tallav= talla;
 
    this.preciov= precio;
    this.numcelv= numcel;
    System.out.print("\n \n \n este es el numcel que se inserta en modificar pedido: "+numcelv);
 
    }
    public BaseDatosPedidosPendientes(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sheintap","postgres","toor055");
            //JOptionPane.showMessageDialog(null,"La conexion fue exitosa","Conexion base de datos",JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"La conexion no fue exitosa"+e.getMessage(),"Conexion de base de datos",JOptionPane.ERROR_MESSAGE);
        }
    }
    public BaseDatosPedidosPendientes(String usuario,String contraseña){
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
    public void insertarPedido(String numcel,String nom_art,String talla, String mescicloaño, String precio, String opc, String color,String nombre){
        try{
            Statement st=conexion.createStatement();
            boolean x= st.execute("INSERT INTO pedidospendientes(numcel, nomart, talla, mescicloaño, precio, opc, color, nombrecliente) VALUES ('"+numcel+"', '"+nom_art+"', '"+talla+"', '"+mescicloaño+"', '"+precio+"', '"+opc+"', '"+color+"', '"+nombre+"');");
            if(x==false){
               JOptionPane.showMessageDialog(null,"Pedido registrado correctamente","Insersion de Pedido",JOptionPane.INFORMATION_MESSAGE);  
            }
       
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(null,"Error al insertar"+e.getMessage(),"Insersion de cliente",JOptionPane.ERROR_MESSAGE); 
        }
        
    }
            
    public String[][] buscarPedido(String busqueda, String dato, String dato2){
        String [][] empleado=new String[1][1];
        int fila;
        String condicion;
        String estandar;
        String consulta;
        condicion="";
        try{
            //Crea el statemen
            Statement st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            /*Dado a que siempre se requiere los mismos datos en cada posible consulta, la primera parte de la consulta se guarda en 
            la cadena "estandar" mientras que en la cadena "consulta" se almacena la condicion a seguir que diferencia a cada consulta*/
            estandar="select * from pedidospendientes ";
            switch(busqueda){
                case "numcel":
                   condicion="where numcel='"+dato+"'";
                break; 
                case "numcelciclo":
                    condicion="where nombrecliente='"+dato+"' and mescicloaño = '"+dato2+"' ";
                break; 
                case "mescicloaño":
                    condicion="where mescicloaño='"+dato+"'";
                break;
                case "nombreciclo":
                    condicion="where nombrecliente='"+dato+"' and mescicloaño = '"+dato2+"'";
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
            } 
            consulta=""+estandar+" "+condicion;
            //Crea el resulset que retornará un objeto
            ResultSet rs=st.executeQuery(consulta);
            //Envia la posicion a la ultima fila de la consulta
            rs.last();
            //Obten el numero de fila en donde se encuentra rs
            fila =rs.getRow();
            //Agrega esa posicion a fila y esa será la dimension del arreglo.
            empleado= new String[7][fila];
            int i=0;
            //Regresa el rs a la posicion anterior a la primera
            rs.beforeFirst();
            
            
            while(rs.next()){
                empleado[0][i]=rs.getString("numcel");
                empleado[1][i]=rs.getString("nomart");
                empleado[2][i]=rs.getString("talla");
                empleado[3][i]=rs.getString("mescicloaño");
                empleado[4][i]=rs.getString("precio");
                empleado[5][i]=rs.getString("color");
                empleado[6][i]=rs.getString("nombrecliente");

                i++;
            }
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de empleaos",JOptionPane.ERROR_MESSAGE);
        }
        return empleado; 
    }
    
    
    
    
    //Eliminar cliente
    public void eliminarPedido(String busqueda, String numcel, String nomart, String precio, String color, String nociclo){
        try{
            int x;
            
            
            Statement st=conexion.createStatement();
            
            switch(busqueda){
            
                case "eliminarart":
                    x=st.executeUpdate("delete from pedidospendientes where numcel='"+numcel+"' and nomart='"+nomart+"' and precio='"+precio+"' and color='"+color+"' and mescicloaño='"+nociclo+"'");
                    if(x==1){
                    JOptionPane.showMessageDialog(null,"Pedido eliminado con exito","Eliminación de pedido",JOptionPane.INFORMATION_MESSAGE);
                    }  
                    break;
                case "eliminarpedido":
                      x=st.executeUpdate("delete from pedidospendientes where numcel='"+numcel+"' and mescicloaño='"+nociclo+"' ");
                    if(x==1){
                    JOptionPane.showMessageDialog(null,"Pedido eliminado con exito","Eliminación de pedido",JOptionPane.INFORMATION_MESSAGE);
                    }  
                    break;
            
            }
            
                
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(null," "+e.getMessage(),"Eliminación de pedido",JOptionPane.ERROR_MESSAGE); 
        }
    }
   
    //Actualizar cliente
    public void actualizarPedido(String numcel, String mescicloaño, String nom_art,String talla, String precio){
        try{
            Statement st=conexion.createStatement();
            int x=st.executeUpdate("UPDATE public.pedidospendientes SET nomart='"+nom_art+"', talla='"+talla+"', precio='"+precio+"' WHERE numcel='"+numcelv+"' and mescicloaño='"+mescicloaño+"' and nomart='"+nomartv+"' and talla='"+tallav+"' and talla='"+tallav+"' and precio='"+preciov+"'; ");
            if(x==1){
               JOptionPane.showMessageDialog(null,"Pedido actualizado con exito","Modificacion de Pedido",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al actualizar Pedido. Cliente no encontrado","Eliminación de Pedido",JOptionPane.INFORMATION_MESSAGE);
            }
       
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(null," "+e.getMessage(),"Eliminación de Pedido",JOptionPane.ERROR_MESSAGE); 
        }
    }
    
   
    
    
    
    
    
    
    
   
    }     

