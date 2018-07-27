package modelo;

import lombok.Getter;
import lombok.Setter;
import modelo.enums.AccionMovimiento;
import modelo.enums.TipoMovimiento;

@Getter
@Setter
public class Movimiento extends Transaccion {

    private Long id;
    private String siglas;
    /*SIGLAS
    *DPS->Deposito.
    *RTR->Retiro.
    *TSC-> Transaccion.
     */
    private TipoMovimiento tipoMovimiento;
    private AccionMovimiento accionMovimiento;
}
