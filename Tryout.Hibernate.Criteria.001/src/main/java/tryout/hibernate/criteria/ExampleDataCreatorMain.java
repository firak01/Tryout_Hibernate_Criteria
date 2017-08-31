package tryout.hibernate.criteria;

import org.hibernate.Session;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataCreatorMain {

	public static void main(String[] args) {
		final Session session = HibernateUtil.getHibernateSession();
		session.getTransaction().begin();
		
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

		//TODO Goon: Vor der Befüllung der Tabelle erst einmal alles daraus entfernene.
		
		//TODO Goon: Weitere Beispiele, Differenziert nach Preisen. < 200 bis > 1000
		Item objItem = new Item();
		//Merke: Id wird per Generator erzeugt.
		objItem.setItemDescription("test01");
		objItem.setItemName("01");
		objItem.setItemPrice(3);
		session.save(objItem); //!!! Das persistiert nicht
		
		session.flush();
		session.getTransaction().commit();	//Ohne Transaktion (die auch begonnen werden muss, s.o., wird nix persistiert.
		session.close();
		
		
		
	}

}
