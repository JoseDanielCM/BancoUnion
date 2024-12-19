package Util;

import Model.Cheque;
import Model.Cliente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteProcesado {

    public static void crearArchivo (String extraPath) throws IOException {
        String PATH = "src/REPORTES/"+extraPath;
        File file = new File(PATH);
        file.createNewFile();
    }
    public static void escribir(String extraPath, Cliente cliente, Cheque cheque, String estado, String razon) throws IOException {
        String PATH = "src/REPORTES/"+extraPath;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH,true))) {
            String linea;
            bufferedWriter.write("\nCheque ID "+cheque.getNumCheque());
            bufferedWriter.write("\nCliente: "+cliente.getName()+" "+cliente.getLastName());
            bufferedWriter.write("\nMonto: "+cheque.getMonto());
            bufferedWriter.write("\nEstado: "+estado);
            bufferedWriter.write("\nRazon: "+razon);
            bufferedWriter.write("\n--------------------------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}
