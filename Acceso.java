/**
 * Clase Acceso. 
 * Crea objetos Acceso obteniendo cada acceso mediante un parametro.
 * 
 * @author Julio Cachón Villadangos
 * @version 06/03/2018
 */
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String ip;
    private String url;
    private int codigo;

    /**
     * Contructor para la clase Acceso
     * 
     * @param fecha recibe cada una de las lineas del archivo log
     */
    public Acceso(String fecha)
    {
        String[] arrayLogs = fecha.split(" ");

        ip = arrayLogs[0];

        ano = Integer.parseInt(arrayLogs[1].substring(1, arrayLogs[1].length()));
        mes = Integer.parseInt(arrayLogs[2]);
        dia = Integer.parseInt(arrayLogs[3]);
        hora = Integer.parseInt(arrayLogs[4]);
        minutos = Integer.parseInt(arrayLogs[5].substring(0, arrayLogs[5].length() -1));

        url = arrayLogs[6];
        codigo = Integer.parseInt(arrayLogs[7]);
    }

    /**
     * Devuelve el año
     * 
     * @return el año como entero
     */
    public int getAno() 
    {
        return ano;
    }

    /**
     * Devuelve el mes
     * 
     * @return el mes como entero
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * Devuelve el dia
     * 
     * @return el dia como entero
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * Devuelve la hora
     * 
     * @return la hora como entero
     */
    public int getHora()
    {
        return hora;
    }

    /**
     * Devuelve los minutos
     * 
     * @return los minutos como entero
     */
    public int getMinutos()
    {
        return minutos;
    }

    /**
     * Devuelve la ip
     * 
     * @return la ip como cadena
     */
    public String getIp()
    {
        return ip;
    }

    /**
     * Devuelve la url
     * 
     * @return la url como cadena
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Devuelve el codigo
     * 
     * @return el codigo como entero
     */
    public int getCodigo()
    {
        return codigo;
    }
}