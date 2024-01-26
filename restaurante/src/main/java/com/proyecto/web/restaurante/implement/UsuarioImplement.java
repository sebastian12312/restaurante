package com.proyecto.web.restaurante.implement;


import com.proyecto.web.restaurante.clases.Empleados;
import com.proyecto.web.restaurante.repository.UsuarioRepository;
import com.proyecto.web.restaurante.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImplement  implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Empleados autenticacion(String id_empleado, String password_empleado)
    {
        Empleados empleado = usuarioRepository.findValidar(id_empleado,password_empleado);
        return empleado;
    }

    @Override
    public List<Empleados> listaEmpleados() {
         List<Empleados> empleados = usuarioRepository.findAll();
        return empleados;
    }

    @Override
    public void eliminarEmpleado(String id_empleado) {
        usuarioRepository.deleteBycodigo_usuario(id_empleado);

    }

    @Override
    public boolean nuevoEmpleado(String id_empleado, int tipo_id, String nombre_empleado, String apellido_empleado,
            String telefono_empleado, String direccion_empleado, int rol, int id_establecimiento,
            String password_empleado, String correo_empleado, int id_estado) {
        try {
            usuarioRepository.insertarEmpleado(id_empleado,tipo_id,nombre_empleado,apellido_empleado,telefono_empleado,direccion_empleado,rol
                    ,id_establecimiento,password_empleado,correo_empleado,id_estado);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
