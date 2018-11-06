/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class PersonaDao extends AdaptadorDao<Persona>{
   private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            //Abrimos la transaccion
            if (persona.getId() != null) {
                modificar(persona);
            } else {
                guardar(persona);
            }
            getManager().getTransaction().commit();
            //commit.-Enviar los cambios a la bbdd
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar " + e);
        }
        return verificar;
    } 
    public List<Persona> listarSinAdministrador() {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre != :nombre"); //:parametro
            q.setParameter("nombre", "Administrador");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }

    public Persona getPersonaCedula(String cedula) {
        Persona p = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p where p.cedula=:ced");
            q.setParameter("ced", cedula);
            p = (Persona) q.getSingleResult();
        } catch (Exception e) {
        }
        return p;
    }

    public List<Persona> listarSinAdministradorTipo(String tipo) {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre != :nombre and p.rol.nombre = :tipo"); //:parametro
            q.setParameter("nombre", "Administrador");
            q.setParameter("tipo", tipo);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }

    public List<Persona> listarSinAdministradorLike(String texto) {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre != :nombre "
                    + "and (lower(p.apellidos)LIKE CONCAT ('%', :texto, '%')"); //:parametro
            q.setParameter("nombre", "Administrador");
            q.setParameter("texto", texto);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }

    public List<Persona> listarSinAdministradorTipoLike(String tipo, String texto) {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre != :nombre "
                    + "and p.rol.nombre = :tipo "
                    + "and (lower(p.apellidos)LIKE CONCAT ('%', :texto, '%')"); //:parametro
            q.setParameter("nombre", "Administrador");
            q.setParameter("tipo", tipo);
            q.setParameter("texto", texto);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
}
