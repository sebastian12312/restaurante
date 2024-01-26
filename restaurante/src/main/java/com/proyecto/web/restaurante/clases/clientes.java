package com.proyecto.web.restaurante.clases;

import lombok.Data;

@Data
public class clientes{
    private String id_cliente;
    private int id_tipo;
    private String nombre_cliente;
    private String apellido_cliente;
    private String direccion_cliente;
    private String telefono_cliente;
}
