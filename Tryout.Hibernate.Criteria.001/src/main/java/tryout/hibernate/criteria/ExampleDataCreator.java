package tryout.hibernate.criteria;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataCreator {
	public ExampleDataCreator() {
		
	}
	public void createObject(Object object) {
		final Session session = HibernateUtil.getHibernateSession();
				
		Transaction tx = session.beginTransaction();
		Item objItem = (Item) object;
		
		session.save(objItem); //!!! Das alleine persistiert nicht		
		session.flush();
		
		tx.commit();	//Ohne Transaktion (die auch begonnen werden muss, s.o., wird nix persistiert.
		session.close();
		
	}
}
