package com.hibernate.cahce.SecondLevelCahching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException
    {
        System.out.println( "Hello World!" );
        Ipl ipl_team1=new Ipl();
        ipl_team1.setName("CSK");
        ipl_team1.setCapitan("Dhoni");
        ipl_team1.setTrophies(4);
        ipl_team1.setAllTimeBestPlayer("Suresh Raina");

        Ipl ipl_team2=new Ipl();
        ipl_team2.setName("MI");
        ipl_team2.setTrophies(5);
        ipl_team2.setCapitan("Rohit");
        ipl_team2.setAllTimeBestPlayer("Pollard");

        Ipl ipl_team3=new Ipl();
        ipl_team3.setName("RCB");
        ipl_team3.setTrophies(0);
        ipl_team3.setCapitan("Faf");
        ipl_team3.setAllTimeBestPlayer("Virat");

        Configuration config=new Configuration().configure().addAnnotatedClass(Ipl.class);
        
        
        SessionFactory sf=config.buildSessionFactory();
        
        Session session1=sf.openSession();
        Transaction tx1=session1.beginTransaction();
        session1.persist(ipl_team1);
        tx1.commit();
        session1.close();
        
        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();
        session2.persist(ipl_team2);
        tx2.commit();
        session2.close();
        
        Session session3=sf.openSession();
        Transaction tx3=session3.beginTransaction();
        session3.persist(ipl_team3);
        tx3.commit();
        session3.close();
       
        Session session4=sf.openSession();
        Transaction tx4=session4.beginTransaction();
        
        Ipl ipl=session4.get(Ipl.class,1L);
        Field[] fields=ipl.getClass().getDeclaredFields();
        for(Field field:fields) {
        	field.setAccessible(true);
    		Object value=field.get(ipl);
    		System.out.println(field.getName()+" :"+value);

        	
        }
        tx4.commit();
        session4.close();
        
        Session session5=sf.openSession();
        Transaction tx5=session5.beginTransaction();
        
        Ipl ipl2=session5.get(Ipl.class,1L);
        Field[] fields2=ipl2.getClass().getDeclaredFields();
        for(Field field:fields2) {
        	field.setAccessible(true);
    		Object value=field.get(ipl2);
    		System.out.println(field.getName()+" :"+value);

        	
        }
        tx5.commit();
        session5.close();
    }
}
