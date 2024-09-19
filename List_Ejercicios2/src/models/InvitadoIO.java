package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InvitadoIO {
    private static final String ARCHIVO_INVITADOS = "Invitados.txt";

    public InvitadoIO() {
        crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        File archivo = new File(ARCHIVO_INVITADOS);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo: " + e.getMessage());
            }
        }
    }

    public void guardarInvitado(Invitado invitado) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_INVITADOS, true))) {
            writer.write(invitado.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Error al guardar el invitado en el archivo.");
        }
    }

    public void leerInvitados() throws FileNotFoundException {
        File archivo = new File(ARCHIVO_INVITADOS);
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        }
    }
}
