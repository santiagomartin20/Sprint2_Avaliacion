package br.com.prueba.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.prueba.model.Producto;

public class ProductoDao {

	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}

	public void salvar(Producto producto) {
		this.em.persist(producto);

	}

	public Producto buscarPorId(int id) {
		return em.find(Producto.class, id);
	}

	public List<Producto> buscarTodos() {
		String jpql = "SELECT p FROM Producto p";
		return em.createQuery(jpql, Producto.class).getResultList();
	}

	public List<Producto> buscarIntervalo(int inicio, int fin) {
		String jpql = "SELECT p FROM Producto p  WHERE p.id BETWEEN :inicio AND :fin";
		return em.createQuery(jpql, Producto.class).setParameter("inicio", inicio).setParameter("fin", fin)
				.getResultList();
	}

}

//<property name="hibernate.show_sql" value="true"/>
//<property name="hibernate.format_sql" value="true"/>