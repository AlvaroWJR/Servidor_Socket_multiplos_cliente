
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Servidor extends Thread {
    private static int contadorCliente = 0;
    private Socket con;
    private BufferedReader in;
    private PrintWriter out;

    public Servidor(Socket socket) {
        try {
            con = socket;
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            out = new PrintWriter(con.getOutputStream(), true);
            contadorCliente++;
            System.out.println("um novo randola entrou.Total de randolas: " + contadorCliente);
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }

    public void run() {
        try {
            out.println("Morram todos!"); //Escreve ao cliente
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }
}
