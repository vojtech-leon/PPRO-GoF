package cz.uhk.ppro.gof.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.uhk.ppro.gof.model.Flag;

@Repository
public class FlagDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Flag> getAllFlags() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Flag> flagList = session.createQuery("from Flag").list();
		return flagList;
	}
	
	public Flag getFlag(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Flag flag = (Flag) session.get(Flag.class, new Integer(id));
		return flag;
	}

	public Flag addFlag(Flag flag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(flag);
		return flag;
	}

	public void updateFlag(Flag flag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(flag);
	}

	public void deleteFlag(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Flag p = (Flag) session.load(Flag.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
