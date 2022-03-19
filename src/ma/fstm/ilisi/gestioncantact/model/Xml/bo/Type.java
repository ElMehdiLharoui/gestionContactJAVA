package ma.fstm.ilisi.gestioncantact.model.bo;

import java.util.HashSet;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

public class Type {
	private String type;
	private Set<Contact> listContact = new HashSet<Contact>();
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Contact> getListContact() {
		return listContact;
	}

	public void setListContact(Set<Contact> listContact) {
		this.listContact = listContact;
	}

	public Type() {
		
	}
	public Type(String t) {
		type=t;
	}
	@Override
	public String toString() {
		return type;
	}
}
