
package gestor;
import dto.ReporteLibroPorAuTOR;
import dto.mPunto2;
import dto.nacional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Libro;
import model.Autor;

public class GestorDB {
    //Los atributos necesarios para poder generar la conexion
    private String CONN = "jdbc:sqlserver://DESKTOP-EV44NM4\\SQLEXPRESS:1433;databaseName=Bibilioteca";
    private String USER = "sa";
    private String PASS = "12345";
    
    //Para que sea viable abrirConexion() y cerrarConexion() es necesario declarar este atributo
    //Con el fin de no estar instanciando una nueva conexion, ante cada metodo que la requiera
    private Connection conn;
    
    public void abrirConexion(){
        try{
        conn = DriverManager.getConnection(CONN, USER, PASS);
        
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }      
    }
    
    public void cerrarConexion(){
        try {
            if ( conn!=null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
    }

    
    public void agregarLibro(Libro libro){
        try {
            abrirConexion();
            //El pstmt nos permite pasarle parametros a la consulta
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Libros VALUES (?,?,?)");
            
            //Le pasamos los parametros
            pstmt.setString(1, libro.getDescripcion());
            pstmt.setString(2, libro.getTipoPrestamo());
            pstmt.setInt(3, libro.getAutor().getId());
            
            //Ejecutamos la consulta
            pstmt.executeUpdate();
            
            //Cerramos el pstmt y la conexion
            pstmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarLibro(int id){
        try {
            abrirConexion();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Libros WHERE id_libro=?");
            pstmt.setInt(1, id);
           
            
            pstmt.executeUpdate();
            
            pstmt.close();
            cerrarConexion();
            
            
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }
    
    public Libro seleccionarLibro(int id){
        // Selecciona un libro con el fin de pasarlo en algun formulario
        // Este metodo requiere que se le informe un id de libro
        // Por ejemplo para modificar un registro
        
        //Inicializamos un libro en null
        Libro libro = null;
        // Para implementar otros metodos que contenga nuestro gestor lo instanciamos
        GestorDB g = new GestorDB();
        
        //Importante poner el try, para prevenir errores
        try {
           
            
            abrirConexion();
            //psmt para poder pasarle un parametro
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Libros WHERE id_libro=?");          
            pstmt.setInt(1, id);
            // En este caso queremos que nos devuelva un resultado, que es un registro unitario
            ResultSet rs =  pstmt.executeQuery();
            
            if (rs.next()) {
                // Creamos y seteamos las variables para asignarlas al Libro
                String descripcion = rs.getString(2);
                String tipoPrestamo = rs.getString(3);
                int id_autor = rs.getInt(4);
                
                //Creamos el objeto libro, el id libro lo obtenemos como entrada del metodo
                libro = new Libro(id, descripcion, tipoPrestamo, g.GetAutorPorId(id_autor) );
            }
            // En este caso no afectaria, pero al pstmt y a la conexion hay que cerrarlos
            // por afuera del if o while, en su caso
            pstmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        
        //Retornamos el libro
    return  libro;
        
        
    }
    
    public void modificarLibro(Libro libro){
        //Importante poner el try, para prevenir errores
        try {
            abrirConexion();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE Libros SET descripcion=?, tipoPrestamo=?, id_Autor=?  WHERE id_libro =?");
            
            pstmt.setString(1, libro.getDescripcion());
            pstmt.setString(2, libro.getTipoPrestamo());
            // Aca utilizamos el atributo que le agregamos a la clase libro
            pstmt.setInt(3, libro.getIdAutor());
            
            pstmt.setInt(4, libro.getId_libro());
            
            pstmt.executeUpdate();
            pstmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }
    
    
    public ArrayList<Libro> GetListadoLibros(){
        //Inicializamos un array vacio
        ArrayList<Libro> listado = new ArrayList<>();
        try {
            abrirConexion();
            //El stmt no permite pasar parametros
            Statement stmt = conn.createStatement();
            
            //Ejecutamos la sentencia que nos devolvera muchos registros, cada uno con un libro
            ResultSet rs = stmt.executeQuery("SELECT * FROM Libros");
            
            while (rs.next()) {    
                //Declaramos y seteamos las variables
                int id= rs.getInt(1);
                String descripcion = rs.getString(2);
                String tipoPrestamo = rs.getString(3);
                int id_Autor = rs.getInt(4);
                // Le pasamos el id_Autor a nuestro metodo
                //de esta forma le estamos pasando el objeto Autor a nuestro constructor
                Autor autor = GetAutorPorId(id_Autor);
                
                //Creamos el objeto libro
                Libro l = new Libro(id, descripcion, tipoPrestamo, autor);
                
                //Lo agregamos a nuestro array 
                listado.add(l);
                
               
            }
            
            //OJO ACA, CERRAR LA CONEXION POR FUERA DEL WHILE
             rs.close();
             stmt.close();
             cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //Retornamos el array
        return  listado;
    }
    
    public ArrayList<Autor> GetAutores(){
        //La utilidad de este metodo es que nos permitira cargar nuestro cboAutores
        //Este metodo es muy silimar a GetListadoLibros
        ArrayList<Autor> listadoAutores = new ArrayList<>();
        try {
            abrirConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Autores");
            
            while (rs.next()) {                
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String nacionalidad = rs.getString(3);
                
                Autor a = new Autor(id, nombre, nacionalidad);
                
                listadoAutores.add(a);
            }
            
            rs.close();
            stmt.close();
            cerrarConexion();
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  listadoAutores;
    }
    
    public String cantidadLibros(){
        //Declaramos la variable y la seteamos en null
        String resultado = "";
        
         try{
            abrirConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("Select count(*) as cantidadLibros FROM Libros");
            
                if (rs.next()) {
                    //Aca le pasamos el nombre de la columna SQL de la consulta
                    resultado= rs.getString("cantidadLibros");
                }
            
            
            rs.close();
            stmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            return resultado;
        }
    
    public Autor GetAutorPorId(int id){
        Autor resultado = null;
        
        try {
            abrirConexion();
            PreparedStatement pstmt = conn.prepareStatement("Select * From Autores WHERE id=?");
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString(2);
                String nacionalidad = rs.getString(3);
                resultado = new Autor(id, nombre, nacionalidad);
            }
            
            rs.close();
            pstmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public ArrayList<mPunto2> listadoReportePunto2(){
         //Inicializamos un array vacio
        ArrayList<mPunto2> listado = new ArrayList<>();
        try {
            abrirConexion();
            //El stmt no permite pasar parametros
            Statement stmt = conn.createStatement();
            
            //Ejecutamos la sentencia que nos devolvera muchos registros, cada uno con un libro
            ResultSet rs = stmt.executeQuery("Select descripcion, nombre, nacionalidad\n" +
"from Autores a inner join Libros l on a.id=l.id_Autor");
            
            while (rs.next()) {    
                //Declaramos y seteamos las variables
                
                String descripcion = rs.getString(1);
                String nombre = rs.getString(2);
                String nacionalidad = rs.getString(3);
                
                
                //Creamos el objeto mPunto2
                mPunto2 mp2 = new mPunto2(descripcion, nombre, nacionalidad);
                
                //Lo agregamos a nuestro array 
                listado.add(mp2);
                
               
            }
            
            //OJO ACA, CERRAR LA CONEXION POR FUERA DEL WHILE
             rs.close();
             stmt.close();
             cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //Retornamos el array
        return  listado;
    }
    
    public ArrayList<nacional> listadoReporteNacional(){
         //Inicializamos un array vacio
        ArrayList<nacional> listado = new ArrayList<>();
        try {
            abrirConexion();
            //El stmt no permite pasar parametros
            Statement stmt = conn.createStatement();
            
            //Ejecutamos la sentencia que nos devolvera muchos registros, cada uno con un libro
            ResultSet rs = stmt.executeQuery("Select l.id_libro 'Codigo Libro', descripcion Libro, nombre Autor\n" +
"from Autores a inner join Libros l on a.id=l.id_Autor\n" +
"where nacionalidad='argentina'");
            
            while (rs.next()) {    
                //Declaramos y seteamos las variables
                
                int codigoLibro = rs.getInt(1);
                String nombreLibro = rs.getString(2);
                String nombreAutor = rs.getString(3);
                
                
                //Creamos el objeto mPunto2
                nacional n = new nacional(codigoLibro, nombreLibro, nombreAutor);
                
                //Lo agregamos a nuestro array 
                listado.add(n);
                
               
            }
            
            //OJO ACA, CERRAR LA CONEXION POR FUERA DEL WHILE
             rs.close();
             stmt.close();
             cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //Retornamos el array
        return  listado;
    }
    
   public ArrayList<ReporteLibroPorAuTOR> ListadoReporteLibrosPorAutor(String nombre){
         //Inicializamos un array vacio
        ArrayList<ReporteLibroPorAuTOR> listado = new ArrayList<>();
        try {
            abrirConexion();
            //El stmt no permite pasar parametros
            PreparedStatement pstmt = conn.prepareStatement("Select nombre Autor, nacionalidad, descripcion\n" +
"from Autores a inner join Libros l on a.id=l.id_Autor\n" +
"where nombre=?");
            pstmt.setString(1, nombre);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {    
                //Declaramos y seteamos las variables
                
                
                String nombreLibro = rs.getString(3);
                
                
                
                //Creamos el objeto mPunto2
                ReporteLibroPorAuTOR reporteLibroPorAuTOR = new ReporteLibroPorAuTOR(nombreLibro);
                
                //Lo agregamos a nuestro array 
                listado.add(reporteLibroPorAuTOR);
                
               
            }
            
            //OJO ACA, CERRAR LA CONEXION POR FUERA DEL WHILE
             rs.close();
             pstmt.close();
             cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //Retornamos el array
        return  listado;
    }
   
   public String PorcentajeLibrosDomicilio(){
        //Declaramos la variable y la seteamos en null
        String resultado = "";
        
         try{
            abrirConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("select  (select count(*)  from libros where tipoPrestamo='Domicilio') *100 / COUNT(*)  Porcentaje \n" +
"from Libros");
            
                if (rs.next()) {
                    //Aca le pasamos el nombre de la columna SQL de la consulta
                    resultado= rs.getString("Porcentaje");
                }
            
            
            rs.close();
            stmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            return resultado;
        }
   
   public Autor GetAutorPorNombre(String nombre){
        Autor resultado = null;
        
        try {
            abrirConexion();
            PreparedStatement pstmt = conn.prepareStatement("Select * From Autores WHERE nombre=?");
            pstmt.setString(1, nombre);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt(1);
                String nacionalidad = rs.getString(3);
                resultado = new Autor(id, nombre, nacionalidad);
            }
            
            rs.close();
            pstmt.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return resultado;
    }
   
   
    
    }

    

     