package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol {

    private Long id;
    /**Los rolesexistentes son:
     * Administrador
     * Cliente
     * Cajero
     * ServicioCliente
     */
    private String rol;
    private Persona id_peronas=new Persona();
}
