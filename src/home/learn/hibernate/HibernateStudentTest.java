package home.learn.hibernate;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import home.learn.hibernate.entities.Student;
import home.learn.hibernate.utils.HibernateUtils;

public class HibernateStudentTest {

	public static void main(String[] args) {

		Student s1 = new Student(1,"Ben");
		
		try(Session dbSession = HibernateUtils.getSessionFactory().openSession()){
			Transaction tx = (Transaction) dbSession.beginTransaction();
			dbSession.save(s1);
			try {
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
		}
	}

}
