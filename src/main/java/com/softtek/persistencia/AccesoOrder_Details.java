package com.softtek.persistencia;

import com.softtek.modelo.Order_Details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoOrder_Details extends Conexion{

    public List<Order_Details> obtenertodos() throws SQLException, ClassNotFoundException {
        Statement sentencias;
        ResultSet resultado;
        String sql = "Select * from order_details;";
        List<Order_Details> lista = new ArrayList<>();
        abrirConexion();
        sentencias = miConexion.createStatement();
        resultado = sentencias.executeQuery(sql);
        while (resultado.next()) {
            lista.add(new Order_Details(
                    resultado.getInt("order_id"),
                    resultado.getInt("product_id"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("quantity"),
                    resultado.getDouble("discount")));
        }
        return lista;
    }
}
