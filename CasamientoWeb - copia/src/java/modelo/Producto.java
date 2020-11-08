/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author luqqa
 */
public class Producto {
    private int idProducto;
    private String descripcionProducto;
    private double precio;

    public Producto(String descripcionProducto, double precio) {
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
    }

    public Producto(int idProducto, String descripcionProducto, double precio) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", descripcionProducto=" + descripcionProducto + ", precio=" + precio + '}';
    }
    
    
    
}
