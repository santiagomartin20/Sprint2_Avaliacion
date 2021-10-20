package br.com.prueba.testes;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import br.com.prueba.dao.ProductoDao;
import br.com.prueba.model.Producto;
import br.com.prueba.util.JPAUtil;

public class CadatroDeProductos {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int ops = 0;
		do {
			// do while para volver al menu mientras no se preciona 0
			while (true) {
				// While true hasta que la opcion marcada sea correcta
								try {
					// Control de exepcion caso se ingrese algo diferente a int
					System.out.println("MARQUE A OPÇÂO DESEJADA" + "\n1) CRIAR OFERTAS" + "\n2) ACTUALIZAR OFERTA"
							+ "\n3) ELIMINAR OFERTA" + "\n4) LISTAR INTERVALO" + "\n0) SAIR");
				System.out.println(scan.next());
					ops = scan.nextInt();
				
					break;
				} catch (Exception e) {
					// Captura de execption
					System.err.println("PORFAVOR INGRESE UN NUMERO VALIDO");
				}
				//finally {
				//	scan.close();
				//}
			} // Fin While true
			Menu(ops); // Entra a menu en base a la ops
		} while (ops != 0); // Fin do while

		System.out.println("-----------\nFin do programa");
		// Fin
		scan.close();

	}

	private static void Menu(int ops) {
		switch (ops) {
		case 1:
			System.out.println("Creando...");
			CadastrarProducto();
			System.out.println("PROMO CREADA\n-------");
			break;
		case 2:
			System.out.println("Actualizando...");
			ActualizarPrimerProducto();
			break;
		case 3:
			System.out.println("Eliminando...");
			EliminarProducto();
			break;
		case 4:
			int inicio = 0, fin = 0;
			Scanner rang = new Scanner(System.in);
			try {
				System.out.println("Inicio do rango:");
				inicio = rang.nextInt();
				System.out.println("Fin do rango:");
				fin = rang.nextInt();
				ListarRagoId(inicio, fin);
			} catch (Exception e) {
				System.err.println("ID ivalido");
			}
			break;
		case 0:
			System.out.println("Exit...");
			break;
		default:
			System.err.println("Valor invalido");
			break;
		}
	}

	private static void EliminarProducto() {
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDao dao = new ProductoDao(em);

		Producto PrimeroPro = dao.buscarPorId(2);
		try {
			em.getTransaction().begin();
			em.remove(PrimeroPro);
			em.getTransaction().commit();
			em.close();
			
			ListarProducto();
			System.out.println("ELIMINACION DE (id = 2) REALIZADA\n-------");
		} catch (Exception e) {
			System.err.println("ERROR AL ELIMINAR");
		}

	}

	private static void ActualizarPrimerProducto() {
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDao dao = new ProductoDao(em);

		Producto PrimeroPro = dao.buscarPorId(1);

		try {
			em.getTransaction().begin();

			PrimeroPro.setNome("Tablet");
			PrimeroPro.setData_fim("1/2/2022");
			PrimeroPro.setData_inicio("17/10/2021");
			PrimeroPro.setDesconto("10%");
			PrimeroPro.setDescricao("DescripcionTEST");

			em.getTransaction().commit();
			em.close();

			ListarProducto();
			System.out.println("ACTUALIZACION DE (id = 1) REALIZADA\n-------");
		} catch (Exception e) {
			System.err.println("ERROR AL ACTUALIZAR");
		}
	}

	private static void CadastrarProducto() {
		Producto Promocion = new Producto();
		Promocion.setData_fim("12/12/2021");
		Promocion.setData_inicio("17/10/2021");
		Promocion.setDesconto("12%");
		Promocion.setDescricao("DescripcionTEST");
		Promocion.setNome("Celular");

		Producto Promocion2 = new Producto();
		Promocion2.setData_fim("12/12/2021");
		Promocion2.setData_inicio("17/10/2021");
		Promocion2.setDesconto("10%");
		Promocion2.setDescricao("DescripcionTEST");
		Promocion2.setNome("Computador");

		Producto Promocion3 = new Producto();
		Promocion3.setData_fim("12/12/2021");
		Promocion3.setData_inicio("17/10/2021");
		Promocion3.setDesconto("20%");
		Promocion3.setDescricao("DescripcionTEST");
		Promocion3.setNome("Television");

		EntityManager em = JPAUtil.getEntityManager();
		ProductoDao dao = new ProductoDao(em);

		em.getTransaction().begin();
		dao.salvar(Promocion);
		dao.salvar(Promocion2);
		dao.salvar(Promocion3);
		em.getTransaction().commit();
		em.close();

		ListarProducto();

	}

	private static void ListarRagoId(int inicio, int fin) {
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDao dao = new ProductoDao(em);

		List<Producto> Todos = dao.buscarIntervalo(inicio, fin);
		System.out.println("\n--------------");
		Todos.forEach(p -> System.out.println(p.toString()));
		System.out.println("\n--------------");
	}

	private static void ListarProducto() {
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDao dao = new ProductoDao(em);

		List<Producto> Todos = dao.buscarTodos();
		System.out.println("\n--------------");
		Todos.forEach(p -> System.out.println(p.toString()));
		System.out.println("\n--------------");
	}
}
