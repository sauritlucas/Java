//
package modelo;


public class Deposito {
    int idDeposito;
    Pareja pareja;
    double montoDeposito;
    String nombreInvitado;

    public String getNombreInvitado() {
        return nombreInvitado;
    }

    public void setNombreInvitado(String nombreInvitado) {
        this.nombreInvitado = nombreInvitado;
    }
    
    

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    public double getMontoDeposito() {
        return montoDeposito;
    }

    public void setMontoDeposito(double montoDeposito) {
        this.montoDeposito = montoDeposito;
    }

    public Deposito(int idDeposito, Pareja pareja, double montoDeposito) {
        this.idDeposito = idDeposito;
        this.pareja = pareja;
        this.montoDeposito = montoDeposito;
    }

    public Deposito(Pareja pareja, double montoDeposito) {
        this.pareja = pareja;
        this.montoDeposito = montoDeposito;
    }

    public Deposito(Pareja pareja, double montoDeposito, String nombreInvitado) {
        this.pareja = pareja;
        this.montoDeposito = montoDeposito;
        this.nombreInvitado = nombreInvitado;
    }
    
    
    
    
    
}
