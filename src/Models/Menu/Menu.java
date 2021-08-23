package Models.Menu;

import java.util.*;

public final class Menu {
    /*    
     *    Menú de opciones
     *  -----------------------------------
     *    @author Moises Reyes
     *    @version 1.0
     */

    private char opcion, opcionDos;
    public Map<String, String> coloresTexto;

    /*    
     *  Inicializando los atributos
     */

    public Menu() {
        opcion       = '\0';
        opcionDos    = '\0';
        // Creando la instancia del mapa
        coloresTexto = new HashMap<String, String>();
        // @param hash, @param value
        coloresTexto.put("negro", "\033[30m");
        coloresTexto.put("rojo", "\033[31m");
        coloresTexto.put("verde", "\033[32m");
        coloresTexto.put("amarillo", "\033[33m");
        coloresTexto.put("azul", "\033[34m");
        coloresTexto.put("magenta", "\033[35m");
        coloresTexto.put("blanco", "\033[37m");
        coloresTexto.put("cyan", "\033[36m");
        coloresTexto.put("reset", "\u001B[0m");
    }
    
    /*    
     *  Get and Set
     */

    // Opción 1
    public char getOpcion() {
        return opcion;
    }

    public void setOpcion(char opcion) {
        this.opcion = opcion;
    }

    // Opción 2
    public char getOpcionDos() {
        return opcionDos;
    }

    public void setOpcionDos(char opcionDos) {
        this.opcionDos = opcionDos;
    }

    /*
     *        Imprime el menú de opciones
     *  ---------------------------------------------
     *  > Opciones permitidas: { 1, 2, 3, 4, 5 }.
     *  @value 1 --> Registrar una persona.
     *  @value 2 --> Mostrar las personas.
     *  @value 3 --> Actualizar datos de la persona.
     *  @value 4 --> Eliminar a una persona.
     *  @value 5 --> Finalizar el programa.
     */

    // Mostrar el menú de operaciones
    public void mostrarMenu() {
        System.out.println(coloresTexto.get("verde") + "-------------- " + coloresTexto.get("cyan") +
        "MENÚ - CRUD" + coloresTexto.get("verde") + " --------------");
        // 1 - Registrar a una persona.
        System.out.println(coloresTexto.get("rojo") + "(" + coloresTexto.get("blanco") + "1" +
        coloresTexto.get("rojo") + "). " + coloresTexto.get("verde") + "Registrar a una persona.");
        // 2 - Ver información de las personas registradas.
        System.out.println(coloresTexto.get("rojo") + "(" + coloresTexto.get("blanco") + "2" +
        coloresTexto.get("rojo") + "). " + coloresTexto.get("cyan") +
        "Ver información de las personas registradas.");
        // 3 - Actualizar datos de una persona.
        System.out.println(coloresTexto.get("rojo") + "(" + coloresTexto.get("blanco") + "3" +
        coloresTexto.get("rojo") + "). " + coloresTexto.get("amarillo") + "Actualizar datos de una persona.");
        // 4 - Eliminar una persona de la lista.
        System.out.println(coloresTexto.get("rojo") + "(" + coloresTexto.get("blanco") + "4" +
        coloresTexto.get("rojo") + "). " + coloresTexto.get("rojo") + "Eliminar una persona de la lista.");
        // 5 - Salir del programa.
        System.out.println(coloresTexto.get("rojo") + "(" + coloresTexto.get("blanco") + "5" +
        coloresTexto.get("rojo") + "). " + coloresTexto.get("magenta") + "Salir del programa.\n");
        // Mensaje - Indica que debe ingresar un número como opción
        System.out.print(coloresTexto.get("azul") + "Ingrese un número, entre "  +
        coloresTexto.get("amarillo") + "(" + coloresTexto.get("blanco") +
        "1" + coloresTexto.get("cyan") + ", " + coloresTexto.get("blanco") + "2" +
        coloresTexto.get("cyan") + ", "  + coloresTexto.get("blanco") + "3" +
        coloresTexto.get("cyan") + ", "  + coloresTexto.get("blanco") + "4" +
        coloresTexto.get("cyan") + " y " + coloresTexto.get("blanco") + "5" +
        coloresTexto.get("amarillo") + ")" + coloresTexto.get("cyan") + ": " +
        coloresTexto.get("blanco"));
    }

