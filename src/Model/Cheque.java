package Model;

import Util.EstadoCheque;
import Util.PrioridadCheque;
import Util.RazonRechazoCheque;

public class Cheque {
    private String numCheque;
    private int idCuenta;
    private String beneficiario;
    private double monto;
    private String montoLetras;
    private PrioridadCheque prioridad;
    private String firmaDigital;
    private EstadoCheque estado;
    private RazonRechazoCheque razonRechazo;
    private String fechaEmision;
    private String fechaProceso;
    private boolean cobrado;
    private double cuentaSaldoMomento;
    private String fechaModificacion;
    private String usuarioModificacion;

    public Cheque(String numCheque, int idCuenta, String beneficiario, double monto, String montoLetras, PrioridadCheque prioridad, String firmaDigital, EstadoCheque estado, RazonRechazoCheque razonRechazo, String fechaEmision, String fechaProceso, boolean cobrado, double cuentaSaldoMomento, String fechaModificacion, String usuarioModificacion) {
        this.numCheque = numCheque;
        this.idCuenta = idCuenta;
        this.beneficiario = beneficiario;
        this.monto = monto;
        this.montoLetras = montoLetras;
        this.prioridad = prioridad;
        this.firmaDigital = firmaDigital;
        this.estado = estado;
        this.razonRechazo = razonRechazo;
        this.fechaEmision = fechaEmision;
        this.fechaProceso = fechaProceso;
        this.cobrado = cobrado;
        this.cuentaSaldoMomento = cuentaSaldoMomento;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    public Cheque(String numCheque,String fechaEmision, String beneficiario, double monto, String montoLetras, String firmaDigital) {
        this.numCheque = numCheque;
        this.fechaEmision = fechaEmision;
        this.beneficiario = beneficiario;
        this.monto = monto;
        this.montoLetras = montoLetras;
        this.firmaDigital = firmaDigital;
    }

    public Cheque(String numCheque,PrioridadCheque prioridadCheque, double monto, int idCuenta) {
        this.numCheque = numCheque;
        this.prioridad = prioridadCheque;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMontoLetras() {
        return montoLetras;
    }

    public void setMontoLetras(String montoLetras) {
        this.montoLetras = montoLetras;
    }

    public PrioridadCheque getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadCheque prioridad) {
        this.prioridad = prioridad;
    }

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public EstadoCheque getEstado() {
        return estado;
    }

    public void setEstado(EstadoCheque estado) {
        this.estado = estado;
    }

    public RazonRechazoCheque getRazonRechazo() {
        return razonRechazo;
    }

    public void setRazonRechazo(RazonRechazoCheque razonRechazo) {
        this.razonRechazo = razonRechazo;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public double getCuentaSaldoMomento() {
        return cuentaSaldoMomento;
    }

    public void setCuentaSaldoMomento(double cuentaSaldoMomento) {
        this.cuentaSaldoMomento = cuentaSaldoMomento;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Override
    public String toString() {
        return "Cheque{" +
                "numCheque='" + numCheque + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}
