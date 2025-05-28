package view;

import java.util.Scanner;
import view.util.ConsoleUtils;
import auth.AuthManager;
import dao.DAOFactory;
import dao.LibroDAO;
import model.Libro;
import dao.CategoriaDAO;
import model.Categoria;
import dao.UsuarioDAO;
import model.Usuario;
import dao.PrestamoDAO;
import model.Prestamo;
import java.util.List;

/**
 * Menú específico para el rol Bibliotecario
 * Gestión de libros y préstamos
 */
public class MenuBibliotecario {
    private Scanner scanner;
    private AuthManager authManager;
    
    public MenuBibliotecario() {
        scanner = new Scanner(System.in);
        authManager = AuthManager.getInstance();
    }
    
    public void mostrarMenu() {
        // Verificar que el usuario tiene el rol correcto
        if (!authManager.isAuthenticated() || !authManager.tieneRol("Bibliotecario")) {
            ConsoleUtils.mostrarError("Acceso denegado. Se requiere el rol Bibliotecario");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        boolean salir = false;
        
        while (!salir) {
            ConsoleUtils.limpiarPantalla();
            ConsoleUtils.mostrarTitulo("Menú Bibliotecario");
            System.out.println("Gestión de libros y préstamos");
            ConsoleUtils.mostrarLinea();
            
            mostrarOpciones();
            
            int maxOpcion = 9;
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, maxOpcion);
            
            if (opcion == 0) {
                salir = true;
            } else if (opcion >= 1 && opcion <= maxOpcion) {
                ejecutarOpcion(opcion);
            } else {
                ConsoleUtils.mostrarError("Opción no válida");
                ConsoleUtils.pausar(scanner);
            }
        }
    }
    
    private void mostrarOpciones() {
        System.out.println("Páginas disponibles para Bibliotecario:");
        System.out.println("1. Biblioteca Universitaria - Inicio");
        System.out.println("2. Información Biblioteca");
        System.out.println("3. Detalle de Categoría");
        System.out.println("4. Índice de Categorías");
        System.out.println("5. Búsqueda Avanzada de Libros");
        System.out.println("6. Listado de Préstamos");
        System.out.println("7. Registrar Préstamo");
        System.out.println("8. Actualizar Préstamo");
        System.out.println("9. Eliminar Préstamo");
        System.out.println("0. Volver al menú principal");
    }
    
    private void ejecutarOpcion(int opcion) {
        switch(opcion) {
            case 1:
                mostrarPaginaHome();
                break;
            case 2:
                mostrarPaginaContenido();
                break;
            case 3:
                mostrarDetalleCategoria();
                break;
            case 4:
                mostrarIndiceCategoria();
                break;
            case 5:
                mostrarIndiceLibro();
                break;
            case 6:
                mostrarIndicePrestamo();
                break;
            case 7:
                crearNuevoPrestamo();
                break;
            case 8:
                actualizarPrestamo();
                break;
            case 9:
                borrarPrestamo();
                break;
            default:
                ConsoleUtils.mostrarError("Opción no válida");
                ConsoleUtils.pausar(scanner);
        }
    }
    
    private void mostrarPaginaHome() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Página de Inicio - Bibliotecario");
        System.out.println("Bienvenido al sistema Biblioteca Universitaria");
        System.out.println("Sistema de gestión de biblioteca universitaria");
        
        // Mostrar redes sociales asociadas
        System.out.println("Síguenos en TWITTER: @BibliotecaUniv");
        
        // Mostrar fuentes RSS
        System.out.println("RSS: Novedades Bibliográficas - https://biblioteca.universidad.edu/novedades/feed");
        
