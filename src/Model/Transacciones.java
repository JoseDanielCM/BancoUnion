package Model;

import Util.EstadoTransaccion;
import Util.TipoTransaccion;

public class Transacciones {
    private int idTransaccion;
    private int idCuenta;
    private TipoTransaccion tipo;
    private double monto;
    private String fecha;
    private String referencia;
    private double saldoAnterior;
    private double saldoNuevo;
    private EstadoTransaccion estado;

    public Transacciones(int idTransaccion, int idCuenta, TipoTransaccion tipo, double monto, String fecha, String referencia, double saldoAnterior, double saldoNuevo, EstadoTransaccion estado) {
        this.idTransaccion = idTransaccion;
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.referencia = referencia;
        this.saldoAnterior = saldoAnterior;
        this.saldoNuevo = saldoNuevo;
        this.estado = estado;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoNuevo() {
        return saldoNuevo;
    }

    public void setSaldoNuevo(double saldoNuevo) {
        this.saldoNuevo = saldoNuevo;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }
}
