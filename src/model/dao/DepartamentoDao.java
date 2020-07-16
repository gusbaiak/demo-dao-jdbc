package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {

	void insert(Departamento obj);

	void update(Departamento obj);

	void deletaPorId(Integer id);

	Departamento procuraPorId(Integer id);

	List<Departamento> achaTodos();
}
