package com.softtek.presentacion;

import com.softtek.modelo.Order_Details;
import com.softtek.persistencia.AccesoOrder_Details;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conexion c1 = new Conexion();
        c1.abrirConexion();
        AccesoOrder_Details od = new AccesoOrder_Details();
        List<Order_Details> lista = od.obtenertodos();
        apartadoE(lista);
    }

    public static void apartadoA(List<Order_Details> lista) {
        System.out.println("Apartado A");
        Predicate<Order_Details> mayor = e -> e.getUnitPrice() > 30;
        lista.stream()
                .filter(mayor)
                .forEach(System.out::println);
    }

    public static void apartadoB(List<Order_Details> lista) {
        System.out.println("Apartado B");
        Comparator<Order_Details> invertir = (x1, x2) -> (int) (x2.getUnitPrice() - x1.getUnitPrice());
        lista.stream()
                .sorted(invertir)
                .forEach(System.out::println);
    }

    public static void apartadoC(List<Order_Details> lista) {
        System.out.println("Apartado C");
        double minPrice = lista.stream()
                .mapToDouble(Order_Details::getUnitPrice)
                .min()
                .orElseThrow(NoSuchElementException::new);

        lista.stream()
                .filter(detail -> detail.getUnitPrice() == minPrice)
                .forEach(System.out::println);
    }

    public static void apartadoD(List<Order_Details> lista) {
        System.out.println("Apartado D");
        lista.stream()
                .mapToInt(Order_Details::getQuantity)
                .forEach(System.out::println);
    }

    public static void apartadoE(List<Order_Details> lista) {
        System.out.println("Apartado E");
        Map<Integer, Integer> productQuantities = lista.stream()
                .collect(Collectors.groupingBy(detail -> detail.getProductID(),
                        Collectors.summingInt(Order_Details::getQuantity)));

        // Iterar sobre el mapa y mostrar la información
        productQuantities.forEach((productName, quantity) -> {
            System.out.println("Producto: " + productName + ", Cantidad Total: " + quantity);
        });
    }
}
