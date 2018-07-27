package modelo;

import javax.print.attribute.standard.DateTimeAtCompleted;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Historial {

    private Long id;
    private String actor;
    private DateTimeAtCompleted fecha_horaAccion;
    private Double lugar;
}
