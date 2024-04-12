package com.softtek.modelo.poliformismo;

public class IvaGeneral implements IImpuesto{
    @Override
    public double calcularImpuesto(Producto p1) {
        double resultado = p1.getPrecio() * 1.4;
        return resultado;
    }
}
