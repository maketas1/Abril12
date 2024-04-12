package com.softtek.modelo.poliformismo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Factura {
    private IImpuesto impuesto;
    private List<Producto> productos;

    public double calcularTotalFactura() {
        double total = 0;
        for (Producto producto:
             productos) {
            total += impuesto.calcularImpuesto(producto);
        }
        return total;
    }
}
