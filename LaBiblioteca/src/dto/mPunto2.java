
package dto;


public class mPunto2 {
    public String descripcion;
    public String nombreAutor;
    public String nacionalidad;

    public mPunto2(String descripcion, String nombreAutor, String nacionalidad) {
        this.descripcion = descripcion;
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return  descripcion + ", nombreAutor=" + nombreAutor + ", nacionalidad=" + nacionalidad ;
    }
    
    
}