        ConsoleUtils.pausar(scanner);
    }
    
    private void mostrarPaginaContenido() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Información Biblioteca");
        System.out.println("La Biblioteca Universitaria ofrece servicios de consulta y préstamo de libros para toda la comunidad universitaria.");
        ConsoleUtils.pausar(scanner);
    }
    
    
    private void mostrarIndicePrestamo() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Listado de Prestamo");
        
        PrestamoDAO dao = PrestamoDAO.getInstance();
        List<Prestamo> lista = dao.findAll();
        
        if (lista.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay registros de Prestamo");
        } else {
            System.out.println("Total de registros: " + lista.size());
            ConsoleUtils.mostrarLinea();
            
            for (int i = 0; i < lista.size(); i++) {
                Prestamo item = lista.get(i);
                System.out.println((i + 1) + ". " + item.toDisplayString());
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    
    private void crearNuevoPrestamo() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Crear Nuevo Prestamo");
        
        Prestamo nuevo = new Prestamo();
        
        // Solicitar datos básicos
        String fechaPrestamo = ConsoleUtils.leerString(scanner, "fechaPrestamo", null, "");
        nuevo.setFechaPrestamo(fechaPrestamo);
        String fechaDevolucion = ConsoleUtils.leerString(scanner, "fechaDevolucion", null, "");
        nuevo.setFechaDevolucion(fechaDevolucion);
        
        try {
            nuevo.validarDatos();
            PrestamoDAO dao = PrestamoDAO.getInstance();
            dao.save(nuevo);
            ConsoleUtils.mostrarCreacion("Prestamo");
        } catch (Exception e) {
            ConsoleUtils.mostrarError("Error al crear Prestamo: " + e.getMessage());
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    private void actualizarPrestamo() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Actualizar Prestamo");
        ConsoleUtils.mostrarInfo("Funcionalidad de actualización disponible para Prestamo");
        ConsoleUtils.pausar(scanner);
    }
    
    private void borrarPrestamo() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Eliminar Prestamo");
        ConsoleUtils.mostrarInfo("Funcionalidad de eliminación disponible para Prestamo");
        ConsoleUtils.pausar(scanner);
    }
    
    
    private void mostrarIndiceCategoria() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Listado de Categoria");
        
        CategoriaDAO dao = CategoriaDAO.getInstance();
        List<Categoria> lista = dao.findAll();
        
        if (lista.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay registros de Categoria");
        } else {
            System.out.println("Total de registros: " + lista.size());
            ConsoleUtils.mostrarLinea();
            
            for (int i = 0; i < lista.size(); i++) {
                Categoria item = lista.get(i);
                System.out.println((i + 1) + ". " + item.toDisplayString());
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    private void mostrarDetalleCategoria() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Detalle de Categoria");
        
        CategoriaDAO dao = CategoriaDAO.getInstance();
        List<Categoria> lista = dao.findAll();
        
        if (lista.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay registros de Categoria");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).toDisplayString());
        }
        
        int indice = ConsoleUtils.leerEntero(scanner, "Seleccione el número del registro", 
                valor -> valor >= 1 && valor <= lista.size(), 1);
        
        if (indice >= 1 && indice <= lista.size()) {
            Categoria item = lista.get(indice - 1);
            ConsoleUtils.mostrarSubtitulo("Detalles de Categoria");
            System.out.println(item.toString());
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    
    
    
    
    private void mostrarIndiceLibro() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Listado de Libro");
        
        LibroDAO dao = LibroDAO.getInstance();
        List<Libro> lista = dao.findAll();
        
        if (lista.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay registros de Libro");
        } else {
            System.out.println("Total de registros: " + lista.size());
            ConsoleUtils.mostrarLinea();
            
            for (int i = 0; i < lista.size(); i++) {
                Libro item = lista.get(i);
                System.out.println((i + 1) + ". " + item.toDisplayString());
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    private void mostrarDetalleLibro() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Detalle de Libro");
        
        LibroDAO dao = LibroDAO.getInstance();
        List<Libro> lista = dao.findAll();
        
        if (lista.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay registros de Libro");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).toDisplayString());
        }
        
        int indice = ConsoleUtils.leerEntero(scanner, "Seleccione el número del registro", 
                valor -> valor >= 1 && valor <= lista.size(), 1);
        
        if (indice >= 1 && indice <= lista.size()) {
            Libro item = lista.get(indice - 1);
            ConsoleUtils.mostrarSubtitulo("Detalles de Libro");
            System.out.println(item.toString());
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    private void crearNuevoLibro() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Crear Nuevo Libro");
        
        Libro nuevo = new Libro();
        
        // Solicitar datos básicos
        String titulo = ConsoleUtils.leerString(scanner, "titulo", null, "");
        nuevo.setTitulo(titulo);
        String autor = ConsoleUtils.leerString(scanner, "autor", null, "");
        nuevo.setAutor(autor);
        int añoPublicacion = ConsoleUtils.leerEntero(scanner, "añoPublicacion", null, 0);
        nuevo.setAñoPublicacion(añoPublicacion);
        boolean disponible = ConsoleUtils.leerBooleano(scanner, "disponible", false);
        nuevo.setDisponible(disponible);
        
        try {
            nuevo.validarDatos();
            LibroDAO dao = LibroDAO.getInstance();
            dao.save(nuevo);
            ConsoleUtils.mostrarCreacion("Libro");
        } catch (Exception e) {
            ConsoleUtils.mostrarError("Error al crear Libro: " + e.getMessage());
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    private void actualizarLibro() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Actualizar Libro");
        ConsoleUtils.mostrarInfo("Funcionalidad de actualización disponible para Libro");
        ConsoleUtils.pausar(scanner);
    }
    
    private void borrarLibro() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Eliminar Libro");
        ConsoleUtils.mostrarInfo("Funcionalidad de eliminación disponible para Libro");
        ConsoleUtils.pausar(scanner);
    }
    
}
