package com.proyecto.web.restaurante.controller;


import com.proyecto.web.restaurante.clases.Empleados;
import com.proyecto.web.restaurante.implement.UsuarioImplement;

import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/administrador")
public class administradorController {

    @Autowired
    private UsuarioImplement usuarioImplement;
    @GetMapping("/dashboard")
    public String dashboardAdministrador(HttpSession session){
        String nombreEmpleado =(String) session.getAttribute("nombreEmpleado");
        String codigoEmpleado =(String) session.getAttribute("codigoEmpleado");
        session.setAttribute("nombreEmpleado",nombreEmpleado);
        session.setAttribute("codigoEmpleado",codigoEmpleado);
     return "administrador/dashboard";
    }
    @GetMapping("/empleados")
    public String empleados(Model model){
        List<Empleados> empleados = usuarioImplement.listaEmpleados();
        model.addAttribute("listaEmpleados", empleados);
        return "administrador/empleados";
    }
    @GetMapping("/empleados/delete/{id_empleado}")
    public String eliminarEmpleado(@PathVariable String id_empleado) {
        System.out.println("id empleado"+ id_empleado);
        usuarioImplement.eliminarEmpleado(id_empleado);
        return "redirect:/administrador/empleados";
    }
    @PostMapping("/empleados/agregar")
    public String agregarEmpleado(RedirectAttributes redirectAttributes, @RequestParam String id_empleado, @RequestParam int tipo_id, @RequestParam String nombre_empleado, @RequestParam  String apellido_empleado,
                                  @RequestParam String telefono_empleado, @RequestParam String direccion_empleado, @RequestParam  int rol, @RequestParam int id_establecimiento,
                                  @RequestParam  String password_empleado, @RequestParam  String correo_empleado, @RequestParam  int id_estado) {
        boolean respuesta = usuarioImplement.nuevoEmpleado(id_empleado, tipo_id, nombre_empleado, apellido_empleado, telefono_empleado, direccion_empleado, rol, id_establecimiento, password_empleado, correo_empleado, id_estado);
        try {
            if (respuesta == true){
                System.out.println("USUARIO  REGISTRADO");
                redirectAttributes.addFlashAttribute("mensajeOk", "¡El Empleado se ha registrado satisfactoriamente!");
            }else{
                System.out.println("USUARIO NO REGISTRADO");
                redirectAttributes.addFlashAttribute("mensajeError", "¡Ha ocurrido un error y no se podido guardar!");
            }
            return "redirect:/administrador/empleados";
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            redirectAttributes.addFlashAttribute("mensajeError", "¡Ha ocurrido un error y no se podido guardar!");

            return "redirect:/administrador/empleados";
        }
    }


}
