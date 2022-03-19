package ma.fstm.ilisi.gestioncantact.model.dao;

import java.sql.SQLException;
import java.util.List;

import ma.fstm.ilisi.gestioncantact.model.bo.Contact;

public interface IDAOContact {

	public void create(Contact c) ; 
	public List<Contact> retrieve() ;
	public boolean update(Contact c)  ;
	public boolean delete(Contact c)  ;
}
