package Repository.Impl;

import Model.Cheque;
import Model.Cliente;
import Model.Cuenta;
import Repository.DAO.ChequeDAO;
import Util.DBconnection;
import Util.EstadoCheque;
import Util.PrioridadCheque;
import Util.RazonRechazoCheque;
import com.mysql.cj.protocol.x.XMessage;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChequeImpl implements ChequeDAO {

    @Override
    public boolean emitirCheque(Cuenta cuenta, String beneficiario, double monto, PrioridadCheque prioridadCheque, String firmaDigital, double cuentaSaldoMomento) {

        String sql = """
                INSERT INTO Cheques (id_cuenta, beneficiario, monto, monto_letras, prioridad, firma_digital, estado, fecha_emision, cuenta_saldo_momento)
                VALUES
                (?, ?, ?, ?, ?, ?, "Pendiente", CURDATE(),?);
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cuenta.getIdCuenta()  );
            preparedStatement.setString(2, beneficiario);
            preparedStatement.setDouble(3, monto);
            preparedStatement.setString(4, "FALTA MONTO PRIORIDAD");
            preparedStatement.setString(5, String.valueOf(prioridadCheque));
            preparedStatement.setString(6, firmaDigital);
            preparedStatement.setDouble(7, cuentaSaldoMomento);

            preparedStatement.executeUpdate();
            System.out.println("CHEQUE AGREGADO CORRECTAMENTE");
        } catch (Exception e) {
            e.getMessage();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Cheque leerNumeroCheque(Cuenta cuenta, String beneficiario, double monto) {
        String sql = """
                SELECT * from `Cheques` WHERE id_cuenta = ? AND beneficiario = ? AND monto=?;
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cuenta.getIdCuenta()  );
            preparedStatement.setString(2, beneficiario);
            preparedStatement.setDouble(3, monto);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String numCheque = resultSet.getString("numero_cheque");
                String fechaEmision = resultSet.getString("fecha_emision");
                String montoLetras = resultSet.getString("monto_letras");
                String firmaDigital = resultSet.getString("firma_digital");
                Cheque cheque = new Cheque(numCheque,fechaEmision,beneficiario,monto,montoLetras,firmaDigital);
                return cheque;
            }
            System.out.println("No se encontro cheque con esas caracteristicas");

        } catch (Exception e) {
            e.getMessage();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String mostrarFechaActual() {
        String sql = """
                SELECT NOW();
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("NOW()");
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<Cheque> listaChequesPendientes() {
        String sql = """
                SELECT * from `Cheques` WHERE estado = "Pendiente";
             """;
        List<Cheque> listaAlta = new ArrayList<Cheque>();
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String numCheque = resultSet.getString("numero_cheque");
                String prioridad = resultSet.getString("prioridad");
                double monto = resultSet.getDouble("monto");
                int id_cuenta = resultSet.getInt("id_cuenta");

                PrioridadCheque prioridadCheque = PrioridadCheque.valueOf(prioridad);
                Cheque cheque = new Cheque(numCheque,prioridadCheque,monto,id_cuenta);
                listaAlta.add(cheque);
            }
            return listaAlta;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void cambiarEstadoCheque(String idCheque, String estado) {
        String sql = """
                UPDATE `Cheques` SET estado = ?, fecha_proceso = NOW() WHERE numero_cheque = ?;
          """;
        List<Cheque> listaAlta = new ArrayList<Cheque>();
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,estado);
            preparedStatement.setString(2,idCheque);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
        }
    }


}
