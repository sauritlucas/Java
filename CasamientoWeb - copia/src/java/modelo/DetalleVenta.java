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
public class DetalleVenta {
    int id;
    Venta venta;
    Producto producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    

    public DetalleVenta(int id, Venta venta, Producto producto) {
        this.id = id;
        this.venta = venta;
        this.producto = producto;
    }
    
    
    
    
}
