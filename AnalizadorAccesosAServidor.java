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
        String paginaWebMasAccesos = null;
        HashMap<String, Integer> urlsYAccesos = new HashMap<>();
        int numeroAccesosUrl = 0;
        if(accesos.size() > 0){
            for(Acceso urlActual : accesos){
                String urlAcceso = urlActual.getUrl();

                if(urlsYAccesos.get(urlAcceso) == null){
                    urlsYAccesos.put(urlAcceso, 1);
                }
                else{
                    urlsYAccesos.replace(urlAcceso, urlsYAccesos.get(urlAcceso) + 1);                    
                }

                if(urlsYAccesos.get(urlAcceso) > numeroAccesosUrl){
                    paginaWebMasAccesos = urlAcceso;
                    numeroAccesosUrl = urlsYAccesos.get(urlAcceso);
                }
            }
        }
        else{
            System.out.println("Ocurrio algun error al leer el archivo, no hay datos que procesar.");
        }
        return paginaWebMasAccesos;
    }

    /**
     * Cliente con mas accesos exitosos
     * 
     * @return ipMasAccesosExitosos, ip con mas accesos exitosos
     */
    public String clienteConMasAccesosExitosos()
    {
        String ipMasAccesosExitosos = null;
        ArrayList<Acceso> ipsBuenas = new ArrayList<>();
        HashMap<String, Integer> ipsYAccesos = new HashMap<>();
        int vecesRepetidaIp = 0;
        int ipMayor = 0;
        for(Acceso acceso : accesos){
            if(acceso.getCodigo() < 400){
                ipsBuenas.add(acceso);
            }
        }
        if(ipsBuenas.size() > 0){
            for(Acceso ipActual : ipsBuenas){
                String ipAcceso = ipActual.getIp();
                if(ipsYAccesos.get(ipAcceso) == null){
                    ipsYAccesos.put(ipAcceso, 1);
                }
                else{
                    ipsYAccesos.replace(ipAcceso, ipsYAccesos.get(ipAcceso) + 1);
                }
                int cuartoOcteto = Integer.parseInt(ipAcceso.split("\\.")[3]);
                int numeroConexiones = ipsYAccesos.get(ipAcceso);
                if(numeroConexiones > vecesRepetidaIp || (numeroConexiones == vecesRepetidaIp && cuartoOcteto > ipMayor)){
                    vecesRepetidaIp = numeroConexiones;
                    ipMayor = cuartoOcteto;
                    ipMasAccesosExitosos = ipAcceso;
                }
            }
        }
        else{
            System.out.println("Ocurrio algun error al leer el archivo, no hay datos que procesar.");
        }
        return ipMasAccesosExitosos;
    }
}