package ma.fstm.ilisi.gestioncantact.model.dao.hib;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibutil
{
    private static SessionFactory sessionFactory;
    private hibutil(){
    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try {
                Configuration configuration=new Configuration();
                
                configuration.configure("ma\\fstm\\ilisi\\gestioncantact\\model\\dao\\hib\\hibernate.cfg.xml");
                sessionFactory=configuration.buildSessionFactory();
            }catch (HibernateException exception){
              System.err.println(exception);
             
            }
        }
        return sessionFactory;
    }
}
