package com.tecsup.labs;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios con problemas de calidad corregidos.
 * Ahora sigue las convenciones de estilo y buenas prácticas.
 */
public final class UserRegistrationService {

    /** Mensaje de error de la última operación fallida. */
    private String lastErrorMessage = "";

    /** Lista de usuarios registrados. */ // ¡PUNTO AGREGADO!
    private final List<String> users = new ArrayList<>();

    /** Longitud mínima de contraseña. */ // ¡PUNTO AGREGADO!
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Constructor por defecto del servicio.
     */
    public UserRegistrationService() {
    }

    /**
     * Registra un nuevo usuario.
     * @param username Nombre de usuario (debe ser final).
     * @param password Contraseña (debe ser final).
     * @param email Correo electrónico (debe ser final).
     * @return true si el registro es exitoso, false si falla.
     */
    public boolean registerUser(final String username,
        final String password,
        final String email) {

        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        if (password == null) {
            lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = "La contraseña es muy corta (Mínimo "
                               + MIN_PASSWORD_LENGTH + " caracteres).";
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no parece válido.";
            return false;
        }

        try {
            saveUser(username, password, email);
        } catch (final Exception e) {
            final StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            System.err.println("Error durante el registro: \n" + sw.toString());

            lastErrorMessage = "Error desconocido al guardar el usuario.";
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Simula el almacenamiento del usuario en la "base de datos".
     * @param username Nombre de usuario (debe ser final).
     * @param password Contraseña (debe ser final).
     * @param email Correo electrónico (debe ser final).
     * @throws Exception Si ocurre un error al guardar (simulado).
     */
    private void saveUser(final String username,
        final String password,
        final String email) throws Exception {

        users.add(username);

        if ("error".equalsIgnoreCase(username)) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    /**
     * Calcula la longitud de la cadena de entrada.
     * @param s Cadena de entrada (debe ser final).
     * @return La longitud de la cadena, o -1 si es nula.
     */
    public int getStringLength(final String s) {
        if (s == null) {
            return -1;
        }
        return s.length();
    }

    /**
     * Getter para obtener el último mensaje de error (por encapsulamiento).
     * @return El último mensaje de error.
     */
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
