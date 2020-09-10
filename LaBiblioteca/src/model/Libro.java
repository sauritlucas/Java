
package model;


public class Libro {
   private int id_libro;
   private String descripcion;
   private String tipoPrestamo;
   private Autor autor;
   // este ultimo atributo me es util a la hora de modificar un registro existente
   private int idAutor;

   // Constructor Convencional
    public Libro(int id_libro, String descripcion, String tipoPrestamo, Autor autor) {
        this.id_libro = id_libro;
        this.descripcion = descripcion;
        this.tipoPrestamo = tipoPrestamo;
        this.autor = autor;
    }
    
    // Constructor utilizado en la VentanaAgregrarLibro para poder manipular el indice que me devuele el cboAutor
    // Al no devolverme un objeto AUTOR el cboaAutor, el Constructor Convencional carece de utilidad
    //Todo esto con el fin de poder modificar un registro existente
    public Libro(int id_libro, String descripcion, String tipoPrestamo, int idAutor) {
        this.id_libro = id_libro;
        this.descripcion = descripcion;
        this.tipoPrestamo = tipoPrestamo;
        this.idAutor = idAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    
    
    
    public Libro( String descripcion, String tipoPrestamo, Autor autor) {
        this.id_libro = -1;
        this.descripcion = descripcion;
        this.tipoPrestamo = tipoPrestamo;
        this.autor = autor;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
   
   
   
   
}
