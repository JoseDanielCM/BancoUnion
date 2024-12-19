package Main;

import Menus.Cheque.AgregarCheque;
import Util.DBconnection;
import Util.ProcesamientoChequesPendientes;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBconnection.getConnection();
        Scanner tecladito = new Scanner(System.in);
        while (true){
            System.out.println("------------------------------------- CHEQUES ----------------------------------------");
            System.out.println("DESEAS INGRESAR A \nModulo 1 -> Agregar Cheque\nOpcion 2 -> Realizar Reportes de cheques procesados");
            String opcion = tecladito.nextLine();

            switch (opcion){
                case "1":
                    AgregarCheque.mostrarMenu();
                    break;
                case "2":
                    ProcesamientoChequesPendientes procesamientoChequesPendientes = new ProcesamientoChequesPendientes();
                    Thread hiloProcesamiento = new Thread(procesamientoChequesPendientes);
                    hiloProcesamiento.run();
            }
        }


    }
}
