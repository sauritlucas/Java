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
public class Pareja {
    int id;
    String descripcionPareja;
    String nombreCompleto1;
    int dniUno;
    String nombreCompleto2;
    int dniDos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionPareja() {
        return descripcionPareja;
    }

    public void setDescripcionPareja(String descripcionPareja) {
        this.descripcionPareja = descripcionPareja;
    }

    public String getNombreCompleto1() {
        return nombreCompleto1;
    }

    public void setNombreCompleto1(String nombreCompleto1) {
        this.nombreCompleto1 = nombreCompleto1;
    }

    public int getDniUno() {
        return dniUno;
    }

    public void setDniUno(int dniUno) {
        this.dniUno = dniUno;
    }

    public String getNombreCompleto2() {
        return nombreCompleto2;
    }

    public void setNombreCompleto2(String nombreCompleto2) {
        this.nombreCompleto2 = nombreCompleto2;
    }

    public int getDniDos() {
        return dniDos;
    }

    public void setDniDos(int dniDos) {
        this.dniDos = dniDos;
    }

    public Pareja(String descripcionPareja, String nombreCompleto1, int dniUno, String nombreCompleto2, int dniDos) {
        this.descripcionPareja = descripcionPareja;
        this.nombreCompleto1 = nombreCompleto1;
        this.dniUno = dniUno;
        this.nombreCompleto2 = nombreCompleto2;
        this.dniDos = dniDos;
    }

    public Pareja(int id, String descripcionPareja, String nombreCompleto1, int dniUno, String nombreCompleto2, int dniDos) {
        this.id = id;
        this.descripcionPareja = descripcionPareja;
        this.nombreCompleto1 = nombreCompleto1;
        this.dniUno = dniUno;
        this.nombreCompleto2 = nombreCompleto2;
        this.dniDos = dniDos;
    }

    public Pareja() {
    }
    

    @Override
    public String toString() {
        return "Pareja{" + "id=" + id + ", descripcionPareja=" + descripcionPareja + ", nombreCompleto1=" + nombreCompleto1 + ", dniUno=" + dniUno + ", nombreCompleto2=" + nombreCompleto2 + ", dniDos=" + dniDos + '}';
    }
    
    
}
