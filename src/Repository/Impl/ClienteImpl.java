package Repository.Impl;

import Model.Cliente;
import Repository.DAO.ClienteDAO;
import Util.DBconnection;
import Util.EstadoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteImpl implements ClienteDAO {
    @Override
    public boolean actividadCliente(String id) {
        String sql = """
                SELECT estado FROM `Clientes`
                WHERE identificacion = ?
                ;
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String actividad =resultSet.getString("estado");
                if (actividad.equals("Activo")){
                    return true;
                }else {
                    System.out.println("**CUENTA INACTIVA**");
                    return false;
                }
            }
            System.out.println("No existe persona con tal identificacion en el sistema");
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Cliente getClienteById(String identificacion) {
        String sql = """
                SELECT * FROM `Clientes`
                WHERE identificacion = ?
                ;
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, identificacion);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id =resultSet.getInt("id");
                String nombre =resultSet.getString("nombre");
                String apellido =resultSet.getString("apellido");
                String direccion =resultSet.getString("direccion");
                String telefono =resultSet.getString("telefono");
                String correo =resultSet.getString("correo");
                String estado =resultSet.getString("estado");
                String fechaRegistro =resultSet.getString("fecha_registro");
                String fechaUltimaActividad =resultSet.getString("ultima_actividad");

                EstadoCliente estadoFinal = EstadoCliente.valueOf(estado);
                Cliente cliente = new Cliente(id,identificacion,nombre,apellido,direccion,telefono,correo,estadoFinal,fechaRegistro,fechaUltimaActividad);
                System.out.println("ENCONTRADO");
                return cliente;
            }
            System.out.println("No existe persona con tal identificacion en el sistema");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String getIdentificacionCliente(int id) {
        String sql = """
                select identificacion FROM `Clientes` WHERE id = ?;
                
                """;
        try (Connection connection = DBconnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("identificacion");
            }
            System.out.println("No existe persona con tal identificacion en el sistema");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
