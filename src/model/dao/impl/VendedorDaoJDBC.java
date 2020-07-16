package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {

	private Connection conn;

	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor obj) {

	}

	@Override
	public void update(Vendedor obj) {

	}

	@Override
	public void deletaPorId(Integer id) {

	}

	@Override
	public Vendedor procuraPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName\r\n"
					+ "FROM seller INNER JOIN department\r\n"
					+ "ON seller.DepartmentId = department.Id\r\n" 
					+ "WHERE seller.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setNome(rs.getString("DepName"));
				Vendedor obj = new Vendedor();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setSalarioBase(rs.getDouble("BaseSalary"));
				obj.setDataNascimento(rs.getDate("BirthDate"));
				obj.setDepartamento(dep);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fechaResultSet(rs);
			DB.fechaStatement(st);
		}
	}

	@Override
	public List<Vendedor> achaTodos() {
		return null;
	}

}
