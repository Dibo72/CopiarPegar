import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class CopiarPegar {
    public static void main(String[] args) {

        System.out.println("Archivo 2");
        try (BufferedReader lector2 = new BufferedReader(new FileReader("Archivo2.txt"))) {
            String linea;
            while ((linea = lector2.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo Archivo2");
        }

        try (
                BufferedReader lector1 = new BufferedReader(new FileReader("Archivo.txt"));
                BufferedWriter escritor = new BufferedWriter(new FileWriter("Archivo2.txt"))
        ) {
            String linea;
            System.out.println();
            System.out.println("Archivo 1");
            while ((linea = lector1.readLine()) != null) {
                System.out.println(linea);
                escritor.write(linea);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error copiando archivos");
        }

        System.out.println();
        System.out.println("Archivo 2 copiado");
        try (BufferedReader lector2 = new BufferedReader(new FileReader("Archivo2.txt"))) {
            String linea;
            while ((linea = lector2.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo Archivo2");
        }
    }
}