    /*
     *    Valida la primera opción a elegir
     *  ------------------------------------
     *  @value this.opcion es distinto a
     *  1, 2, 3, 4 y 5 @return false
     */

    public boolean laOpcionEsValida() {
        boolean resultado = (opcion == '1' || opcion == '2' || opcion == '3' ||
        opcion == '4' || opcion == '5') ? true : false;
        return resultado;
    }

    // Devuelve un valor booleano, comprueba si existen registros
    public boolean existenRegistros(Integer totalPersonas) {
        boolean resultado = (opcion == '2' || opcion == '3' ||
        opcion == '4' && totalPersonas > 0) ? true : false;
        return resultado;
    }

    // Mensaje - ¿Continuar o salir del programa?
    public void mensajeContinuar() {
        System.out.print(coloresTexto.get("cyan") + "\nPara continuar en el programa, por favor ingrese el número de la siguiente opción.\n" +
        coloresTexto.get("blanco") +
        "\n(" + coloresTexto.get("amarillo") + "1" + coloresTexto.get("blanco") + ") " +
        coloresTexto.get("azul") + "Continuar.\n\n" + coloresTexto.get("magenta") +
        "Respuesta: " + coloresTexto.get("blanco"));
    }

    // Mensaje - No hay existen registros
    public void mensajeNoExistenRegistros() {
        System.out.println(coloresTexto.get("cyan") + "\nNo existe alguna persona registrada. " + 
        "Si gusta,\npuede elegir la opción " + coloresTexto.get("amarillo") + 
        "(" + coloresTexto.get("blanco") + "1" + coloresTexto.get("amarillo") + ") " +
        coloresTexto.get("verde") + "para registrar a una persona." + coloresTexto.get("blanco") + "\n");
        System.out.print(coloresTexto.get("amarillo") +
        "Ingrese una tecla y presione la tecla \"Enter\" para continuar... " +
        coloresTexto.get("blanco"));
    }

    // Muestra un mensaje de error. Sólo si la opción uno es incorrecta o si no existen registros
    public void mensajeErrorOpciones(Integer totalPersonas) {
        if (opcion != '2' && opcion != '3' &&
            opcion != '4' && opcion != '5') {
            System.out.println(coloresTexto.get("rojo") + "\n¡ERROR! La opción es incorrecta.\n" +
            coloresTexto.get("blanco"));

        } else if (opcion == '2' || opcion == '3' || opcion == '4' && totalPersonas == 0) {
            System.out.println(coloresTexto.get("cyan") + "\nNo existe alguna persona registrada. " + 
            "Si gusta,\npuede elegir la opción " + coloresTexto.get("amarillo") + 
            "(" + coloresTexto.get("blanco") + "1" + coloresTexto.get("amarillo") + ") " +
            coloresTexto.get("verde") + "para registrar a una persona." + coloresTexto.get("blanco") + "\n");
        }

        System.out.print(coloresTexto.get("amarillo") +
        "Ingrese una tecla y presione la tecla \"Enter\" para continuar... " +
        coloresTexto.get("blanco"));
    }

    /*
     *    Valida la segunda opción a elegir
     *  ------------------------------------
     *  @value this.opcionDos es distinto a
     *  1 y 2 > @return false
     */

    public boolean laOpcionDosEsValida() {
        boolean resultado = (opcionDos == '1') ? true : false;
        return resultado;
    }

    // Muestra un mensaje de error. Sólo si la opción dos es incorrecta
    public void mensajeErrorOpcionDos() {
        if (opcionDos != '1') {
            System.out.println(coloresTexto.get("rojo") + "\n¡ERROR! La opción es incorrecta.\n" +
            coloresTexto.get("blanco"));
            System.out.print(coloresTexto.get("amarillo") +
            "Ingrese una tecla y presione la tecla \"Enter\" para continuar... " +
            coloresTexto.get("blanco"));
        }
    }

