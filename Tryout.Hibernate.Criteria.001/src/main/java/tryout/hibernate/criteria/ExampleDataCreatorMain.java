package tryout.hibernate.criteria;

import org.hibernate.Session;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;
import com.baeldung.hibernate.criteria.view.ApplicationView;

/**Bereite die Datenbank vor, so dass die JUnit Tests funktionieren.
		
	Merke: Die JUnit Tests dienen dazu die Methoden folgender Klasse zu testen, in der dann tatsächlich die Criteria API verwendet wird:
	com\baeldung\hibernate\criteria\view\ApplicationView.java
	Einmalig erstellt in HibernateCriteriaIntegrationTest.java
	final private ApplicationView av = new ApplicationView();
	
	In den Tests wird dann das Ergebnis von normalem HQL mit dem Ergebnis der Criteria-Methoden verglichen.
 * @author Fritz Lindhauer
 *
 */
public class ExampleDataCreatorMain {

	public static void main(String[] args) {	
		//Merke: Das permanente Aufbauen einer Session ist schlecht und ist momentan eher ein Performancetest
		final Session session = HibernateUtil.getHibernateSession();
		
		//Erst einmal alles Löschen....
		ExampleDataCollectionRemover objCollectionRemover = new ExampleDataCollectionRemover(session);
		objCollectionRemover.deleteObjects();
		
		//Nun wieder neu befüllen....
		ExampleDataCollectionCreator objCollectionCreator = new ExampleDataCollectionCreator(session);
		objCollectionCreator.createObjects();
		
		System.out.println("Fertig");
		session.close();
	}

}
