package com.tecsup.labs;

/**
 * Clase principal para probar el servicio de registro de usuarios.
 */
public final class Main {

    /**
     * Constructor privado para evitar la instanciación de la clase utility.
     */
    private Main() {
        // Clase utility.
    }

    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(final String[] args) {
        final UserRegistrationService service = new UserRegistrationService();

        // Casos de prueba simples
        service.registerUser("juan", "123", "juan@correo.com");
        System.out.println("Error 1: " + service.getLastErrorMessage());

        service.registerUser(null, "12345678", "correo@valido.com");
        System.out.println("Error 2: " + service.getLastErrorMessage());

        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println("Error 3: " + service.getLastErrorMessage());

        System.out.println("Longitud de 'Test': "
                            + service.getStringLength("Test"));
    }
}
