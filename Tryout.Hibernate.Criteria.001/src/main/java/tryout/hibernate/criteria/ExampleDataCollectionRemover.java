package tryout.hibernate.criteria;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataCollectionRemover extends ExampleBasic {
		
	public ExampleDataCollectionRemover() {
		
	}
		
	public ExampleDataCollectionRemover(Session session) {
		super(session);
	}


	public void deleteObjects() {
		//Es soll performanter sein erst die ganze Liste zu holen (wg. Lazy), statt Über die ID jede Zelle einzeln.
		List<Item>listItem = this.findLazyAll("Item", 0, 0);//daoAreaCell.findLazyAll(0, -1);
		//System.out.println(ReflectCodeZZZ.getPositionCurrent() + ": Anzahl gefundener HexCells = " + listAreaCell.size());

		ExampleDataRemover objRemover = new ExampleDataRemover(this.getSession());
		for(Item objItem : listItem){
			objRemover.deleteData(objItem);
		}
	}
			
			/** FGL: Ursprünglich in der DAO - Klasse (s. TileHexMap-Projekt). Dann hier deutlich reduziert....
			 * General findLazyAll for managing the find Lazy methods.
			 * @param <T>
			 */
			protected <T> List<T> findLazyAll(String table, int first, int max){
				//final Session objSession = HibernateUtil.getHibernateSession();
				final Session objSession = this.getSession();
				objSession.getTransaction().begin();
				
				Query q = objSession.createQuery("from "+table+" p") ;
				
				q.setFirstResult(first);
				q.setMaxResults(max);
				@SuppressWarnings("unchecked")
				List<T> list = q.list();
				
				objSession.getTransaction().commit();				
				//objSession.close();								
				//return this.refreshList(list);
				return list;
			}
			
			
			
}
