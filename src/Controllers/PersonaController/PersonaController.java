package Controllers.PersonaController;

import Models.Menu.Menu;
import Models.PersonaModel.*;

/*    
 *    Acciones de una persona
 *  -----------------------------------
 *    @author Moises Reyes
 *    @version 1.0
 */

public class PersonaController {
    
    private Integer idConsulta;
    private Menu menu;
    
    /*     
     *     Método Constructor
     *  Inicializando los atributos
     */

    public PersonaController() {
        idConsulta = 0;
        menu       = new Menu();
    }

    /*    
     *  Getters and Setters
     */

    // ID a consultar
    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    // Mostrar información de las personas
    public void mostrarInformacion(Persona[] persona) {
        System.out.println(menu.coloresTexto.get("cyan") + "\nLista de persona registradas:\n");

        for (Integer i = 0; i < Persona.getTotalPersonas(); i++) {
            System.out.println(menu.coloresTexto.get("azul") +
            "------ Persona " + menu.coloresTexto.get("cyan") + (i + 1) +
            menu.coloresTexto.get("azul") + " -----" + menu.coloresTexto.get("blanco"));
            System.out.println("ID: " + menu.coloresTexto.get("cyan") + persona[i].getId());
            System.out.println(menu.coloresTexto.get("blanco") + "Nombre: " +
            menu.coloresTexto.get("cyan") + persona[i].getNombre());
            System.out.println(menu.coloresTexto.get("blanco") + "Apellido: " +
            menu.coloresTexto.get("cyan") + persona[i].getApellido());
            System.out.println(menu.coloresTexto.get("blanco") + "Fecha de nacimiento: " +
            menu.coloresTexto.get("amarillo") + persona[i].getDia() + menu.coloresTexto.get("cyan") +
            "/" + menu.coloresTexto.get("amarillo") + persona[i].getMes() + menu.coloresTexto.get("cyan") +
            "/" + menu.coloresTexto.get("amarillo") + persona[i].getAño());

            if (Persona.getTotalPersonas() > 1) System.out.println("");
        }
    }

    // Eliminar objeto (Persona)
    public void eliminarPersona(Persona[] persona, Integer posicion) {
        for (Integer iterador = posicion;  iterador < Persona.getTotalPersonas(); iterador++) {
            persona[iterador - 1] = persona[iterador];
        }
    }

    // Verifica si el id existe
    public boolean existeElId(Persona[] persona, Integer id) {
        boolean bandera   = false;
        Integer iterador  = 0;

        while ((!bandera) && (iterador < Persona.getTotalPersonas())) {
            bandera = (id == persona[iterador].getId()) ? true : false;
            iterador++;
        }

        return bandera;
    }

    // Mensaje de error - El id no existe
    public void mensajeErrorId() {
        System.out.println(menu.coloresTexto.get("rojo") + "\n¡ERROR! El ID ingresado es incorrecto.\n" +
        menu.coloresTexto.get("blanco"));
        System.out.print(menu.coloresTexto.get("amarillo") +
        "Ingrese una tecla y presione la tecla \"Enter\" para continuar... " +
        menu.coloresTexto.get("blanco"));
        System.out.print(menu.coloresTexto.get("amarillo") +
        "Ingrese una tecla y presione la tecla \"Enter\" para continuar... " +
        menu.coloresTexto.get("blanco"));
    }
}