    // Continuar en el programa
    public boolean continuarEnElPrograma() {
        boolean resultado = (opcionDos == '1') ? true : false;
        return resultado;
    }

    // Salir del programa
    public boolean salirDelPrograma() {
        boolean resultado = (opcion == '5' || opcionDos == '2') ? true : false;
        return resultado;
    }

    /*
     *  Imprime un mensaje, luego de haber
     *       ingresado la opción
     */

	public void mensajeOpcion() {
        if (opcion == '1') {
            System.out.println("\nHa elegido la opción " + coloresTexto.get("amarillo") + "(" + "" +
            coloresTexto.get("blanco") + opcion + coloresTexto.get("amarillo") + ")" + coloresTexto.get("blanco") +". " + this.coloresTexto.get("verde") + "Registrar a una persona." + coloresTexto.get("blanco"));

        } else if (opcion == '2') {
            System.out.println("\nHa elegido la opción " + coloresTexto.get("amarillo") + "(" + "" +
            coloresTexto.get("blanco") + opcion + coloresTexto.get("amarillo") + ")" + coloresTexto.get("blanco") +". " + coloresTexto.get("cyan") + "Ver información de las personas registradas."
            + coloresTexto.get("blanco"));

        } else if (opcion == '3') {
            System.out.println("\nHa elegido la opción " + coloresTexto.get("amarillo") + "(" + "" +
            coloresTexto.get("blanco") + opcion + coloresTexto.get("amarillo") + ")" + coloresTexto.get("blanco") +". " + coloresTexto.get("amarillo") + "Actualizar datos de una persona."
            + coloresTexto.get("blanco"));

        } else if (opcion == '4') {
            System.out.println("\nHa elegido la opción " + coloresTexto.get("amarillo") + "(" + "" +
            coloresTexto.get("blanco") + opcion + coloresTexto.get("amarillo") + ")" + coloresTexto.get("blanco") +". " + coloresTexto.get("rojo") + "Eliminar una persona de la lista."
            + coloresTexto.get("blanco"));

        } else if (opcion == '5') {
            System.out.println("\nHa elegido la opción " + coloresTexto.get("amarillo") + "(" + "" +
            coloresTexto.get("blanco") + opcion + coloresTexto.get("amarillo") + ")" + coloresTexto.get("blanco") +". " + coloresTexto.get("cyan") + "Salir del programa." + coloresTexto.get("blanco") +
            "¡Muchas gracias por participar! " + coloresTexto.get("azul") + ";D" + coloresTexto.get("blanco"));
        }
	}

    /*
     *  Imprime un mensaje, segun:
     *    - La tarea se realizó con éxito.
     *    - Hubo un problema al realizar
     *      la tarea.
     */

    public void mensajeDeLaTarea(char opcion) {
        switch (opcion) {
            case '1':
            System.out.println(coloresTexto.get("verde") + "\n¡El registro se completó con éxito!" +
            coloresTexto.get("blanco"));
            break;

            case '3':
            System.out.println(coloresTexto.get("verde") + "\n¡Los datos de la persona se actualizaron correctamente!" +
            coloresTexto.get("blanco"));
            break;

            case '4':
            System.out.println(coloresTexto.get("rojo") + "\n¡La persona fue eliminada satisfactoriamente!" +
            coloresTexto.get("blanco"));
            break;
        }
    }

    // Mensaje - El array llegó al tope (100)
    public void mensajeArrayAlTope() {
        System.out.println(coloresTexto.get("amarillo") + "\n¡Lo sentimos! " +
        coloresTexto.get("blanco") + ":( " + coloresTexto.get("cyan") + "En este momento no puede " +
        "continuar registrando personas.\nElimine alguna persona para tener la oportunidad de registrar " +
        "a otra." + coloresTexto.get("blanco"));
        System.out.print(coloresTexto.get("azul") +
        "\nIngrese una tecla y presione la tecla \"Enter\" para continuar... " +
        coloresTexto.get("blanco"));
    }
}