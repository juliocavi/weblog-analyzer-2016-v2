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

    /**
     * Contructor para la clase Acceso
     * 
     * @param fecha recibe cada una de las lineas del archivo log
     */
    public Acceso(String fecha)
    {
        String[] arrayLogs = fecha.split(" ");

        ano = Integer.parseInt(arrayLogs[0]);
        mes = Integer.parseInt(arrayLogs[1]);
        dia = Integer.parseInt(arrayLogs[2]);
        hora = Integer.parseInt(arrayLogs[3]);
        minutos = Integer.parseInt(arrayLogs[4]);

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
}