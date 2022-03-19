package ma.fstm.ilisi.gestioncantact.model.bo;

import java.io.Serializable;

public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int id;
	private String tele;
	private String nom;    
	private String prenom;
	private Type  type; 

	public Type getType() 
	{
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getId() {
		return id;    
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tel) {
		this.tele = tel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
 
	public Contact( String nom,String prenom,  String tel,Type t) {
		this.tele = tel;
		this.nom = nom;
		this.prenom = prenom;
		this.type = t;
	}
	public Contact() {
		
	}
	@Override
	public String toString() {
		return " [id=" + id + ", tele=" + tele + ", nom=" + nom + ", prenom=" + prenom + "]";
	}



	    


    
}