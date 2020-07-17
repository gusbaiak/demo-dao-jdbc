package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {

	void insert(Vendedor obj);

	void update(Vendedor obj);

	void deletaPorId(Integer id);

	Vendedor procuraPorId(Integer id);

	List<Vendedor> achaTodos();

	List<Vendedor> procuraPorDepartamento(Departamento departamento);

}
