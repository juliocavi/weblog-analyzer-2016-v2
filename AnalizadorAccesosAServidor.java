import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase AnalizadorAccesosAServidor, analiza los archivos logs 
 * y los agrega a un array
 * 
 * @author Julio Cachón Villadangos
 * @version 06/03/2018
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;

    /**
     * Constructor de la clase AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }

    /**
     * Analizar cada linea de los archivos log 
     */
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();
                Acceso accesoActual = new Acceso(lineaLeida);
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }

    /**
     * Obtener la fecha con mas accesos
     * 
     * @return aDevolver la hora con mas accesos
     */
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;

        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];

            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }

            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }

            valorADevolver = horaDeAccesosMasAlto;                      
        }

        return valorADevolver;
    }

    /**
     * Devuelve la pagina web mas solicitada
     * 
     * @return paginaWebMasAccesos, web mas solicitada
     */
    public String paginaWebMasSolicitada() 
    {
        return "";
    }

    /**
     * Cliente con mas accesos exitosos
     * 
     * @return ipMasAccesosExitosos, ip con mas accesos exitosos
     */
    public String clienteConMasAccesosExitosos()
    {
        return "";
    }
}