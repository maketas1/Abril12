package com.softtek.modelo.poliformismo;

public class IvaSuperReducido implements IImpuesto{
    @Override
    public double calcularImpuesto(Producto p1) {
        double resultado = p1.getPrecio() * 0.04;
        return resultado;
    }
}
