package ma.fstm.ilisi.gestioncantact.model.bo;

import java.util.HashSet;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

@Table(name = "type")
public class Type {
	@Id
	private String type;
	 @OneToMany(fetch = FetchType.LAZY,mappedBy = "type")
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
