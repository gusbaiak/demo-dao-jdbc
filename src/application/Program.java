package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {

		VendedorDao vendedorDao = DaoFactory.criaVendedorDao();

		System.out.println("=== TEST 1: vendedor procuraPorId ===");
		Vendedor vendedor = vendedorDao.procuraPorId(3);
		System.out.println(vendedor);

		System.out.println("\n=== TEST 2: vendedor procuraPorDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.procuraPorDepartamento(departamento);
		for (Vendedor obj : lista) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: vendedor achaTodos ===");
		lista = vendedorDao.achaTodos();
		for (Vendedor obj : lista) {
			System.out.println(obj);
		}

	}

}
