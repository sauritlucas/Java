/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Deposito;
import modelo.DetalleVenta;
import modelo.Pareja;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author luqqa
 */
public class GestorDB {
    private Connection con;
    
	 private String CONN = "jdbc:sqlserver://DESKTOP-EV44NM4\\SQLEXPRESS:1433;databaseName=Casamiento";
         private String USER = "sa";
         private String PASS = "12345";
         
          public GestorDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	private void abrirConexion() {
		try {
                   
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			con = DriverManager.getConnection(CONN, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void cerrarConexion() {
		try {

			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
        
        public ArrayList<Producto> obtenerProductos(){
            
            ArrayList<Producto> lista = new ArrayList<Producto>();
            try {
                abrirConexion();
                String sql = "select * from Productos";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    
                    int id = rs.getInt("idProductos");
                    String descripcion = rs.getString("descripcion");
                    double precio = rs.getInt("Precio");
                    
                    Producto p = new Producto(id, descripcion, precio);
                    
                    lista.add(p);
                }
              rs.close();
                   
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
            }
        
   
          public boolean agregarProducto(Producto producto){
            boolean agregado = false;
            
             try {
                abrirConexion();
                String sql = "INSERT INTO Productos (descripcion,Precio) VALUES(?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, producto.getDescripcionProducto() );
                pst.setDouble(2, producto.getPrecio() );
              
               
               pst.execute();
               agregado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  agregado;
        }
        
        public boolean modificarProducto(Producto producto){
            boolean modificado = false;
            
             try {
                abrirConexion();
                String sql = "UPDATE Productos SET descripcion=?, Precio=? WHERE idProductos=?";
                PreparedStatement pst = con.prepareStatement(sql);
               pst.setString(1, producto.getDescripcionProducto() );
               pst.setDouble(2, producto.getPrecio() );
               pst.setInt(3, producto.getIdProducto() );
               
               pst.executeUpdate();
               modificado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  modificado;
        }
        
        public void eliminarProducto(int id){
            try {
                abrirConexion();
                String sql = "DELETE FROM Productos WHERE idProductos=?";
                PreparedStatement pst = con.prepareStatement(sql);
               
               pst.setInt(1, id );
               
               pst.executeUpdate();
                
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            
                
         
        }
        
        
        
        
         public ArrayList<Pareja> obtenerParejas(){
            
            ArrayList<Pareja> lista = new ArrayList<Pareja>();
            try {
                abrirConexion();
                String sql = "select * from Parejas";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    
                    int id = rs.getInt("id");
                    String descripcion = rs.getString("descripcionPareja");
                    String nombre1 = rs.getString("nombreCompleto1");
                    int dniUno = rs.getInt("dni1");
                    String nombre2 = rs.getString("nombreCompleto2");
                    int dniDos = rs.getInt("dni2");
                    
                    Pareja p = new Pareja(id, descripcion, nombre1, dniUno, nombre2, dniDos);
                    
                    lista.add(p);
                }
              rs.close();
                   
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
            }
         
         
         public boolean agregarPareja(Pareja pareja){
            boolean agregado = false;
            
             try {
                abrirConexion();
                String sql = "INSERT INTO Parejas (descripcionPareja,nombreCompleto1,dni1,nombreCompleto2,dni2) VALUES(?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
               pst.setString(1, pareja.getDescripcionPareja());
               pst.setString(2, pareja.getNombreCompleto1());
               pst.setInt(3, pareja.getDniUno());
               pst.setString(4, pareja.getNombreCompleto2());
               pst.setInt(5, pareja.getDniDos());
              
              
               
               pst.execute();
               agregado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  agregado;
        }
        
         
         public boolean modificarPareja(Pareja pareja){
            boolean modificado = false;
            
             try {
                abrirConexion();
                String sql = "UPDATE Parejas SET descripcionPareja=?, nombreCompleto1=?, dni1=?, nombreCompleto2=?, dni2=? WHERE id=?";
                PreparedStatement pst = con.prepareStatement(sql);
               pst.setString(1, pareja.getDescripcionPareja());
               pst.setString(2, pareja.getNombreCompleto1());
               pst.setInt(3, pareja.getDniUno());
               pst.setString(4, pareja.getNombreCompleto2());
               pst.setInt(5, pareja.getDniDos());
               
               pst.setInt(6, pareja.getId());
               
               pst.executeUpdate();
               modificado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  modificado;
        }
         
         public void eliminarPareja(int id){
            try {
                abrirConexion();
                String sql = "DELETE FROM Parejas WHERE id=?";
                PreparedStatement pst = con.prepareStatement(sql);
               
               pst.setInt(1, id );
               
               pst.executeUpdate();
                
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            
                
         
        }
         
         public Pareja obtenerParejaPorID(int id){
             Pareja pareja = null;
             
             try {
			abrirConexion();
			String sql = "select * from Parejas WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id); 

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String descripcionPareja = rs.getString("descripcionPareja");
				String nombreCompleto1 = rs.getString("nombreCompleto1");
				int dniUno = rs.getInt("dni1");
				String nombreCompleto2 = rs.getString("nombreCompleto2");
				int dniDos = rs.getInt("dni2");
				

				pareja = new Pareja(id, descripcionPareja, nombreCompleto1, dniUno, nombreCompleto2, dniDos);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return pareja;
             
         }
         
         public Producto obtenerProductoPorID(int id){
             Producto producto = null;
             
             try {
			abrirConexion();
			String sql = "select * from Productos WHERE idProductos=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id); 

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String descripcionProducto = rs.getString("descripcion");
                                double precio = rs.getDouble("Precio");
				

				producto = new Producto(id,descripcionProducto, precio);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return producto;
             
         }
         
         public boolean existeUsuario(String username, String password) {
		// comparar el username y password con la base de datos
		// Advertencia:Ojo que las contraseñas deberían estar encriptadas en la BD BCrypt
		if (username.equals("lab") && password.equals("lab")) {
			return true;
		}
		return false;
	}
         
         public boolean agregarDetalleVenta(DetalleVenta detalleVenta){
            boolean agregado = false;
            
             try {
                abrirConexion();
                String sql = " INSERT INTO DetallesVenta(idVentas,idProducto) VALUES (?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, detalleVenta.getVenta().getId() );
                pst.setInt(2, detalleVenta.getProducto().getIdProducto() );
              
               
               pst.execute();
               agregado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  agregado;
        }
         
         public boolean agregarVenta(Venta venta){
            boolean agregado = false;
            
             try {
                abrirConexion();
                String sql = " INSERT INTO Ventas(idPareja,montoTotal) VALUES (?,(select sum (p.Precio ) from Ventas v inner join DetallesVenta dv on  v.idVentas=dv.idVentas inner join Productos p on dv.idProducto=p.idProductos where dv.idVentas=?) )";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, venta.getPareja().getId() );
                pst.setDouble(2, venta.getTotal() );
              
               
               pst.execute();
               agregado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  agregado;
        }
         
         
         public boolean agregarDeposito(Deposito deposito){
            boolean agregado = false;
            
             try {
                abrirConexion();
                String sql = " INSERT INTO DepositosPareja(idPareja,Monto,NombreInvitado) VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, deposito.getPareja().getId() );
                pst.setDouble(2, deposito.getMontoDeposito() );
                pst.setString(3, deposito.getNombreInvitado());
              
               
               pst.execute();
               agregado = true;  
                            
                
            } catch (SQLException ex) {
                	ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
            return  agregado;
        }
         
         
}
