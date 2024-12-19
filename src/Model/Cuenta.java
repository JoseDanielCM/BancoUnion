package Model;

import Util.EstadoCuenta;
import Util.TipoPersona;

public class Cuenta {
    private int idCuenta;
    private int idCliente;
    private TipoPersona tipo;
    private double saldo;
    private double limiteSaldo;
    private String fechaApertura;
    private EstadoCuenta estado;

    public Cuenta(int idCuenta, int idCliente, TipoPersona tipo, double saldo, double limiteSaldo, String fechaApertura, EstadoCuenta estado) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limiteSaldo = limiteSaldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public TipoPersona getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteSaldo() {
        return limiteSaldo;
    }

    public void setLimiteSaldo(double limiteSaldo) {
        this.limiteSaldo = limiteSaldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }
}
