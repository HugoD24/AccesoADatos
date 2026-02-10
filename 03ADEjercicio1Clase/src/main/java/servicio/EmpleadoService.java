package servicio;

import entidades.Empleado;
import jakarta.persistence.*;

import java.util.List;

public class EmpleadoService {
    private EntityManagerFactory emf;

    public EmpleadoService() {
        emf = Persistence.createEntityManagerFactory("empresaPU");
    }
    public boolean insertarEmpleado(Empleado e){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (PersistenceException ex) {
            em.close();
            return false;
        }
    }
    public Empleado getEmpleadoById(int id){
        EntityManager em = emf.createEntityManager();
        Empleado e = em.find(Empleado.class, id);
        em.close();
        return e;
    }
    public boolean actualizarEmpleado(int id, long salario){
        try{
            EntityManager em = emf.createEntityManager();
            Empleado e = em.find(Empleado.class, id);
            e.setSalario(e.getSalario()+salario);
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            return true;
        }catch(PersistenceException ex){
            System.out.println("No se ha actualizado");
            return false;
        }
    }
    public boolean eliminarEmpleado(String nombre){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.nombre=:nombre");
        q.setParameter("nombre", nombre);
        List<Empleado> lista = q.getResultList();
        if(lista.isEmpty()){
            em.close();
            return false;
        }else{
            em.getTransaction().begin();
            for(Empleado e : lista){
                em.remove(e);
            }
            em.getTransaction().commit();
            em.close();
            return true;
        }
    }
    public List<Empleado> obtenerEmpleadosSalarioSuperior(Long salario){
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("select e from Empleado e where salario>:parametro", Empleado.class);
            q.setParameter("parametro", salario);
            List<Empleado> empleados = q.getResultList();
            em.close();
            return empleados;
    }
    public List<Empleado> obtenerEmpleadosVentas(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("empleado.ventas", Empleado.class);
        List<Empleado> empleados = q.getResultList();
        em.close();
        return empleados;
    }
}
