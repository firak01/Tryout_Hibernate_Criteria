package tryout.hibernate.criteria;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.baeldung.hibernate.criteria.model.Item;
import com.baeldung.hibernate.criteria.util.HibernateUtil;

public class ExampleDataCollectionCreator extends ExampleBasic {
	public ExampleDataCollectionCreator() {		
	}
	
	
	public ExampleDataCollectionCreator(Session session) {
		super(session);
	}


	public static List<Item> provideData(){
		ArrayList<Item> listReturn = new  ArrayList<Item>();
		
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
		//--------------------
		
		int iTestObjectCounter = 0;
		String sTestObject = new String("");
		Item objItem = null;
				
		//TODO Goon: Weitere Beispiele, Differenziert nach Preisen. < 200 bis > 1000
		//------ Preise < 200
		iTestObjectCounter++;
		sTestObject = ExampleDataCollectionCreator.computeTestItemName(iTestObjectCounter);
		objItem = new Item(); //Merke: Id wird per Generator erzeugt.
		objItem.setItemDescription("test"+sTestObject);
		objItem.setItemName(sTestObject);
		objItem.setItemPrice(3);
		listReturn.add(objItem);
								
		//------ Preise > 200 aber < 1000
		iTestObjectCounter++;
		sTestObject = ExampleDataCollectionCreator.computeTestItemName(iTestObjectCounter);
		objItem = new Item(); //Merke: Id wird per Generator erzeugt.
		objItem.setItemDescription("test"+sTestObject);
		objItem.setItemName(sTestObject);
		objItem.setItemPrice(201);
		listReturn.add(objItem);
				
		//------ Preise > 1000
		iTestObjectCounter++;
		sTestObject = ExampleDataCollectionCreator.computeTestItemName(iTestObjectCounter);
		objItem = new Item(); //Merke: Id wird per Generator erzeugt.
		objItem.setItemDescription("test"+sTestObject);
		objItem.setItemName(sTestObject);
		objItem.setItemPrice(1001);
		listReturn.add(objItem);		
		
		return listReturn;
	}
	
	/** Mache den Zählwert zu einem normierten String 
	 * @param iTestObjectCounter
	 * @return
	 */
	public static String computeTestItemName(int iTestObjectCounter) {
		String sReturn  = "000" + iTestObjectCounter;
		sReturn = sReturn.substring(sReturn.length()-2, sReturn.length());		
		return sReturn;
	}
	
	public void createObjects() {
		List<Item> listItem2create = ExampleDataCollectionCreator.provideData();		
		this.persistObects(listItem2create);
	}
	
	public void persistObects(List<Item> listItem2create) {				
		
		//Habe das eigentliche Erstellen in einer Unterfunktion/Klasse ausgelagert.... 
		//Merke: Das permanente Aufbauen einer Session ist schlecht und ist momentan eher ein Performancetest
		//final Session session = HibernateUtil.getHibernateSession();
		//session.getTransaction().begin();
		
		int iCounter=0;
		ExampleDataCreator objCreator = new ExampleDataCreator(this.getSession());
		for(Item objItem : listItem2create) {
			objCreator.createObject(objItem);
			iCounter++;
			System.out.println("Erstellt, Objeckt: " + iCounter);
		}
	}
	
}
