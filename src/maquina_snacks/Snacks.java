package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Chips", 2));
        snacks.add(new Snack("Galletas", 1));
        snacks.add(new Snack("Chocolates", 3));
        snacks.add(new Snack("Refresco", 1.5));
        snacks.add(new Snack("Sandwich", 2.5));
        snacks.add(new Snack("Agua", 1));
    }

    public static void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static void mostrarSnacks() {
        StringBuilder inventarioSnacks = new StringBuilder();
        for (Snack snack : snacks) {
            inventarioSnacks.append(snack.toString()).append("\n");
        }
        System.out.println("----- INVENTARIO DE SNACKS -----");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks() {
        return snacks;
    }
}
