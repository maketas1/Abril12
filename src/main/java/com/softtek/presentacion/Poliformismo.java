package com.softtek.presentacion;

import com.softtek.modelo.poliformismo.Factura;
import com.softtek.modelo.poliformismo.IvaGeneral;
import com.softtek.modelo.poliformismo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Poliformismo {
    public static void main(String[] args) {
        Producto p1 = new Producto("Leche", 10);
        Producto p2 = new Producto("Agua", 5);

        List<Producto> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);

        IvaGeneral iva = new IvaGeneral();

        Factura factura = new Factura(iva, lista);
        System.out.println(factura.calcularTotalFactura());
    }
}
