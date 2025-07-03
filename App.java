package in.sp.entities.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.main.User;

public class App 
{
   

	public static void main( String[] args )
    {
        User user = new User();
        
        user.setId(2L);
        user.setName("deepak");
        user.setEmail("deepal232@gmail.com");
        user.setPassword("43232");
        user.setCity("goa");
        
        Configuration cfg =new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sessionFactory =cfg.buildSessionFactory();
        Session session = sessionFactory .openSession();
        Transaction  teansection =session.beginTransaction();
        
        try {
//  --------- ---------insert operation-----------
        session.save(user);
        teansection.commit();
        	
        }catch(Exception e)
        {
        	e.printStackTrace();
        	teansection.rollback(); 
        	System.out.print("the data successfully in the database...");
        }
        session.close();
        sessionFactory.close();
    }


}
