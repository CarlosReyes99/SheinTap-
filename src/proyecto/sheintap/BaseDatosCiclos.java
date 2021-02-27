package proyecto.sheintap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BaseDatosCiclos {
    Connection conexionQuincena;
    
    public BaseDatosCiclos(){
        try{
            Class.forName("org.postgresql.Driver");
            conexionQuincena=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sheintap","postgres","toor055");
            //JOptionPane.showMessageDialog(null,"La conexion fue exitosa","Conexion base de datos",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"La conexion no fue exitosa"+e.getMessage(),"Conexion de base de datos",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodos puesto. 
    
    public void insertarCiclo(String mescicloaño){
        System.out.println("Entró al metodo");
        try{
            Statement st=conexionQuincena.createStatement();
            boolean x= st.execute("insert into ciclos values ('"+mescicloaño+"')");
            if(x==false){
                JOptionPane.showMessageDialog(null,"Ciclo registrada con exito","Registro de Ciclos",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error al insertar"+e.getMessage(),"Registro de Ciclos",JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    public String[][] buscarCiclos(String caso){
        String [][] resultado= new String[1][1];
        int fila;
        String consulta=new String(); 
        //System.out.println("El parametro de buscarpuesto es "+busqueda);
        //System.out.println("El dato de buscarpuesto es "+dato);
        try{
            //Crea el statemen
            Statement st=conexionQuincena.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            switch(caso){
                case "Todos":
                    consulta="select * from ciclos ";
                break;
                
                
                default:
                    //Si no coincide con nada, no hacer consulta.
                    System.out.println("Error en caso de busqueda");
                break;
            }
            //System.out.println("El dato x es "+x);//Activar para hacer pruebas
                System.out.println("la consulta es: "+consulta);//Activar para hacer pruebas
                //Crea el resulset que retornará un objeto
                //System.out.print(consulta+"-----"+x+"---"+y);
                ResultSet rs=st.executeQuery(consulta);
                //Envia la posicion a la ultima fila de la consulta
                rs.last();
                //Obten el numero de fila en donde se encuentra rs
                fila =rs.getRow();
                //Agrega esa posicion a fila y esa será la dimension del arreglo.
                resultado= new String[1][fila];
                int i=0;
                //Regresa el rs a la posicion anterior a la primera
                rs.beforeFirst();

                while(rs.next()){
                    resultado[0][i]=rs.getString("mescicloaño");
                    i++;
                }
            
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de quincena",JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
    
    //Función que recibe los datos de puesto y actualiza en la base de datos. 
    public void modificarQuincena(String año,String noquincena, String fechainicial, String fechafinal){
        try{
            Statement st=conexionQuincena.createStatement();
            int x= st.executeUpdate("update quincena set fechainicial='"+fechainicial+"',fechafinal='"+fechafinal+"' where year='"+año+"' and noquincena="+noquincena+";");
            if(x==1){
                JOptionPane.showMessageDialog(null,"Quincena actualizada con éxito","Actualización de quincena",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,""+e.getMessage(),"Actualización de puesto",JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    public void eliminarQuincena(String noquincena){
        try{
            Statement st=conexionQuincena.createStatement();
            int x= st.executeUpdate("delete from ciclos where mescicloaño='"+noquincena+"'");
            if(x==1){
                JOptionPane.showMessageDialog(null,"Ciclo eliminado con éxito","Eliminación de ciclos",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,""+e.getMessage(),"Eliminación de ciclo",JOptionPane.ERROR_MESSAGE);   
        }
    }   
    
     public String[][] hacerpago(String caso,String id, int noquincena, String año){
        String[][] resultadoimporte= new String[1][1];
        String [][] resultadofechas= new String[1][1];
        int fila;
        int i=0;
        String consulta=new String(); 
        
        //System.out.println("El parametro de buscarpuesto es "+busqueda);
        //System.out.println("El dato de buscarpuesto es "+dato);
        try{
            //Crea el statemen
            Statement st=conexionQuincena.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            switch(caso){
                case "nuevo":
                    //consulta para capturar la fecha incial y final dependiendo del número de quincena y el año, de la tabla quincena
                    consulta= "select  fechainicial, fechafinal from quincena where noquincena='"+noquincena+"' and year='"+año+"' ";
                    ResultSet rsfechas=st.executeQuery(consulta);
                    //Envia la posicion a la ultima fila de la consulta
                    rsfechas.last();
                    //Obten el numero de fila en donde se encuentra rs
                    fila =rsfechas.getRow();
                     //Agrega esa posicion a fila y esa será la dimension del arreglo.
                    resultadofechas= new String[2][fila];
                    
                    //Regresa el rs a la posicion anterior a la primera
                    rsfechas.beforeFirst();
                    while(rsfechas.next()){
                        resultadofechas[0][i]=rsfechas.getString("fechainicial");
                        resultadofechas[1][i]=rsfechas.getString("fechafinal");
                        i++;
                    }//termina de llenar el String de fechas
                    
                    //consulta que ocupa la consulta anterior para poder genrar el pago mediante la funcion pagoelegido
                    consulta="select pagoelegido('"+id+"','"+resultadofechas[0][0]+"','"+resultadofechas[1][0]+"')";
                    System.out.println("select pagoelegido(id: "+id+"fechainicial"+resultadofechas[0][0]+"Fecha final: "+resultadofechas[1][0]);
                    //System.out.println("la consulta es: "+consulta);//Activar para hacer pruebas
                    //Crea el resulset que retornará un objeto
                    ResultSet rs=st.executeQuery(consulta);
                    //termina nuevo
                    consulta= "select noquincena,importe from pago_quincenal where id_empleado='"+id+"' and noquincena='"+noquincena+"'";
                    ResultSet rsimporten=st.executeQuery(consulta);
                    //Envia la posicion a la ultima fila de la consulta
                    rsimporten.last();
                    //Obten el numero de fila en donde se encuentra rs
                    fila =rsimporten.getRow();
                    //Agrega esa posicion a fila y esa será la dimension del arreglo.
                    resultadoimporte= new String[2][fila];
                    i=0;
                    //Regresa el rs a la posicion anterior a la primera
                    rsimporten.beforeFirst();
                    while(rsimporten.next()){
                        resultadoimporte[0][i]=rsimporten.getString("noquincena");
                        resultadoimporte[1][i]=rsimporten.getString("importe");
                        i++;
                    }
                    break;
            
                case "buscar"://consulta para capturar el número de quincena y el importe del pago generado
                    consulta= "select noquincena,importe from pago_quincenal where id_empleado='"+id+"' and noquincena='"+noquincena+"'";
                    ResultSet rsimporte=st.executeQuery(consulta);
                    //Envia la posicion a la ultima fila de la consulta
                    rsimporte.last();
                    //Obten el numero de fila en donde se encuentra rs
                    fila =rsimporte.getRow();
                    //Agrega esa posicion a fila y esa será la dimension del arreglo.
                    resultadoimporte= new String[2][fila];
                    i=0;
                    //Regresa el rs a la posicion anterior a la primera
                    rsimporte.beforeFirst();
                    while(rsimporte.next()){
                        resultadoimporte[0][i]=rsimporte.getString("noquincena");
                        resultadoimporte[1][i]=rsimporte.getString("importe");
                        i++;
                    }
                break;
        }
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Quincena no encontrada o no insertada",JOptionPane.ERROR_MESSAGE);
        }
        return resultadoimporte;
    }//termina hacerpago
    public String[][] añocombo(String caso, String año){
       String [][] resultadoaños= new String[1][1];
        int fila;
        int i=0;
        String consulta=new String(); 
        //System.out.println("El parametro de buscarpuesto es "+busqueda);
        //System.out.println("El dato de buscarpuesto es "+dato);
        try{
            //Crea el statemen
            Statement st=conexionQuincena.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            switch(caso){
                case "años":
                    consulta="select year from quincena group by year";
                    ResultSet rs=st.executeQuery(consulta);
                     //Envia la posicion a la ultima fila de la consulta
                    rs.last();
                    //Obten el numero de fila en donde se encuentra rs
                    fila =rs.getRow();
                    //Agrega esa posicion a fila y esa será la dimension del arreglo.
                    resultadoaños= new String[1][fila];
                    i=0;
                    //Regresa el rs a la posicion anterior a la primera
                    rs.beforeFirst();
                    while(rs.next()){
                        resultadoaños[0][i]=rs.getString("year");
                        i++;
                    }
                break;
                case "noquincena":
                        consulta="SELECT MAX(noquincena) noquincena FROM quincena where year= '"+año+"' group by noquincena order by noquincena desc limit 1;";
                        ResultSet rsaños=st.executeQuery(consulta);
                         //Envia la posicion a la ultima fila de la consulta
                        rsaños.last();
                        //Obten el numero de fila en donde se encuentra rs
                        fila =rsaños.getRow();
                        //Agrega esa posicion a fila y esa será la dimension del arreglo.
                        resultadoaños= new String[1][fila];
                        i=0;
                        //Regresa el rs a la posicion anterior a la primera
                        rsaños.beforeFirst();
                        while(rsaños.next()){
                            resultadoaños[0][i]=rsaños.getString("noquincena");
                            i++;
                        }
                case "noquincenaño":
                    consulta="SELECT noquincena FROM quincena where year='"+año+"' group by noquincena";
                    System.out.println(consulta);
                        ResultSet rsnoquin=st.executeQuery(consulta);
                         //Envia la posicion a la ultima fila de la consulta
                        rsnoquin.last();
                        //Obten el numero de fila en donde se encuentra rs
                        fila =rsnoquin.getRow();
                        //Agrega esa posicion a fila y esa será la dimension del arreglo.
                        resultadoaños= new String[1][fila];
                        i=0;
                        //Regresa el rs a la posicion anterior a la primera
                        rsnoquin.beforeFirst();
                        while(rsnoquin.next()){
                            resultadoaños[0][i]=rsnoquin.getString("noquincena");
                            i++;
                        }
                break;
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Busqueda de años combo",JOptionPane.ERROR_MESSAGE);
        }
        return resultadoaños;
    }
}
