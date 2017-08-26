package cz.uhk.ppro.gof.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.uhk.ppro.gof.model.Fraction;

@Repository
public class FractionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Fraction> getAllFractions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Fraction> fractionList = session.createQuery("from Fraction").list();
		return fractionList;
	}

	public Fraction getFraction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Fraction fraction = (Fraction) session.get(Fraction.class, new Integer(id));
		return fraction;
	}

	public Fraction addFraction(Fraction fraction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(fraction);
		return fraction;
	}

	public void updateFraction(Fraction fraction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(fraction);
	}

	public void deleteFraction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Fraction p = (Fraction) session.load(Fraction.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
