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
public class Venta {
    int id;
    Pareja pareja;
    double Total;
    double EfectivoCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getEfectivoCliente() {
        return EfectivoCliente;
    }

    public void setEfectivoCliente(double EfectivoCliente) {
        this.EfectivoCliente = EfectivoCliente;
    }

    public Venta(int id, Pareja pareja, double Total, double EfectivoCliente) {
        this.id = id;
        this.pareja = pareja;
        this.Total = Total;
        this.EfectivoCliente = EfectivoCliente;
    }

    public Venta(int id, Pareja pareja, double Total) {
        this.id = id;
        this.pareja = pareja;
        this.Total = Total;
    }
    
    
    
}
