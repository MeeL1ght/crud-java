package Main;

import Models.Menu.Menu;
import Models.PersonaModel.*;
import Controllers.PersonaController.PersonaController;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    // Método principal
    public static void main(String[] args) throws
        Exception,
        IOException,
        InterruptedException {

        // Variables y la constante
        char opcion = '\0', opcionDos = '\0', key = '\0';
        Integer dia, mes, año, id;
        String nombre, apellido;
        final Integer MAXIMO_PERSONAS = 100;

        // Instancias
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        PersonaController controladorPersona = new PersonaController();
        Persona[] persona = new Persona[MAXIMO_PERSONAS];

        // Creando los objetos
        for (Integer i = 0; i < MAXIMO_PERSONAS; i++) {
            persona[i] = new Persona();
        }

        do {
            do {
                // Menú y entrada del dato
                //System.out.println("Total de personas registradas: " + Persona.getTotalPersonas());
                menu.mostrarMenu();
                opcion = input.next().charAt(0);
                menu.setOpcion(opcion);

                // Comprobando si hay espacio disponible para permitir registrar a una persona
                if (menu.getOpcion() == '1' && Persona.limiteExcedidoArray(MAXIMO_PERSONAS)) {
                    // Mensaje - El array llegó al tope
                    menu.mensajeArrayAlTope();
                    key = input.next().charAt(0);
                    // Limpiar la consola
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }
                
                if (!menu.laOpcionEsValida() || (menu.getOpcion() == '2' && Persona.getTotalPersonas() == 0) ||
                   (menu.getOpcion() == '3' && Persona.getTotalPersonas() == 0) || (menu.getOpcion() == '4' &&
                   Persona.getTotalPersonas() == 0)) {
                    // Mensaje - La opción es incorrecta
                    menu.mensajeErrorOpciones(Persona.getTotalPersonas());
                    key = input.next().charAt(0);
                    // Limpiar la consola
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }

            } while (!menu.laOpcionEsValida() || (menu.getOpcion() == '2' && Persona.getTotalPersonas() == 0) ||
                    (menu.getOpcion() == '3' && Persona.getTotalPersonas() == 0) || (menu.getOpcion() == '4' &&
                    Persona.getTotalPersonas() == 0) || (menu.getOpcion() == '1' &&
                    Persona.limiteExcedidoArray(MAXIMO_PERSONAS)));

            // Limpiar la consola
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            // Mensaje - Solo si la opción es válida { 1, 2, 3, 4, 5 }
            menu.mensajeOpcion();

            // Opción 1 - Registrar a la persona
            if (menu.getOpcion() == '1') {
                // Asignando el ID
                persona[Persona.getTotalPersonas()].setId(Persona.getTotalPersonas() + 1);
                // Mensaje - Número de persona al ser registrada
                System.out.println(menu.coloresTexto.get("azul") +
                "\n----- " + menu.coloresTexto.get("cyan") + "Persona " + menu.coloresTexto.get("blanco") +
                persona[Persona.getTotalPersonas()].getId() + menu.coloresTexto.get("azul") + " -----");
                // Nombre
                System.out.print(menu.coloresTexto.get("amarillo") + "\nIngrese su nombre: " +
                menu.coloresTexto.get("blanco"));
                // Limpia el buffer
                input.nextLine();
                nombre = input.nextLine();
                persona[Persona.getTotalPersonas()].setNombre(nombre);
                // Apellido
                System.out.print(menu.coloresTexto.get("blanco") + "Ingrese su apellido: " +
                menu.coloresTexto.get("cyan"));
                apellido = input.nextLine();
                persona[Persona.getTotalPersonas()].setApellido(apellido);
                // Día
                System.out.print(menu.coloresTexto.get("amarillo") + "Ingrese su día de nacimiento: " +
                menu.coloresTexto.get("blanco"));
                dia = input.nextInt();
                persona[Persona.getTotalPersonas()].setDia(dia);
                // Mes
                System.out.print(menu.coloresTexto.get("blanco") + "Ingrese su mes de nacimiento: " +
                menu.coloresTexto.get("cyan"));
                mes = input.nextInt();
                persona[Persona.getTotalPersonas()].setMes(mes);
                // Año
                System.out.print(menu.coloresTexto.get("amarillo") + "Ingrese su año de nacimiento: " +
                menu.coloresTexto.get("blanco"));
                año = input.nextInt();
                persona[Persona.getTotalPersonas()].setAño(año);
                // Postincrementa el contador de personas
                Persona.setTotalPersonas(Persona.getTotalPersonas() + 1);
                // Mensaje
                menu.mensajeDeLaTarea(menu.getOpcion());
            } 

            // Opción 2 - Imprimir las personas registradas
            if (menu.getOpcion() == '2') {
                controladorPersona.mostrarInformacion(persona);
            }

            // Opción 3 - Actualizar los datos de una persona
            if (menu.getOpcion() == '3') {
                // Preguntar por el ID
                do {
                    System.out.print(menu.coloresTexto.get("blanco") + "\nIngrese un " + menu.coloresTexto.get("cyan") +
                    "ID: " + menu.coloresTexto.get("blanco"));
                    id = input.nextInt();
                    controladorPersona.setIdConsulta(id);

                    // Verificar ID
                    if (!controladorPersona.existeElId(persona, controladorPersona.getIdConsulta())) {
                        // Mensaje
                        controladorPersona.mensajeErrorId();
                        key = input.next().charAt(0);
                        // Limpiar la consola
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }

                } while (!controladorPersona.existeElId(persona, controladorPersona.getIdConsulta()));

                // Pedir los datos de entrada para la actualizaciòn 
                if (controladorPersona.existeElId(persona, controladorPersona.getIdConsulta())) {
                    // Mensaje - Número de persona al ser registrada
                    System.out.println(menu.coloresTexto.get("azul") +
                    "\n----- Se actualizarán los datos de " + menu.coloresTexto.get("cyan") +
                    persona[controladorPersona.getIdConsulta() - 1].getNombre() + menu.coloresTexto.get("blanco") +
                    ". Su ID es el número " + controladorPersona.getIdConsulta() + menu.coloresTexto.get("azul") + " -----");
                    // Limpia el buffer
                    input.nextLine();
                    // Nombre
                    System.out.print(menu.coloresTexto.get("amarillo") + "\nIngrese su nuevo nombre: " +
                    menu.coloresTexto.get("blanco"));
                    nombre = input.nextLine();
                    persona[controladorPersona.getIdConsulta() - 1].setNombre(nombre);
                    // Apellido
                    System.out.print(menu.coloresTexto.get("blanco") + "Ingrese su nuevo apellido: ");
                    apellido = input.nextLine();
                    persona[controladorPersona.getIdConsulta() - 1].setApellido(apellido);
                    // Día
                    System.out.print(menu.coloresTexto.get("amarillo") + "Ingrese su día de nacimiento: " +
                    menu.coloresTexto.get("blanco"));
                    dia = input.nextInt();
                    persona[controladorPersona.getIdConsulta() - 1].setDia(dia);
                    // Mes
                    System.out.print(menu.coloresTexto.get("blanco") + "Ingrese su mes de nacimiento: " +
                    menu.coloresTexto.get("cyan"));
                    mes = input.nextInt();
                    persona[controladorPersona.getIdConsulta() - 1].setMes(mes);
                    // Año
                    System.out.print(menu.coloresTexto.get("amarillo") + "Ingrese su año de nacimiento: " +
                    menu.coloresTexto.get("blanco"));
                    año = input.nextInt();
                    persona[controladorPersona.getIdConsulta() - 1].setAño(año);
                    // Mensaje 
                    menu.mensajeDeLaTarea(menu.getOpcion());
                }
            }

            // Opción 4 - Eliminar a una persona
            if (menu.getOpcion() == '4') {
                // Entrada de dato (ID)
                do {
                    System.out.print(menu.coloresTexto.get("blanco") + "\nIngrese un " + menu.coloresTexto.get("cyan") +
                    "ID: " + menu.coloresTexto.get("blanco"));
                    id = input.nextInt();
                    controladorPersona.setIdConsulta(id);

                    // Verificar ID
                    if (!controladorPersona.existeElId(persona, controladorPersona.getIdConsulta())) {
                        // Mensaje
                        controladorPersona.mensajeErrorId();
                        key = input.next().charAt(0);
                        // Limpiar la consola
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }

                } while (!controladorPersona.existeElId(persona, controladorPersona.getIdConsulta()));

                // Acción de eliminar
                if (controladorPersona.existeElId(persona, controladorPersona.getIdConsulta())) {
                    // Eliminar a la persona
                    controladorPersona.eliminarPersona(persona, controladorPersona.getIdConsulta());
                    // Postdecrementar el contador de personas
                    Persona.setTotalPersonas(Persona.getTotalPersonas() - 1);
                    // Mensaje 
                    menu.mensajeDeLaTarea(menu.getOpcion());
                }
            }

            // Opción 5 - Finalizar el programa
            if (menu.salirDelPrograma()) {
                System.exit(0);
            }

            // Se espera una respuesta para continuar
            do {
                menu.mensajeContinuar();
                opcionDos = input.next().charAt(0);
                menu.setOpcionDos(opcionDos);

                // Mensaje de opción no válida
                if (!menu.laOpcionDosEsValida()) {
                    menu.mensajeErrorOpcionDos();
                    key = input.next().charAt(0);
                    // Limpiar la consola
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }

            } while (!menu.laOpcionDosEsValida());

            // Limpiar la consola
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            // Si el valor de la segunda variable de opción es 2, finaliza el programa
            if (menu.salirDelPrograma()) {
                System.exit(0);
            }
        
          // Continuará siempre y cuando la respuesta sea el caracter '1'
        } while (menu.continuarEnElPrograma()); 
    }
}
