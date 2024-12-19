package Repository.Impl;

import Model.Cliente;
import Model.Cuenta;
import Repository.DAO.CuentaDAO;
import Util.DBconnection;
import Util.EstadoCliente;
import Util.EstadoCuenta;
import Util.TipoPersona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaImpl implements CuentaDAO {
    @Override
    public Cuenta getCuentaById(int id) {
        String sql = """
                SELECT * FROM `Cuentas`
                WHERE id = ?
                ;
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id_cliente =resultSet.getInt("id_cliente");
                String tipo =resultSet.getString("tipo");
                double saldo =resultSet.getDouble("saldo");
                double limite_saldo =resultSet.getDouble("limite_saldo");
                String fecha_apertura =resultSet.getString("fecha_apertura");
                String estado =resultSet.getString("estado");

                EstadoCuenta estadoCuenta = EstadoCuenta.valueOf(estado);
                TipoPersona tipoPersona = TipoPersona.valueOf(tipo);
                Cuenta cuenta = new Cuenta(id,id_cliente,tipoPersona,saldo,limite_saldo,fecha_apertura,estadoCuenta);
                return cuenta;
            }
            System.out.println("No existe persona con tal identificacion en el sistema");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
