package tryout.hibernate.criteria;

import org.hibernate.Session;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataCreatorMain {

	public static void main(String[] args) {
		
		//Merke: Das permanente Aufbeuen einer Session ist schlecht und ist momentan eher ein Performancetest
		//final Session session = HibernateUtil.getHibernateSession();
		//TODO: Die session immer wiederverwenden. Innerhalb der aufgerufenen Lösch / Erstell - Methoden Transaktionsorientiert vorgehen.
		
		//Erst einmal alles Löschen....
		ExampleDataCollectionRemover objCollectionRemover = new ExampleDataCollectionRemover();
		objCollectionRemover.deleteObjects();
		
		//Nun wieder neu befüllen....
		ExampleDataCollectionCreator objCollectionCreator = new ExampleDataCollectionCreator();
		objCollectionCreator.createObjects();
		
		System.out.println("Fertig");
	}

}
