package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
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

		System.out.println("\n=== TEST 4: vendedor insert ===");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.insert(novoVendedor);
		System.out.println("Inserido! Novo Id = " + novoVendedor.getId());

		System.out.println("\n=== TEST 5: vendedor update ===");
		vendedor = vendedorDao.procuraPorId(1);
		vendedor.setNome("Marta Waine");
		vendedorDao.update(vendedor);
		System.out.println("Update Completa");

		System.out.println("\n=== TEST 6: vendedor delete ===");
		System.out.println("Entre com o id para o teste: ");
		int id = sc.nextInt();
		vendedorDao.deletaPorId(id);
		System.out.println("Delete Completa");

		sc.close();

	}

}
