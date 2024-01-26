package com.proyecto.web.restaurante.repository;
import com.proyecto.web.restaurante.clases.Empleados;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Empleados,String> {
    @Query("SELECT u FROM Empleados u WHERE u.id_empleado = :id_empleado and u.password_empleado = :password_empleado")
    Empleados  findValidar(@Param("id_empleado") String id_empleado, @Param("password_empleado") String password_empleado);
    @Modifying
    @Transactional
    @Query("DELETE FROM Empleados c WHERE c.id_empleado = :id_empleado")
    void deleteBycodigo_usuario(@Param("id_empleado") String id_empleado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (id_empleado, tipo_id, nombre_empleado, apellido_empleado, telefono_empleado, direccion_empleado, rol, id_establecimiento, password_empleado, correo_empleado, id_estado) " +
            "VALUES (:idEmpleado, :tipoId, :nombreEmpleado, :apellidoEmpleado, :telefonoEmpleado, :direccionEmpleado, :rol, :idEstablecimiento, :passwordEmpleado, :correoEmpleado, :idEstado)", nativeQuery = true)
    void insertarEmpleado(@Param("idEmpleado") String idEmpleado,
                          @Param("tipoId") int tipoId,
                          @Param("nombreEmpleado") String nombreEmpleado,
                          @Param("apellidoEmpleado") String apellidoEmpleado,
                          @Param("telefonoEmpleado") String telefonoEmpleado,
                          @Param("direccionEmpleado") String direccionEmpleado,
                          @Param("rol") int rol,
                          @Param("idEstablecimiento") int idEstablecimiento,
                          @Param("passwordEmpleado") String passwordEmpleado,
                          @Param("correoEmpleado") String correoEmpleado,
                          @Param("idEstado") int idEstado);
}
