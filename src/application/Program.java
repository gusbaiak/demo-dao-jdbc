package application;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {

		VendedorDao vendedorDao = DaoFactory.criaVendedorDao();

		System.out.println("=== TEST 1: vendedor procuraPorId ===");

		Vendedor vendedor = vendedorDao.procuraPorId(3);

		System.out.println(vendedor);
	}

}
