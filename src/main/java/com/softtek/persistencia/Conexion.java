package com.softtek.persistencia;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
public class Conexion {

    protected Connection miConexion;

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        miConexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/northwind",
                "postgres", "Maketas1_");
        System.out.println("Conexion exitosa");
    }
}
