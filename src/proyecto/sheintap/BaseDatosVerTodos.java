package proyecto.sheintap;
//Importar las librerias necesarias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BaseDatosVerTodos {

    //Declarció de variables de clase. 
    Connection conexionIncidencias;
    //Creación del constructor. 
    public BaseDatosVerTodos(){
        try{
            Class.forName("org.postgresql.Driver");
            conexionIncidencias=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sheintap","postgres","toor055");
            //JOptionPane.showMessageDialog(null,"La conexion fue exitosa","Conexion base de datos",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"La conexion no fue exitosa"+e.getMessage(),"Conexion de base de datos",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  String[][] buscarTodos(String opc){
       String [][] ausencias=new String[1][1];
        int fila;
        String condicion;
        condicion="";
        String estandar;
        String consulta= new String();
        //El inicio de una consulta muy larga que arroja datos mas detallados de empleados con ausencias. 
        estandar="select * from pedidospagados, pedidospendientes ";
        //System.out.println("el parametro de buscar empleado es:"+busqueda); //Active para hacer pruebas
        //System.out.println("el dato de buscar empleado es:"+dato);//Active para hacer pruebas
        try{
            //Crea el statemen
            Statement st=conexionIncidencias.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            /*Dado a que siempre se requiere los mismos datos en cada posible consulta, la primera parte de la consulta se guarda en 
            la cadena "estandar" mientras que en la cadena "consulta" se almacena la condicion a seguir que diferencia a cada consulta*/
            switch(opc){
                case "Todos":
                    
                break; 
                case "Desde: Hace un mes":
                    //condicion="select * from ausencias where fecha between (current_date - interval '1 month' ) and current_date;";
                    condicion="where a.fecha between (current_date - interval '1 month' ) and current_date ORDER BY fecha desc";
                break; 
                case "Cualquier fecha":
                    condicion="ORDER BY fecha desc";
                break;
                default:
                    JOptionPane.showMessageDialog(null,"No conincide ninguna caso de busqueda","Busqueda de ausencias",JOptionPane.ERROR_MESSAGE);
                break;
                    
            } 
            
            //Se construye la consulta
            consulta=""+estandar+" "+condicion;
            //Crea el resulset que retornará un objeto
            ResultSet rs=st.executeQuery(consulta);
            //Envia la posicion a la ultima fila de la consulta
            rs.last();
            //Obten el numero de fila en donde se encuentra rs
            fila =rs.getRow();
            //Agrega esa posicion a fila y esa será la dimension del arreglo.
            ausencias= new String[8][fila];
            int i=0;
            //Regresa el rs a la posicion anterior a la primera
            rs.beforeFirst();
            
            while(rs.next()){
                ausencias[0][i]=rs.getString("fecha");
                ausencias[1][i]=rs.getString("id_empleado");
                ausencias[2][i]=rs.getString("nombrepila");
                ausencias[3][i]=rs.getString("apellidopat");
                ausencias[4][i]=rs.getString("falta");
                ausencias[5][i]=rs.getString("descanso");
                ausencias[6][i]=rs.getString("retardos");
                i++;
            }
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de empleaos",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Se ejecutó buscarAusencias");
        
        System.out.println("Consulta="+consulta);
        System.out.println("Resultados:");
        /*for(int x=0;x<=11;x++){
            System.out.println(ausencias[0][x]);
        }*/
        return ausencias; 
    }
    
    public void registrarDescanso(String fecha,String id){
        
        try{
            Statement st=conexionIncidencias.createStatement();
            boolean x= st.execute("insert into ausencias values('"+fecha+"','"+id+"',false,true,false,null)" );
            if(x==false){
               JOptionPane.showMessageDialog(null,"Descanso registrado con exito","Registrar descanso",JOptionPane.INFORMATION_MESSAGE);  
            }
       
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error al insertar"+e.getMessage(),"Insersion de descanso",JOptionPane.ERROR_MESSAGE); 
        }
        
    }
    
    
}
