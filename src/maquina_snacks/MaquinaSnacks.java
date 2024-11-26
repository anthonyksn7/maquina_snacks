package maquina_snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        List<Snack> productos = new ArrayList<>();
        System.out.println("------- BIENVENIDO A LA MAQUINA DE SNACKS ------");
        Snacks.mostrarSnacks();
        while (!salir) {
            try {
                int opcion = mostrarMenu(sc);
                salir = ejecutarOpciones(opcion, sc, productos);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner sc) {
        System.out.print("""
                Menú:
                1. Comprar Snack
                2. Mostrar ticket
                3. Agregar nuevo Snack
                4. Salir
                Elige una opción:\s""");
        return Integer.parseInt(sc.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner sc, List<Snack> productos) {
        boolean salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(sc, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(sc);
            case 4 -> {
                System.out.println("Regresa pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no valida: " + opcion);
        }
        return salir;
    }

    private static void comprarSnack(Scanner sc, List<Snack> productos) {
        System.out.print("Que snack deseas comprar(id)?: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean snackEncontrado = false;
        for (Snack snack : Snacks.getSnacks()) {
            if (id == snack.getIdSnack()) {
                productos.add(snack);
                System.out.println("Ok, snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado) {
            System.out.println("Id de snack no encontrado: " + id);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de venta ***";
        var total = 0.0;
        for (var producto : productos) {
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner sc) {
        System.out.print("Nombre del snack: ");
        String nombre = sc.nextLine();
        System.out.print("Precio del snack: ");
        double precio = Double.parseDouble(sc.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack ha sido agregado correctamente!");
        Snacks.mostrarSnacks();
    }
}
