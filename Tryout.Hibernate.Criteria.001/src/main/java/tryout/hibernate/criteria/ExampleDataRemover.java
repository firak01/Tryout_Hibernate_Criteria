package tryout.hibernate.criteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataRemover {
	public ExampleDataRemover() {
		
	}
	public void deleteData(Object object) {
		final Session session = HibernateUtil.getHibernateSession();
		
		Transaction tx = session.beginTransaction();
		Item item = (Item) object;
		String hql = "delete from Item where ITEM_ID = '" + item.getItemId() + "'";
		Query query = session.createQuery(hql);
		System.out.println(hql);
		//Merke: wird hier die Query ausgeführt??? Nein....
		query.executeUpdate(); // Das führt erst die Query aus...
		
		tx.commit();
		session.close();
		}
}
