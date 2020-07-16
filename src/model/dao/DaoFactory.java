package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {

	public static VendedorDao criaVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
