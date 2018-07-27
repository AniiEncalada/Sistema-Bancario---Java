package modelo;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaccion implements Serializable {

    private Long id;
    private Double valor;
    private DateTimeFormatter fecha_hora;
    private Double Lugar;
    private Long nroCuenta;
    private CuentaBancaria id_CuentaBnacaria= new CuentaBancaria();

}
