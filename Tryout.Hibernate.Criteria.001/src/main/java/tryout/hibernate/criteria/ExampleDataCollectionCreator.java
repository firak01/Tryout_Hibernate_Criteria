package tryout.hibernate.criteria;

import org.hibernate.Session;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataCollectionCreator {
	public ExampleDataCollectionCreator() {		
	}
	
	public void createObects() {				
		
		
		/* Merke: Anders als z.B. in meinemTileHexMap Projekt wird hier nicht über Annotations in den Java Klassen (Item) gearbeitet,
		 * sondern die Konfiguration des Mappings Item.hbm.xml, wie angegeben in criteria.cfg.xml
		 */
		/* im Mapping angegebene Properties
		<id name="itemId" type="java.lang.Integer">
			<column name="ITEM_ID" />
			<generator class="identity" />
		</id>
		<property name="itemDescription" type="string">
			<column name="ITEM_DESC" length="100" />
		</property>
		<property name="itemPrice" type="java.lang.Integer">
			<column name="ITEM_PRICE" not-null="true" />
		</property>
		<property name="itemName" type="string">
			<column name="ITEM_NAME" not-null="true" />
		</property>
		 */
	
		
		//TODO Goon: Weitere Beispiele, Differenziert nach Preisen. < 200 bis > 1000
		Item objItem = new Item();
		//Merke: Id wird per Generator erzeugt.
		objItem.setItemDescription("test01");
		objItem.setItemName("01");
		objItem.setItemPrice(3);
		
		
		//Habe das eigentliche Erstellen in einer Unterfunktion/Klasse ausgelagert.... 
		//Merke: Das permanente Aufbeuen einer Session ist schlecht und ist momentan eher ein Performancetest
		//final Session session = HibernateUtil.getHibernateSession();
		//session.getTransaction().begin();
		
		ExampleDataCreator objCreator = new ExampleDataCreator();
		objCreator.createObject(objItem);
		
		
		
	}
	
}
