package Repository.DAO;

import Model.Cliente;

public interface ClienteDAO {
    boolean actividadCliente(String id);

    Cliente getClienteById(String id);

    String getIdentificacionCliente(int id);
}
