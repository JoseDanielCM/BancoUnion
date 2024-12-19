package Util;

import Model.Cheque;
import Model.Cliente;
import Model.Cuenta;
import Repository.Impl.ChequeImpl;
import Repository.Impl.ClienteImpl;
import Repository.Impl.CuentaImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProcesamientoChequesPendientes implements Runnable {

    private ChequeImpl chequeImpl = new ChequeImpl();
    private CuentaImpl cuentaImpl = new CuentaImpl();
    private ClienteImpl clienteImpl = new ClienteImpl();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            // lista num cheque < 1010;
            // REQ : USO STREAM API
            List<Cheque> listaCheques = chequeImpl.listaChequesPendientes();
            List<Cheque> listaAlta = listaCheques.stream().filter(cheque -> cheque.getPrioridad() == PrioridadCheque.Alta ).toList();
            List<Cheque> listaMedia = listaCheques.stream().filter(cheque -> cheque.getPrioridad() == PrioridadCheque.Media ).toList();;
            List<Cheque> listaBaja = listaCheques.stream().filter(cheque -> cheque.getPrioridad() == PrioridadCheque.Baja ).toList();;
            String fechaArchivo = chequeImpl.mostrarFechaActual();
            try {
                ReporteProcesado.crearArchivo(fechaArchivo+"-procesado-cheques.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (Cheque cheque: listaAlta){
                Cuenta cuenta = cuentaImpl.getCuentaById(cheque.getIdCuenta());
                String identificacionCliente = clienteImpl.getIdentificacionCliente(cuenta.getIdCliente());
                Cliente cliente = clienteImpl.getClienteById(identificacionCliente);
                if (cuenta.getSaldo()<= cheque.getMonto()){
                    chequeImpl.cambiarEstadoCheque(cheque.getNumCheque(),"Rechazado");
                    try {
                        ReporteProcesado.escribir(fechaArchivo+"-procesado-cheques.txt",cliente,cheque,"Rechazado","El monto del cheque es menor al saldo de la cuenta");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    chequeImpl.cambiarEstadoCheque(cheque.getNumCheque(),"Procesado");
                    try {
                        ReporteProcesado.escribir(fechaArchivo+"-procesado-cheques.txt",cliente,cheque,"Procesado","-");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("PROCESANDO CHEQUES....");
                Thread.sleep(2000);

            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

