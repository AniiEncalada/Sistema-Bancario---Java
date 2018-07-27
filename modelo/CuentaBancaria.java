package modelo;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
import modelo.enums.EstadoCuenta;

@Getter
@Setter
public class CuentaBancaria {
    private Long id;
    private Integer nroCuenta;
    private Double saldo;
    private Date fechaApertura;
    private Date fechaCierre;
    private Date fechaModificacion;
    private Persona id_person=new Persona();
    private EstadoCuenta estadoCuenta;
    private Transaccion id_transaccion= new Transaccion();
}
