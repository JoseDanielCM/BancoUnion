package Repository.DAO;

import Model.Cheque;
import Model.Cliente;
import Model.Cuenta;
import Util.EstadoCheque;
import Util.PrioridadCheque;
import Util.RazonRechazoCheque;

import java.util.List;

public interface ChequeDAO {
    // REQ: Patrones de diseño
    boolean emitirCheque(Cuenta cuenta, String beneficiario, double monto, PrioridadCheque prioridadCheque, String firmaDigital, double cuentaSaldoMomento);

    Cheque leerNumeroCheque(Cuenta cuenta, String beneficiario, double monto);

    String mostrarFechaActual();

    List<Cheque> listaChequesPendientes();

    void cambiarEstadoCheque(String idCheque, String estado);


}
