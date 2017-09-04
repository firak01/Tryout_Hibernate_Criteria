package tryout.hibernate.criteria;

import org.hibernate.Session;

public class ExampleBasic {
	Session session = null;
	
	
	public ExampleBasic() {
		
	}
	
	public ExampleBasic(Session session) {
		this.setSession(session);
	}
	
	//++++++++++++
	//GETTER Setter
	private void setSession(Session session) {
		this.session = session;
	}
	public Session getSession() {
		return this.session;
	}
	
}
