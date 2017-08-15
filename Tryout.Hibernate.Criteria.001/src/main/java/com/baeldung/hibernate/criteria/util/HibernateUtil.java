package com.baeldung.hibernate.criteria.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    @SuppressWarnings("deprecation")
    public static Session getHibernateSession() {

    	
//    	 try {
//             // Create the SessionFactory from hibernate.cfg.xml
//             return new AnnotationConfiguration()
//             		.configure()
//                     .buildSessionFactory();
//         } catch (Throwable ex) {
//             System.err.println("Initial SessionFactory creation failed." + ex);
//             throw new ExceptionInInitializerError(ex);
//         }
    	
       // final SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        		
    	Configuration cfg = new Configuration().configure("criteria.cfg.xml");
        final SessionFactory sf = cfg.buildSessionFactory();
        
        // factory = new Configuration().configure().buildSessionFactory();
        final Session session = sf.openSession();
        return session;
    }

}
