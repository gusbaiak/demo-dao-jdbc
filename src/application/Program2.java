package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartamentoDao departamentoDao = DaoFactory.criaDepartamentoDao();

		System.out.println("=== TEST 1: departamento procuraPorId ===");
		Departamento departamento = departamentoDao.procuraPorId(3);
		System.out.println(departamento);

		System.out.println("\n=== TEST 2: departamento achaTodos ===");
		List<Departamento> lista = departamentoDao.achaTodos();
		for (Departamento dep : lista) {
			System.out.println(dep);
		}

		System.out.println("\n=== TEST 3: departamento insert ===");
		Departamento novoDepartamento = new Departamento(null, "Music");
		departamentoDao.insert(novoDepartamento);
		System.out.println("Inserido! Novo Id = " + novoDepartamento.getId());

		System.out.println("\n=== TEST 4: departamento update ===");
		departamento = departamentoDao.procuraPorId(1);
		departamento.setNome("Games");
		departamentoDao.update(departamento);
		System.out.println("Update Completa");

		System.out.println("\n=== TEST 5: departamentp delete ===");
		System.out.println("Entre com o id para o teste: ");
		int id = sc.nextInt();
		departamentoDao.deletaPorId(id);
		System.out.println("Delete Completa");

		sc.close();

	}

}
