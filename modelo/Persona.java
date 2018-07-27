package modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Persona {

    private Long id;
    private String nombre;
    private String apellido;
    private String cedula_pasaporte;
    private String nacionalidad;
    private String direccion;
    private String telefono;
    private String email;
    private Rol Rol;
    private CuentaBancaria id_cuentaBancaria=new CuentaBancaria();
}
