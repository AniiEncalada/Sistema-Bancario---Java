package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cuenta {

    private Long id;
    private String usuario;
    private String clave;
    private Persona id_peronas=new Persona();
}
