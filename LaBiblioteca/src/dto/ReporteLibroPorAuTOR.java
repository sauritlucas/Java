
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class ReporteLibroPorAuTOR {
    public String nombreAutor;
    public String nacionalidad;
    public String nombreLibro;

    public ReporteLibroPorAuTOR(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public ReporteLibroPorAuTOR(String nombreAutor, String nacionalidad, String nombreLibro) {
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
        this.nombreLibro = nombreLibro;
    }

    @Override
    public String toString() {
        return  nombreAutor + ", nacionalidad=" + nacionalidad + ", nombreLibro=" + nombreLibro ;
    }
    
    
    
    
}
