package Models.PersonaModel;

/*    
 *    Se asemeja a una persona
 *  -----------------------------------
 *    @author Moises Reyes
 *    @version 1.0
 */

public class Persona {

    /*    
     *    La persona será identificada por
     *       los siguientes atributos:
     *  ----------------------------------------------------------------------------
     *    @param id               --> el identificador, es un valor numérico
     *                                entero que no se repite y se autoincrementa.
     *    @param totalPersonas    --> el total de personas registradas
     *    @param dia, mes, año    --> fecha de nacimiento.
     *    @param nombre, apellido --> nombre y apellido.
     */

    private Integer id, dia, mes, año;
    private static Integer totalPersonas;
    private String nombre, apellido;

    /*     
     *     Método Constructor
     *  Inicializando los atributos
     */

    public Persona() {
        id            = 1;
        totalPersonas = 0;
        dia           = 0;
        mes           = 0;
        año           = 0;
        nombre        = "";
        apellido      = "";
    }

    /*    
     *  Getters and Setters
     */

    // ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Apellido
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Día
    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    // Mes
    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    // Año
    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    // Total de personas
    public static Integer getTotalPersonas() {
        return totalPersonas;
    }

    public static void setTotalPersonas(Integer totalPersonas) {
        Persona.totalPersonas = totalPersonas;
    }

    // Comprobar si el tamaño del array llegó al tope
    public static boolean limiteExcedidoArray(Integer maximo) {
        boolean resultado = (Persona.totalPersonas == maximo) ? true : false;
        return resultado;
    }
}
