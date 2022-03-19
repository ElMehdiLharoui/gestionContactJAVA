package ma.fstm.ilisi.gestioncantact.controller;


import java.util.List;
import java.sql.SQLException;

import ma.fstm.ilisi.gestioncantact.model.bo.Contact;
import ma.fstm.ilisi.gestioncantact.model.bo.Type;
import ma.fstm.ilisi.gestioncantact.model.dao.DAOContact;
import ma.fstm.ilisi.gestioncantact.view.creation;
import ma.fstm.ilisi.gestioncantact.view.mainT;
import ma.fstm.ilisi.gestioncantact.view.updatepage;



public class CantactController {
	List<Contact> contacts =null;
	public CantactController() {
		// TODO Auto-generated constructor stub
	}
	 

	/*
	
	public String ajouter(String s1, String S2) {
	Resultat re = new Resultat();
	ContactView con = new ContactView();
	return "";
	
	9WAADAAAAA ASSAAAAT 
	                         
	}*/
	
	public void redirection()
	{
		creation cre = new creation();
		cre.setVisible(true);
		mainT ma =mainT.GetMain();
		ma.setVisible(false);
		
	}
	public  void creation(String nom,String prenom,String tele ,String choix) 
	{
		Type type = new Type(choix);
		Contact c = new Contact(nom,prenom, tele,type);
		new DAOContact().create(c); 
		mainT.GetMain().Refrech_Table();
		mainT.GetMain().setVisible(true);
		/*mainT ma =new mainT();
		ma.setVisible(true);
		creation cre = new creation();
		cre.setVisible(false);*/
		
	}
	public  void Update_page(int i,String nom,String prenom,String tele ,String choix) 
	{ 
		Type type = new Type(choix);
		Contact c= DAOContact.getDAOContact().RetreveById(i);
		
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setTele(tele);
		c.setType(type);
		 new DAOContact().update(c); 
		mainT.GetMain().setVisible(true);
		mainT.GetMain().Refrech_Table();
	
		
		
	}
	
	public  List<Contact> retrve() 
	{ 
		 
		return new DAOContact().retrieve();
	}
	 public boolean  deleteContact(int c){
	        boolean b= DAOContact.getDAOContact().delete(c);
	        mainT ma =mainT.GetMain();
			ma.setVisible(true);
			ma.Refrech_Table();
	        if( b && contacts!=null)
	                contacts.remove(c); 
	        return b;
	    }
	 
	 public void update(int id)
	 {
		 Contact b= DAOContact.getDAOContact().RetreveById(id);
		 updatepage pUpdatepage =new updatepage(b);
		 pUpdatepage.setVisible(true);
		 
	 }
	 
}
