package Menus.Cheque;

import Model.Cheque;
import Model.Cliente;
import Model.Cuenta;
import Repository.Impl.ChequeImpl;
import Repository.Impl.ClienteImpl;
import Repository.Impl.CuentaImpl;
import Util.PrioridadCheque;
import Util.WriteChequesEmitidos;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class AgregarCheque {
    public static boolean mostrarMenu(){
        ClienteImpl clienteImpl = new ClienteImpl();
        ChequeImpl chequeImpl = new ChequeImpl();
        CuentaImpl cuentaImpl = new CuentaImpl();

        Scanner tecladito = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Ingresa tu identificacion");
        String idCliente = tecladito.nextLine();
        System.out.println("Ingresa el id de tu cuenta");
        int idCuenta = tecladito.nextInt();

        boolean activo = clienteImpl.actividadCliente(idCliente);
        if (!activo){
            System.out.println("El cliente posee cuenta inactiva o no posee cuenta no es posible realizar acciones");
            return false;
        }

            Cliente cliente = clienteImpl.getClienteById(idCliente);
            Cuenta cuenta = cuentaImpl.getCuentaById(idCuenta);

        if (cliente.getId()!=cuenta.getIdCliente()){
            System.out.println("El cliente no corresponde a la cuenta ingresada");
            return false;
        }else {
            System.out.println("CLIENTE Y CUENTA VINCULADOS CORRECTAMENTE");
        }

        System.out.println("Ingresa el monto a hacer el cheque ");
            double monto = tecladito.nextDouble();
        if (monto>cuenta.getSaldo()){
            System.out.println("El monto a realizar cheque es mayor al saldo disponible en la cuenta");
            return false;
        }

        System.out.println("Ingresa nombre del beneficiario del cheque");
            tecladito.nextLine();
            String beneficiario = tecladito.nextLine();
        System.out.println("Ingresa el nivel de prioridad del cheque\n 1 -> Alta\n2 -> Media\n3 -> Baja");
        String prioridad = tecladito.nextLine();
            PrioridadCheque prioridadCheque = PrioridadCheque.Baja;
        switch (prioridad){
            case ("1"):
                prioridadCheque = PrioridadCheque.Alta;
                break;
            case ("2"):
                prioridadCheque = PrioridadCheque.Media;
                break;
            case ("3"):
                prioridadCheque = PrioridadCheque.Baja;
                break;
        }
        System.out.println("Escriba su firma digital");
        String firmaDigital = tecladito.nextLine();
        chequeImpl.emitirCheque(cuenta,beneficiario,monto,prioridadCheque,firmaDigital,cuenta.getSaldo());
        Cheque cheque = chequeImpl.leerNumeroCheque(cuenta,beneficiario,monto);
        System.out.println("----------------------------------------------------------------");
        System.out.println("BANCO UNION S.A");
        System.out.println("CHEQUE No : "+cheque.getNumCheque());
        System.out.println("Fecha "+cheque.getFechaEmision());
        System.out.println("\nPaguese A "+cheque.getBeneficiario());
        System.out.println("LA SUMA DE "+cheque.getMonto());
        System.out.println("\nFIRMA DIGITAL "+cheque.getFirmaDigital());
        System.out.println("----------------------------------------------------------------");

        try {
            WriteChequesEmitidos.escribir(chequeImpl.mostrarFechaActual()+"-emision-cheques.txt",cliente.getName()+" "+cliente.getLastName(),beneficiario, String.valueOf(monto),prioridadCheque.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

