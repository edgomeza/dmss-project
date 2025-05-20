package view.util;

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.function.Predicate;
import java.io.IOException;
import config.AppConfig;

/**
 * Utilidades para la interfaz de consola
 * Proporciona métodos comunes para toda la interfaz de usuario
 */
public class ConsoleUtils {
    // Constantes para colores ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    // Constantes para fondos ANSI
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    // Estilos
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    
    // Caracteres para barras de progreso
    private static final String PROGRESS_EMPTY = "░";
    private static final String PROGRESS_FULL = "█";
    
    /**
     * Limpia la pantalla de la consola
     */
    public static void limpiarPantalla() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException e) {
                    // Si hay error, fallback a imprimir líneas en blanco
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                }
            } else {
                // En sistemas UNIX-like
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback a imprimir líneas en blanco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    /**
     * Verifica si los colores deben mostrarse según la configuración
     * @return true si los colores deben mostrarse, false en caso contrario
     */
    private static boolean shouldShowColors() {
        try {
            return Boolean.parseBoolean(AppConfig.getInstance().getProperty("display.showColors", "true"));
        } catch (Exception e) {
            return true; // Por defecto mostrar colores
        }
    }
    
    /**
     * Obtiene el string con color si está habilitado, o sin color si no
     * @param text Texto a colorear
     * @param colorCode Código de color ANSI
     * @return Texto coloreado o normal
     */
    private static String getColoredText(String text, String colorCode) {
        if (shouldShowColors()) {
            return colorCode + text + ANSI_RESET;
        }
        return text;
    }
    
    /**
     * Muestra un título formateado
     * @param titulo Texto del título
     */
    public static void mostrarTitulo(String titulo) {
        int longitud = titulo.length() + 4;
        StringBuilder borde = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            borde.append("=");
        }
        
        String bordeStr = getColoredText(borde.toString(), ANSI_BOLD + ANSI_BLUE);
        String tituloStr = getColoredText("  " + titulo + "  ", ANSI_BOLD + ANSI_BLUE);
        
        System.out.println("\n" + bordeStr);
        System.out.println(tituloStr);
        System.out.println(bordeStr + "\n");
    }
    
    /**
     * Muestra un subtítulo formateado
     * @param subtitulo Texto del subtítulo
     */
    public static void mostrarSubtitulo(String subtitulo) {
        String texto = getColoredText("-- " + subtitulo + " --", ANSI_BOLD + ANSI_CYAN);
        System.out.println("\n" + texto);
        mostrarLinea();
    }
    
    /**
     * Muestra una línea separadora
     */
    public static void mostrarLinea() {
        String linea = getColoredText("----------------------------------------", ANSI_BOLD);
        System.out.println(linea);
    }
    
    /**
     * Muestra un mensaje de éxito
     * @param mensaje Mensaje a mostrar
     */
    public static void mostrarExito(String mensaje) {
        String texto = getColoredText("✓ " + mensaje, ANSI_GREEN);
        System.out.println(texto);
    }
    
    /**
     * Muestra un mensaje de error
     * @param mensaje Mensaje a mostrar
     */
    public static void mostrarError(String mensaje) {
        String texto = getColoredText("✗ " + mensaje, ANSI_RED);
        System.out.println(texto);
    }
    
    /**
     * Muestra un mensaje de advertencia
     * @param mensaje Mensaje a mostrar
     */
    public static void mostrarAdvertencia(String mensaje) {
        String texto = getColoredText("⚠ " + mensaje, ANSI_YELLOW);
        System.out.println(texto);
    }
    
    /**
     * Muestra un mensaje informativo
     * @param mensaje Mensaje a mostrar
     */
    public static void mostrarInfo(String mensaje) {
        String texto = getColoredText("ℹ " + mensaje, ANSI_BLUE);
        System.out.println(texto);
    }
    
    /**
     * Lee una opción numérica del usuario dentro de un rango
     * @param scanner Scanner para leer la entrada
     * @param min Valor mínimo aceptable
     * @param max Valor máximo aceptable
     * @return Opción seleccionada
     */
    public static int leerOpcion(Scanner scanner, int min, int max) {
        try {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                return -1;  // Valor especial para entrada vacía
            }
            
            int opcion = Integer.parseInt(input);
            if (opcion >= min && opcion <= max) {
                return opcion;
            } else {
                mostrarError("Opción fuera de rango (" + min + "-" + max + ")");
                return -1;
            }
        } catch (NumberFormatException e) {
            mostrarError("Por favor, introduzca un número válido");
            return -1;
        }
    }
    
    /**
     * Lee un valor entero del usuario
     * @param scanner Scanner para leer la entrada
     * @param mensaje Mensaje de solicitud
     * @param predicate Predicado de validación (opcional)
     * @param defaultValue Valor por defecto si la entrada está vacía
     * @return Valor leído
     */
    public static int leerEntero(Scanner scanner, String mensaje, Predicate<Integer> predicate, Integer defaultValue) {
        while (true) {
            try {
                System.out.print(mensaje);
                if (defaultValue != null) {
                    System.out.print(" [" + defaultValue + "]: ");
                } else {
                    System.out.print(": ");
                }
                
                String input = scanner.nextLine();
                if (input.isEmpty() && defaultValue != null) {
                    return defaultValue;
                }
                
                int valor = Integer.parseInt(input);
                if (predicate == null || predicate.test(valor)) {
                    return valor;
                } else {
                    mostrarError("El valor no cumple con los requisitos");
                }
            } catch (NumberFormatException e) {
                mostrarError("Por favor, introduzca un número entero válido");
            }
        }
    }
    
    /**
     * Lee un valor decimal del usuario
     * @param scanner Scanner para leer la entrada
     * @param mensaje Mensaje de solicitud
     * @param predicate Predicado de validación (opcional)
     * @param defaultValue Valor por defecto si la entrada está vacía
     * @return Valor leído
     */
    public static double leerDecimal(Scanner scanner, String mensaje, Predicate<Double> predicate, Double defaultValue) {
        while (true) {
            try {
                System.out.print(mensaje);
                if (defaultValue != null) {
                    System.out.print(" [" + defaultValue + "]: ");
                } else {
                    System.out.print(": ");
                }
                
                String input = scanner.nextLine();
                if (input.isEmpty() && defaultValue != null) {
                    return defaultValue;
                }
                
                double valor = Double.parseDouble(input);
                if (predicate == null || predicate.test(valor)) {
                    return valor;
                } else {
                    mostrarError("El valor no cumple con los requisitos");
                }
            } catch (NumberFormatException e) {
                mostrarError("Por favor, introduzca un número decimal válido");
            }
        }
    }
    
    /**
     * Lee un valor booleano del usuario
     * @param scanner Scanner para leer la entrada
     * @param mensaje Mensaje de solicitud
     * @param defaultValue Valor por defecto si la entrada está vacía
     * @return Valor leído
     */
    public static boolean leerBooleano(Scanner scanner, String mensaje, Boolean defaultValue) {
        while (true) {
            System.out.print(mensaje);
            if (defaultValue != null) {
                System.out.print(" [" + (defaultValue ? "s" : "n") + "]: ");
            } else {
                System.out.print(" (s/n): ");
            }
            
            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty() && defaultValue != null) {
                return defaultValue;
            }
            
            if (input.startsWith("s") || input.startsWith("y") || input.equals("1") || input.equals("true")) {
                return true;
            } else if (input.startsWith("n") || input.equals("0") || input.equals("false")) {
                return false;
            } else {
                mostrarError("Por favor, responda 's' para Sí o 'n' para No");
            }
        }
    }
    
    /**
     * Lee una cadena del usuario
     * @param scanner Scanner para leer la entrada
     * @param mensaje Mensaje de solicitud
     * @param predicate Predicado de validación (opcional)
     * @param defaultValue Valor por defecto si la entrada está vacía
     * @return Valor leído
     */
    public static String leerString(Scanner scanner, String mensaje, Predicate<String> predicate, String defaultValue) {
        while (true) {
            System.out.print(mensaje);
            if (defaultValue != null && !defaultValue.isEmpty()) {
                System.out.print(" [" + defaultValue + "]: ");
            } else {
                System.out.print(": ");
            }
            
            String input = scanner.nextLine();
            if (input.isEmpty() && defaultValue != null) {
                return defaultValue;
            }
            
            if (predicate == null || predicate.test(input)) {
                return input;
            } else {
                mostrarError("El valor no cumple con los requisitos");
            }
        }
    }
    
    /**
     * Lee una fecha del usuario en formato yyyy-MM-dd
     * @param scanner Scanner para leer la entrada
     * @param mensaje Mensaje de solicitud
     * @param predicate Predicado de validación (opcional)
     * @param defaultValue Valor por defecto si la entrada está vacía
     * @return Valor leído
     */
    public static String leerFecha(Scanner scanner, String mensaje, Predicate<Date> predicate, String defaultValue) {
        // Obtener formato de fecha configurado
        String formatoFecha = AppConfig.getInstance().getProperty("display.dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);
        dateFormat.setLenient(false);
        
        while (true) {
            System.out.print(mensaje + " (" + formatoFecha + ")");
            if (defaultValue != null && !defaultValue.isEmpty()) {
                System.out.print(" [" + defaultValue + "]: ");
            } else {
                System.out.print(": ");
            }
            
            String input = scanner.nextLine();
            if (input.isEmpty() && defaultValue != null) {
                return defaultValue;
            }
            
            try {
                Date fecha = dateFormat.parse(input);
                if (predicate == null || predicate.test(fecha)) {
                    return dateFormat.format(fecha);
                } else {
                    mostrarError("La fecha no cumple con los requisitos");
                }
            } catch (ParseException e) {
                mostrarError("Por favor, introduzca una fecha válida en formato " + formatoFecha);
            }
        }
    }
    
    /**
     * Espera a que el usuario pulse Enter para continuar
     * @param scanner Scanner para leer la entrada
     */
    public static void pausar(Scanner scanner) {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Muestra un elemento de una lista con formato
     * @param index Índice del elemento
     * @param elemento Texto del elemento
     */
    public static void mostrarElementoLista(int index, String elemento) {
        String indexStr = getColoredText("[" + index + "]", ANSI_BOLD);
        System.out.println(indexStr + " " + elemento);
    }
    
    /**
     * Muestra una tabla de datos simple
     * @param headers Cabeceras de la tabla
     * @param data Datos de la tabla (filas)
     */
    public static void mostrarTabla(String[] headers, List<String[]> data) {
        // Calcular el ancho de cada columna
        int[] anchos = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            anchos[i] = headers[i].length();
        }
        
        for (String[] fila : data) {
            for (int i = 0; i < fila.length && i < headers.length; i++) {
                if (fila[i] != null && fila[i].length() > anchos[i]) {
                    anchos[i] = fila[i].length();
                }
            }
        }
        
        // Construir la línea separadora
        StringBuilder separador = new StringBuilder("+");
        for (int ancho : anchos) {
            for (int i = 0; i < ancho + 2; i++) {
                separador.append("-");
            }
            separador.append("+");
        }
        
        // Mostrar cabecera
        System.out.println(separador.toString());
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.print(getColoredText(" " + String.format("%-" + anchos[i] + "s", headers[i]) + " ", ANSI_BOLD) + "|");
        }
        System.out.println();
        System.out.println(separador.toString());
        
        // Mostrar datos
        for (String[] fila : data) {
            System.out.print("|");
            for (int i = 0; i < headers.length; i++) {
                String valor = (i < fila.length && fila[i] != null) ? fila[i] : "";
                System.out.print(" " + String.format("%-" + anchos[i] + "s", valor) + " |");
            }
            System.out.println();
        }
        
        System.out.println(separador.toString());
    }

    /**
     * Muestra un mensaje tras la creación de un elemento
     * @param entidad Nombre de la entidad creada
     */
    public static void mostrarCreacion(String entidad) {
        mostrarExito(entidad + " creado correctamente");
    }
    
    /**
     * Muestra un mensaje tras la actualización de un elemento
     * @param entidad Nombre de la entidad actualizada
     */
    public static void mostrarActualizacion(String entidad) {
        mostrarExito(entidad + " actualizado correctamente");
    }
    
    /**
     * Muestra un mensaje tras el borrado de un elemento
     * @param entidad Nombre de la entidad borrada
     */
    public static void mostrarBorrado(String entidad) {
        mostrarExito(entidad + " borrado correctamente");
    }
    
    /**
     * Muestra los detalles de un elemento de forma tabular
     * @param titulo   Descripción de lo que se muestra (e.g. nombre de la entidad)
     * @param headers  Cabeceras de las columnas
     * @param values   Valores correspondientes a cada cabecera
     */
    public static void mostrarDetalle(String titulo, String[] headers, String[] values) {
        mostrarSubtitulo("Detalle de " + titulo);
        mostrarTabla(headers, Collections.singletonList(values));
    }
    
    /**
     * Muestra una barra de progreso
     * @param progreso Valor actual de progreso (0-100)
     * @param longitud Longitud de la barra
     */
    public static void mostrarBarraProgreso(int progreso, int longitud) {
        if (progreso < 0) progreso = 0;
        if (progreso > 100) progreso = 100;
        
        int completados = (int) Math.round(progreso * longitud / 100.0);
        int pendientes = longitud - completados;
        
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < completados; i++) {
            barra.append(PROGRESS_FULL);
        }
        for (int i = 0; i < pendientes; i++) {
            barra.append(PROGRESS_EMPTY);
        }
        barra.append("] ").append(progreso).append("%");
        
        System.out.print("\r" + barra);
        
        if (progreso == 100) {
            System.out.println();
        }
    }
    
    /**
     * Muestra una notificación con estilo y temporizador
     * @param mensaje Mensaje a mostrar
     * @param tipo Tipo de notificación (info, exito, error, advertencia)
     * @param duracionMs Duración en milisegundos (0 para no esperar)
     */
    public static void mostrarNotificacion(String mensaje, String tipo, int duracionMs) {
        String icono;
        String color;
        
        switch (tipo.toLowerCase()) {
            case "exito":
                icono = "✓";
                color = ANSI_GREEN;
                break;
            case "error":
                icono = "✗";
                color = ANSI_RED;
                break;
            case "advertencia":
                icono = "⚠";
                color = ANSI_YELLOW;
                break;
            case "info":
            default:
                icono = "ℹ";
                color = ANSI_BLUE;
                break;
        }
        
        StringBuilder notificacion = new StringBuilder();
        notificacion.append("\n┌").append("─".repeat(mensaje.length() + 6)).append("┐\n");
        notificacion.append("│  ").append(getColoredText(icono + " " + mensaje, color)).append("  │\n");
        notificacion.append("└").append("─".repeat(mensaje.length() + 6)).append("┘\n");
        
        System.out.println(notificacion.toString());
        
        if (duracionMs > 0) {
            try {
                Thread.sleep(duracionMs);
            } catch (InterruptedException e) {
                // Ignorar
            }
        }
    }
    
    /**
     * Resalta un texto de búsqueda dentro de un contenido
     * @param contenido Texto completo
     * @param busqueda Texto a resaltar
     * @return Texto con la búsqueda resaltada
     */
    public static String resaltarTexto(String contenido, String busqueda) {
        if (busqueda == null || busqueda.isEmpty() || contenido == null || contenido.isEmpty()) {
            return contenido;
        }
        
        StringBuilder result = new StringBuilder();
        String lowerContenido = contenido.toLowerCase();
        String lowerBusqueda = busqueda.toLowerCase();
        
        int startIndex = 0;
        int index;
        
        while ((index = lowerContenido.indexOf(lowerBusqueda, startIndex)) != -1) {
            // Añadir el texto hasta la coincidencia
            result.append(contenido.substring(startIndex, index));
            
            // Añadir el texto resaltado
            String match = contenido.substring(index, index + busqueda.length());
            result.append(getColoredText(match, ANSI_YELLOW + ANSI_BOLD));
            
            // Actualizar índice
            startIndex = index + busqueda.length();
        }
        
        // Añadir el resto del texto
        if (startIndex < contenido.length()) {
            result.append(contenido.substring(startIndex));
        }
        
        return result.toString();
    }
    
    /**
     * Muestra un menú de ayuda contextual
     * @param titulo Título de la ayuda
     * @param contenido Contenido de la ayuda
     */
    public static void mostrarAyuda(String titulo, String contenido) {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Ayuda: " + titulo);
        System.out.println(contenido);
        System.out.println("\nPresione Enter para volver...");
        new Scanner(System.in).nextLine();
    }
    
    /**
     * Muestra un diálogo de confirmación para acciones destructivas
     * @param scanner Scanner para leer la entrada
     * @param mensaje Mensaje de confirmación
     * @return true si se confirma, false en caso contrario
     */
    public static boolean confirmarAccionDestructiva(Scanner scanner, String mensaje) {
        mostrarAdvertencia("ATENCIÓN: Esta acción no se puede deshacer");
        System.out.println(getColoredText(mensaje, ANSI_RED + ANSI_BOLD));
        
        System.out.print("Para confirmar, escriba 'CONFIRMAR': ");
        String input = scanner.nextLine();
        
        return "CONFIRMAR".equals(input);
    }
}
