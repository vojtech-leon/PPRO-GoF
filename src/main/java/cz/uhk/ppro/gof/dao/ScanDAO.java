package cz.uhk.ppro.gof.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.uhk.ppro.gof.model.Scan;

@Repository
public class ScanDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Scan> getAllScans() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Scan> scanList = session.createQuery("from Scan").list();
		return scanList;
	}

	public Scan getScan(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Scan scan = (Scan) session.get(Scan.class, new Integer(id));
		return scan;
	}

	public Scan addScan(Scan scan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(scan);
		return scan;
	}

	public void updateScan(Scan scan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(scan);
	}

	public void deleteScan(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Scan p = (Scan) session.load(Scan.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
