package Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteChequesEmitidos {
    public static void escribir(String extraPath,String emisor, String beneficiario, String monto, String prioridad) throws IOException {
        String PATH = "src/REPORTES/"+extraPath;
        File file = new File(PATH);
        file.createNewFile();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH,true))) {
            String linea;
            bufferedWriter.write("Emisor: "+emisor);
            bufferedWriter.write("\nBeneficiario: "+beneficiario);
            bufferedWriter.write("\nMonto: "+monto);
            bufferedWriter.write("\nPrioridad: "+prioridad);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}

